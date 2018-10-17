package HomeIns_case_study_Cucumbertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterNewUserStepdef {
	static WebDriver driver;			//Register as a new user
    @Before
    public void setup() {
    	System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Student.DESKTOP-Q29NSH0\\Desktop\\SeleniumRARfiles\\chromedriver.exe");  
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
    }

@Given("^Open HomeInsurance page$")
public void Open_HomeInsurance_page() throws Throwable {
	Thread.sleep(3000);
	driver.get("http://localhost:8080/practice_case_study/login.jsp");//navigate to the website
	}

@Then("^Click on the Register Here button$")
public void click_on_the_Register_Here_button() throws Throwable {	
   driver.findElement(By.xpath("//*[@id=\"register\"]")).click();  
   Thread.sleep(2000);
}

@And("^Enter a valid user name$")
public void Enter_a_valid_user_name() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"UserId\"]")).sendKeys("blackPanther");
	  Thread.sleep(2000);
}

@Then("^Enter a valid password$")
public void Enter_a_valid_password() throws Throwable {
   //Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("pass123");

}

@And("^ReEnter the password to confirm it$")
public void ReEnter_the_password_to_confirm_it() throws Throwable {
   Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"confirmPass\"]")).sendKeys("pass123");
}

@Then("^click the Register button$")
public void click_the_Register_button() throws Throwable {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"submitReg\"]")).click();
}
}