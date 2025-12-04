package com.mauro.authapi.service;

import com.mauro.authapi.dto.CreateUserDTO;
import com.mauro.authapi.model.Role;
import com.mauro.authapi.model.RoleName;
import com.mauro.authapi.model.User;
import com.mauro.authapi.repository.RoleRepository;
import com.mauro.authapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder; // vem do SecurityConfig

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // usado automaticamente pelo Spring Security no /login
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    public User register(CreateUserDTO dto) {

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username já existe");
        }

        // pega ROLE_USER automaticamente (criado pelo DataInitializer)
        Role defaultRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role USER não encontrada"));

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(Collections.singleton(defaultRole));

        return userRepository.save(user);
    }
}
