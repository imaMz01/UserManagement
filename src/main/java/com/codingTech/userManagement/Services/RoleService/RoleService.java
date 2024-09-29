package com.codingTech.userManagement.Services.RoleService;

import com.codingTech.userManagement.Dto.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto add(RoleDto roleDto);
    List<RoleDto> roles();
    String delete(Long id);
    RoleDto roleById(Long id);
    RoleDto update(RoleDto roleDto);

}
