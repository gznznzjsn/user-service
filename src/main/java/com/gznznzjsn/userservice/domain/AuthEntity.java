package com.gznznzjsn.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthEntity {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String accessToken;
    private String refreshToken;

}
