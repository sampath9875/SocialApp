/**
 * 
 */
package com.mindtree.socialapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author azureUser
 *
 */
@Entity
@Table(name = "LocationDetails")
public class Location {

	@Id
	@Column(name = "Location_Id")
	private int locationId;

	@Column(name = "Location_Details")
	private String locationDetails;

	@OneToMany(targetEntity = Event.class, cascade = CascadeType.ALL)
	private List<Event> eventsForLocation;

	/**
	 * 
	 */
	public Location() {
	}

	/**
	 * @param locationId
	 * @param locationDetails
	 */
	public Location(String locationDetails) {
		super();
		this.locationDetails = locationDetails;
	}

	
	/**
	 * @param locationId
	 * @param locationDetails
	 * @param eventsForLocation
	 */
	public Location(int locationId, String locationDetails, List<Event> eventsForLocation) {
		super();
		this.locationId = locationId;
		this.locationDetails = locationDetails;
		this.eventsForLocation = eventsForLocation;
	}

	/**
	 * @return the locationId
	 */
	public int getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId
	 *            the locationId to set
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	/**
	 * @return the locationDetails
	 */
	public String getLocationDetails() {
		return locationDetails;
	}

	/**
	 * @param locationDetails
	 *            the locationDetails to set
	 */
	public void setLocationDetails(String locationDetails) {
		this.locationDetails = locationDetails;
	}

	/**
	 * @return the eventsForLocation
	 */
	public List<Event> getEventsForLocation() {
		return eventsForLocation;
	}

	/**
	 * @param eventsForLocation
	 *            the eventsForLocation to set
	 */
	public void setEventsForLocation(List<Event> eventsForLocation) {
		this.eventsForLocation = eventsForLocation;
	}

}
