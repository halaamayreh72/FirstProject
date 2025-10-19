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
	Random rand = new Random();

	
	@BeforeTest
	public void MySetup ()
	
	{
            driver.get(theURL);
        // Set an implicit wait time (wait up to 3 seconds when locating elements)
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
	
	
	@Test(priority=2 , enabled = false)
	public void AddRandomItem() 
	
	{
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
	
	@Test (priority=3)
	public void RandomItem()
	
	
	{
		
		
		int RandomItem1=rand.nextInt(2); //0 or 1
		int RandomItem2=rand.nextInt(2,4); // 2 or 3
		int RandomItem3=rand.nextInt(4,6); // 4 or 5
        System.out.println(RandomItem1);
        System.out.println(RandomItem2);
        System.out.println(RandomItem3);

		List <WebElement> AddToCartButton= driver.findElements(By.className("btn"));
		AddToCartButton.get(RandomItem1).click();
		AddToCartButton.get(RandomItem2).click();
		AddToCartButton.get(RandomItem3).click();


		
		
		
		
	}
	

}
