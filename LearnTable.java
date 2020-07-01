package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the URL
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		
		//Get the count of number of rows
		WebElement eleTable = driver.findElementById("table_id");
		List<WebElement> allRows = eleTable.findElements(By.tagName("tr"));
		System.out.println("Number of rows: " + allRows.size());
		
		//Get the count of number of columns
        WebElement eachRow = allRows.get(1);
        List<WebElement> allCols = eachRow.findElements(By.tagName("td"));
        System.out.println("Number of columns: " + allCols.size());
        
        //Get the progress value of 'Learn to interact with elements'
        String text = driver.findElementByXPath("(//table[@id='table_id'])//following::tr[3]/td[2]").getText();
        System.out.println("Progress value:" + text);
        
        //check the vital task for the least completed progress
        List<WebElement> myList = driver.findElementsByXPath("(//table[@id='table_id'])//following::tr/td[2]");
        List<Integer> allElements=new ArrayList<Integer>();
        for(WebElement eachProgress:myList) {
        	String textPercentage=eachProgress.getText();
        	allElements.add(Integer.parseInt(textPercentage.replaceAll("%","")));
        }
        int a=Collections.min(allElements);
		System.out.println("Min value: " + a);
        
          if(a==30) {
		  driver.findElementByXPath("(//input[@name='vital'])[3]").click(); 
		  System.out.println("vital task for the least completed progress is selected: " +
		  driver.findElementByXPath("(//input[@name='vital'])[3]").isSelected());
		  
		  }
		  
		      
	}

}
