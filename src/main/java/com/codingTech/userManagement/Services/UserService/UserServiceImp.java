package com.codingTech.userManagement.Services.UserService;


import com.codingTech.userManagement.Dto.UserDto;
import com.codingTech.userManagement.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;


    @Override
    public UserDto add(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> users() {
        return List.of();
    }

    @Override
    public UserDto userById(Long id) {
        return null;
    }

    @Override
    public UserDto userByEmail(String email) {
        return null;
    }

    @Override
    public UserDto login(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto update(UserDto userDto) {
        return null;
    }

    @Override
    public String delete(String email) {
        return "";
    }
}
