package com.shopping.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.baseClass.org.BaseClass;

public class CreateAccount extends BaseClass
{
	public static void main(String[] args) throws Throwable 
	{
		setBrowser("chrome");
		navigateTo("http://automationpractice.com/index.php");
		getWindowHandle();
		getWait(15);
		WebElement login = driver.findElement(By.xpath("//a[@class='login']"));
		login.click();
		
		//CreateNewAccount
		Thread.sleep(1000);
		driver.findElement(By.id("email_create")).sendKeys("abi2001raj@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='id_gender'])[1]")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Abishek");
		driver.findElement(By.id("customer_lastname")).sendKeys("Raj");
		driver.findElement(By.id("passwd")).sendKeys("Abi789");
		WebElement days = driver.findElement(By.id("days"));
		Select day = new Select(days);
		day.selectByIndex(3);
		WebElement months = driver.findElement(By.id("months"));
		Select month = new Select(months);
		month.selectByValue("6");
		WebElement years = driver.findElement(By.id("years"));
		Select year = new Select(years);
		year.selectByValue("2001");
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("firstname")).sendKeys("Abishek");
		driver.findElement(By.id("lastname")).sendKeys("Raj");
		driver.findElement(By.id("company")).sendKeys("ABC XYZ Pvt Limited.");
		driver.findElement(By.id("address1")).sendKeys("5H Anna Nagar Colony");
		driver.findElement(By.id("address2")).sendKeys("73/2A Gandhi Street");
		driver.findElement(By.id("city")).sendKeys("Chennai");
		WebElement state = driver.findElement(By.id("id_state"));
		Select State = new Select(state);
		State.selectByVisibleText("Florida");
		driver.findElement(By.id("postcode")).sendKeys("67301");
		WebElement country = driver.findElement(By.id("id_country"));
		Select Country = new Select(country);
		Country.selectByVisibleText("United States");
		driver.findElement(By.id("other")).sendKeys("Speed Delivery of produts is encouraged!");
		driver.findElement(By.id("phone")).sendKeys("044 2235 7853");
		driver.findElement(By.id("phone_mobile")).sendKeys("99528 29336");
		driver.findElement(By.id("alias")).sendKeys("Nothing");
		driver.findElement(By.xpath("//span[text()='Register']")).click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
