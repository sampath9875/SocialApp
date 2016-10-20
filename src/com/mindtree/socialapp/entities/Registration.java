/**
 * 
 */
package com.mindtree.socialapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author azureUser
 *
 */
@Entity
@Table(name = "Volunteer_Register")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Registration_Id")
	private int registrationId;

	@Column(name = "Employee_Id")
	private String employeeId;

	@Column(name = "Employee_Name")
	private String employeeName;

	@Column(name = "Employee_Email")
	private String employeeEmail;

	@ManyToOne(targetEntity = Event.class)
	private Event event;

	/**
	 * 
	 */
	public Registration() {
	}

	/**
	 * @return the registrationId
	 */
	public int getRegistrationId() {
		return registrationId;
	}

	/**
	 * @param registrationId
	 *            the registrationId to set
	 */
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeEmail
	 */
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	/**
	 * @param employeeEmail
	 *            the employeeEmail to set
	 */
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

}
