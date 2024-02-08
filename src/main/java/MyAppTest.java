import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

//Note:- Run appium 2 using this command:- appium --use-plugins=images

public class MyAppTest {
    public static AppiumDriver driver;
    
    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        Android_setUp();
    }
    
    @Test(dataProvider = "teamsData")
    public void testTeamPage(String teamName[]) throws InterruptedException {
    	//App Launches
        driver.findElement(By.xpath("//android.widget.TextView[@text='Get Started']")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("com.fivemobile.thescore:id/action_button_text")).click();
        Thread.sleep(4000);
        /*driver.findElement(By.id("com.fivemobile.thescore:id/btn_allow")).click(); // Permissions
        Thread.sleep(4000);
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click(); // Permissions
        Thread.sleep(4000);*/
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + teamName[0] + "']")).click();
        //driver.findElement(By.xpath("//android.widget.TextView[@text='Toronto Raptors']")).click(); 
        Thread.sleep(2000);
        driver.findElement(By.id("com.fivemobile.thescore:id/action_button_text")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
        Thread.sleep(16000);
          
        
     //Automating Step 1: Open a league, team, or player page of your choice.
        
        By combinedLocator = By.xpath("//*[@resource-id='com.fivemobile.thescore:id/label' and contains(@text, '"+  teamName[1] + "')]");
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
        	System.out.println("Verified that Expected page opens correctly");
        	driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Team Stats\"]/android.widget.TextView")).click();}   
        else {
        	Assert.fail("Error: Element does not exist. Raise Error"); 
        }
        Thread.sleep(6000);
        
        
        
        
     //Automating Step 4: Verify that you are on the correct tab and that the data is displayed correctly and corresponds to the league, team, or player from step 1.
        
        By teamNameLocator = By.xpath("//android.widget.TextView[@text='" + teamName[0] + "']");
        By paceLocator = By.xpath("//android.widget.TextView[@text='"+teamName[2]+"']");
        By ppgLocator = By.xpath("//android.widget.TextView[@text='"+teamName[3]+"']");

        // Check if all three elements exist
        boolean teamNameExists = !driver.findElements(teamNameLocator).isEmpty();
        boolean paceExists = !driver.findElements(paceLocator).isEmpty();
        boolean ppgExists = !driver.findElements(ppgLocator).isEmpty();
        
     // Use assertTrue for assertions
        Assert.assertTrue(teamNameExists, "Team name element not found");
        Assert.assertTrue(paceExists, "Pace element not found");
        Assert.assertTrue(ppgExists, "PPG element not found");

        // If all elements exist, the test will continue; otherwise, it will fail.
        System.out.println("Verified that All elements exist.");
        Thread.sleep(5000);
        
       
        
        
        
     //Automating Step 5: Verify that back navigation returns you to the previous page correctly.
        driver.navigate().back();
        Thread.sleep(6000);

        By element_Locator = By.id("com.fivemobile.thescore:id/icon_team_logo");
        By element_Text = By.xpath("//android.widget.TextView[@text='" + teamName[1]+ "']");
        WebElement previousPageElement = null;
        WebElement secondElement = null;

        try {
            // Verify if the elements exist
        	previousPageElement = driver.findElement(element_Locator);
        	secondElement = driver.findElement(element_Text);
            System.out.println("Successfully reloaded the previous page");
        } catch (NoSuchElementException e) {
        	Assert.fail("Error: Previous page elements not found");
            // You can raise an error, throw an exception, or take appropriate action here
        }
        Thread.sleep(6000);

        //Close the driver when done
        driver.quit();

    }

    @DataProvider(name = "teamsData")
    public Object[][] getTeamsData() {
        // Provide data for teams you want to test
        return new Object[][]{
                {"Toronto Raptors","TOR", "Pace","PPG"}
                //{"Manchester United","MAN","Goals","Passes"}// Add only one team at a time.
                //{"Some Other Team"},
        };
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
        capabilities.setCapability("autoGrantPermissions", true); //This can also be used if you don't want to tap allow for any permissions.
        capabilities.setCapability("appium:app", app.getAbsolutePath());
        
        URL appiumServerURL = new URL("http://localhost:4723/");// Specify the Appium server URL
        driver = new AndroidDriver(appiumServerURL, capabilities);
        Thread.sleep(8000);
        
        

    }
}