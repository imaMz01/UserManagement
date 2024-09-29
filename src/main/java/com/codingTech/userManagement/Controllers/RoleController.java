package com.codingTech.userManagement.Controllers;

import com.codingTech.userManagement.Dto.RoleDto;
import com.codingTech.userManagement.Services.RoleService.RoleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Role")
public class RoleController {

    private final RoleService roleService;

    @PostMapping("addRole")
    public RoleDto addRole(@RequestBody RoleDto roleDto){
        return  roleService.add(roleDto);
    }

    @GetMapping("allRoles")
    public List<RoleDto> allRoles(){
        return roleService.roles();
    }

    @DeleteMapping("delete/{id}")
    public String deleteRole(@PathVariable Long id){
        return roleService.delete(id);
    }

    @GetMapping("roleById/{id}")
    public RoleDto roleById(@PathVariable Long id){
        return roleService.roleById(id);
    }

    @PutMapping("updateRole")
    public RoleDto updateRole(@RequestBody RoleDto roleDto){
        return  roleService.update(roleDto);
    }
}
