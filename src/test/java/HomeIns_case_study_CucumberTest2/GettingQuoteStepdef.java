package HomeIns_case_study_CucumberTest2;


	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	import cucumber.api.java.After;
	import cucumber.api.java.Before;
	import cucumber.api.java.en.And;
	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;

	public class GettingQuoteStepdef {
		static WebDriver driver;
		static WebDriverWait wait;
		static Actions act;
								// Happy Path for successfully buying a quote by the user
		   @Before
		    public void setup() {
		    	System.setProperty("webdriver.chrome.driver", 
						"C:\\Users\\Student.DESKTOP-Q29NSH0\\Desktop\\SeleniumRARfiles\\chromedriver.exe");  
				 driver = new ChromeDriver();
				 driver.manage().window().maximize();
		    }

		@Given("^Access the homeinsurance website$")
		public void Access_the_homeinsurance_website() throws Throwable {
			Thread.sleep(3000);
			driver.get("http://localhost:8080/practice_case_study/login.jsp");
		}

		@Then("^Login into the website$")
		public void Login_into_the_website() throws Throwable {
			Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@id=\"overlay\"]/div[1]/div/div/form/div[1]/input")).sendKeys("superman"); //user
		    driver.findElement(By.xpath("//*[@id=\"overlay\"]/div[1]/div/div/form/div[2]/input")).sendKeys("marvel123");	//pass
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@id=\"submitLogin\"]")).click();	//clicking login
		    
		}

		@Then("^Get redirected to Get Quote navigation page and fill the form$")
		public void Get_redirected_to_Get_Quote_navigation_page_and_fill_the_form() throws Throwable {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"navbar9\"]/ul/li[1]/a")).click(); //Quote
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//input[@id='']")).click(); //Quote				
			//Select typeSel = new Select(driver.findElement(By.name(("residencyType"))));	//by name
			//typeSel.selectByVisibleText("Condo"); //option
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[1]/select")).sendKeys("Single-Family Home");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[2]/input")).sendKeys("address1");	//address1
			driver.findElement(By.xpath("//*[@id=\"inputCity\"]")).sendKeys("Dallas");
			driver.findElement(By.xpath("//*[@id=\"inputState\"]")).sendKeys("Tx");
			driver.findElement(By.xpath("//*[@id=\"inputZip\"]")).sendKeys("75065");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[5]/select")).sendKeys("Primary");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/button")).click();
			}
		  
		@Then("^Get redirected to Homeowner Information page and fill the form$")
		public void Get_redirected_to_Homeowner_Information_page_and_fill_the_form() throws Throwable {
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[1]/div/input")).sendKeys("Super");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[2]/div/input")).sendKeys("Man");	//address1
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[3]/div/input")).sendKeys("03251995");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[4]/div/div[2]/label/input")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[5]/div/input")).sendKeys("967123123");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[6]/div/input")).sendKeys("krit@gmail.com");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/button")).click();
			}
		
		@Then("^Get redirected to property details page and fill the form$")
		public void Get_redirected_to_property_details_page_and_fill_the_form() throws Throwable {
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[1]/div/input")).sendKeys("573000");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[2]/div/input")).sendKeys("1999");	
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[3]/div/input")).sendKeys("5392");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[4]/div/select")).click();	
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[5]/div/select")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[6]/div/select")).click();		
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[7]/div/input")).sendKeys("7");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[8]/div/input")).sendKeys("4");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[9]/div/div[1]/label/input")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/button")).click();
			}
			
		@Then("^Get redirected on coverage details page and fill the form$")
		public void Get_redirected_to_coverage_details_page_and_fill_the_form() throws Throwable {
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/table/tbody/tr[9]/th/button/a")).click();	
			}
		
		@And ("^Get redirected to quote details page$")
		public void Get_redirected_to_quote_details_page() throws Throwable {
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td[9]/a")).click();	
			}
		
		@Then ("^Get redirected to quote summary page$")
		public void Get_redirected_to_quote_summary_page() throws Throwable {
			Thread.sleep(3000);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.linkText("Buy Quote")));
			driver.findElement(By.linkText("Buy Quote")).click();
			Thread.sleep(3000);
		}
			
			@And("^Get redirected to buy quote page$")
			public void Get_redirected_to_buy_quote_page() throws Throwable {
				Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys("10022018");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div/label/input")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/button")).click();
				Thread.sleep(3000);
			}
			
			@Then("^Get redirected to policy confirmation page successfully and logout$")
			public void Get_redirected_to_policy_confirmation_page_successfully_and_logout() throws Throwable {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"navbar9\"]/ul/li[4]/a")).click();	
				Thread.sleep(3000);
				}
			
				
		@Then ("^Close$")
		public void Close() throws Throwable {
			Thread.sleep(3000);
			driver.close();
			driver.quit();
		}
		
	}
