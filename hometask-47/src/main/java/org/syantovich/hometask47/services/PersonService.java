package org.syantovich.hometask47.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.syantovich.hometask47.domain.PersonEntity;
import org.syantovich.hometask47.dto.AuthResponseDto;
import org.syantovich.hometask47.dto.LoginDto;
import org.syantovich.hometask47.dto.PersonDto;
import org.syantovich.hometask47.dto.RegisterDto;
import org.syantovich.hometask47.enums.ERoles;
import org.syantovich.hometask47.mappers.PersonMapper;
import org.syantovich.hometask47.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonService implements UserDetailsService {
    final PersonRepository personRepository;
    final PersonMapper personMapper;
    final TokenService tokenService;
    final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var personEntity = personRepository.findByEmail(username);

        if (personEntity.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        return personEntity.get();
    }

    public AuthResponseDto registerPerson(RegisterDto registerDto) {
        if (personRepository.findByEmail(registerDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        var personDto = new PersonDto();
        personDto.setEmail(registerDto.getEmail());
        personDto.setPassword(registerDto.getPassword());
        personDto.setAuthorities(List.of(ERoles.valueOf(registerDto.getRole().name())));
        personDto.setName(registerDto.getName());

        var personEntity = personMapper.toEntity(personDto);
        personRepository.save(personEntity);
        PersonDto savedPerson = personMapper.toDto(personRepository.findByEmail(registerDto.getEmail()).get());
        String token = tokenService.createToken(personEntity);
        return new AuthResponseDto(token, savedPerson);
    }

    public PersonDto getPersonByEmail(String email) {
        var personEntity = personRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User with this email not found"));
        return personMapper.toDto(personEntity);
    }

    public AuthResponseDto login(LoginDto loginDto) {
        var personEntity = personRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User with this email not found"));

        if (!passwordEncoder.matches(loginDto.getPassword(), personEntity.getPassword())) {
            throw new IllegalArgumentException("Password is incorrect");
        }

        var personDto = personMapper.toDto(personEntity);
        return new AuthResponseDto(tokenService.createToken(personEntity), personDto);
    }

    public List<PersonDto> getAllUsers() {
        return personMapper.toDtoList(personRepository.findAll());
    }

}
