package autopjt;


	
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.time.Duration;
	import java.util.List;
	import java.util.Set;

	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class HiristTech {
		WebDriver driver;
		String baseurl="https://www.hirist.tech/";
		
		@BeforeTest
		public void setup() {
			driver=new ChromeDriver();
		}
		@BeforeMethod
		public void urlloading() {
			driver.get(baseurl);
			
		}
		
		@Test
		public void test1() throws AWTException, IOException, InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			
			
			
			
			driver.findElement(By.xpath("//*[@id=\"hm-root\"]/div[3]/div/div/span[1]/a/p")).click();
			
			
			WebElement hover=driver.findElement(By.xpath("//*[@id=\"observer-div\"]/div/div[1]/div[1]/div[2]/a[2]"));	
			Actions act=new Actions(driver);
			act.moveToElement(hover).perform();
			
			driver.findElement(By.xpath("//*[@id=\"observer-div\"]/div/div[1]/div[1]/div[2]/a[2]/div/div[2]/a[1]")).click();
			
			
			driver.findElement(By.xpath("//*[@id=\"sticky-tab\"]/a[2]")).click();
			
			
			String parentWindow=driver.getWindowHandle();
			driver.findElement(By.xpath("//*[@id=\"observer-div\"]/div/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div/div/div[2]/div[5]/a")).click();
			
			Set<String> allwindowhandle = driver.getWindowHandles();
			for(String a:allwindowhandle) {
				if(!a.equalsIgnoreCase(parentWindow)) {
					driver.switchTo().window(a);
					
					driver.close();
				}
				driver.switchTo().window(parentWindow);
			}
			
			Thread.sleep(3000);
			

			
			String actualtitle=driver.getTitle();
			System.out.println(actualtitle);
			String exp="Companies -hirist.tech";
			if(actualtitle.equals(exp)) { 
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			}
					
			//WebElement dayelement=driver.findElement(By.xpath("//*[@id=\"observer-div\"]/div/div[1]/div[1]/div[1]/a/img"));
			//File src1=dayelement.getScreenshotAs(OutputType.FILE);
			//FileHandler.copy(src1, new File("./scrnsht//Elementsscreenshot01.png"));
			
			driver.navigate().back();
			driver.navigate().back();
			driver.navigate().back();
				
			
			
			driver.findElement(By.xpath("//*[@id=\"user-login-button-id\"]/p")).click();
			
			driver.findElement(By.xpath("//*[@id=\"signUp-email-input\"]")).sendKeys("stonasuresh1999@gmail.com");
			
			driver.findElement(By.xpath("//*[@id=\"signUpPassword\"]")).sendKeys("Stona@1999");
			
			
			
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div/form/div[3]/div/div[2]/div/div/span")).click();
			fileUpload("C:\\Users\\Dell\\Documents\\Resume4_Stona.pdf");
			
			
	        
		}
		private void fileUpload(String p) throws AWTException, IOException {
			StringSelection strSelection=new StringSelection(p);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
			
			Robot robo=new Robot();
			robo.delay(3000);
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_V); 
			robo.keyRelease(KeyEvent.VK_CONTROL);
			
			robo.keyPress(KeyEvent.VK_ENTER);
			
			//Thread.sleep(3000);
			
			robo.keyRelease(KeyEvent.VK_ENTER);
			
			
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div/form/div[4]/p/span")).click();
			
			
			
			
			
			
			File f = new File("C:\\Users\\Dell\\Documents\\databook.xlsx");
			FileInputStream fi= new FileInputStream(f);
			XSSFWorkbook wb= new XSSFWorkbook(fi);
			XSSFSheet sh= wb.getSheet("Sheet1");
			System.out.println(sh.getLastRowNum());
			
			for (int i=1;i<=sh.getLastRowNum();i++)
			{
				String Email= sh.getRow(i).getCell(0).getStringCellValue();
				System.out.println("Email="+Email);
				String Password=sh.getRow(i).getCell(1).getStringCellValue();
				System.out.println("Password="+Password);
				
				driver.findElement(By.xpath("//*[@id=\"login-email-input\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"login-email-input\"]")).sendKeys(Email);
				driver.findElement(By.xpath("//*[@id=\"loginPassword\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"loginPassword\"]")).sendKeys(Password);
			}
				driver.findElement(By.xpath("//*[@id=\"loginSubmit\"]")).click();
				
				
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				
				
						
				
				URL ob=new URL(baseurl);
				HttpURLConnection con=(HttpURLConnection)ob.openConnection();
				con.connect();
				if(con.getResponseCode()==200) {
					System.out.println("Valid url");
				}else {
					System.out.println("invalid url");
				}
				
			
				
				
			}
				
			
		}


