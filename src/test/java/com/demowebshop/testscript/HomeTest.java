package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.utilities.ExcelUtility;

public class HomeTest extends Base {

	HomePage home;// object declare

	@Test(priority=1,enabled=true,description="tc_001 verify HomePage Title",groups= {"Smoke"})
	public void tc_001_verifyHomePageTitle() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String expHomePageTitle = data.get(1).get(0);
		home = new HomePage(driver);
		String actHomePageTitle = home.getHomePageTitle();
		Assert.assertEquals(actHomePageTitle, expHomePageTitle, "Invalid Title");
	}

	@Test(priority=1,enabled=true,description="tc_002 verify Subscribe Email Message",groups= {"Regression"})
	public void tc_002_verifySubscribeEmailMessage() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String expMessage = data.get(1).get(1);
		home = new HomePage(driver);
		home.enterSubEmailID();
		home.clickSubButton();
		String actMessage = home.getSubMessage();
		Assert.assertEquals(actMessage, expMessage, "Invalid Message Field");

	}
}
