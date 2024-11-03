package autopjt;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sona_newpjt {

	
	WebDriver driver;
	String baseurl="https://santamonicaedu.in/";
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlloading() {
		driver.get(baseurl);
		
	}
	
	@Test
	public void test()
	{
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		String exp="Santamonica";
		if(actualtitle.equals(exp)) { 
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		
		
		
		 WebElement element = driver.findElement(By.xpath("//*[@id=\"menu-item-567\"]/a"));
driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div/div[2]/div[7]/div/div/div[2]/div[2]/h5/a")).click();
	        // Create Actions object
	        Actions actions = new Actions(driver);

	        // Perform mouse over
	        actions.moveToElement(element).perform();

	        
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	        // Find element to verify
	        WebElement enquiry =driver.findElement(By.xpath("/html/body/div[1]/div[3]/section[1]/div/div[1]/div/div/div/div[1]/div/div[2]/a[2]"));

	        // Verify element is displayed
	        Assert.assertTrue(enquiry.isDisplayed());

	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        driver.findElement(By.xpath("//*[@id=\"contactUs\"]/span")).click();
	        
	        driver.findElement(By.xpath("//*[@id=\"wpcf7-f1147-o1\"]/form/div[2]/div[1]/span/input")).sendKeys("Sona K S");
	        driver.findElement(By.xpath("//*[@id=\"wpcf7-f1147-o1\"]/form/div[2]/div[2]/span/input")).sendKeys("sonaks7025@gmail.com");
	        driver.findElement(By.xpath("//*[@id=\"wpcf7-f1147-o1\"]/form/div[3]/div[1]/span/input")).sendKeys("7025951803");
	        driver.findElement(By.xpath("//*[@id=\"wpcf7-f1147-o1\"]/form/div[3]/div[2]/span/input")).sendKeys("IT");
	        driver.findElement(By.xpath("//*[@id=\"wpcf7-f1147-o1\"]/form/div[4]/p/span/textarea")).sendKeys("INTERSTED TO STUDY ABROAD");
	        driver.findElement(By.xpath("//*[@id=\"wpcf7-f1147-o1\"]/form/div[5]/input")).click();
	}
	
}
