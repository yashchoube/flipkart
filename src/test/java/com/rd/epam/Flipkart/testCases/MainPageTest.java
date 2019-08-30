package com.rd.epam.Flipkart.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rd.epam.Flipkart.pages.MainPage;

public class MainPageTest {
	
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");	
			driver = new ChromeDriver(); 
	}
	
	@Test
	public void check() {
		driver.get("https://www.flipkart.com/search");
		MainPage mainPage=PageFactory.initElements(driver, MainPage.class);
		mainPage.clickOnWomen();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainPage.clickOnWomenShoes();
		
	}

}
