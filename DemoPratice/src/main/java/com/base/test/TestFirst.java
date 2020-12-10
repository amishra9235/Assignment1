package com.base.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.dataproviders.BrowserDataProvider;
import com.demo.base.BaseSetUp;

public class TestFirst {

	WebDriver drivers;

	@Test(dataProvider = "Browser", dataProviderClass = BrowserDataProvider.class)
	public void firstTest(String browserName) {
		drivers = BaseSetUp.setDriver(browserName);
		drivers.get("https://www.irissoftware.com/");
		Assert.assertEquals(true, true);

	}

	@AfterMethod
	public void tearDown() {
		if (drivers != null) {
			drivers.quit();
		}
	}
}
