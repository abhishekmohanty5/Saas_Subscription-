package com.jobhunt.saas.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthContext {
    public Long getCurrentUserId() {
        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        if (!(principal instanceof CustomUserDetail)) {
            throw new SecurityException("Unauthenticated user");
        }
        return ((CustomUserDetail) principal).getId();
    }

}
