package com.gznznzjsn.userservice.web.controller;


import com.gznznzjsn.userservice.domain.AuthEntity;
import com.gznznzjsn.userservice.service.AuthenticationService;
import com.gznznzjsn.userservice.web.dto.AuthEntityDto;
import com.gznznzjsn.userservice.web.dto.group.OnAuthenticate;
import com.gznznzjsn.userservice.web.dto.group.OnRefresh;
import com.gznznzjsn.userservice.web.dto.group.OnRegister;
import com.gznznzjsn.userservice.web.dto.group.OnValidate;
import com.gznznzjsn.userservice.web.dto.mapper.AuthEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final AuthEntityMapper authEntityMapper;

    @PostMapping("/register")
    public AuthEntityDto register(@Validated(OnRegister.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        return authEntityMapper.toDto(
                authenticationService.register(authEntity)
        );
    }

    @PostMapping("/authenticate")
    public AuthEntityDto authenticate(@Validated(OnAuthenticate.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        return authEntityMapper.toDto(
                authenticationService.authenticate(authEntity)
        );
    }

    @PostMapping("/refresh")
    public AuthEntityDto refresh(@Validated(OnRefresh.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        return authEntityMapper.toDto(
                authenticationService.refresh(authEntity)
        );
    }

    @PostMapping("/validate")
    public AuthEntityDto validate(@Validated(OnValidate.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        return authEntityMapper.toDto(
                authenticationService.validate(authEntity)
        );
    }

}
