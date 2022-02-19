package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/browser-windows");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		String ParentWindow = driver.getWindowHandle();
		System.out.println("PW: " + ParentWindow);

		WebElement newWindow = driver.findElement(By.xpath("//button[@id='tabButton']"));
		newWindow.click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();

		while (itr.hasNext()) {
			String CurrentWindow = itr.next();
			System.out.println("CW: " + CurrentWindow);

			if (!CurrentWindow.equals(ParentWindow)) {
				driver.switchTo().window(CurrentWindow);
			}
		}

		WebElement textonNewWindow = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(textonNewWindow.getText());

		driver.close();
		driver.switchTo().window(ParentWindow);
		System.out.println("PW: " + ParentWindow);

		// new window message
		Thread.sleep(1000);

		WebElement newMessageWindow1 = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
		newMessageWindow1.click();
		
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> itr1 = handles1.iterator();

		while (itr1.hasNext()) {
			String CurrentWindow1 = itr1.next();
			System.out.println("CW: " + CurrentWindow1);

			if (!CurrentWindow1.equals(ParentWindow)) {
				driver.switchTo().window(CurrentWindow1);
			}
		}

		WebElement textonNewMessagewWindow1 = driver.findElement(By.xpath("//body"));
		System.out.println(textonNewMessagewWindow1.getText());
		driver.close();
		
		driver.switchTo().window(ParentWindow);
		System.out.println("PW: " + ParentWindow);

		driver.quit();

	}

}
