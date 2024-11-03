package autopjt;


	

	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.io.FileHandler;
	import org.testng.annotations.Test;

	
		public class Oxygen {

		
		ChromeDriver driver=new ChromeDriver();
		
		
		@Test
		public void test() throws Exception
		{
			driver.get("https://oxygendigitalshop.com/");
			
			driver.manage().window().maximize();
			/driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/div[1]/div[2]/ul[2]/li[4]/[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"root\"]/aside/div/div/div/div/div/div/button/span/span")).click();
			driver.findElement(By.xpath("//*[@id=\"root\"]/aside/div/div/div/div/div/div/form/div[2]/button")).click();
			driver.findElement(By.name("customer.email")).sendKeys("sonasuja69@gmail.com");
			driver.findElement(By.name("customer.firstname")).sendKeys("Sona");
			driver.findElement(By.name("customer.lastname")).sendKeys("K S");
			driver.findElement(By.name("password")).sendKeys("Sonaks@101");
			driver.findElement(By.xpath("//*[@id=\"root\"]/aside/div/div/div/div/div/div/form/div[7]/button")).click();
			driver.findElement(By.xpath("//*[@id=\"root\"]/main/header/nav/div[1]/div/div/div[2]/ul[1]/li/div/span[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"root\"]/main/header/nav/div[1]/div/div/div[2]/ul[1]/li/div[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"root\"]/main/header/nav/div[1]/div/div/div[2]/ul[1]/li/div[2]/div/div[6]/a/div[2]/span")).click();
			driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/ul/li[1]/form/ul/li[1]/button/span[2]")).isSelected();
			driver.navigate().back();
			String actualtitle=driver.getTitle();
			System.out.println(actualtitle);
			String exp="Oxygen Digital Shop - Online electronics store";
			if(actualtitle.equals(exp)) { 
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			
			WebElement oxyelement=driver.findElement(By.xpath("//*[@id=\"root\"]/main/header/nav/div[1]/div/div/div[1]/a/img"));
			File ss1=oxyelement.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(ss1,new File("./susus1//screenshotoxy1.png"));
		}
		
	}
}
