package com.luminar.craftstore.test;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.luminar.craftstore.pages.CraftStorePage;



public class CraftStoreTest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void testAddToCart() throws Exception
	{
		
		driver.get("https://craftstoreofindia.com/");
		CraftStorePage ob=new CraftStorePage(driver);
		ob.performSearch("Earrings");
		ob.addToCart();
		ob.checkOut();
		ob.applyDiscount("FIRST_10");
			
	}
	
	@Test(priority=2)
	public void testSelectItemFromNav() throws Exception
	{
		
		driver.get("https://craftstoreofindia.com/");
		CraftStorePage ob=new CraftStorePage(driver);
		ob.navigate();
		
			
	}
	
	/*
	 This test will select an item from Products,
	 and increase the quantity to 2. Then will check if
	  cart shows the quantity as 2.
	 */
	@Test(priority=3)
	public void testAddQuantity() throws Exception
	{
		
		driver.get("https://craftstoreofindia.com/");
		CraftStorePage ob=new CraftStorePage(driver);
		ob.addMultipleQuantity();	
			
	}
	/*
	 * 
	 */
	@Test(priority=4)
	public void test() throws Exception
	{
		
		driver.get("https://craftstoreofindia.com/");
		CraftStorePage ob=new CraftStorePage(driver);
		ob.goToLoginPage();
		FileInputStream f=new FileInputStream("D:\\febina tesing\\assignments\\craftstore.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet sh=wb.getSheet("sheet1");
		int row=sh.getLastRowNum();
		for(int i=1;i<=row;i++)
		{
		    //ob.clearFields();
			String username=null;


			 username=sh.getRow(i).getCell(0).getStringCellValue();
			
			String password=sh.getRow(i).getCell(1).getStringCellValue();
			
	
			ob.performLogin(username,password);
			ob.clearFields();
			
		}		
	}
	

}
