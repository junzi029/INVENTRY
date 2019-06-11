package com.example.inventory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.inventory.dao.UserDao;
import com.example.inventory.domain.User;
import com.example.inventory.group.LoginGroup;

@Controller
public class AuthController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@Validated(LoginGroup.class) User user, Errors errors, HttpSession session)
			throws Exception {
		if (!errors.hasErrors()) {
			user = userDao.findByLoginIdAndLoginPass(
					user.getLoginId(), user.getLoginPass());
			if (user != null) {
				session.setAttribute("userId", user.getId());
				session.setAttribute("userName", user.getName());
				return "redirect:/listItem";
			} else {
				errors.reject("error.login");
				return "login";
			}
		} else {
			return "login";
		}
	}

	@RequestMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "logoutDone";
	}

}
