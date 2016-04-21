package com.alexberemart.core.model.dao.base.hibernate;


import com.alexberemart.core.model.dao.base.GenericDAO;

import java.io.Serializable;


/**
 * GenericDAO extension for Hibernate based implementations
 *
 */
public interface GenericHibernateDAO<T, ID extends Serializable> extends GenericDAO<T, ID> {
	//
}
