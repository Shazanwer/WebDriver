package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/alerts");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement alertBtn = driver.findElement(By.xpath("//button[@id='alertButton']"));
		alertBtn.click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		alert.accept();
		
		WebElement alertBtn1 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		alertBtn1.click();
		
		System.out.println(alert.getText());
		alert.dismiss();
		
		WebElement alertBtn2 = driver.findElement(By.xpath("//button[@id='promtButton']"));
		alertBtn2.click();
		
		alert.sendKeys("123");
		System.out.println(alert.getText());
		alert.accept();
		
		driver.close();
	}

}
