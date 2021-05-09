package com.nikita.klimkin.testTaskJarSoft;

import com.nikita.klimkin.testTaskJarSoft.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotNull;
import java.util.Collection;
@Getter
public class AuthUser extends org.springframework.security.core.userdetails.User{

    @NotNull
    private User user;

    public AuthUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.user = user;
    }

    public int id() {
        return user.getId();
    }
}
