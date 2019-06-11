package com.example.inventory.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.domain.Location;

@Transactional
@Repository
public class LocationDaoImpl extends BaseDao implements LocationDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> findAll() throws Exception {
		return getSession().createCriteria(Location.class).list();
	}

	@Override
	public Location findById(Integer id) throws Exception {
		return (Location) getSession().get(Location.class, id);
	}

	@Override
	public void insert(Location location) throws Exception {
		getSession().save(location);
	}

	@Override
	public void update(Location location) throws Exception {
		getSession().update(location);
	}

	@Override
	public void delete(Location location) throws Exception {
		getSession().delete(location);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> findLocationList() {
		List<Location> locationList = getSession().createCriteria(Location.class).list();
		Location all = new Location();
		all.setId(0);
		all.setName("ALL");
		locationList.add(0, all);
		return locationList;
	}

	@Override
	public List<Location> findByLocationId(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
