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

import com.example.inventory.dao.LocationDao;
import com.example.inventory.domain.Location;

@Controller
public class LocationController {
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
	private LocationDao LocationDao;

	@RequestMapping(value = "/listLocation", method = RequestMethod.GET)
	public String listGet(Model model) throws Exception {
		List<Location> LocationList = LocationDao.findAll();
		model.addAttribute("LocationList", LocationList);
		List<Location> locationList = locationDao.findLocationList();
		model.addAttribute("locationList", locationList);
		model.addAttribute("location", new Location());
		return "listLocation";
	}

	@RequestMapping(value = "/listLocation", method = RequestMethod.POST)
	public String listPost(
			Location location,
			Errors errors,
			Model model) throws Exception {
		List<Location> locationList = locationDao.findLocationList();
		model.addAttribute("locationList", locationList);
		model.addAttribute("location", location);
		List<Location> LocationList = LocationDao.findByLocationId(location.getId());
		model.addAttribute("LocationList", LocationList);
		return "listLocation";
	}

	@RequestMapping(value = "/addLocation", method = RequestMethod.GET)
	public String addGet(Model model) throws Exception {
		Location location = new Location();
		model.addAttribute("location", location);
		return "addLocation";
	}

	@RequestMapping(value = "/addLocation", method = RequestMethod.POST)
	public String addPost(
			@Valid Location Location,
			Errors errors,
			Model model) throws Exception {
		List<Location> locationList = locationDao.findAll();
		model.addAttribute("locationList", locationList);
		if (!errors.hasErrors()) {
			// データの追加
			try {

				LocationDao.insert(Location);
			} catch (Exception e) {
				e.printStackTrace();
				errors.rejectValue("name", "error.location.name");
				// フォームを再表示
				return "addLocation";
			}
			// 完了ページを表示
			return "addLocationDone";
		} else {
			// フォームを再表示
			return "addLocation";
		}
	}

	@RequestMapping(value = "/editLocation", method = RequestMethod.GET)
	public String editGet(@RequestParam Integer id, Model model) throws Exception {
		List<Location> locationList = locationDao.findAll();
		model.addAttribute("locationList", locationList);
		Location Location = LocationDao.findById(id);
		System.out.println(Location.getId());
		model.addAttribute("Location", Location);
		return "editLocation";
	}

	@RequestMapping(value = "/editLocation", method = RequestMethod.POST)
	public String editPost(
			@Valid Location Location,
			Errors errors,
			Model model) throws Exception {
		List<Location> locationList = locationDao.findAll();
		model.addAttribute("locationList", locationList);
		// 完了ページを表示

		if (!errors.hasErrors()) {
			// データの追加

			LocationDao.update(Location);
			return "editLocationDone";
		} else {
			// フォームを再表示
			return "editLocation";
		}
	}

	@RequestMapping(value = "/deleteLocation", method = RequestMethod.GET)
	public String deleteGet(@RequestParam Integer id, Model model) throws Exception {
		List<Location> locationList = locationDao.findAll();
		model.addAttribute("locationList", locationList);
		Location Location = new Location();
		Location.setId(id);
		LocationDao.delete(Location);
		return "redirect:listLocation";
	}
}
