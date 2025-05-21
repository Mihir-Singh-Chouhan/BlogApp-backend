package com.mihir.blog.blogAppApis.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;

    @NotEmpty
    @Size(min=4,message = "Username must have atleast 4 charaters")
    private String name;

    @Email(message = "Email is Invalid format")
    private String email;

    @NotEmpty
    @Size(min = 6,message = "Password atleast of 6 charaters")
    private String password;

    @NotEmpty
    private String about;
}
