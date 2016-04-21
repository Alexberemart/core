package com.alexberemart.core.model.dao;

import com.alexberemart.core.model.dao.base.hibernate.GenericHibernateDAO;
import com.alexberemart.core.model.vo.user.Role;
import com.alexberemart.core.model.vo.user.User;
import com.alexberemart.core.model.vo.user.UserRole;

import java.util.List;

public interface UserRoleDAO extends GenericHibernateDAO<UserRole, String> {

    public List<UserRole> getUserRoles(User user);

    public List<UserRole> getUserRoles(String userCode);

    public UserRole addRoleToUser(String userCode, String roleName);

    public UserRole addRoleToUser(String userCode, Role role);

    public UserRole addRoleToUser(UserRole userRole);

    public void revokeRoleToUser(String userCode, String roleName);

    public void revokeRoleToUser(String userCode, Role role);

    public void revokeRoleToUser(UserRole userRole);

    public void deleteByUserCode(String userCode);
}
