package com.alexberemart.core.security;

import com.alexberemart.core.model.vo.user.Permission;
import Alexberemart.core.util.StringUtils;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class AlexberemartPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return hasPermission(authentication, permission);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return hasPermission(authentication, permission);
    }

    private boolean hasPermission(Authentication authentication, Object permission) {
        if (permission instanceof String) {
            for (GrantedAuthority it : authentication.getAuthorities()) {
                if (it instanceof Permission) {
                    if (StringUtils.equals((String) permission, ((Permission) it).getId())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
