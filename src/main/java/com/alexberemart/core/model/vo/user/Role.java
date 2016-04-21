package com.alexberemart.core.model.vo.user;

import com.alexberemart.core.model.vo.base.BaseEntity;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "roles")
@Entity
public class Role extends BaseEntity implements GrantedAuthority, Serializable {
    protected String description;

    public Role(){
        super();
    }

    private static final long serialVersionUID = -1735136402719224939L;


    private Set<Permission> permissions = new HashSet<Permission>();

    @Transient
    @JsonIgnore
    public String getName() {
        return id;
    }

    @Override
    @Transient
    @JsonIgnore
    public String getAuthority() {
        return id;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permissions",
            joinColumns = { @JoinColumn(name = "role_id") },
            inverseJoinColumns = { @JoinColumn(name = "permission_id") })
    public Set<Permission> getPermissions() { return permissions; }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
