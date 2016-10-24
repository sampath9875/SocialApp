/**
 * 
 */
package com.mindtree.socialapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

/**
 * @author azureUser
 *
 */
@Component
@Entity
@Table(name = "Event_Register")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Event_Id")
	private int eventId;

	@Column(name = "Event_Name")
	private String eventName;

	@ManyToOne(targetEntity = Location.class)
	private Location location;

	@Column(name = "Event_Date")
	private Date eventDate;

<<<<<<< HEAD
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
=======
	@ManyToOne(targetEntity = User.class)
>>>>>>> branch 'FirstBranch' of https://github.com/sampath9875/SocialApp
	private User user;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Registration.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Registration> registrationsForEvent;

	/**
	 * 
	 */
	public Event() {
	}

	/**
	 * @param eventId
	 * @param eventName
	 * @param location
	 * @param eventDate
	 * @param user
	 * @param registrationsForEvent
	 */
	public Event(int eventId, String eventName, Location location, Date eventDate, User user,
			List<Registration> registrationsForEvent) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.location = location;
		this.eventDate = eventDate;
		this.user = user;
		this.registrationsForEvent = registrationsForEvent;
	}

	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * @param eventId
	 *            the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName
	 *            the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the eventDate
	 */
	public Date getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate
	 *            the eventDate to set
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the registrationsForEvent
	 */
	public List<Registration> getRegistrationsForEvent() {
		return registrationsForEvent;
	}

	/**
	 * @param registrationsForEvent
	 *            the registrationsForEvent to set
	 */
	public void setRegistrationsForEvent(List<Registration> registrationsForEvent) {
		this.registrationsForEvent = registrationsForEvent;
	}

}
