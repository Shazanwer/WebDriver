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

		UserName.sendKeys("xyz@abc.com");
		Password.sendKeys("Abcd@123");

		LoginBtn.click();

//		driver.close();

	}

}
