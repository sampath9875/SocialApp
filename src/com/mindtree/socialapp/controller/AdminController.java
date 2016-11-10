/**
 * 
 */
package com.mindtree.socialapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.socialapp.entities.Event;
import com.mindtree.socialapp.entities.Location;
import com.mindtree.socialapp.entities.User;
import com.mindtree.socialapp.exceptions.InvalidLoginException;
import com.mindtree.socialapp.service.SocialAppService;

/**
 * @author azureUser
 *
 */

@Controller
public class AdminController {

	@Autowired(required = true)
	private User user;

	@Autowired(required = true)
	private Event event;

	@Autowired
	private SocialAppService socialAppService;

	/**
	 * 
	 */
	public AdminController() {
	}

	@RequestMapping(value = "adminlogin", method = RequestMethod.GET)
	public ModelAndView goToAdminLogin() {
		Map<String, Object> adminLogin = new HashMap<>();
		adminLogin.put("user", user);
		return new ModelAndView("adminlogin", adminLogin);
	}

	@RequestMapping(value = "adminsignup", method = RequestMethod.GET)
	public String adminSignUp(Model model) {
		model.addAttribute("user", user);
		return "adminsignup";
	}

	@ResponseBody
	@RequestMapping(value = "validateUserName", method = RequestMethod.GET, produces = "application/text")
	public String validateUserName(@RequestParam String userName) {
		boolean isValid = socialAppService.validUser(userName);
		if (isValid)
			return "valid";
		else
			return "inValid";
	}

	@RequestMapping(value = "adminSignUp.action", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		String resultPage = "redirect:/success?message=";
		if (bindingResult.hasErrors()) {
			resultPage = "redirect:/error?message=The%20user%20object%20passed%20has%20some%20errors2E%20Please%20try%20again";
		} else {
			if (!socialAppService.saveUser(user)) {
				resultPage = "redirect:/error?message=The%20user%20creation%20failed2E%20Please%20try%20again";
			} else {
				request.getSession().setAttribute("user", user);
				resultPage = "adminhome";
				// resultPage +=
				// "User%20Saved%20Successfully%2E%20Please%20login%20with%20your%20credentials%20to%20continue";
			}
		}
		return resultPage;
	}

	@RequestMapping(value = "adminLogin.action", method = RequestMethod.GET)
	public String loginRedirect(Model model, HttpServletRequest request) {
		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser == null) {
			return loginMandate(model);
		} else
			return "adminhome";
	}

	@RequestMapping(value = "adminLogin.action", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute User user, BindingResult bindingResult, Model model,
			HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "redirect:/error?message=The%20user%20object%20passed%20has%20some%20errors2E%20Please%20try%20again";
		} else {
			try {
				User sessionUser = socialAppService.getUser(user);
				request.getSession().setAttribute("user", sessionUser);
			} catch (InvalidLoginException e) {
				model.addAttribute("message", e.getMessage());
				return "adminlogin";
			}
		}
		return "adminhome";
	}

	@RequestMapping(value = "registerevents.get", method = RequestMethod.GET)
	public String registerEvents(Model model, HttpServletRequest request) {
		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser == null) {
			return loginMandate(model);
		} else {
			model.addAttribute("locations", socialAppService.getAllLocations());
			model.addAttribute("event", event);
			return "registerevents";
		}
	}

	@RequestMapping(value = "adminviewevents.get", method = RequestMethod.GET)
	public String viewEvents(Model model, HttpServletRequest request) {
		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser == null) {
			return loginMandate(model);
		} else {
			model.addAttribute("locations", socialAppService.getAllLocations());
			model.addAttribute("event", event);
			return "adminviewevents";
		}
	}

	@RequestMapping(value = "registerEvent.action", method = RequestMethod.GET)
	public String registerEventGet(Model model, HttpServletRequest request) {
		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser == null) {
			return loginMandate(model);
		} else {
			model.addAttribute("locations", socialAppService.getAllLocations());
			model.addAttribute("event", event);
			return "registerevents";
		}
	}

	@RequestMapping(value = "registerEvent.action", method = RequestMethod.POST)
	public String registerEvent(@ModelAttribute Event event, BindingResult result, HttpServletRequest request,
			Model model) {
		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser == null) {
			return loginMandate(model);
		} else if (result.hasErrors()) {
			return "redirect:/error?message=The%20user%20object%20passed%20has%20some%20errors2E%20Please%20try%20again";
		} else {
			event.setLocation(socialAppService.getLocationById(event.getLocation().getLocationId()));
			event.setUser(sessionUser);
			int eventId = socialAppService.registerEvent(event);
			if (eventId > 0)
				model.addAttribute("eventId", eventId);
			else
				model.addAttribute("message", "Failed to register Event. Please try again");
			return "adminhome";
		}
	}

	@RequestMapping(value = "getEvents.action", method = RequestMethod.POST)
	public String viewEventsPage(@ModelAttribute Event event, Model model, HttpServletRequest request) {
		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser == null) {
			return loginMandate(model);
		} else {
			List<Event> events;
			if (event == null)
				return "adminhome";
			else {
				Location location = event.getLocation();
				if (location.getLocationId() == 0) {
					events = socialAppService.getEventsForDate(event.getEventDate());
				} else
					events = socialAppService.getEventsForLocation(location);
				model.addAttribute("events", events);
			}

			return "viewevents";
		}
	}

	@RequestMapping(value = "adminHome.get", method = RequestMethod.GET)
	public String adminHome(Model model, HttpServletRequest request) {
		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser == null) {
			return loginMandate(model);
		} else
			return "adminhome";
	}

	@RequestMapping(value = "viewVolunteers", method = RequestMethod.GET)
	public String viewRegistrations(Model model, HttpServletRequest request) {
		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser == null) {
			return loginMandate(model);
		} else {
			int eventId = Integer.parseInt(request.getParameter("eventId"));
			Event selectedEvent = new Event();
			selectedEvent.setEventId(eventId);
			model.addAttribute("registrations", socialAppService.getRegistrationsForEvent(selectedEvent));
			return "viewvolunteers";
		}
	}

	@RequestMapping(value = "logout.action", method = RequestMethod.GET)
	public String logoutInvalidateSession(Model model, HttpServletRequest request) {
		request.getSession().invalidate();
		return "home";
	}

	public String loginMandate(Model model) {
		model.addAttribute("message", "Please login to access admin module");
		model.addAttribute("user", user);
		return "adminlogin";
	}
}
