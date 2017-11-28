import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddEntity {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver", "/Users/aditisale/Downloads/chromedriver");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
	        driver.get("http://fits.qauber.com/#/page/login");
	       //* Login into the system**//    
	        
	        
	     
	        WebElement emailTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
	        emailTextBox.sendKeys("reshmaaher@gmail.com");
	        

	        WebElement passwordTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']"));
	        passwordTextBox.sendKeys("Iltarget3");
	        
	        
	        Thread.sleep(5000);
	      
	        WebElement loginButton = driver.findElement( By.xpath("//button[text()='Login']"));
	        loginButton.click();
	       

	        WebElement clickEntity = driver.findElement(By.xpath("//a[@title='Entities']"));
	        clickEntity.click();
	        WebElement addEntity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
	        addEntity.click();
	        
	        WebElement EntityName = driver.findElement(By.xpath("//input[@placeholder='Cool Name']"));
	        EntityName.sendKeys("Aditi");
	        
	        WebElement PhoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
	        PhoneNumber.sendKeys("4088965488");
	        
	        WebElement EmailID = driver.findElement(By.xpath("//input[@name='email']"));
	        EmailID.sendKeys("Aditi@gmail.com");
	        
	        Select drpCountry = new Select(driver.findElement(By.name("country")));
	        drpCountry.selectByVisibleText("United States");
	        
	        WebElement add1 = driver.findElement(By.xpath("//input[@name='address1']"));
	        add1.sendKeys("3901 lick mill blvd");
	        
	        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
	        city.sendKeys("Santa Clara");
	        
	        Select drpState = new Select(driver.findElement(By.name("state")));
	        drpState.selectByVisibleText("California");
	        
	        
	        WebElement postalCode = driver.findElement(By.xpath("//input[@name='zip']"));
	        postalCode.sendKeys("Santa Clara");
	        
	      WebElement notes = driver.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-valid ng-empty ng-touched']"));
	      notes.sendKeys("ABCDd");
	        		
	      WebElement next = driver.findElement(By.xpath("//button[@ class='btn btn-info btn-labeled'][2]"));

			Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
			if (cp.getBrowserName().equals("chrome")) {
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
				} catch (Exception e) {

				}
			}

			next.click();
	        
	     
	    
         }
			
			
	       
	      
	        
	
}

	





