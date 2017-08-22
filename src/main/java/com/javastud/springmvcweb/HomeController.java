package com.javastud.springmvcweb;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javastud.springmvcweb.dao.UserDao;
import com.javastud.springmvcweb.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, HttpServletRequest request, Model model ) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "login";
	}
	
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public String profile(HttpSession session){
		String activeUser = (String)session.getAttribute("activeUser");
		if(null == activeUser){
			return "login";
		}
		return "profile";
	}
	
	@RequestMapping(value="/profile", method = RequestMethod.POST)
	public String profilePOST( @ModelAttribute User user, Model model, HttpSession session){
		if(userDao.validateUser(user)){
			//Success: Display Profile
			session.setAttribute("activeUser", user.getUsername());
			session.setMaxInactiveInterval(3 * 60); //3 minute
			return "profile";
			
		}else {
			//Show error msg in login screen.
			model.addAttribute("loginError", "Sorry User/Password invalid! Please re-login.");
			logger.error("Sorry User/Password invalid! Please re-login.");
			return "login";
		}
	}
	
	@RequestMapping(value="/logout" , method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value="/rest", method = RequestMethod.GET)
	public String rest(){
		return "rest";
	}
	
	@RequestMapping(value="/angular", method = RequestMethod.GET)
	public String angular(){
		return "currency";
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String about(){
		return "about";
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/relation", method = RequestMethod.GET)
	public String saveAllRelationDemo(){
		return "relation/employee";
	}
	
}
