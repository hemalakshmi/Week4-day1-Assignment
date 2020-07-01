package week4.day1;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the URL
		driver.get("http://www.leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		
      //I am inside a frame
	  WebElement frame1 = driver.findElementByXPath("(//div[@id='wrapframe'][1])/iframe");
	  driver.switchTo().frame(frame1);
	  driver.findElementById("Click").click();
	  System.out.println("Frame One: " + driver.findElementByXPath("//button[@id='Click']").getText());
	  driver.switchTo().defaultContent();
	  
	  //Total no.of frames
	  int size = driver.findElements(By.tagName("iframe")).size();
	  System.out.println("Number of Frames: " +size);
	  driver.switchTo().defaultContent();
	  
	  //I am inside a nested frame
	  WebElement frame2 = driver.findElementByXPath("(//div[@id='wrapframe'][2])/iframe");
	  driver.switchTo().frame(frame2);
	  WebElement e2Frame = driver.findElements(By.tagName("iframe")).get(0);
	  driver.switchTo().frame(e2Frame);
	  driver.findElementById("Click1").click();
	  System.out.println("Nested Frame: "+ driver.findElementById("Click1").getText());
	  driver.switchTo().defaultContent();  
	  
	}
	
}
