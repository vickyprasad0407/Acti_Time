package com.actiTime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actiTime.pom.EnterTimeTrackPage;
import com.actiTime.pom.LoginPage;

public class BaseClass {

	public static WebDriver driver;
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@BeforeClass
	public void launchBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	@BeforeMethod
	public void login() throws IOException
	{
		FileLib f=new FileLib();
		driver.get(f.getPropertyData("url"));
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
	}
	@AfterMethod
	public void logout()
	{
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.setLogout();
	}
}
