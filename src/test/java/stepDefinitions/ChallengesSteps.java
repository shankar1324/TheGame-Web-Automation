package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonFunctions;

public class ChallengesSteps extends CommonFunctions {
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement element;
	
	@When("I click on {string} battlefield")
	public void i_click_on_battlefield(String string) {
		switch(string) {
		case "Are you game?":
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("news")));
			element.click();
			break;
		case "Take the bus":
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("bus")));
			element.click();
			break;
		case "Go to a public place":
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("restaurant")));
			element.click();
			break;
		case "Go to the office":
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("office")));
			element.click();
			break;
		default:
			System.out.println("Invalid battlefield selected");		
		}
	}
	
	@When("I click on Start button")
	public void i_click_start_button() {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Start')]")));
		element.click();
	}
	
	@When("I select option 1 for challenge 1")
	public void i_select_option1_for_question1() {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("bus_answer_1")));
		element.click();
	}
	
	@When("I click on Check your final score button")
	public void i_click_check_final_score_button() {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("leaderboard_link")));
		element.click();
	}
	
	@Then("I should be navigated to {string} battlefield")
	public void verify_battlefield(String string) {
		switch(string) {
		case "Are you game?":
			Assert.assertTrue(driver.getCurrentUrl().equals("https://responsivefight.herokuapp.com/news"));
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("start")));
			element.click();
			break;
		case "Take the bus":
			Assert.assertTrue(driver.getCurrentUrl().equals("https://responsivefight.herokuapp.com/bus"));
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("bus_timer_start")));
			break;
		case "Go to a public place":
			Assert.assertTrue(driver.getCurrentUrl().equals("https://responsivefight.herokuapp.com/restaurant"));
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("restaurant_timer_start")));
			element.click();
			break;
		case "Go to the office":
			Assert.assertTrue(driver.getCurrentUrl().equals("https://responsivefight.herokuapp.com/office"));
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("start")));
			element.click();
			break;
		default:
			System.out.println("Invalid battlefield selected");		
		}
	}
	
	@Then("I should be navigated to the game home page")
	public void verify_game_homepage() {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alpha-heading")));
		Assert.assertEquals(element.getText(), "COVID-19 THE GAME");
	}
	
	@Then("I should be navigated to Take the bus challenge")
	public void verify_challenge_page() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(), 'Start')]")));
		Assert.assertTrue(driver.findElement(By.id("bus_title")).isDisplayed());
	}
	
	@Then("I verify that answer should be evaluated")
	public void verify_answer_evaluated() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("close_correct_modal_btn")));
		Assert.assertTrue(driver.findElement(By.id("leaderboard_link")).isDisplayed());
	}
	

}
