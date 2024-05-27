package ui.page;/*
 * Copyright 2001-2024 by HireRight, Inc. All rights reserved.
 * This software is the confidential and proprietary information
 * of HireRight, Inc. Use is subject to license terms.
 */

import core.selenium.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class GoogleResultsPage
{
	private static final Logger log = Logger.getLogger(BasicInformationPage.class);
	
	public GoogleResultsPage() {
		try
		{
			Thread.sleep(5000);
		} catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		log.info("Google results page is opened");
	}
	
	public String returnTextOfTheFirstLink() {
		return DriverManager.getInstance().getDriver()
				.findElements(By.xpath("//div[@id='search']//a")).get(0).getText();
	}
	
}
