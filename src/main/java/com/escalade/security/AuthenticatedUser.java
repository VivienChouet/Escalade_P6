package com.escalade.security;


import com.escalade.entity.Role;
import com.escalade.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ramesh Fadatare
 */
public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;
    private Users user;

    public AuthenticatedUser(Users user) {
        super(user.getEmail(), user.getPassword(), getAuthorities(user));
        this.user = user;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Users user) {
        Set<String> roleAndPermissions = new HashSet<>();
        List<Role> roles = user.getRoles();

        for (Role role : roles) {
            roleAndPermissions.add(role.getName());
        }
        String[] roleNames = new String[roleAndPermissions.size()];
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
        return authorities;
    }

    public Users getUser() {
        return user;
    }
}