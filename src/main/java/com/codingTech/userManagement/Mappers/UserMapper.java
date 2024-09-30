package com.codingTech.userManagement.Mappers;

import com.codingTech.userManagement.Dto.UserDto;
import com.codingTech.userManagement.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper {

    //UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    List<UserDto> userToUserDto(List<User> user);
    List<User> userDtoToUser(List<UserDto> userDto);
}
