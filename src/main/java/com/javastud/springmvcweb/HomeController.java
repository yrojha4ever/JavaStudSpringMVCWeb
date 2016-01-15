package com.javastud.springmvcweb;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javastud.springmvcweb.dao.JdbcTemplateService;
import com.javastud.springmvcweb.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private JdbcTemplateService jdbcTemplateService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession session ) {
		logger.info("Welcome home! The client locale is {}.", locale);

		if (StringUtils.isEmpty(session.getAttribute("activeUser"))) {
			return "login";
		}
		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profile(@ModelAttribute User user, Model model, HttpSession session) {
		session.setAttribute("activeUser", user.getUsername());
		session.setMaxInactiveInterval(10 * 60);
		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileGET(HttpSession session) {
		if (StringUtils.isEmpty(session.getAttribute("activeUser"))) {
			return "login";
		}
		return "profile";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

}
