package com.gznznzjsn.userservice.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.gznznzjsn.userservice.web.dto.group.OnAuthenticate;
import com.gznznzjsn.userservice.web.dto.group.OnRefresh;
import com.gznznzjsn.userservice.web.dto.group.OnRegister;
import com.gznznzjsn.userservice.web.dto.group.OnValidate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record AuthEntityDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotBlank(message = "User's name can't be blank!", groups = OnRegister.class)
        @Length(max = 40, message = "Too long name!", groups = OnRegister.class)
        String name,

        @Email(message = "It's not an email!", groups = {OnRegister.class, OnAuthenticate.class})
        @NotBlank(message = "Email can't be blank!", groups = {OnRegister.class, OnAuthenticate.class})
        @Length(max = 40, message = "Too long email!", groups = {OnRegister.class, OnAuthenticate.class})
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String email,

        @NotBlank(message = "Password can't be blank!", groups = {OnRegister.class, OnAuthenticate.class})
        @Length(max = 255, message = "Too long password!", groups = {OnRegister.class, OnAuthenticate.class})
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String password,

        @NotBlank(message = "Access token can't be blank!", groups = {OnValidate.class})
        String accessToken,

        @NotBlank(message = "Refresh token can't be blank!", groups = {OnRefresh.class})
        String refreshToken

) {
}
