package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import utilities.CommonFunctions;

public class LeaderboardSteps extends CommonFunctions {
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement element;
	
	@Then("I should be navigated to leaderboard page for {string}")
	public void verify_leaderboard_page(String string) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("leaderboard_link")));
		Assert.assertEquals(driver.getCurrentUrl(), "https://responsivefight.herokuapp.com/leaderboard");
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(), "+string+")]")).isDisplayed());
	}

}
