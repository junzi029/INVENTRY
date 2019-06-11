package com.example.inventory.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.domain.UserType;

@Transactional
@Repository
public class UserTypeDaoImpl extends BaseDao implements UserTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserType> findAll() throws Exception {
		return getSession().createCriteria(UserType.class).list();
	}

	@Override
	public UserType findById(Integer id) throws Exception {
		return (UserType) getSession().get(UserType.class, id);
	}

	@Override
	public void insert(UserType userType) throws Exception {
		getSession().save(userType);
	}

	@Override
	public void update(UserType userType) throws Exception {
		getSession().update(userType);
	}

	@Override
	public void delete(UserType userType) throws Exception {
		getSession().delete(userType);
	}

}
