package swaglab;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddRandomITem 

{

    
	WebDriver driver = new EdgeDriver();
	String theURL ="https://www.saucedemo.com/";
	
	
	@BeforeTest
	public void MySetup ()
	
	{
            driver.get(theURL);
        // Set an implicit wait time (wait up to 5 seconds when locating elements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        
		    	
		     
     }
		
		
		
	
	
	
	
	@Test (priority=1)
	public void LoginWithNormalUser()
	
	{
		  // Define login credentials
    	String UserName = "standard_user";
    	String Password = "secret_sauce";
    	
        // Enter username
    	//WebElement UserNameInput =  driver.findElement(By.cssSelector("#user-name"));
    	WebElement UserNameInput =  driver.findElement(By.xpath("//input[@data-test=\'username']"));

        UserNameInput.sendKeys(UserName);
        // Enter password
        WebElement PasswordInput = driver.findElement(By.xpath("//input[@data-test=\'password']"));
        PasswordInput.sendKeys(Password);
        // Click the login button
        WebElement LoginButton = driver.findElement(By.id("login-button"));
        LoginButton.click();
        //Thread.sleep(1000);
        
		
	}
	
	
	@Test(priority=2)
	public void AddRandomItem() 
	
	{
		Random rand = new Random();
		int RandomItem1 =rand.nextInt(6);
		int RandomItem2;
		if (RandomItem1==5) {
			
			 RandomItem2 = RandomItem1-1;
		}
		else { RandomItem2=RandomItem1+1;}
		
		List <WebElement> AddToCartButton= driver.findElements(By.className("btn"));
		List <WebElement> ItemsName= driver.findElements(By.className("inventory_item_name"));
       

		
		AddToCartButton.get(RandomItem1).click();
		AddToCartButton.get(RandomItem2).click();

		
		System.out.println(ItemsName.get(RandomItem1).getText()+ "has been Added"+ "and the index for it" + RandomItem1);
		 System.out.println(RandomItem1);
	     System.out.println(RandomItem2);
	}
	
	

}
