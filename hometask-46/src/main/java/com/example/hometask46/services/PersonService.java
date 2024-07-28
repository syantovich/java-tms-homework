package com.example.hometask46.services;

import com.example.hometask46.domain.AuthorityEntity;
import com.example.hometask46.dto.PersonDto;
import com.example.hometask46.dto.RegisterDto;
import com.example.hometask46.enums.ERoles;
import com.example.hometask46.mappers.PersonMapper;
import com.example.hometask46.repository.PersonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonService implements UserDetailsService {
    final PersonRepository personRepository;
    final PersonMapper personMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var personEntity = personRepository.findByEmail(username);

        if (personEntity.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        return personEntity.get();
    }

    public void registerPerson(RegisterDto registerDto) {
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
    }

    public Boolean isAdministrator(UserDetails userDetails) {
        return userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(ERoles.ADMIN.toRoleString()));
    }

}
