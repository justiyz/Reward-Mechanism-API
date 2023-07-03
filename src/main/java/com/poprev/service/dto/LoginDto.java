package com.poprev.service.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDto {

    private String email;

    @NotEmpty
    private String password;

    private String type;

}
