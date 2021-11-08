package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoleDetails 
{

	@FindBy(xpath=".//*[@id='btnRoles']")
    WebElement NewRole;
	
	@FindBy(xpath=".//*[@id='Table_01']/tbody/tr/td[1]/a/img")
	WebElement Home;
	
	public void nRole() 
	{
		NewRole.click();
	}
	
	public void Hom() 
	{
		Home.click();
	}
}
