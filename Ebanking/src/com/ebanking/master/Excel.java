package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
	   Library LB=new Library();
	   
	   LB.OpenApp("http://122.175.8.158/ranford2");
	   LB.AdmLgn("Admin","Te$ting@");
	   
	   //To Get Test Data File
	   
	   FileInputStream FIS=new FileInputStream("E:\\Evngsepbatch\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
	 
	   //WorkBook
	   
	   XSSFWorkbook WB=new XSSFWorkbook(FIS);
 
	   //Sheet
	   
	   XSSFSheet WS=WB.getSheet("Rdata");
	   
	   //Rowcount
	   
	   int RC=WS.getLastRowNum();
	   System.out.println(RC);
	   
	   //Multiple Iterations
	   
	   for (int i=1;i<=RC;i++) 
	   {
		//Rows
		   
		   XSSFRow WR=WS.getRow(i);
		   
		   //Cells
		   
		   XSSFCell WC=WR.getCell(0);
		   XSSFCell WC1=WR.getCell(1);
		   
		   XSSFCell WC2=WR.createCell(2);
		   
		   //Cell Values
		   
		   String Rname=WC.getStringCellValue();
		   String Rtyp=WC1.getStringCellValue();
		   
		   String Res=LB.Role(Rname,Rtyp);
	       System.out.println(Res);
	       
	       WC2.setCellValue(Res);
	   }
	
	//Results
	   
	   FileOutputStream FOS=new FileOutputStream("E:\\Evngsepbatch\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.xlsx");
	   WB.write(FOS);
	   WB.close();
	   
    }
	

}
