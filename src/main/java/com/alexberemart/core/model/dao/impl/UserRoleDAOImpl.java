package com.alexberemart.core.model.dao.impl;

import com.alexberemart.core.model.dao.RoleDAO;
import com.alexberemart.core.model.dao.UserRoleDAO;
import com.alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import com.alexberemart.core.model.vo.user.Role;
import com.alexberemart.core.model.vo.user.User;
import com.alexberemart.core.model.vo.user.UserRole;
import com.alexberemart.core.util.ApplicationContextProvider;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserRoleDAOImpl extends GenericHibernateSpringDAOImpl<UserRole, String> implements UserRoleDAO {

    public UserRoleDAOImpl() {
        super(UserRole.class);
    }

    public List<UserRole> getUserRoles(User user) {
        Criterion userCriteria = Restrictions.eq("userCode", user.getUserCode());

        return super.findByCriteria(userCriteria);
    }

    public List<UserRole> getUserRoles(String userCode) {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(UserRole.class)
                .add(Restrictions.eq("userCode", userCode))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return getHibernateTemplate().findByCriteria(detachedCriteria);
    }

    public UserRole addRoleToUser(String userCode, String roleName) {
        RoleDAO roleDAO = (RoleDAO) ApplicationContextProvider.getInstance().getBean("roleDAOTarget");
        final Role role = roleDAO.getById(roleName, true);

        return addRoleToUser(userCode, role);
    }

    public UserRole addRoleToUser(String userCode, Role role) {
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUserCode(userCode);

        return addRoleToUser(userRole);
    }

    public UserRole addRoleToUser(UserRole userRole) {
        return makePersistent(userRole);
    }

    @Override
    public void revokeRoleToUser(String userCode, String roleName) {
        RoleDAO roleDAO = (RoleDAO) ApplicationContextProvider.getInstance().getBean("roleDAOTarget");
        final Role role = roleDAO.getById(roleName, true);

        revokeRoleToUser(userCode, role);
    }

    @Override
    public void revokeRoleToUser(String userCode, Role role) {
        final DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(UserRole.class)
                .add(Restrictions.eq("userCode", userCode))
                .add(Restrictions.eq("role", role));

        final List<UserRole>byCriteria = this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if(byCriteria.size() != 0) {
            final UserRole userRole = byCriteria.get(0);
            revokeRoleToUser(userRole);
        }
    }

    @Override
    public void revokeRoleToUser(UserRole userRole) {
        makeTransient(userRole);
    }

    @Override
    public void deleteByUserCode(String userCode) {

        final DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(UserRole.class)
                .add(Restrictions.eq("userCode", userCode));

        final List<UserRole> userRoleList = this.getHibernateTemplate().findByCriteria(detachedCriteria);
        getHibernateTemplate().deleteAll(userRoleList);
    }
}
