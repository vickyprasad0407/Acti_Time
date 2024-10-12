package com.actiTime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath = "//div[text()='+ New Customer']")
	private WebElement newCustBtn;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement newCustName;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement newCustDes;
	
	@FindBy(xpath = "(//div[text()='- Select Customer -'])[1]")
	private WebElement selectCust;
	
	@FindBy(xpath = "//div[text()='Our company' and @class='itemRow cpItemRow ']")
	private WebElement ourCompany;
	
	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCust;
	
	@FindBy(xpath = "//div[@class='titleEditButtonContainer']/div[@class='title']")
	private WebElement actualCustName;

	
	public TaskListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}

	public WebElement getNewCustBtn() {
		return newCustBtn;
	}

	public WebElement getNewCustName() {
		return newCustName;
	}

	public WebElement getNewCustDes() {
		return newCustDes;
	}

	public WebElement getSelectCust() {
		return selectCust;
	}

	public WebElement getOurCompany() {
		return ourCompany;
	}
	public WebElement getCreateCust() {
		return createCust;
	}
	public WebElement getActualCustName() {
		return actualCustName;
	}


}
