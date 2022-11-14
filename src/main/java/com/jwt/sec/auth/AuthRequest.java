package com.jwt.sec.auth;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Getter
@Setter
public class AuthRequest {
    @NotNull
    @Email
    @Length(min = 5, max = 50)
    private String email;

    @NotNull @Length(min = 5, max = 10)
    private String password;
}
