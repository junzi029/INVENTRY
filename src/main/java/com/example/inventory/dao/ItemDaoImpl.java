package com.example.inventory.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.domain.Item;

@Transactional
@Repository
public class ItemDaoImpl extends BaseDao implements ItemDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findAll() throws Exception {
		return getSession().createCriteria(Item.class).addOrder(Order.asc("updated"))
				.setFetchMode("location", FetchMode.JOIN)
				.list();
	}

	@Override
	public Item findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return (Item) getSession().createCriteria(Item.class).add(Restrictions.eq("id", id))
				.addOrder(Order.asc("updated"))
				.setFetchMode("location", FetchMode.JOIN).uniqueResult();
	}

	@Override
	public void insert(Item item) throws Exception {
		item.setRegistered(new Date());
		item.setUpdated(new Date());
		getSession().save(item);
	}

	@Override
	public void update(Item item) throws Exception {
		getSession().update(item);
	}

	@Override
	public void delete(Item item) throws Exception {
		getSession().delete(item);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findByLocationId(Integer locationId) {
		if (locationId == 0) {
			return getSession().createCriteria(Item.class)
					.setFetchMode("location", FetchMode.JOIN)
					.list();
		} else {
			return getSession().createCriteria(Item.class).add(Restrictions.eq("location.id", locationId))
					.setFetchMode("location", FetchMode.JOIN)
					.list();
		}
	}

}
