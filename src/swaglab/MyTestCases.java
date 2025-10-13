package swaglab;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases
{
    WebDriver driver;

    @BeforeTest
    public void setUp() 
    {
    	
        // Launch browser before each test
        driver = new ChromeDriver();
        
        // Set an implicit wait time (wait up to 5 seconds when locating elements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Navigate to the SauceDemo login page
        driver.get("https://www.saucedemo.com/");
    }

    

    // Reusable method for login
    // Test Case 1: Login and add a product to the shopping cart
    @Test (priority = 1 , enabled = true)
    public void login() throws InterruptedException 
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
    //Test Case 2 : Add Item to the Cart
    @Test (priority=2 , enabled = true)
    public void AddItem ()
    
    {
    	//AfterLogin
        // Add a product to the cart
        WebElement TheFirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        TheFirstItem.click();
        //Thread.sleep(1000);
        WebElement TheSecondItem = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        TheSecondItem.click();

    	
    }
   
    // Test Case 3: Proceed to checkout and complete the purchase
    @Test (priority = 3 , enabled = true)
    public void CheckoutProcess() throws InterruptedException
    
    {
        // Define shipping information
    	//String FirstName = "Hala";
    	//String LastName="Amayerh";
    	//String PostalCode = "242344";
    	
    	
        // Click on the cart icon
    	driver.navigate().to("https://www.saucedemo.com/cart.html");
       //WebElement TheCart=  driver.findElement(By.className("shopping_cart_link"));
       //TheCart.click();
          //Thread.sleep(1000);
        // Click the checkout button
           WebElement Checkout =driver.findElement(By.name("checkout"));
           Checkout.click();
           
           
        // Fill in user information
       WebElement firstName= driver.findElement(By.name("firstName"));
       firstName.sendKeys("Hala");
       WebElement lastName= driver.findElement(By.name("lastName"));
       lastName.sendKeys("Kamal");
       WebElement Postalcode =driver.findElement(By.name("postalCode"));
        Postalcode.sendKeys("243242");
        
        // Click the "Continue" button to proceed
        WebElement ContinueButton = driver.findElement(By.id("continue"));
        ContinueButton.click();
        
        // Click the "Finish" button to complete the order
        WebElement FinishButton = driver.findElement(By.name("finish"));
        FinishButton.click();
        
        
        driver.navigate().refresh();
        
        driver.findElement(By.cssSelector(".btn.btn_primary.btn_small")).click();
    }
}
