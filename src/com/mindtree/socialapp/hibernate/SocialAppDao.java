/**
 * 
 */
package com.mindtree.socialapp.hibernate;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.mindtree.socialapp.entities.Event;
import com.mindtree.socialapp.entities.Location;
import com.mindtree.socialapp.entities.Registration;
import com.mindtree.socialapp.entities.User;

/**
 * @author azureUser
 *
 */
@Component
public class SocialAppDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * 
	 */
	public SocialAppDao() {
	}

	public boolean saveUser(User user) {
		hibernateTemplate.save(user);
		return true;
	}

	public User getUser(String username) {
		User loadedUser;

		loadedUser = (User) hibernateTemplate.find("Select U from User U where u.user_name=?", username).get(0);

		return loadedUser;
	}

	public int registerEvent(Event event) {
		hibernateTemplate.save(event);
		return event.getEventId();
	}

	@SuppressWarnings("unchecked")
	public List<Location> getAllLocations() {
		return (List<Location>) hibernateTemplate.find("Select L from Location L");
	}

	public List<Event> getEventsForLocation(Location location) {
		Location loadedLocation = (Location) hibernateTemplate.find("Select L from Location L where l.location_id=?",
				location.getLocationId());
		return loadedLocation.getEventsForLocation();
	}

	public List<Event> getEventsForDate(Date date) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Event.class);

		long eventDate = date.getTime();

		Date fromDate = new Date(eventDate);
		Date toDate = new Date(eventDate + TimeUnit.DAYS.toMillis(1));
		criteria.add(Restrictions.ge("eventDate", fromDate));
		criteria.add(Restrictions.lt("eventDate", toDate));

		@SuppressWarnings("unchecked")
		List<Event> eventsForDate = (List<Event>) hibernateTemplate.findByCriteria(criteria);

		return eventsForDate;
	}

	public int registerForEvent(Registration registration) {
		hibernateTemplate.save(registration);
		return registration.getRegistrationId();
	}

	public List<Registration> getRegistrationsForEvent(Event event) {

		return null;
	}
}
