package StepDefinitions;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinitions {
	static WebDriver driver;
	
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   driver.get("https://www.saucedemo.com/v1/");
	   driver.manage().window().maximize();
	}
	
	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	    
	}

	@And("Clicks on Login button")
	public void clicks_on_login_button() {
	   driver.findElement(By.id("login-button")).click();
	}

	@Then("User is navigated to Home page")
	public void user_is_navigated_to_home_page() {
	  // Assert.assertEquals(driver.findElements(By.xpath("//div[@class='app_logo']")).size()>0,"User navigates to Home page");
	 
		String actualText = driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		Assert.assertEquals(actualText, "Products");
	}

	@And("Close the browser")
	public void close_the_browser() {
	   driver.quit();
	}


}
