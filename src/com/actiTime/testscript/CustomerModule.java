package com.actiTime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseClass;
import com.actiTime.generic.FileLib;
import com.actiTime.pom.EnterTimeTrackPage;
import com.actiTime.pom.TaskListPage;
@Listeners(com.actiTime.generic.ListnerImplementation.class)
public class CustomerModule extends BaseClass
{
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException
	{
		FileLib f=new FileLib();
		String custName = f.getExcelData("createcustomer", 1, 1);
		 String custDesc = f.getExcelData("createcustomer", 1, 2);
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustBtn().click();
		t.getNewCustName().sendKeys(custName);
		t.getNewCustDes().sendKeys(custDesc);
		t.getSelectCust().click();
		t.getOurCompany().click();
		t.getCreateCust().click();
		//Thread.sleep(4000);
        WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='titleEditButtonContainer']/div[@class='title']")));
        String expCustName=f.getExcelData("createcustomer", 1, 1);
	    String actualCustName = t.getActualCustName().getText();
	    Assert.assertEquals(actualCustName, expCustName);
	}

}
