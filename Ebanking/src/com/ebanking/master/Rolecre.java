package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Rolecre
{
	@FindBy(id="txtRname")
	WebElement Rname;
	
	@FindBy(id="lstRtypeN")
	WebElement Rtype;
	
	@FindBy(xpath=".//*[@id='btninsert']")
	WebElement Submit;
	

	public void Rcre(String Rn,String Rty) throws InterruptedException 
	{
	Rname.sendKeys(Rn);
	Select RT=new Select(Rtype);
	RT.selectByVisibleText(Rty);
	Thread.sleep(3000);
	Submit.click();
	}
}
