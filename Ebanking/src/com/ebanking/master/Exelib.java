package com.ebanking.master;

import java.io.IOException;

public class Exelib {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		//Instance class
		
		Library LB=new Library();
		
		String Rval=LB.OpenApp("http://122.175.8.158/ranford2");
		System.out.println(Rval);
		LB.AdmLgn("Admin","Te$ting@");
		Rval=LB.BCreation("cashierxb","ammerpet","12345","INDIA","GOA","GOA");
		System.out.println(Rval);
	}

}
