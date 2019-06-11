package com.example.inventory.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.inventory.dao.ItemDao;
import com.example.inventory.dao.LocationDao;
import com.example.inventory.domain.Item;
import com.example.inventory.domain.Location;

@Controller
public class ItemController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(format, true));
	}

	@Autowired
	private LocationDao locationDao;
	@Autowired
	private ItemDao itemDao;

	@RequestMapping(value = { "/", "/listItem" }, method = RequestMethod.GET)
	public String listGet(Model model) throws Exception {
		List<Item> itemList = itemDao.findAll();
		model.addAttribute("itemList", itemList);
		List<Location> locationList = locationDao.findLocationList();
		model.addAttribute("locationList", locationList);
		model.addAttribute("location", new Location());
		return "listItem";
	}

	@RequestMapping(value = { "/", "/listItem" }, method = RequestMethod.POST)
	public String listPost(
			Location location,
			Errors errors,
			Model model) throws Exception {
		List<Location> locationList = locationDao.findLocationList();
		model.addAttribute("locationList", locationList);
		model.addAttribute("location", location);
		List<Item> itemList = itemDao.findByLocationId(location.getId());
		model.addAttribute("itemList", itemList);
		return "listItem";
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public String addGet(Model model) throws Exception {
		List<Location> locationList = locationDao.findAll();
		model.addAttribute("locationList", locationList);
		Item item = new Item();
		model.addAttribute("item", item);
		return "addItem";
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addPost(
			@Valid Item item,
			Errors errors,
			Model model) throws Exception {
		List<Location> locationList = locationDao.findAll();
		model.addAttribute("locationList", locationList);
		if (!errors.hasErrors()) {
			// データの追加
			itemDao.insert(item);
			// 完了ページを表示
			return "addItemDone";
		} else {
			// フォームを再表示
			return "addItem";
		}
	}

	@RequestMapping(value = "/editItem", method = RequestMethod.GET)
	public String editGet(@RequestParam Integer id, Model model) throws Exception {
		List<Location> locationList = locationDao.findAll();
		model.addAttribute("locationList", locationList);
		Item item = itemDao.findById(id);
		System.out.println(item.getId());
		model.addAttribute("item", item);
		return "editItem";
	}

	@RequestMapping(value = "/editItem", method = RequestMethod.POST)
	public String editPost(
			@Valid Item item,
			Errors errors,
			Model model) throws Exception {
		List<Location> locationList = locationDao.findAll();
		model.addAttribute("locationList", locationList);
		// 完了ページを表示

		if (!errors.hasErrors()) {
			// データの追加
			item.setUpdated(new Date());
			itemDao.update(item);
			return "editItemDone";
		} else {
			// フォームを再表示
			return "editItem";
		}
	}

	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public String deleteGet(@RequestParam Integer id, Model model) throws Exception {
		List<Location> locationList = locationDao.findAll();
		model.addAttribute("locationList", locationList);
		Item item = new Item();
		item.setId(id);
		itemDao.delete(item);
		return "redirect:listItem";
	}
}
