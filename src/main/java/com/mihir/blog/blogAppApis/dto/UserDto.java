package com.mihir.blog.blogAppApis.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String about;
}
