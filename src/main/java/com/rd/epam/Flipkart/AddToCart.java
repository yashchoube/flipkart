package com.rd.epam.Flipkart;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
	static WebDriverWait wait = null;
	//static Logger logger = Logger.getAnonymousLogger(AddToCart.class.getName());
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[@class='Y5-ZPI']/form//button[@class='vh79eN']")
	WebElement searchButton;

	
	@FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addToCartButton;
	

	@FindBy(how = How.XPATH, using = "//input[@class=\"LM6RPg\"]")
	WebElement searchBar;

	public AddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchBar(String productName) {
		searchBar.sendKeys(productName);
	}

//	public void aa() {
//	WebDriverWait wait3 = new WebDriverWait(driver, 10);
//	wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='Y5-ZPI']/form//button[@class='vh79eN']")));
//	}
	public void clickOnSearchButton() { 
		
		
		Actions actions = new Actions(driver);
		actions.moveToElement(searchButton).click().build().perform();
	
	}
	
	
	public void clickOnAddToCartButton() throws InterruptedException {
		
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(4000);
		for (String childTab:driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
		
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		driver.manage().window().maximize();
		 wait = new WebDriverWait(driver, 2);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")));
		//addToCartButton.click();
		actions.moveToElement(addToCartButton).click().build().perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a")
	WebElement selectProduct;
	
	public void clickOnProduct() {
		// boolean present = isProductPresent();
		// if(present) {
		
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 Actions actions = new Actions(driver);
		 actions.moveToElement(selectProduct).click().build().perform();
		 //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 //}
		 //else {
	//		 logger.info("No product found");
		 }
		 
	//}
	
//	public boolean isProductPresent() {
//		boolean searchResult=false;
//		String productName = selectProduct.getText();
//		 if(productName.contains("Canon EOS")) {
//			 searchResult = true;
//			 
//		 }
//		 return searchResult;
//	}
          
	
}
