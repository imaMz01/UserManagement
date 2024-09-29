package com.codingTech.userManagement.Mappers;


import com.codingTech.userManagement.Dto.RoleDto;
import com.codingTech.userManagement.Entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper roleMapper = Mappers.getMapper(RoleMapper.class);
    RoleDto roleToRoleDto(Role user);
    Role roleDtoToRole(RoleDto userDto);
    List<RoleDto> roleToRoleDto(List<Role> user);
    List<Role> roleDtoToRole(List<RoleDto> userDto);
}
