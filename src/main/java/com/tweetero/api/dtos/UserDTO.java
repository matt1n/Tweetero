package com.tweetero.api.dtos;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank
    @URL
    private String avatar;
    
    @NotBlank
    @Size(max = 100, message = "O nome tem que ter até 100 caractéres")
    private String username;
}
