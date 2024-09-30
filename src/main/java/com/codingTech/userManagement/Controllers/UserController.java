package com.codingTech.userManagement.Controllers;

import com.codingTech.userManagement.Dto.UserDto;
import com.codingTech.userManagement.Dto.UserRequest;
import com.codingTech.userManagement.Services.UserService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/User")
public class UserController {

    private final UserService userService;

    @GetMapping("Users")
    public List<UserDto> users(){
        return userService.users();
    }

    @GetMapping("userById/{id}")
    public UserDto userById(@PathVariable Long id){
        return userService.userById(id);
    }

    @GetMapping("userByEmail/{email}")
    public UserDto userByEmail(@PathVariable String email){
        return userService.userByEmail(email);
    }

    @PostMapping("addUser")
    public UserDto addUser(@RequestBody UserDto userDto){
        return userService.add(userDto);
    }

    @PostMapping("login")
    public UserDto login(@RequestBody UserRequest userRequest){
       return userService.login(userRequest);
    }

    @PutMapping("update")
    public UserDto update(@RequestBody UserDto userDto){
        return userService.update(userDto);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return userService.delete(id);
    }

}
