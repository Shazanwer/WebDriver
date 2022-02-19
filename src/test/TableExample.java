package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		List<WebElement> tbRows = driver.findElements(By.xpath("//table[@id=\"customers\"]//tr"));
		System.out.println("No of rown in table: " + tbRows.size());

		List<WebElement> tbCol = driver.findElements(By.xpath("//table[@id=\"customers\"]//th"));
		System.out.println("No of rown in table: " + tbCol.size());

		List<WebElement> tbRow4 = driver.findElements(By.xpath("//table[@id=\"customers\"]//tr[4]/td"));
		for (WebElement elm : tbRow4) {

			System.out.println("Data in 4th rows is : " + elm.getText());
		}
		
		
		List<WebElement> data = driver.findElements(By.xpath("//td[text()='Island Trading']/parent::tr/td"));
		for (WebElement elm : data) {

			System.out.println("Data : " + elm.getText());
		}
		

		//scroll example
		
		WebElement scroll = driver.findElement(By.xpath("//h2[text()='Table Headers']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		
//		driver.close();

	}

}
