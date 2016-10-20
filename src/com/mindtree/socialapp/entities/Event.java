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

/**
 * @author azureUser
 *
 */
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

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Registration.class)
	private List<Registration> registrationsForEvent;

	/**
	 * 
	 */
	public Event() {
	}

}
