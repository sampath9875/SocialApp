package com.mindtree.socialapp.test;

import org.testng.annotations.Test;

import com.mindtree.socialapp.entities.Event;
import com.mindtree.socialapp.entities.Location;
import com.mindtree.socialapp.entities.Registration;
import com.mindtree.socialapp.entities.User;
import com.mindtree.socialapp.hibernate.SocialAppDao;

import org.testng.annotations.BeforeClass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@ContextConfiguration(locations = {
		"file:C:/SDET-Workspaces/Shanmukha/SocialApp/WebContent/WEB-INF/dispatcher-servlet.xml" })
public class TestHibernate extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SocialAppDao socialAppDao;

	private Location location1, location2, location3, location4;
	private Event event1, event2, event3, event4, event5, event6;
	private User user1, user2;
	private Registration reg1, reg2, reg3, reg4, reg5, reg6;

	@Rollback(false)
	@Test(priority = 1)
	public void testSaveUser() {
		Assert.assertEquals(socialAppDao.saveUser(user1), true);
		Assert.assertEquals(socialAppDao.saveUser(user2), true);
	}

	@Rollback(false)
	@Test(priority = 2)
	public void testGetUser() {
		Assert.assertEquals(socialAppDao.getUser(user1.getUserName()).getUserId(), user1.getUserId());
		Assert.assertEquals(socialAppDao.getUser(user2.getUserName()).getUserId(), user2.getUserId());
	}

	@Rollback(false)
	@Test(priority = 3)
	public void testRegisterEvent() {
		Assert.assertNotEquals(socialAppDao.registerEvent(event1), 0);
		Assert.assertNotEquals(socialAppDao.registerEvent(event2), 0);
		Assert.assertNotEquals(socialAppDao.registerEvent(event3), 0);
		Assert.assertNotEquals(socialAppDao.registerEvent(event4), 0);
		Assert.assertNotEquals(socialAppDao.registerEvent(event5), 0);
		Assert.assertNotEquals(socialAppDao.registerEvent(event6), 0);
	}

	@Rollback(false)
	@Test(priority = 4)
	public void testGetAllLocations() {
		List<Location> locations = socialAppDao.getAllLocations();
		Assert.assertEquals(locations.size(), 4);
	}

	@Rollback(false)
	@Test(priority = 5)
	public void testGetEventsForDate() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		long current = 0;
		try {
			current = dateFormat.parse(dateFormat.format(new Date().getTime())).getTime();
		} catch (ParseException e) {
		}
		Assert.assertEquals(socialAppDao.getEventsForDate(new Date(current + TimeUnit.DAYS.toMillis(1))).size(), 1);
		Assert.assertEquals(socialAppDao.getEventsForDate(new Date(current + TimeUnit.DAYS.toMillis(2))).size(), 2);
		Assert.assertEquals(socialAppDao.getEventsForDate(new Date(current + TimeUnit.DAYS.toMillis(3))).size(), 2);
		Assert.assertEquals(socialAppDao.getEventsForDate(new Date(current + TimeUnit.DAYS.toMillis(4))).size(), 1);
	}

	@Rollback(false)
	@Test(priority = 6)
	public void testGetEventsForLocation() {
		Assert.assertEquals(socialAppDao.getEventsForLocation(location1).size(), 1);
		Assert.assertEquals(socialAppDao.getEventsForLocation(location2).size(), 2);
		Assert.assertEquals(socialAppDao.getEventsForLocation(location3).size(), 2);
		Assert.assertEquals(socialAppDao.getEventsForLocation(location4).size(), 1);
	}

	@Rollback(false)
	@Test(priority = 7)
	public void testRegisterForEvent() {
		Assert.assertNotEquals(socialAppDao.registerForEvent(reg1), 0);
		Assert.assertNotEquals(socialAppDao.registerForEvent(reg2), 0);
		Assert.assertNotEquals(socialAppDao.registerForEvent(reg3), 0);
		Assert.assertNotEquals(socialAppDao.registerForEvent(reg4), 0);
		Assert.assertNotEquals(socialAppDao.registerForEvent(reg5), 0);
		Assert.assertNotEquals(socialAppDao.registerForEvent(reg6), 0);
	}

	@Rollback(false)
	@Test(priority = 8)
	public void testGetRegistrationsForEvent() {
		Assert.assertEquals(socialAppDao.getRegistrationsForEvent(event1).size(), 1);
		Assert.assertEquals(socialAppDao.getRegistrationsForEvent(event2).size(), 2);
		Assert.assertEquals(socialAppDao.getRegistrationsForEvent(event3).size(), 2);
		Assert.assertEquals(socialAppDao.getRegistrationsForEvent(event4).size(), 1);
	}

	@BeforeClass
	public void beforeClass() {
		user1 = new User("Name 1", "testUser1", "test123", "dummy@email.com");
		user2 = new User("Name 2", "testUser2", "test123", "dummy@email.com");

		location1 = new Location("Global Village, Bangalore");
		location2 = new Location("Hinjewadi, Pune");
		location3 = new Location("Gachibowli, Hyderabad");
		location4 = new Location("Velachery, Chennai");

		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		long current = 0;
		try {
			current = dateFormat.parse(dateFormat.format(new Date().getTime())).getTime();
		} catch (ParseException e) {
		}
		event1 = new Event("One Good Deed", location1, new Date(current + TimeUnit.DAYS.toMillis(1)), user1);
		event2 = new Event("Health Is Wealth", location2, new Date(current + TimeUnit.DAYS.toMillis(2)), user2);
		event3 = new Event("Tree for Me", location3, new Date(current + TimeUnit.DAYS.toMillis(3)), user1);
		event4 = new Event("Sharing is Caring", location4, new Date(current + TimeUnit.DAYS.toMillis(4)), user2);
		event5 = new Event("Health is Wealth", location3, new Date(current + TimeUnit.DAYS.toMillis(2)), user1);
		event6 = new Event("Sharing is Caring", location2, new Date(current + TimeUnit.DAYS.toMillis(3)), user2);

		reg1 = new Registration("M1030491", "Some Nam1", "volunteer@event.com", "9764589232", event1);
		reg2 = new Registration("M1030492", "Some Nam2", "volunteer@event.com", "9764589232", event2);
		reg3 = new Registration("M1030493", "Some Nam3", "volunteer@event.com", "9764589232", event3);
		reg4 = new Registration("M1030494", "Some Nam4", "volunteer@event.com", "9764589232", event4);
		reg5 = new Registration("M1030495", "Some Nam5", "volunteer@event.com", "9764589232", event3);
		reg6 = new Registration("M1030496", "Some Nam6", "volunteer@event.com", "9764589232", event2);
	}

	@AfterClass
	public void afterClass() {
	}

}
