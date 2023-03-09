package com.gznznzjsn.userservice.web.dto.mapper;


import com.gznznzjsn.userservice.domain.AuthEntity;
import com.gznznzjsn.userservice.web.dto.AuthEntityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthEntityMapper {

    AuthEntity toEntity(AuthEntityDto dto);

    AuthEntityDto toDto(AuthEntity entity);

}
