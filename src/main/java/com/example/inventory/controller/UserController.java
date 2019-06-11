package com.example.inventory.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.inventory.dao.UserDao;
import com.example.inventory.dao.UserTypeDao;
import com.example.inventory.domain.User;
import com.example.inventory.domain.UserType;
import com.example.inventory.group.LoginGroup;

@Controller
public class UserController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// bind empty strings as null
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(format, true));
	}

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserTypeDao userTypeDao;

	@RequestMapping(value = "/mypage")
	public String list(HttpSession session, Model model) throws Exception {
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userDao.findById(userId);
		model.addAttribute("user", user);
		return "myPage";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addGet(Model model) throws Exception {
		List<UserType> userTypeList = userTypeDao.findAll();
		model.addAttribute("userTypeList", userTypeList);
		User user = new User();
		model.addAttribute("user", user);
		return "addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addPost(
			@Valid User user,
			Errors errors,
			Model model) throws Exception {
		List<UserType> userTypeList = userTypeDao.findAll();
		model.addAttribute("userTypeList", userTypeList);
		if (!errors.hasErrors()) {
			// データの追加
			userDao.insert(user);
			// 完了ページを表示
			return "addUserDone";
		} else {
			// フォームを再表示
			return "addUser";
		}
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String editGet(HttpSession session, Model model) throws Exception {
		List<UserType> userTypeList = userTypeDao.findAll();
		model.addAttribute("userTypeList", userTypeList);
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userDao.findById(userId);
		model.addAttribute("user", user);
		return "editUser";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String editPost(
			@Validated(LoginGroup.class) User user,
			Errors errors,
			HttpSession session, Model model) throws Exception {
		List<UserType> userTypeList = userTypeDao.findAll();
		model.addAttribute("userTypeList", userTypeList);
		// 完了ページを表示

		if (!errors.hasErrors()) {
			// データの追加
			Integer userId = (Integer) session.getAttribute("userId");
			User baseUser = userDao.findById(userId);

			user.setRegistered(baseUser.getRegistered());
			user.setUpdated(new Date());
			if (user.getLoginPass() == null) {
				user.setLoginPass(baseUser.getLoginPass());
				userDao.update(user);
			} else {
				String hashed = BCrypt.hashpw(user.getLoginPass(), BCrypt.gensalt());
				user.setLoginPass(hashed);
				userDao.update(user);
			}
			session.setAttribute("userName", user.getName());
			return "myPage";
		} else {
			// フォームを再表示
			return "editUser";
		}
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteGet(@RequestParam Integer id, Model model) throws Exception {
		List<UserType> userTypeList = userTypeDao.findAll();
		model.addAttribute("userTypeList", userTypeList);
		User user = new User();
		user.setId(id);
		userDao.delete(user);
		return "redirect:listUser";
	}
}
