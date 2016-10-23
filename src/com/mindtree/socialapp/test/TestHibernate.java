package com.mindtree.socialapp.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.AfterClass;

@ContextConfiguration(locations = { "classpath:beans.xml" })
public class TestHibernate {
	@Test
	public void f() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

}
