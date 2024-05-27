package ui.page;/*
 * Copyright 2001-2024 by HireRight, Inc. All rights reserved.
 * This software is the confidential and proprietary information
 * of HireRight, Inc. Use is subject to license terms.
 */

import core.selenium.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class GoogleStartPage
{
	private static final Logger log = Logger.getLogger(BasicInformationPage.class);
	
	public GoogleStartPage() {
		try
		{
			Thread.sleep(5000);
		} catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		log.info("Google start page is opened");
	}
	
	//search input
	public void setSearchTextAndSearch(String text) {
//		DriverManager.getInstance().getDriver().findElement(By.className("gLFyf"));
//		DriverManager.getInstance().getDriver().findElement(By.name("q"));
//		DriverManager.getInstance().getDriver()
//				.findElement(By.xpath("//textarea[@id='APjFqb']"));
		
		DriverManager.getInstance().getDriver().findElement(By.id("APjFqb"))
				.sendKeys(text);
		DriverManager.getInstance().getDriver().findElement(By.className("gNO89b"))
				.click();
	}
}
