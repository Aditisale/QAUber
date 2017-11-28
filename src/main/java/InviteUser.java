import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InviteUser {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/aditisale/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
		driver.get("http://fits.qauber.com/#/page/login");

		By x = By.xpath(".//*[@id='exampleInputEmail1']");
		WebElement emailTextBox = driver.findElement(x);
		emailTextBox.sendKeys("reshmaaher@gmail.com");

		By y = By.xpath(".//*[@id='exampleInputPassword1']");
		WebElement passwordTextBox = driver.findElement(y);
		passwordTextBox.sendKeys("Iltarget3");

		Thread.sleep(5000);
		By z = By.xpath("//button[text()='Login']");
		WebElement loginButton = driver.findElement(z);
		loginButton.click();

		WebElement TextBox = driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']"));
		String d = TextBox.getText();

		if (d.equals("Aditi")) {
			System.out.println("Test Case passed ...");
		} else {
			System.out.println("Test Case Failed ...");
		}
		System.out.println("Login into the FITS application");
		// Thread.sleep(5000);

		// *Inviting new user using User List option *//
		WebElement user = driver.findElement(By.xpath("//span[text()='Users']"));
		user.click();
		System.out.println("Clicked Users list");

		WebElement inviteuser = driver.findElement(By.xpath("//button[@class='pull-right btn btn-info btn-sm']"));
		inviteuser.click();

		WebElement emailInvite = driver.findElement(By.xpath("//input[@name='email']"));
		emailInvite.sendKeys("kk@mailinator.com");

		WebElement sendInvite = driver.findElement(By.xpath("//button[@class='btn btn-primary mr']"));
		sendInvite.click();

		List<WebElement> allElements = driver.findElements(By.xpath("//table[@class='table table-bordered']//a"));
		for (WebElement element : allElements) {
			System.out.println(element.getText());
		}

	}
}