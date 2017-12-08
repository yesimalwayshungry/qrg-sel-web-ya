package Common;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperFunctions {
	
	/***************************************************************************
	*Create a web driver with the desired browser and set the driver wait times
	*@param: String desiredBrowser
	*@param: int  implicitWaitSec
	*@param: int pageLoadSec
	*@return: Webdriver driver
	***************************************************************************/
	public static WebDriver DriverInit(String desiredBrowser, int implicitWaitSec, int pageLoadSec)
	{
		WebDriver driver = null;
		try{
			switch(desiredBrowser){
				case "Chrome":
					System.setProperty("webdriver.chrome.driver", "./WebDrivers/chromedriver.exe");
					driver = new ChromeDriver();
					break;
				case "Firefox":
					System.setProperty("", "");//SET FIREFOX PATH
					driver = new FirefoxDriver();
					break;
				default:
					driver = null;
					System.err.println("Unable to start driver, please verify desired browser.");
					break;
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(implicitWaitSec, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(pageLoadSec, TimeUnit.SECONDS);
			}
		catch(Exception e)
		{
			driver = null;
			System.err.println("Unable to start driver, please verify desired browser.");
		}
		return driver;
	}

	/***************************************************************************
	*Navigate to a web page on desired browser
	*@param: WedDriver driver
	*@param: String desiredURL
	*@return: 
	***************************************************************************/
	public static void NavigateToWebpage(WebDriver driver, String desiredURL)
	{
		try
		{
			driver.get(desiredURL);
		}
		catch(Exception e)
		{
			System.err.println("Unable to navigate to desired page, killing driver");
			driver.quit();
		}
	}
	
	/***************************************************************************
	*kill webdriver
	*@param: WedDriver driver
	*@return: 
	***************************************************************************/
	public static void KillDriver(WebDriver driver)
	{
		try
		{
			driver.quit();
		}
		catch(Exception e)
		{
			System.err.println("Unable to kill webdriver");
		}
	}
}
