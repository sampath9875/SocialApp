/**
 * 
 */
package com.mindtree.socialapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author M1030496
 *
 */

@Controller
public class SampleController {

	/**
	 * 
	 */
	public SampleController() {
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home()
	{
		return "home";
	}
	
}
