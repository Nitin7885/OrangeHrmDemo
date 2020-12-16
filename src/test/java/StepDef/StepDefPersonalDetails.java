package StepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageBeans.ViewPersonalDetails;

public class StepDefPersonalDetails {
	private WebDriver driver;
	private ViewPersonalDetails objelppf;
	
	
	@Given("user is on the Employee list page")
	public void user_is_on_the_Employee_list_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abc\\Downloads\\Programs\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		objelppf = new ViewPersonalDetails(driver);
		objelppf.setUname("Admin");
		objelppf.setPwd("admin123");
		objelppf.setLogin();
	}

	@When("user enters valid employee name, employee ID, supervisor name")
	public void user_enters_valid_employee_name_employee_ID_supervisor_name() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objelppf.setPimLink();
		Thread.sleep(1000);
		objelppf.setEmpName("&//**");
		objelppf.setSearchButton();
	}

	@Then("display the table with the employee data")
	public void display_the_table_with_the_employee_data() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
	    String data = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td")).getText();
	    String expectedResult = "No Records Found";
	    Assert.assertEquals(data, expectedResult);
	    
	    
	    if(data.contentEquals("No Records Found")) {
	    	System.out.println("Good job");
	    }
	    else {
	    	System.out.println("Failed");
	    }
	    driver.close();
	}


}
