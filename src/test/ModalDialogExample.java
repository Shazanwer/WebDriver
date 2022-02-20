package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModalDialogExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/modal-dialogs");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement smallModalbtn = driver.findElement(By.xpath("//button[@id='showSmallModal']"));		
		smallModalbtn.click();		
		driver.switchTo().activeElement();
		WebElement dialogBody = driver.findElement(By.cssSelector("div.modal-body"));
		System.out.println(dialogBody.getText());		
		WebElement closeBtn =  driver.findElement(By.cssSelector("button#closeSmallModal"));
		closeBtn.click();		 
		driver.switchTo().activeElement();
		
		WebElement largeModalbtn = driver.findElement(By.xpath("//button[@id='showLargeModal']"));		
		largeModalbtn.click();		
		driver.switchTo().activeElement();
		WebElement dialogBody1 = driver.findElement(By.cssSelector("div.modal-body"));
		System.out.println("####Text in large modal dialog is######: "+ dialogBody1.getText());		
		WebElement closeBtn1 =  driver.findElement(By.cssSelector("button#closeLargeModal"));
		closeBtn1.click();		 
		driver.switchTo().activeElement();
		
		driver.close();
		
		
	}

}
