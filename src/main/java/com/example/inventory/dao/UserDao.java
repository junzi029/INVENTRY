package com.example.inventory.dao;

import java.util.List;

import com.example.inventory.domain.User;

public interface UserDao {

	public List<User> findAll() throws Exception;

	public User findById(Integer id) throws Exception;

	public void insert(User user) throws Exception;

	public void update(User user) throws Exception;

	public void delete(User user) throws Exception;

	public User findByLoginIdAndLoginPass(String loginId, String loginPass)
			throws Exception;

}
