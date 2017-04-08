package com.javastud.springmvcweb;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Locale locale, HttpServletRequest request, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "profile";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String profile() {
		return "login";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getCurrentUserName());
		return "accessDenied";
	}

	private String getCurrentUserName() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String rest() {
		return "rest";
	}

	@RequestMapping(value = "/angular", method = RequestMethod.GET)
	public String angular() {
		return "currency";
	}

}
