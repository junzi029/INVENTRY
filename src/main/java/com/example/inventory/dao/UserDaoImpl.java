package com.example.inventory.dao;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.domain.User;

@Transactional
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() throws Exception {
		return getSession().createCriteria(User.class).setFetchMode("userType", FetchMode.JOIN).list();
	}

	@Override
	public User findById(Integer userId) throws Exception {
		return (User) getSession().createCriteria(User.class).add(Restrictions.eq("id", userId))
				.setFetchMode("userType", FetchMode.JOIN).uniqueResult();
	}

	@Override
	public void insert(User user) throws Exception {
		getSession().save(user);
	}

	@Override
	public void update(User user) throws Exception {
		getSession().update(user);
	}

	@Override
	public void delete(User user) throws Exception {
		getSession().delete(user);
	}

	@Override
	public User findByLoginIdAndLoginPass(String loginId, String loginPass) throws Exception {
		User user = (User) getSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("loginId", loginId))
				.uniqueResult();

		if (user == null) {
			return null;
		}

		if (BCrypt.checkpw(loginPass, user.getLoginPass())) {
			return user;
		} else {
			return null;
		}
	}

}
