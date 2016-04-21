package com.alexberemart.core.model.dao.impl;

import com.alexberemart.core.model.dao.PermissionDAO;
import com.alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import com.alexberemart.core.model.vo.user.Permission;

public class PermissionDAOImpl extends GenericHibernateSpringDAOImpl<Permission, String> implements PermissionDAO {

    public PermissionDAOImpl() {
        super(Permission.class);
    }

}
