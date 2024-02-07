import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;



public class MyAppTest {
    public static AppiumDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        MyAppTest test = new MyAppTest();
        test.Android_setUp();
    }
    public void Android_setUp() throws MalformedURLException, InterruptedException {
    	
    	// Specify the absolute path to the APK file
        File appDir = new File("src/test/java");
		File app = new File(appDir, "theScore_ Sports News & Scores_24.2.0_Apkpure.apk");
		
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:platformVersion", "11.0");
        capabilities.setCapability("appium:deviceName", "Pixel_4");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("autoGrantPermissions", true); //This is used if you don't want to tap allow for any permissions.
        capabilities.setCapability("appium:app", app.getAbsolutePath());
        
        URL appiumServerURL = new URL("http://localhost:4723/");// Specify the Appium server URL
        driver = new AndroidDriver(appiumServerURL, capabilities);
        Thread.sleep(8000);
        
        
        //App Launches
        driver.findElement(By.xpath("//android.widget.TextView[@text='Get Started']")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("com.fivemobile.thescore:id/action_button_text")).click();
        Thread.sleep(4000);
        //if you want to allow permission individually use the following script.
        /*driver.findElement(By.id("com.fivemobile.thescore:id/btn_allow")).click(); // Permissions
        Thread.sleep(4000);
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click(); // Permissions
        Thread.sleep(4000);*/
        //driver.findElement(By.xpath("//android.widget.TextView[@text='Toronto Raptors']")).click(); 
        
        Thread.sleep(2000);
        driver.findElement(By.id("com.fivemobile.thescore:id/action_button_text")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
        Thread.sleep(16000);
        
        
          
        
     //Automating Step 1: Open a league, team, or player page of your choice.
        
        By combinedLocator = By.xpath("//*[@resource-id='com.fivemobile.thescore:id/label' and contains(@text, 'TOR')]");
        WebElement team = driver.findElement(combinedLocator);
        team.click(); // Opens the team Toronto Raptors
        Thread.sleep(6000);
        
     //Automating Step 2: Verify that the expected page opens correctly.
        
        By elementLocator = By.id("com.fivemobile.thescore:id/team_name");
        WebElement elementIsPresent = driver.findElement(elementLocator);
        // Verify if the element exists
        if (elementIsPresent != null) {
        
        	
        	
     //Automating Step 3: Tap on a sub-tab of your choice, eg: league table / standings / leaders, or stats tab of the league, team, or player.
            //Tapped on Team Stats.
        	System.out.println("Expected page opens correctly");
        	driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Team Stats\"]/android.widget.TextView")).click();}   
        else {
            System.out.println("Error: Element does not exist. Handling accordingly...or we can use raise error");// Error: Element does not exist will be displayed if element is not present.
        }
        Thread.sleep(6000);
        
        
        
        
     //Automating Step 4: Verify that you are on the correct tab and that the data is displayed correctly and corresponds to the league, team, or player from step 1.
        
        By teamNameLocator = By.xpath("//android.widget.TextView[@text='Toronto Raptors']");
        By paceLocator = By.xpath("//android.widget.TextView[@text='Pace']");
        By ppgLocator = By.xpath("//android.widget.TextView[@text='PPG']");

        // Check if all three elements exist
        boolean teamNameExists = !driver.findElements(teamNameLocator).isEmpty();
        boolean paceExists = !driver.findElements(paceLocator).isEmpty();
        boolean ppgExists = !driver.findElements(ppgLocator).isEmpty();

        // Check if all elements exist
        if (teamNameExists && paceExists && ppgExists) {
            System.out.println("All elements exist.");
        } else {
            System.out.println("Error: Not all elements exist.");
            // Handle the case when any of the elements is not found
        }
        Thread.sleep(5000);
        
       
        
        
        
     //Automating Step 5: Verify that back navigation returns you to the previous page correctly.
        driver.navigate().back();
        Thread.sleep(6000);

        By element_Locator = By.id("com.fivemobile.thescore:id/icon_team_logo");
        By element_Text = By.xpath("//android.widget.TextView[@text='TOR']");
        WebElement previousPageElement = null;
        WebElement secondElement = null;

        try {
            // Verify if the elements exist
        	previousPageElement = driver.findElement(element_Locator);
        	secondElement = driver.findElement(element_Text);
            System.out.println("Successfully reloaded the previous page");
        } catch (NoSuchElementException e) {
            System.out.println("Error: Previous page element not found");
            // You can raise an error, throw an exception, or take appropriate action here
        }
        Thread.sleep(6000);

        //Close the driver when done
        driver.quit();
        
        
    }
}

