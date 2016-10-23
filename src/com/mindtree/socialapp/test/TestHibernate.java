package com.mindtree.socialapp.test;

import org.testng.annotations.Test;

import com.mindtree.socialapp.entities.Event;
import com.mindtree.socialapp.entities.Location;
import com.mindtree.socialapp.entities.Registration;
import com.mindtree.socialapp.entities.User;
import com.mindtree.socialapp.hibernate.SocialAppDao;

import org.testng.annotations.BeforeClass;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@ContextConfiguration("file:C:/SDET-Workspaces/Shanmukha/SocialApp/WebContent/WEB-INF/dispatcher-servlet.xml")
public class TestHibernate extends AbstractTestNGSpringContextTests {

	@Autowired
	private SocialAppDao socialAppDao;

	private User user1, user2;
	private Location location1, location2, location3, location4;
	private Event event1, event2, event3, event4, event5, event6;
	private Registration reg1, reg2, reg3, reg4, reg5, reg6;

	@Test
	public void f() {
		Assert.assertTrue(socialAppDao.saveUser(user1));
		Assert.assertTrue(socialAppDao.saveUser(user2));

		Assert.assertNotNull(socialAppDao.registerEvent(event1));
		Assert.assertNotNull(socialAppDao.registerEvent(event2));
		Assert.assertNotNull(socialAppDao.registerEvent(event3));
		Assert.assertNotNull(socialAppDao.registerEvent(event4));
		Assert.assertNotNull(socialAppDao.registerEvent(event5));
		Assert.assertNotNull(socialAppDao.registerEvent(event6));

		Assert.assertNotNull(socialAppDao.registerForEvent(reg1));
		Assert.assertNotNull(socialAppDao.registerForEvent(reg2));
		Assert.assertNotNull(socialAppDao.registerForEvent(reg3));
		Assert.assertNotNull(socialAppDao.registerForEvent(reg4));
		Assert.assertNotNull(socialAppDao.registerForEvent(reg5));
		Assert.assertNotNull(socialAppDao.registerForEvent(reg6));

		Assert.assertEquals(socialAppDao.getAllLocations(), 4);
		Assert.assertEquals(socialAppDao.getEventsForDate(new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(2))),
				2);
		Assert.assertEquals(socialAppDao.getEventsForDate(new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(3))),
				2);

		Assert.assertEquals(socialAppDao.getEventsForLocation(location4), 2);
		Assert.assertEquals(socialAppDao.getEventsForLocation(location2), 2);

		Assert.assertEquals(socialAppDao.getUser("testUser1"), user1);
		Assert.assertEquals(socialAppDao.getUser("testUser2"), user2);

		Assert.assertEquals(socialAppDao.getRegistrationsForEvent(event2), 2);
		Assert.assertEquals(socialAppDao.getRegistrationsForEvent(event3), 2);
		Assert.assertEquals(socialAppDao.getRegistrationsForEvent(event4), 1);
		Assert.assertEquals(socialAppDao.getRegistrationsForEvent(event5), 1);
	}

	@BeforeClass
	public void beforeClass() {
		user1 = new User("testUser1", "test", "test@mail.com");
		user2 = new User("testUser2", "test", "test@mail.com");

		location1 = new Location("Global Village, Bangalore");
		location2 = new Location("Hinjewadi, Pune");
		location3 = new Location("Gachibowli, Hyderabad");
		location4 = new Location("Velambakkam, Chennai");

		long today = new Date().getTime();
		event1 = new Event("One Good Deed", location1, new Date(today + TimeUnit.DAYS.toMillis(1)), user1);
		event2 = new Event("Tree for Me", location2, new Date(today + TimeUnit.DAYS.toMillis(2)), user2);
		event3 = new Event("Health is Wealth", location3, new Date(today + TimeUnit.DAYS.toMillis(3)), user1);
		event4 = new Event("Swach Bharath", location4, new Date(today + TimeUnit.DAYS.toMillis(4)), user2);
		event5 = new Event("One Good Deed", location2, new Date(today + TimeUnit.DAYS.toMillis(3)), user1);
		event6 = new Event("Health Is Wealth", location4, new Date(today + TimeUnit.DAYS.toMillis(2)), user2);

		reg1 = new Registration("M1030496", "Shanmukha1", "test@email.com", event2);
		reg2 = new Registration("M1030495", "Shanmukha4", "test@email.com", event3);
		reg3 = new Registration("M1030494", "Shanmukha7", "test@email.com", event4);
		reg4 = new Registration("M1030493", "Shanmukha9", "test@email.com", event5);
		reg5 = new Registration("M1030492", "Shanmukha2", "test@email.com", event2);
		reg6 = new Registration("M1030491", "Shanmukha5", "test@email.com", event3);
	}

	@AfterClass
	public void afterClass() {
	}

}
