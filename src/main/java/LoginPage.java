
public class LoginPage {

	private String username = ".//*[@id='exampleInputEmail1']";
	private String userpassword = ".//*[@id='exampleInputPassword1']";
	private String login = "html/body/div[2]/div/div/div[1]/div[2]/form/button";
	private String forgotpassword = "html/body/div[2]/div/div/div[1]/div[2]/form/div[3]/div/a";
	private String register = "html/body/div[2]/div/div/div[1]/div[2]/a";
	
	public LoginPage (String name, String password) {
		username = username;
		userpassword = userpassword; 
		
		
	}
	

public void login(String username, String userpassword)
{
	System.out.println("Login into the application");
}

public void forgotpassword() {
	System.out.println("Forgot password");
}
public void register() {
	System.out.println("Registered");

}
}