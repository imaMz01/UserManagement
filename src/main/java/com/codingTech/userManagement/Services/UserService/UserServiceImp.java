package com.codingTech.userManagement.Services.UserService;


import com.codingTech.userManagement.Dto.UserDto;
import com.codingTech.userManagement.Dto.UserRequest;
import com.codingTech.userManagement.Entities.Role;
import com.codingTech.userManagement.Entities.User;
import com.codingTech.userManagement.Mappers.RoleMapper;
import com.codingTech.userManagement.Mappers.UserMapper;
import com.codingTech.userManagement.Repositories.UserRepository;
import com.codingTech.userManagement.Services.RoleService.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;
    @Override
    public UserDto add(UserDto userDto) {
        System.out.println(userDto.toString());
        if( ! checkEmail(userDto.getEmail())){
            User user = userMapper.userDtoToUser(userDto);
            Role role = RoleMapper.roleMapper.roleDtoToRole(
                    roleService.roleById(userDto.getRole().getId())
            );
            user.setActivated(false);
            user.setRole(role);
            return userMapper.userToUserDto(userRepository.save(user));
        }else{
            throw new RuntimeException("Email already exist");
        }

    }

    @Override
    public List<UserDto> users() {
        userRepository.findAll().forEach(u-> System.out.println(u.getRole().toString()));
        return userMapper.userToUserDto(userRepository.findAll());
    }

    @Override
    public UserDto userById(Long id) {
        return userMapper.userToUserDto(
                userRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("User not found")
        ));
    }

    @Override
    public UserDto userByEmail(String email) {
        return userMapper.userToUserDto(
                userRepository.findByEmail(email).orElseThrow(
                        () -> new RuntimeException("User not found")
                )
        );
    }

    @Override
    public UserDto login(UserRequest userRequest) {
        Optional<User> user = userRepository.findByEmail(userRequest.getEmail());
        return userMapper.userToUserDto(
                user.filter(
                        value -> value.getPassword().equals(userRequest.getPassword())
                ).
                        orElseThrow( () -> new RuntimeException("Email or password incorrect"))
        );
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userMapper.userDtoToUser(
                userById(userDto.getId())
        );
        Role role = RoleMapper.roleMapper.roleDtoToRole(
                roleService.roleById(userDto.getRole().getId())
        );

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRole(role);
        user.setPassword(userDto.getPassword());
        return userMapper.userToUserDto(userRepository.save(user));
    }

    @Override
    public String delete(Long id) {
        userRepository.findById(id).ifPresentOrElse(
                        user -> userRepository.deleteById(user.getId())
                ,
                        () -> {
                            throw  new RuntimeException("User not found");
                        }
        );
        return "User was deleted successfully";
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
