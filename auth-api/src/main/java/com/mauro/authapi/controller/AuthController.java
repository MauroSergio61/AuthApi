package com.mauro.authapi.controller;

import com.mauro.authapi.dto.CreateUserDTO;
import com.mauro.authapi.dto.LoginDTO;
import com.mauro.authapi.dto.LoginResponseDTO;
import com.mauro.authapi.model.User;
import com.mauro.authapi.security.JwtUtil;
import com.mauro.authapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO) {

        User user = userService.authenticate(
                loginDTO.getUsername(),
                loginDTO.getPassword()
        );

        // JwtUtil geralmente gera token usando apenas o username
        String token = jwtUtil.generateToken(user.getUsername());

        LoginResponseDTO response = new LoginResponseDTO(
                user.getId(),
                user.getUsername(),
                token
        );

        return ResponseEntity.ok(response);
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

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Token ausente ou inválido.");
        }

        String token = authHeader.substring(7);

        boolean isValid = jwtUtil.validateToken(token);

        if (!isValid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido.");
        }

        String username = jwtUtil.extractUsername(token);

        return ResponseEntity.ok("Token válido para usuário: " + username);
    }
}
