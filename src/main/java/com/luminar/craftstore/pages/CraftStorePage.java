package com.luminar.craftstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CraftStorePage {
	WebDriver driver;

	@FindBy(id = "CustomerEmail")
	WebElement usernameField;

	@FindBy(id = "CustomerPassword")
	WebElement passwordField;

	@FindBy(id = "customer_login_link")
	WebElement login;

	@FindBy(xpath = "//*[@id=\"customer_login\"]/p[1]/input")
	WebElement loginButton;

	@FindBy(id = "SiteNavSearch")
	WebElement searchButton;

	@FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[1]/div[2]/a")
	WebElement item;
	
	@FindBy(xpath = "//*[@id=\"AddToCartForm-product-template\"]/div[1]/div/button[2]")
	WebElement increaseItemButton;

	@FindBy(id = "AddToCart-product-template")
	WebElement addToCartButton;

	@FindBy(xpath = "//*[@id=\"SiteNavSearchCart\"]/a")
	WebElement viewCartLink;
	
	@FindBy(id = "SiteNavLabel-products")
	WebElement productsLink;
	
	@FindBy(partialLinkText="Christmas Decoration")
	WebElement christmasDecorationLink;
	
	//*[@id="SortTags"]
	@FindBy(xpath = "//*[@id=\"SortTags\"]")
	WebElement filterBySelect;
	
	@FindBy(xpath="//*[@id=\"MainContent\"]/div/div/div[1]/a")
	WebElement itemBalloon;
	
	//*[@id="Updates_43714996469984:b32ead22122c6e2897a70b602746a4be"]
	@FindBy(xpath="//*[@id=\"Updates_43466106470624:bc2143fd79bc068146cc50761f5a5671\"]")
	WebElement quantityInput;
	
	//*[@id="shopify-section-cart-template"]/div/div/form/div/div[2]/button[2]
	@FindBy(xpath="//*[@id=\"shopify-section-cart-template\"]/div/div/form/div/div[2]/button[2]")
	WebElement checkOutButton;
	
	@FindBy(id="TextField6")
	WebElement discountTextField;
	
	@FindBy(xpath="//*[@id=\"Form1\"]/div[1]/div/button")
	WebElement applyButton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div/aside/div/section/div[2]/div[5]/div[2]/div/div/strong")
	WebElement totalAmount;

	public CraftStorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clearFields() throws InterruptedException {
		// driver.navigate().back();
		System.out.println("clearing");

		usernameField.clear();
		passwordField.clear();

		driver.navigate().refresh();
	}

	public void performLogin(String username, String password) throws InterruptedException {
		Thread.sleep(2500);
		usernameField.sendKeys(username);
		Thread.sleep(2500);
		passwordField.sendKeys(password);
		Thread.sleep(2500);
		loginButton.click();
		Thread.sleep(2500);
	}
	
	public void checkOut() throws InterruptedException {
		checkOutButton.click();
		Thread.sleep(1000);
	}
	
	public void applyDiscount(String code) {
	
		discountTextField.sendKeys(code);
		
		applyButton.click();
		
		
	}

	public void goToLoginPage() {
		login.click();

	}

	public void navigate() throws InterruptedException {
		productsLink.click();
		Thread.sleep(1000);
		christmasDecorationLink.click();
		Select filterSelect =new Select(filterBySelect);
		filterSelect.selectByVisibleText("Balloons");
	}
	
	public void addMultipleQuantity() throws InterruptedException {
		clickOnLink("PRODUCTS");
		clickOnLink("Wall Frames");
		item.click();
		increaseItemButton.click();
		Thread.sleep(1000);
		addToCartButton.click();
		Thread.sleep(1000);
		viewCartLink.click();
		if(quantityInput.getAttribute("value").equals("2")) {
			System.out.print("success");
		
		}
	}

	public void performSearch(String value) {
		searchButton.click();
		searchButton.sendKeys(value);
		searchButton.sendKeys(Keys.ENTER);

	}

	public void addToCart() throws InterruptedException {
		item.click();
		Thread.sleep(1000);
		addToCartButton.click();
		Thread.sleep(1000);
		viewCartLink.click();
	}
	
	public void clickOnLink(String partialLinkText) {
		driver.findElement(By.partialLinkText(partialLinkText)).click();
	}

}

