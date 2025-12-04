package com.mauro.authapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
