package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exepom 
{
	WebDriver driver;
	
    @BeforeTest
	public void login() throws InterruptedException
	{
    	 driver=new FirefoxDriver();
    	driver.manage().window().maximize();
    	driver.get("http://122.175.8.158/ranford2");
    	
    	//PageFactory
    	
    	RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
    	RHP.login();
    	
	}
    @Test(dataProvider="Rdata")
    public void Rcreation(String Rn,String Rt) throws InterruptedException 
    {
    	
    	AdminHp AHP=PageFactory.initElements(driver,AdminHp.class);
    	AHP.Rol();
    	
    	RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
    	RD.nRole();
    	
    	Rolecre RC=PageFactory.initElements(driver,Rolecre.class);
    	RC.Rcre(Rn,Rt);
    	
    	Thread.sleep(3000);
    	//Alert
    	
    	driver.switchTo().alert().accept();
    
    	Thread.sleep(3000);
    	
    	//Home
    	
    	RD.Hom();
    }	
    
  @DataProvider
    
    public Object [][] Rdata()
    {
       Object [][] Obj=new Object[3][2];
       
       Obj[0][0]="GmanagerOct";
       Obj[0][1]="E";
       
       Obj[1][0]="AmanagerOct";
       Obj[1][1]="E";
       
       Obj[2][0]="ManagerOct";
       Obj[2][1]="E";
       
       return Obj;
    }

	}
