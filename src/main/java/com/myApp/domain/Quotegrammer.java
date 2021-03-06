package com.myApp.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Quotegrammer extends User implements UserDetails {

    public Quotegrammer(User user) {
        super(user);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(getRoles().split(","))
                .map(role -> new SimpleGrantedAuthority("ROLE_" +role))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive();
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}
