package com.codingTech.userManagement.Services.UserService;

import com.codingTech.userManagement.Dto.UserDto;
import com.codingTech.userManagement.Dto.UserRequest;

import java.util.List;

public interface UserService {

    UserDto add(UserDto userDto);
    List<UserDto> users();
    UserDto userById(Long id);
    UserDto userByEmail(String email);
    UserDto login(UserRequest userRequest);
    UserDto update(UserDto userDto);
    String delete(Long id);
    boolean checkEmail(String email);
}
