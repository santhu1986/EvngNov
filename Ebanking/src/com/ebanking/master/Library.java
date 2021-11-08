package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library 
{
   public static WebDriver driver;
    public static String Expval,Actval;
     public static FileInputStream Fis;
     public static Properties PR;
     
	 public String OpenApp(String Url) throws IOException 
	 
	 {
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\santh\\Desktop\\geckodriver.exe");
		 
		 Fis=new FileInputStream("E:\\Evngsepbatch\\Ebanking\\src\\com\\ebanking\\properties\\Repo.properties");
		 PR=new Properties();
		 PR.load(Fis);
		 
		 Expval="Ranford Bank";
			
			//Launch Firefox
			
			driver=new FirefoxDriver();
			
			//Maximise
			
			driver.manage().window().maximize();
			
			//URL
			
			driver.get(Url);
	
			Actval=driver.findElement(By.xpath("//span[@class='style10'][contains(.,'Ranford Bank')]")).getText();
			
			//Comparision
			
			if (Expval.equalsIgnoreCase(Actval))
			{
			System.out.println("Application Launch Succ");	
			}
			else
			{
			System.out.println("Application Failed To Launch");	
			}
				 return "Pass";
				 
	 }
	
	 public void AdmLgn(String Un,String Pwd) 
	 {
		 Expval="Welcome to Admin";
			
			driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
			driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
			driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();
		
			Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
			
			//Comparision
			
					if (Expval.equalsIgnoreCase(Actval))
					{
					System.out.println("Admin Login Succ");	
					}
					else
					{
					System.out.println("Admin Failed To Login");	
					}
	}
	 
	 public String BCreation(String Bname,String Add,String Zc,String Cty,String Sta,String Cy) throws InterruptedException 
	 {

		    Expval="Sucessfully";
					
			driver.findElement(By.xpath(PR.getProperty("Bbutton"))).click();
			driver.findElement(By.id("BtnNewBR")).click();
			
			driver.findElement(By.id("txtbName")).sendKeys(Bname);
	        driver.findElement(By.id("txtAdd1")).sendKeys(Add);
	        driver.findElement(By.id("txtZip")).sendKeys(Zc); 
			
	        Thread.sleep(3000);
	        
			//DropDown
	        
			Select Ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
			Ctry.selectByVisibleText(Cty);
			
			new Select(driver.findElement(By.id("lst_stateI"))).selectByVisibleText(Sta);
			new Select(driver.findElement(By.id("lst_cityI"))).selectByVisibleText(Cy);
			driver.findElement(By.id("btn_insert")).click();
			
			Thread.sleep(3000);
			//Alert
			
			Actval=driver.switchTo().alert().getText();
			
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			 driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
		     
			if (Actval.contains(Expval)) 
			{
			System.out.println("Branch Created");	
			}
			else
			{
				System.out.println("Branch Alreay Exist");
			}
			return Actval;
		}
	//Role

	public String Role(String RN,String RT) throws InterruptedException
	{
		Expval="Sucessfully";
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
	driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
		driver.findElement(By.id("txtRname")).sendKeys(RN);
		driver.findElement(By.id("lstRtypeN")).click();
        driver.findElement(By.id("lstRtypeN")).sendKeys(RT);
      driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
       Thread.sleep(4000);
       Actval=driver.switchTo().alert().getText();
		
		System.out.println(Actval);
		
		
	      driver.switchTo().alert().accept();
	      driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
	      if (Actval.contains(Expval)) 
	      {
	    	  System.out.println("Role Created");
	    	  
			
		}
	      else{
	    	  System.out.println("role not created");
	    	  
	      }
	      return Actval;
	     }


	
public void admlgt()
   
   {
  	 driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
  	 
  	 }

   public void Appc()
   {
  	 driver.close();
   }

	
   }
	 //Emp
	 //Log out
	 //Close
	 
