package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/frames");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement elem = driver.findElement(By.xpath("//iframe[@id='frame2']"));

//		driver.switchTo().frame("frame2");//this will take time
		
		driver.switchTo().frame(elem);
		
		WebElement elem1 = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(elem1.getText());

		driver.switchTo().defaultContent();
		driver.close();

	}

}
