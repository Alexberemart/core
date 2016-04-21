package com.alexberemart.core.model.dao.impl;

import com.alexberemart.core.model.dao.RoleDAO;
import com.alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import com.alexberemart.core.model.vo.user.Role;

public class RoleDAOImpl extends GenericHibernateSpringDAOImpl<Role, String> implements RoleDAO {

    public RoleDAOImpl() {
        super(Role.class);
    }

}
