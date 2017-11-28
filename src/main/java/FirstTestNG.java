
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNG {
	public String baseUrl = "http://fits.qauber.com/#/page/login";
	String driverPath = "/Users/aditisale/Downloads/chromedriver";
	public WebDriver driver;

	@BeforeTest
	public void Setup() {
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
		driver.get(baseUrl);
	}

	@Test(priority = 0, enabled = true, groups = {
			"Login page" }, description = "User should be able to login into the FITS with valid email id and password")
	public void Test1() throws InterruptedException {

		WebElement emailTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
		emailTextBox.sendKeys("reshmaaher@gmail.com");

		WebElement passwordTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']"));
		passwordTextBox.sendKeys("Iltarget3");

		Thread.sleep(5000);

		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
		loginButton.click();

	}

	@Test(priority = 0, enabled = false, groups = { "Login page" }, description = "Verifying the home page")
	public void test2() {
		WebElement TextBox = driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']"));
		String d = TextBox.getText();
		Assert.assertEquals("AditiCafe", d);

	}

	@Test(priority = 0, enabled = false, groups = {
			"Login page" }, description = "User should not be able login into the FITS with invalid email id")
	public void test3() throws InterruptedException {
		Thread.sleep(5000);
		WebElement emailTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
		emailTextBox.sendKeys("---$@gmail.com");

		WebElement error = driver.findElement(By.xpath("//span[@class='text-danger']"));
		String z = error.getText();
		Assert.assertEquals("Please enter a valid email address", z);

	}

	@Test(priority = 0, enabled = false, groups = {
			"Login page" }, description = "User should not be able to login into the FITS with  empty login id and password")
	public void test4() throws InterruptedException {

		WebElement emptyemaild = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
		emptyemaild.sendKeys("");

		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
		Thread.sleep(5000);

		loginButton.click();
		WebElement ErrorMessage = driver.findElement(By.xpath("//span[@class='text-danger']"));
		String d = ErrorMessage.getText();
		Assert.assertEquals("This field is required", d);

	}

	@Test(priority = 0, enabled = false, groups = {
			"Login page" }, description = "User should not be able login into the FITS with invalid password")
	public void test5() throws InterruptedException {
		WebElement emailID = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
		emailID.sendKeys("reshmaaher@gmail.com");
		WebElement PassWord = driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']"));
		PassWord.sendKeys("Iltarget");

		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
		Thread.sleep(5000);

		loginButton.click();
		WebElement PwdErrormessage = driver
				.findElement(By.xpath("//div[@class='alert alert-danger text-center ng-binding']"));
		String a = PwdErrormessage.getText();
		Assert.assertEquals("Please make sure your email and password are correct", a);

	}

	@Test( enabled = true, groups = {
			"Invite Users" }, description = "SA should invite Regular User with valid  email id")
	public void test6() throws InterruptedException {
		WebElement user = driver.findElement(By.xpath("//span[text()='Users']"));
		user.click();
		System.out.println("Clicked Users list");
		WebElement inviteuser = driver.findElement(By.xpath("//button[@class='pull-right btn btn-info btn-sm']"));
		inviteuser.click();
		WebElement emailInvite = driver.findElement(By.xpath("//input[@name='email']"));
		emailInvite.sendKeys("pp@mailinator.com");

		WebElement sendInvite = driver.findElement(By.xpath("//button[@class='btn btn-primary mr']"));
		sendInvite.click();
		Thread.sleep(10000);

		List<WebElement> allElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//a"));
		for (WebElement e : allElement) {
			System.out.println(e.getText());
		}
	}

	@Test( enabled = false, groups = {
			"Invite Users" }, description = "SA should not invite Regular User with invalid  email id")
	public void test7() throws InterruptedException {
		WebElement user = driver.findElement(By.xpath("//span[text()='Users']"));
		user.click();
		System.out.println("Clicked Users list");
		WebElement inviteuser = driver.findElement(By.xpath("//button[@class='pull-right btn btn-info btn-sm']"));
		inviteuser.click();
		WebElement emailInvite = driver.findElement(By.xpath("//input[@name='email']"));
		emailInvite.sendKeys("---$@gmail.com");
		Thread.sleep(10000);

		WebElement ErrorEmailId = driver.findElement(By.xpath("//span[text()='Please enter a valid email address']"));
		String g = ErrorEmailId.getText();
		Assert.assertEquals("Please enter a valid email address", g);
		
			

	}

	@Test( enabled = false, groups = {
			"Invite Users" }, description = "SA should not invite Regular User with empty email id")
	public void test8() throws InterruptedException {
		WebElement user = driver.findElement(By.xpath("//span[text()='Users']"));
		user.click();
		System.out.println("Clicked Users list");
		WebElement inviteuser = driver.findElement(By.xpath("//button[@class='pull-right btn btn-info btn-sm']"));
		inviteuser.click();
		WebElement emailInvite = driver.findElement(By.xpath("//input[@name='email']"));
		emailInvite.sendKeys("");
		
		WebElement sendInvite = driver.findElement(By.xpath("//button[@class='btn btn-primary mr']"));
		sendInvite.click();
		Thread.sleep(10000);

		WebElement ErrorEmailId = driver.findElement(By.xpath("//span[text()='This field is required']"));
		String g = ErrorEmailId.getText();
		Assert.assertEquals("This field is required", g);
		
		Thread.sleep(10000);
	}
			
	

	@AfterTest
	public void logOut() {
		// driver.close();
		// WebElement logOutButton =
		// driver.findElement(By.xpath("//button[@class='btn btn-labeled
		// btn-primary btn-sm' ]"));
		// logOutButton.click();
	}
}
