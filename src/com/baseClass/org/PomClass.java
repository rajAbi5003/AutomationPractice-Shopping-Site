package com.baseClass.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass 
{
	public static WebDriver driver;
	
	public PomClass(WebDriver driver) 
	{
		PomClass.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='login']")
	private WebElement signIn;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement login;
	
	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	private WebElement dress;
	
	@FindBy(xpath = "(//a[@title='Casual Dresses'])[2]")
	private WebElement casualDress;
	
	@FindBy(xpath = "//span[text()='Quick view']")
	private WebElement quickView;
	
	@FindBy(xpath = "//img[@alt='Printed Dress']")
	private WebElement image;
	
	@FindBy(xpath = "(//a[@data-field-qty='qty'])[2]")
	private WebElement plus;
	
	@FindBy(xpath = "(//a[@data-field-qty='qty'])[1]")
	private WebElement minus;
	
	@FindBy(id = "group_1")
	private WebElement size;
	
	@FindBy(xpath = "(//span[text()='Add to cart'])[1]")
	private WebElement addToCart;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckOut1;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut23;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement tick;
	
	@FindBy(xpath = "//button[@name='processCarrier']")
	private WebElement processCarrier;
	
	@FindBy(xpath = "//a[@class='bankwire']")
	private WebElement bankWire;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement submit;

	@FindBy(xpath = "(//a[@title='Back to orders'])")
	private WebElement backToOrders;
	
	@FindBy(xpath = "(//span[text()=' Home'])")
	private WebElement home;
	
	@FindBy(xpath = "(//a[@class='logout'])")
	private WebElement logOut;

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getDress() {
		return dress;
	}

	public WebElement getCasualDress() {
		return casualDress;
	}

	public WebElement getQuickView() {
		return quickView;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getPlus() {
		return plus;
	}

	public WebElement getMinus() {
		return minus;
	}

	public WebElement getSize() {
		return size;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getProceedToCheckOut1() {
		return proceedToCheckOut1;
	}

	public WebElement getProceedToCheckOut23() {
		return proceedToCheckOut23;
	}

	public WebElement getTick() {
		return tick;
	}

	public WebElement getProcessCarrier() {
		return processCarrier;
	}

	public WebElement getBankWire() {
		return bankWire;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getBackToOrders() {
		return backToOrders;
	}

	public WebElement getHome() {
		return home;
	}

	public WebElement getLogOut() {
		return logOut;
	}
	
}
