package com.codingTech.userManagement.Services.RoleService;

import com.codingTech.userManagement.Dto.RoleDto;
import com.codingTech.userManagement.Entities.Role;
import com.codingTech.userManagement.Mappers.RoleMapper;
import com.codingTech.userManagement.Repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService{

    private final RoleRepository roleRepository;

    @Override
    public RoleDto add(RoleDto roleDto) {
        Role role = RoleMapper.roleMapper.roleDtoToRole(roleDto);
        return RoleMapper.roleMapper.roleToRoleDto(roleRepository.save(role));
    }

    @Override
    public List<RoleDto> roles() {
        return RoleMapper.roleMapper.roleToRoleDto(roleRepository.findAll());
    }

    @Override
    public String delete(Long id) {
        roleRepository.deleteById(id);
        return "Role was delete successfully";
    }

    @Override
    public RoleDto roleById(Long id) {
        return RoleMapper.roleMapper.roleToRoleDto(roleRepository.findById(id).get());
    }

    @Override
    public RoleDto update(RoleDto roleDto) {
        Role role = RoleMapper.roleMapper.roleDtoToRole(roleDto);
        Role toSave = roleRepository.findById(role.getId()).orElseThrow(
                () -> new RuntimeException("Role not found")
        );
        toSave.setRole(role.getRole());
        return RoleMapper.roleMapper.roleToRoleDto(roleRepository.save(toSave));
    }
}
