package com.mauro.authapi.dto;

public record LoginResponseDTO(
        Long id,
        String username,
        String token
) {}
