package com.javastud.springmvcweb;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/home"}, method = RequestMethod.GET)
	public String home(Locale locale, HttpServletRequest request, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "profile";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String profile() {
		return "login";
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String profilePOST(@ModelAttribute User user, Model model, HttpSession session) {

		try {
			UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
			if (bCryptPasswordEncoder.matches(user.getPassword(), userDetails.getPassword())) {
				logger.info("Successfully loged in: User : " + userDetails.getUsername());
				return "profile";
			}
		} catch (UsernameNotFoundException e) {
		}

		// Show error msg in login screen.
		model.addAttribute("loginError", "Sorry User/Password invalid! Please re-login.");
		logger.error("Sorry User/Password invalid! Please re-login.");
		return "redirect:/login?error";

	}*/

	@RequestMapping(value = { "/logout", "/session-expired" }, method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
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
