package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSIgnUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement CreateNewbtn = driver.findElement(By.cssSelector("a[data-testid$='-button']"));
		CreateNewbtn.click();

		WebElement FirstName = driver.findElement(By.cssSelector("input[name^='first']"));
		WebElement LastName = driver.findElement(By.cssSelector("input[name*='last']"));
		WebElement MobileNo = driver.findElement(By.cssSelector("input[name='reg_email__']"));

		FirstName.sendKeys("Shaz");
		LastName.sendKeys("Anwer");
		MobileNo.sendKeys("123456789");

		// Dynamic Xpath
		String Gender = "Male";
		String GenXpath = "//label[text()='" + Gender + "']/following-sibling::input";

		WebElement selectGender = driver.findElement(By.xpath(GenXpath));
		selectGender.click();

//		Getting text from drop down list
		List<WebElement> Months = driver.findElements(By.xpath("//select[@title='Month']/option"));
		for (WebElement elm : Months) {
			System.out.println(elm.getText());
		}

		List<WebElement> Days = driver.findElements(By.xpath("//select[@name='birthday_day']/option"));
		for (WebElement elm : Days) {
			System.out.println(elm.getText());
		}

		// select[@name='birthday_year']/option

		WebElement currentMonth = driver.findElement(By.xpath("//*[@id='month']/option[@selected=1]"));
		// using css select#month>option[selected='1']
		System.out.println(currentMonth.getText());

		WebElement Month = driver.findElement(By.xpath("//select[@id='month']"));
		Select mMonth = new Select(Month);
		mMonth.selectByVisibleText("May");

		WebElement Day = driver.findElement(By.xpath("//select[@id='day']"));
		Select dDay = new Select(Day);
		dDay.selectByVisibleText("3");

		WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
		Select yYear = new Select(Year);
		yYear.selectByVisibleText("1984");

//		driver.close();

	}

}
