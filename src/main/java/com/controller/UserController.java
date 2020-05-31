package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	/*
	 * @RequestMapping(value="/adduser") public String addUser(Model m){
	 * //applictionContext ->instance -- //manule instance create
	 * 
	 * m.addAttribute("userBean",new UserBean()); ///jsp -->user bean -->
	 * userbean empty return "addUser"; }
	 */

	@RequestMapping(value = "/adduser")
	public ModelAndView addUser(ModelAndView model) { // applictionContext
														// ->instance --
		// manule instance create

		// m.addAttribute("userBean",new UserBean());
		model.addObject("userBean", new UserBean());
		model.setViewName("addUser");
		/// jsp -->user bean --> userbean empty
		return model;
	}

	@RequestMapping(value = "/insertuser")
	public String insertUser(UserBean userBean) {

		int status = userDao.addUser(userBean);
		return "redirect:/viewuser";
	}

	@RequestMapping(value = "/viewuser")
	public String viewUser(Model model) {

		List<UserBean> userList = userDao.listofUser();
		// servet
		System.out.println(userList.get(0).getuName());
		model.addAttribute("users", userList);

		return "viewUser";
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {

		model.addAttribute("userLogin", new UserBean());
		return "Login";
	}

	@RequestMapping(value = "/userlogin")
	public String loginUser(UserBean userBean, Model model, HttpSession session) {

		UserBean userBean2 = userDao.loginUser(userBean);
		model.addAttribute("loggedinuser", userBean2);

		session.setAttribute("loggedinuser", userBean2);
		return "index";
	}

}
