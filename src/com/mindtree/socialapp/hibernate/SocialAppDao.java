/**
 * 
 */
package com.mindtree.socialapp.hibernate;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.socialapp.entities.Event;
import com.mindtree.socialapp.entities.Location;
import com.mindtree.socialapp.entities.Registration;
import com.mindtree.socialapp.entities.User;

/**
 * @author azureUser
 *
 */
@Component
@Repository
@Transactional
public class SocialAppDao {

	/*
	 * @Autowired private HibernateTemplate hibernateTemplate;
	 */

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 */
	public SocialAppDao() {
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public boolean saveUser(User user) {
		Session session = getSession();
		session.save(user);
		// hibernateTemplate.save(user);
		return true;
	}

	public User getUser(String username) {
		User loadedUser;

		Session session = getSession();
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));

		loadedUser = (User) criteria.getExecutableCriteria(session).uniqueResult();

		// loadedUser = (User) hibernateTemplate.find("Select U from User U
		// where u.user_name=?", username).get(0);

		return loadedUser;
	}

	public int registerEvent(Event event) {
		Session session = getSession();
		session.save(event);
		// hibernateTemplate.save(event);
		return event.getEventId();
	}

	@SuppressWarnings("unchecked")
	public List<Location> getAllLocations() {
		Session session = getSession();

		return (List<Location>) session.createCriteria(Location.class).list();
		// hibernateTemplate.find("Select L from Location L");
	}

	public List<Event> getEventsForLocation(Location location) {
		Location loadedLocation;
		// = (Location) hibernateTemplate.find("Select L from Location L where
		// l.location_id=?",
		// location.getLocationId());
		Session session = getSession();
		loadedLocation = session.load(Location.class, location.getLocationId());
		return loadedLocation.getEventsForLocation();
	}

	public List<Event> getEventsForDate(Date date) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Event.class);

		long eventDate = date.getTime();

		Date fromDate = new Date(eventDate);
		Date toDate = new Date(eventDate + TimeUnit.DAYS.toMillis(1));
		criteria.add(Restrictions.ge("eventDate", fromDate));
		criteria.add(Restrictions.lt("eventDate", toDate));

		/*
		 * @SuppressWarnings("unchecked") (List<Event>)
		 * hibernateTemplate.findByCriteria(criteria);
		 */
		@SuppressWarnings("unchecked")
		List<Event> eventsForDate = criteria.getExecutableCriteria(getSession()).list();
		return eventsForDate;
	}

	public int registerForEvent(Registration registration) {
		Session session = getSession();
		session.save(registration);
		// hibernateTemplate.save(registration);
		return registration.getRegistrationId();
	}

	public List<Registration> getRegistrationsForEvent(Event event) {
		Session session = getSession();
		Event loadedEvent = session.load(Event.class, event.getEventId());
		return loadedEvent.getRegistrationsForEvent();
	}
}
