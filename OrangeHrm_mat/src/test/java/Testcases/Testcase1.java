package Testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Testcase1 
{
	public static WebDriver driver;
	String empid;
	@Given("I want to open browser and enter url {string}")
	public void i_want_to_open_browser_and_enter_url(String url)
	{
	    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get(url);
	}
	@Then("I should see loginpage displayed")
	public void i_should_see_loginpage_displayed()
	{
	   if( driver.findElement(By.name("Submit")).isDisplayed())
	   {
	   System.out.println("login page Displayed");
	   }  
    }
	@When("I enter user id {string}")
	public void i_enter_user_id(String uid)
	{
		  driver.findElement(By.name("txtUsername")).sendKeys(uid);
		  
	}
	@When("I enter password {string}")
	public void i_enter_password(String pwd) 
	{
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
	}
	@When("I click login")
	public void i_click_login() 
	{
	    driver.findElement(By.name("Submit")).click();
	}
	@Then("I should see admin module displayed or not")
	public boolean i_should_see_admin_module_displayed_or_not() 
	{
	 try {
		 driver.findElement(By.linkText("Admin")).isDisplayed();
		 return true;
		
	} catch (Exception e) {
		return false;
	} 
	}
	@When("I click logout")
	public void i_click_logout() {
		driver.findElement(By.partialLinkText("Welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
	}
	/*@Then("I should see Login Page")
	public boolean i_should_see_login_page() 
	{
		try {
		    driver.findElement(By.linkText("Admin")).isDisplayed();
		    return true;
			}
			catch (Exception e)
			{
				return false;
			}
	}*/
	@When("I close Browser")
	public void i_close_browser() 
	{
	    driver.close();
	}
	@Then("I should see error Message displayed")
	public void i_should_see_error_message_displayed() 
	{
	  String errMsg = driver.findElement(By.id("spanMessage")).getText();
	  if(errMsg.contains("Invalid")||errMsg.contains("Empty"))
	  {
            System.out.println("err msg displayed test pass");
	  }else
	  {
		  System.out.println("err msg not displayed test fail");
	  
	  }
	}
	
	  
		
		 

	
		
		
		
	@When("I click Add Employee")
	public void i_click_add_employee() {
		driver.findElement(By.linkText("PIM")).click();
		  driver.findElement(By.linkText("Add Employee")).click();
	    
	}
	@When("I enter fName {string}")
	public void i_enter_f_name(String fname)
	{
		driver.findElement(By.id("firstName")).sendKeys(fname);   
	}
	@When("I enter lName {string}")
	public void i_enter_l_name(String lname) 
	{
		driver.findElement(By.id("lastName")).sendKeys(lname);    
	}
	@Then("I click SaveButton")
	public void i_click_save_button() 
	{
		empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();      
	}
	@When("I click on employee list")
	public void i_click_on_employee_list() 
	{
		driver.findElement(By.linkText("Employee List")).click();
	}
	@When("I enter Id")
	public void i_enter_id() 
	{
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
	}
	@When("I click search")
	public void i_click_search()
	{
		driver.findElement(By.id("searchBtn")).click();
	}
	@Then("i should see Employee is added or not")
	public boolean i_should_see_employee_is_added_or_not()
	{
		WebElement element= driver.findElement(By.id("resultTable"));
		boolean res=false;
	List<WebElement> rows=	element.findElements(By.tagName("tr"));
	
	for(int i=1;i<rows.size();i++)
	{
	List<WebElement> cols=	rows.get(i).findElements(By.tagName("td"));
	if(cols.get(1).getText().equals(empid))
	{
		 res=true;
		 break;
	}
	System.out.println("completed it");
	}
	return res;
	}
	
	private void syso() 
	{
		System.out.println("how to say that complete");
	}
	}



