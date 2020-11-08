package com.antikryptonite.outsourcing.configurations.security;

import com.antikryptonite.outsourcing.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * Это что-то вроде ДТО?
 */
public class CustomUserDetails implements UserDetails {

    private String login;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    /**
     * Конвертация сущности пользователя
     *
     * @param userEntity - параметры сущности пользователя
     * @return - конвертированная сущность пользователя
     */
    public static CustomUserDetails fromUserEntityToCustomUserDetails(UserEntity userEntity) {
        CustomUserDetails c = new CustomUserDetails();
        c.login = userEntity.getLogin();
        c.password = userEntity.getPassword();
        c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRoleEntity().getName()));
        return c;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
