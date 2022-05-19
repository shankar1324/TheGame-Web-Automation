package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonFunctions;

public class LoginSteps extends CommonFunctions {
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement element;
	
	@Given("I am on the homepage of the application")
	public void i_am_on_the_homepage() {
		driver.navigate().to("https://responsivefight.herokuapp.com/");
	}
	
	@When("I click on Register button")
	public void i_click_on_register_button() {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("rego")));
		element.click();
	}
	
	@When("I enter {string} in Username field")
	public void i_enter_in_username_field(String string) {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("uname")));
	    element.sendKeys(string);
	}

	@When("I enter {string} in Password field")
	public void i_enter_in_password_field(String string) {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("pwd")));
		element.sendKeys(string);
	}
	
	@When("I enter {string} in Username field in login popup")
	public void i_enter_in_username_field_login_popup(String string) {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("worrior_username")));
	    element.sendKeys(string);
	}

	@When("I enter {string} in Password field in login popup")
	public void i_enter_in_password_field_login_popup(String string) {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("worrior_pwd")));
		element.sendKeys(string);
	}

	@When("I enter {string} in Repeat Password field")
	public void i_enter_in_repeat_password_field(String string) {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("psw-repeat")));
		element.sendKeys(string);
	}

	@When("I click on Sign Up button")
	public void i_click_on_sign_up_button() {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("signupbtn")));
		element.click();
	}
	
	@When("I click on Login button")
	public void i_click_on_login_button() {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
		element.click();
	}

	@When("I click on Login warrior button")
	public void i_click_on_login_warrior_button() {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("warrior")));
		element.click();
	}
	
	@When("I click on Start your journey button")
	public void i_click_start_journey() {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("start")));
		element.click();
	}
	
	@Then("I should be presented with a popup for signup")
	public void verify_signup_popup() {
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Sign Up')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Please fill in this form to create an account.')]")).isDisplayed());
	}
	
	@Then("I should verify that user {string} is created successfully")
	public void verify_user_is_created(String string) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("warrior")));
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(), 'Login with your warrior name')]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.id("worrior_username")).getAttribute("value"), string);
	}
	
	@Then("I should verify that {string} is logged in successfully")
	public void verify_logged_in_success(String string) {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("start")));
		Assert.assertEquals(element.getText(), "Start your journey "+string);
	}

}
