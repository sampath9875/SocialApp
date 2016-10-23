/**
 * 
 */
package com.mindtree.socialapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.socialapp.entities.Registration;

/**
 * @author M1030496
 *
 */

@Controller
public class EventController {
	@Autowired(required=true)
	private Registration volunteer;
	/**
	 * 
	 */
	public EventController() {
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home()
	{
		return "home";
	}
	@RequestMapping(value="registration",method=RequestMethod.GET)
	public ModelAndView register()
	{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("volunteer",volunteer);
		return new ModelAndView("registration",map);
	}
	
}
