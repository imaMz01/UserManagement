package com.codingTech.userManagement.Mappers;


import com.codingTech.userManagement.Dto.RoleDto;
import com.codingTech.userManagement.Entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper roleMapper = Mappers.getMapper(RoleMapper.class);
    RoleDto roleToRoleDto(Role role);
    Role roleDtoToRole(RoleDto roleDto);
    List<RoleDto> roleToRoleDto(List<Role> roles);
    List<Role> roleDtoToRole(List<RoleDto> roleDtos);
}
