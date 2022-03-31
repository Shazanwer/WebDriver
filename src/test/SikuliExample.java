package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class SikuliExample {

	public static void main(String[] args) throws FindFailed {
		// TODO Auto-generated method stub
		Screen s = new Screen();
//		Pattern ToolSQA = new Pattern("C:\\SELENIUM\\Sikuli\\ToolsQA.jpg");
		
		
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/browser-windows");

//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		s.click("C:\\SELENIUM\\Sikuli\\ToolsQA.jpg");
		
		 
		driver.close();

	}

}
