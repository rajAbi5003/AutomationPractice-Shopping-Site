package com.baseClass.org;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass 
{
	public static WebDriver driver;
	//1
	public static void setBrowser(String browser) throws InterruptedException 
	{
		try 
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\Driver\\chromedriver.exe"));
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+("\\Drivers\\geckodriver.exe"));
				driver = new FirefoxDriver();
			}
			else
				System.out.println("Browser Not Initialised!");
			
			System.out.println("Browser Launch Successful!");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Exception catched in SetBrowser");
		}
		driver.manage().window().maximize();
		Thread.sleep(1000);
		return;
	}
	//2
	public static void closeBrowser() 
	{
		try 
		{
			System.out.println("Closing the current Tab or Window");
			driver.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return;
	}
	//3
	public static void quitBrowser() 
	{
		System.out.println("Quiting the entire browser session!");
		driver.quit();
		return;
	}
	//4
	public static void navigateTo(String url) throws Throwable 
	{
		driver.navigate().to(url);
		Thread.sleep(2000);
		return;
	}
	//5
	public static void navigateBack() throws Throwable
	{
		try 
		{
			driver.navigate().back();
			Thread.sleep(2000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		return;
	}
	//6
	public static void navigateForward() throws Throwable 
	{
		try
		{
			driver.navigate().forward();
			Thread.sleep(2000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		return;
	}
	//7
	public static void refresh() throws Throwable
	{
		try 
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		return;
	}
	//8
	public static void getUrl(String url) throws InterruptedException 
	{
		try 
		{
			driver.get(url);
			Thread.sleep(2000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		return;
	}
	//9-a
	public static void getAlerts(String option,String value) 
	{
		try 
		{
			if(option.contains("simpleAlert"))
				driver.switchTo().alert().accept();
			else if(option.contains("confirmationAlert") && (value.equalsIgnoreCase("ok")) || value.equalsIgnoreCase("accept"))
					driver.switchTo().alert().accept();
			else if(option.contains("confirmationAlert") && (value.equalsIgnoreCase("cancel")) || value.equalsIgnoreCase("dismiss"))
					driver.switchTo().alert().dismiss();
			else
				System.out.println("Option Not Found");
			
			Thread.sleep(1000);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return;
	}
	//9-b
	public static void promptAlert(String sendValue,String option) 
	{
		String promptText = driver.switchTo().alert().getText();
		System.out.println(promptText);
		if(option.equalsIgnoreCase("cancel") || option.equalsIgnoreCase("dismiss"))
		{
			driver.switchTo().alert().dismiss();
			return;
		}
		driver.switchTo().alert().sendKeys(sendValue);
		driver.switchTo().alert().accept();
		return;
	}
	//10-a
	public static void SingleArgumentedActions(WebElement element,String option)
	{
		try 
		{
			Actions action = new Actions(driver);
			if(option.equalsIgnoreCase("moveToElement"))
				action.moveToElement(element).build().perform();
			else if(option.equalsIgnoreCase("contextClick"))
					action.contextClick(element).build().perform();
			else if(option.equalsIgnoreCase("DoubleClick"))
					action.doubleClick(element).build().perform();
			else if(option.equalsIgnoreCase("click"))
					action.click(element).build().perform();
			else
				System.out.println("Invalid Option!");
			
			System.out.println("Action Perfomed!");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	//10-b
	public static void dragAndDropInActions(WebElement source,WebElement target) 
	{
		try 
		{
			Actions action = new Actions(driver);
			action.dragAndDrop(source, target).build().perform();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	//11-a
	public static void getFrame(int index) 
	{
		try 
		{
			driver.switchTo().frame(index);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	//11-b
	public static void getFrame(String option,Object value) throws InterruptedException 
	{
		try
		{
			if(option.equalsIgnoreCase("byIndex"))
			{
				Integer val = Integer.parseInt((String)value);
				driver.switchTo().frame(val);
			}
			else if(option.equalsIgnoreCase("byString"))
			{
				driver.switchTo().frame((String)value);
			}
			else if(option.equalsIgnoreCase("byWebElement"))
			{
				driver.switchTo().frame((WebElement)value);
			}
			else
				System.out.println("Invalid option for frame!");
			
			System.out.println("Got Into the frame!");
			Thread.sleep(2000);
		}
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
		}
	}
	//12
	/*
	public void KeyboardActionsUsingRobot(String option,String key) throws AWTException 
	{
		Robot robot = new Robot();
		if(option.equalsIgnoreCase("KeyPress"))
		{
			robot.keyPress(KeyEvent.VK_ +key );
		}
	}
	*/
	//13
	public static void doWindowsHandling(String resultantTitle) throws InterruptedException 
	{
		Set<String> windows = driver.getWindowHandles();
		for(String id : windows)
		{
			WebDriver temptitle = driver.switchTo().window(id);
			if(temptitle.equals(resultantTitle))
			{
				driver.switchTo().window(id);
				Thread.sleep(2000);
				break;
			}
		}
	}
	//14
	public static void selectDropDownOptions(String option,String value,WebElement element) throws InterruptedException 
	{
		try 
		{
			Select s = new Select(element);
			if(option.equalsIgnoreCase("byIndex"))
			{
				Integer val = Integer.parseInt(value);
				s.selectByIndex(val);
			}
			else if(option.equalsIgnoreCase("byValue"))
			{
				s.selectByValue(value);
			}
			else if(option.equalsIgnoreCase("byVisibleText"))
			{
				s.selectByVisibleText(value);
			}
			else
				System.out.println("Inavlid Option in DropDown!");
			
			System.out.println("DropDown Executed!");
			Thread.sleep(2000);
		} 
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
	}
	//15
	public static void checkBox(WebElement element) 
	{
		element.click();
	}
	//16
	public static void isEnabled(WebElement element) throws InterruptedException 
	{
		boolean enabled = element.isEnabled();
		if(enabled==true)
			System.out.println("Yes,It's enabled!");
		else
			System.out.println("No,It's not enabled!");
		Thread.sleep(2000);
	}
	//17
	public static void isDisplayed(WebElement element) throws InterruptedException 
	{
		boolean displayed = element.isDisplayed();
		if(displayed==true)
			System.out.println("Yes,It's Displayed!");
		else
			System.out.println("No,It's not Displayed!");
		Thread.sleep(2000);
	}
	//18
	public static void isSelected(WebElement element) throws InterruptedException 
	{
		boolean selected = element.isSelected();
		if(selected==true)
			System.out.println("Yes,It's selected!");
		else
			System.out.println("No,It's not selected!");
		Thread.sleep(2000);
	}
	
	//19-getOptions
	public static void getDropDownOptions(WebElement element) 
	{
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		if(multiple==true)
			System.out.println("Yes,Multiple options can be selected..");
		else
			System.out.println("Only one option can be selected!");
		System.out.println("Given Options");
		List<WebElement> options = s.getOptions();
		for(WebElement option : options)
			System.out.println(option.getText());
	}	
	//20
	public static void getCurrentWindowTitle()
	{
		String currentTitle = driver.getTitle();
		System.out.println("Current Page Title is :" + currentTitle);
	}
	//21
	public void getCurrentUrl() 
	{
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current Page URL is :" + currentUrl);
	}
	//22
	public static void getText(WebElement element) 
	{
		String text = element.getText();
		System.out.println("Given Text :" + text);
	}
	//23
	public static void getAttribute(WebElement element,String value) 
	{
		String attribute = element.getAttribute(value);
		System.out.println("Required Attribute :" + attribute);
	}
	//24
	public static void getWait(int time) throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	//25
	public static void takeScreenshot() throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\Abishek Raj\\eclipse-workspace\\Automation-Practice-Shopping\\Screenshots");
		FileUtils.copyFileToDirectory(source, target);
	}
	//26
	public static void scrollFeature(WebElement element) throws InterruptedException 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
		Thread.sleep(2000);
	}
	//27
	public static void sendKeys(WebElement element,String value) throws InterruptedException 
	{
		element.sendKeys(value);
		Thread.sleep(2000);
	}
	//28,29,30
	public static void getOptionsInDropDown(WebElement element,String option) throws InterruptedException 
	{
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		boolean multiple = s.isMultiple();
		if(option.equalsIgnoreCase("allSelectedOptions"))
		{
			for(WebElement value : allSelectedOptions)
			System.out.println(value.getText());
		}
		else if(option.equalsIgnoreCase("firstSelectedOption"))
				System.out.println("First Selected Option : " + firstSelectedOption.getText());
		else if(option.equalsIgnoreCase("isMultiple"))
			System.out.println("Multiple(True) or Not(False) :" + multiple);
		else
			System.out.println("Invalid Option");
		
		Thread.sleep(2000);
	}
	//31
	public static void click(WebElement element) throws InterruptedException 
	{
		element.click();
		Thread.sleep(2000);
	}
	//32
	public static void getWindowHandle() 
	{
		String mainId = driver.getWindowHandle();
		driver.switchTo().window(mainId);
	}
	//33
	public static void switchToWindowfromFrame() 
	{
		driver.switchTo().defaultContent();
	}
	
	
}
