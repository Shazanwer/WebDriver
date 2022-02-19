package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.simplilearn.com");

		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);  // implicit wait

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(LoginLink)); // explicit wait

		LoginLink.click();

		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		WebElement RememberMeChkBox = driver.findElement(By.className("rememberMe"));

		UserName.sendKeys("xyz@abc.com");
		Password.sendKeys("Abcd@123");
		RememberMeChkBox.click();
		LoginBtn.click();

		WebElement msgbox = driver.findElement(By.id("msg_box"));
		String Errormsg = msgbox.getText();
		String ActErrorMsg = "The email or password you have entered is invalid.";

		if (Errormsg.equals(ActErrorMsg)) {
			System.out.println("TC Passed");
		} else {
			System.out.println("TC Falied");
		}

		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println(Links.size());

		for (WebElement element : Links) {
			System.out.println(element.getAttribute("href"));
		}

		driver.close();

	}

}
