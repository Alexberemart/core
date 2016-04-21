package com.alexberemart.core.model.vo.user;

import com.alexberemart.core.model.vo.base.BaseEntity;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "permissions")
@javax.persistence.Entity
public class Permission extends BaseEntity implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = -6695743044613509351L;

    @Transient
    @JsonIgnore
    public String getName() { return id; }

    @Override
    @Transient
    @JsonIgnore
    public String getAuthority() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        GrantedAuthority ga = (GrantedAuthority) o;
        return (getAuthority().equals(ga.getAuthority()));
    }

    @Override
    public int hashCode() {
        return getAuthority().hashCode();
    }

}
