package com.example.WorkFlowManagement.dto.response;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

public class UserDetail extends User {
    private final String userId;

    public UserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, String userId) {
        super(username, password, authorities);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
