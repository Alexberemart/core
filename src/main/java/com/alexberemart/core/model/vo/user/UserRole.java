package com.alexberemart.core.model.vo.user;

import com.alexberemart.core.model.vo.base.BaseEntity;
import com.alexberemart.core.model.vo.user.Role;

import javax.persistence.*;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "user_roles")
@Entity
public class UserRole extends BaseEntity {

    protected String userCode = null;

    private Role role;

    @Column(name = "user_code")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

}
