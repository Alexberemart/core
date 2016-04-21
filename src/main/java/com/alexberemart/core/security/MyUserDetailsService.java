package com.alexberemart.core.security;

import com.alexberemart.core.model.vo.user.Permission;
import com.alexberemart.core.model.vo.user.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * User Details Service - hard coded to two users for the example.
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private final Log logger = LogFactory.getLog(this.getClass());

    private Map<String, User> availableUsers = new HashMap<String, User>();

    public MyUserDetailsService() {

        populateDemoUsers();

    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        availableUsers = new HashMap<String, User>();

        populateDemoUsers();

        logger.info("Load user by username " + username);

        User user = availableUsers.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        } else {
            return availableUsers.get(username);
        }

    }

    /**
     * Create demo users (note: obviously in a real system these would be persisted
     * in database or retrieved from another system).
     */
    private void populateDemoUsers() {

        logger.info("Populate demo users");

        availableUsers.put("admin", createUser("admin", "password", Arrays.asList("HTU_ADMIN")));
        availableUsers.put("user", createUser("user", "user", Arrays.asList("HTU_USER")));
        availableUsers.put("Alex6", createUser("Alex6", "Alex6", Arrays.asList("HTU_USER")));
    }

    /**
     * Create a demo User.
     *
     * @param username
     *            Username
     * @param password
     *            Password
     * @param roles
     *            Role names user is assigned to
     * @return User
     */
    private User createUser(String username, String password, List<String> roles) {

        logger.info("Create user " + username);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            Permission permission = new Permission();
            permission.setId(role);
            authorities.add(permission);
        }
        return new User(username, password, authorities);
    }
}