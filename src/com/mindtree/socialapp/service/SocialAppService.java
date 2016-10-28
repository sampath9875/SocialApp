/**
 * 
 */
package com.mindtree.socialapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.socialapp.entities.Event;
import com.mindtree.socialapp.entities.Location;
import com.mindtree.socialapp.entities.Registration;
import com.mindtree.socialapp.entities.User;
import com.mindtree.socialapp.exceptions.InvalidLoginException;
import com.mindtree.socialapp.hibernate.SocialAppDao;

/**
 * @author azureUser
 *
 */
@Component
public class SocialAppService {

	/**
	 * 
	 */
	@Autowired
	private SocialAppDao socialAppDao;

	public SocialAppService() {
	}

	public User getUser(User user) throws InvalidLoginException {
		User loadedUser = socialAppDao.getUser(user.getUserName());

		if (loadedUser == null)
			throw new InvalidLoginException("User with Username:" + user.getUserName() + " does not exist");
		else if (!loadedUser.getPassword().equals(user.getPassword()))
			throw new InvalidLoginException("Incorrect Password. Please Try again");
		else
			return loadedUser;
	}

	public boolean validUser(String userName) {
		User loadedUser = socialAppDao.getUser(userName);

		if (loadedUser == null)
			return true;
		else
			return false;
	}

	public boolean saveUser(User user) {
		return socialAppDao.saveUser(user);
	}

	public List<Location> getAllLocations() {
		return socialAppDao.getAllLocations();
	}

	public List<Event> getEventsForDate(Date date) {
		return socialAppDao.getEventsForDate(date);
	}

	public List<Event> getEventsForLocation(Location location) {
		return socialAppDao.getEventsForLocation(location);
	}

	public List<Registration> getRegistrationsForEvent(Event event) {
		return socialAppDao.getRegistrationsForEvent(event);
	}

	public int registerEvent(Event event) {
		return socialAppDao.registerEvent(event);
	}

	public int registerForEvent(Registration registration) {
		return socialAppDao.registerForEvent(registration);
	}

	public Location getLocationById(int id) {
		return socialAppDao.getLocationById(id);
	}
}
