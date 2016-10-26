/**
 * 
 */
package com.mindtree.socialapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.ajp.AjpAprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.socialapp.entities.Event;
import com.mindtree.socialapp.entities.Location;
import com.mindtree.socialapp.entities.Registration;
import com.mindtree.socialapp.hibernate.SocialAppDao;

/**
 * @author M1030496
 *
 */

@Controller
public class EventController {
	@Autowired(required = true)
	private Registration volunteer;

	@Autowired
	private SocialAppDao socialAppDao;

	/**
	 * 
	 */
	public EventController() {
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public ModelAndView register() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Location> locations=socialAppDao.getAllLocations();
		map.put("locations", locations);
		map.put("volunteer", volunteer);
		return new ModelAndView("registration", map);
	}

	@ResponseBody
	@RequestMapping(value = "getEvents", method = RequestMethod.GET,produces = "application/json")
	public String getEvents(@RequestBody String location,HttpServletRequest request, HttpServletResponse response) throws ParseException {
		int locationId = Integer.parseInt(request.getParameter("location"));
		Location loc=new Location();
		loc.setLocationId(locationId);
		List<Event> li=socialAppDao.getEventsForLocation(loc);
		System.out.println(locationId + "Hello"+li.size());
		String str="{ '1': 'test 1', '2': 'test ' }";
		return str;
	}
}
