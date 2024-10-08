package com.codingTech.userManagement.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private long id;
    private String name;
    private String email;
    private String password;
    private RoleDto role;
}
