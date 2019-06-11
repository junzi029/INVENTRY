package com.example.inventory.dao;

import java.util.List;

import com.example.inventory.domain.UserType;

public interface UserTypeDao {

	public List<UserType> findAll() throws Exception;

	public UserType findById(Integer id) throws Exception;

	public void insert(UserType userType) throws Exception;

	public void update(UserType userType) throws Exception;

	public void delete(UserType userType) throws Exception;

}
