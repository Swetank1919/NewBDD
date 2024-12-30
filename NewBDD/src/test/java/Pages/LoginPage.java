package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	 public LoginPage(WebDriver driver){
		this.driver=driver;	
		
	}
	public void loginUser(String user) {
		WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys(user);
	}
	
	public void loginPassword(String password) {
		WebElement pass=driver.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys(password);
	}
	public void clickBtn() {
		WebElement button=driver.findElement(By.xpath("//input[@id='login-button']"));
		button.click();
	}
	
	

}
