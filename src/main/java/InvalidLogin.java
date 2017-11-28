
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class InvalidLogin 
 {
	    public static void main(String[] args) throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "/Users/aditisale/Downloads/chromedriver");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
	        driver.get("http://fits.qauber.com/#/page/login");
	        
	        By x = By.xpath(".//*[@id='exampleInputEmail1']");
	        WebElement emailTextBox = driver.findElement(x);
	        //*Validating error messages for invalid email id *//
	        emailTextBox.sendKeys("---$@gmail.com");
	        
	        
		    WebElement error = driver.findElement(By.xpath("//span[@class='text-danger']"));
		    String z = error.getText();
	        	if(z.equals("Please enter a valid email address")) {
	        		System.out.println("Test case passed for invalid email id");
	        	}
	        	else 
	        	{
	        		System.out.println("Test case failed invalid email id");

	        	}
	        	
	        	//*Validating error messages for empty id *// 
	        		emailTextBox.clear();
		        WebElement emptyemaild = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
		        emptyemaild.sendKeys("");
		        
		        
		        WebElement loginButton = driver.findElement( By.xpath("//button[text()='Login']"));
		        Thread.sleep(5000);

		        loginButton.click();
		        
		        WebElement ErrorMessage = driver.findElement(By.xpath("//span[@class='text-danger']"));
			    String d = ErrorMessage.getText();
		        	if(d.equals("This field is required")) {
		        		System.out.println("Test case passed for empty email id");
		        	}
		        	else 
		        	{
		        		System.out.println(" Test case failed for empty email id ");

		        	}
		        	
		        	//Validating error messages for invalid password *//
		        	emailTextBox.clear();
			        WebElement emailID = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
			        emailID.sendKeys("reshmaaher@gmail.com");
			        WebElement PassWord = driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']"));
			        PassWord.sendKeys("Iltarget");

			        loginButton.click();
			        WebElement PwdErrormessage = driver.findElement(By.xpath("//div[@class='alert alert-danger text-center ng-binding']"));
			        String a = PwdErrormessage.getText();
			        
			        if(!a.equals("Please make sure your email and password are correct.")) {
		        		System.out.println("Testcase failed for Invalid password error message");
		        	}
		        		
		                	System.out.println("Test case Passed...Invalid password error message is correct");
		                }

		        	
	    
 }