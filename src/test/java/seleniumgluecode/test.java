package seleniumgluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class test {
	public static WebDriver driver;

	@Given("user is  on homepage")
	public void user_is_on_homepage() {
		System.setProperty("webdriver.gecko.driver","/Users/Documents/geckodriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php"); 
	}

	@When("user navigates to Login Page")
	public void user_navigates_to_Login_Page() {
		driver.findElement(By.linkText("Sign in")).click();
	}

	@When("user enters username and Password")
	public void user_enters_username_and_Password() {
		driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
        driver.findElement(By.id("SubmitLogin")).click();   
	}

	@Then("success message is displayed")
	public void success_message_is_displayed() {
		String exp_message = "Welcome to your account. Here you can manage all   of your personal information and orders.";
    	String actual = driver.findElement(By.cssSelector(".info-account")).getText();
        Assert.assertEquals(exp_message, actual);
        driver.quit();  


	}



	
}
