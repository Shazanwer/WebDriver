package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.facebook.com");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement UserName = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement Password = driver.findElement(By.xpath("//input[@id='pass']"));
		WebElement LoginBtn = driver.findElement(By.xpath("//*[@type='submit']"));
		
		//*[text()='Create new account'] - find xpath using text function
		//*[contains(text(),'Connect with friends')] - using partial text
		//*[contains(@data-testid,'open')]  -  using attribute value
		//*[starts-with(text(),'Terms')]  - xpath using start with 
		//a[@class='logo']/img  - find xpath using child
		//div[@class='col-centered content-wrapper']/div[1]/img - accessing child node and grand child node
		//div[@class='col-centered content-wrapper']//img  - direct access to grand child
		
		//input[@name='user_login']/parent::div - xpath to get immediate parent 
		//div[@class='col-centered content-wrapper']/following::div - xpath using following
		//div[@class='logo-image']/following-sibling::div - xpath using following
		//div[@class='content-heading ']/preceding::div - xpath using preceding
		//div[@class='content-heading ']/ancestor::div  -xpath to find all ancestor
		
		//css selector - comparatively faster
		
		//  input#email   -- this is used only when id value is known
		//  input.email  --this is used only when class value is known
		//  a[data-testid='open-registration-form-button']  - using tag name and its attribute value
		//  a[data-testid*='open-registrati']  - using tag name with * like contains providing part of text
		//  a[data-testid^='open-registrati']  - ^ to start-with
		//  a[data-testid$='-button']  - use $ for end with
		//  select#month>option    - > to get child tag

		UserName.sendKeys("xyz@abc.com");
		Password.sendKeys("Abcd@123");

		LoginBtn.click();

//		driver.close();

	}

}
