package com.example.hometask46.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false)
    String email;
    String name;
    String password;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = ALL)
    List<AuthorityEntity> perms;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (perms == null) {
            return List.of();
        }

        var authorities = new ArrayList<GrantedAuthority>();
        for (var perm : perms) {
            var auth = new SimpleGrantedAuthority(perm.getName());
            authorities.add(auth);
        }

        return authorities;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

}
