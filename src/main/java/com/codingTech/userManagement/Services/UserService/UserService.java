package com.codingTech.userManagement.Services.UserService;

import com.codingTech.userManagement.Dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto add(UserDto userDto);
    List<UserDto> users();
    UserDto userById(Long id);
    UserDto userByEmail(String email);
    UserDto login(UserDto userDto);
    UserDto update(UserDto userDto);
    String delete(String email);
}
