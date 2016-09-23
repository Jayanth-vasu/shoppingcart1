package com.niit.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopping.model.UserDetails;
import com.niit.shopping.service.LoginService;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String loginshow() {

		return "login";
	}

	@ModelAttribute("userDetails")
	public UserDetails getob() {
		return new UserDetails();
	}

	

/*@RequestMapping(value = { "/login", "/userLogin" }, method = RequestMethod.POST)
public String login(@RequestParam(value = "error", required = false) String error,
  @RequestParam(value = "logout", required = false) String logout, Model model) {
 String ret = "";
 System.out.println("in admin login" + error);
 if (error != null) {
  ret = "error";
  System.out.println("errrr");
  model.addAttribute("error", "Invalid username and password!");
 } else if (error == null) {
  System.out.println("succ");
  ret = "index";
  model.addAttribute("error", "Success!");
 }
 if (logout != null) {

  model.addAttribute("error", "You have been logged out successfully.");
 }

 return ret;
}*/
}
/*
 * @Autowired(required = true) LoginService ls;
 * 
 * @RequestMapping(value = "/loginpage", method = RequestMethod.POST) public
 * ModelAndView loginuser(@ModelAttribute UserDetails u) { boolean isvaliduser =
 * false;
 * 
 * u.setUser_name(name); u.setUser_password(pwd);
 * 
 * isvaliduser = ls.checkUser(u); ModelAndView mv = new ModelAndView("index");
 * if (isvaliduser == true) {
 * 
 * mv.addObject("msg", "Welcome"); mv.addObject("name", u.getUser_firstname());
 * } return mv; }
 * 
 * }
 */