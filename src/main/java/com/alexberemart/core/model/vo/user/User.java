package com.alexberemart.core.model.vo.user;


import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JacksonInject;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Collection;

@JsonAutoDetect
public class User extends org.springframework.security.core.userdetails.User {

    public User(@JacksonInject("username") String username,
                @JacksonInject("password") String password,
                @JacksonInject Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    @Id
    protected String id;

    @Column(name = "user_name")
    protected String userCode = null;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
