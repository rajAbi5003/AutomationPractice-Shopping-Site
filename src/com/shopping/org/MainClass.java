package com.shopping.org;

import com.baseClass.org.BaseClass;
import com.baseClass.org.PomClass;

public class MainClass extends BaseClass
{
	public static void main(String[] args) throws Throwable 
	{
		setBrowser("chrome");
		navigateTo("http://automationpractice.com/index.php");
		getWindowHandle();
		getWait(15);
		
		PomClass pc = new PomClass(driver);
		try
		{
			click(pc.getSignIn());
			sendKeys(pc.getEmail() , "abi2001raj@gmail.com");
			sendKeys(pc.getPassword(), "Abi789");
			click(pc.getLogin());
			SingleArgumentedActions(pc.getDress(), "moveToElement");
			click(pc.getCasualDress());
			scrollFeature(pc.getImage());
			SingleArgumentedActions(pc.getImage(), "moveToElement");
			click(pc.getQuickView());
			getFrame(0);
			click(pc.getPlus());
			click(pc.getPlus());
			click(pc.getMinus());
			click(pc.getPlus());
			selectDropDownOptions("byValue", "3" , pc.getSize());
			click(pc.getAddToCart());
			switchToWindowfromFrame();
			click(pc.getProceedToCheckOut1());
			click(pc.getProceedToCheckOut23());
			click(pc.getProceedToCheckOut23());
			checkBox(pc.getTick());
			click(pc.getProcessCarrier());
			click(pc.getBankWire());
			click(pc.getSubmit());
			click(pc.getBackToOrders());
			takeScreenshot();
			click(pc.getHome());			
			click(pc.getLogOut());
			System.out.println("Purchase Done!");
			Thread.sleep(2000);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.out.println("Exception Happened!");
		}
		finally 
		{
			System.out.println("Execution Done!");
			closeBrowser();
			quitBrowser();
		}
	}
}
