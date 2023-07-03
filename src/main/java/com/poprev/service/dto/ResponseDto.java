package com.poprev.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private Long id;

    private String token;

    private String firstName;

    private String username;

    private String lastName;

    private String phoneNumber;

    private String email;

    private Boolean isVerified;

    private LocalDateTime createdDate;

    private String verificationToken;

    private String dateOfBirth;


}
