package com.example.inventory.dao;

import java.util.List;

import com.example.inventory.domain.Location;

public interface LocationDao {

	public List<Location> findAll() throws Exception;

	public Location findById(Integer id) throws Exception;

	public void insert(Location location) throws Exception;

	public void update(Location location) throws Exception;

	public void delete(Location location) throws Exception;

	public List<Location> findLocationList();

	public List<Location> findByLocationId(Integer id);

}
