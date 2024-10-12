package com.actiTime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage {

	@FindBy(id="container_tasks")
	private WebElement taskTab;
	
	@FindBy(id="logoutLink")
	private WebElement lgout;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void setLogout()
	{
		lgout.click();
	}
	public void setTaskTab()
	{
		taskTab.click();
	}
	
}
