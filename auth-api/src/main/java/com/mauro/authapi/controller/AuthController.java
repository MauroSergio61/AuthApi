package com.mauro.authapi.controller;

import com.mauro.authapi.dto.CreateUserDTO;
import com.mauro.authapi.dto.LoginDTO;
import com.mauro.authapi.model.User;
import com.mauro.authapi.security.JwtUtil;
import com.mauro.authapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()
                )
        );

        User user = (User) auth.getPrincipal();

        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CreateUserDTO dto) {
        User created = userService.register(dto);
        return ResponseEntity.ok(created);
    }
    @GetMapping("/teste")
    public String teste() {
        return "Acesso liberado";
    }


}
