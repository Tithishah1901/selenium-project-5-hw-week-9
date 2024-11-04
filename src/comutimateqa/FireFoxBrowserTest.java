package comutimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFoxBrowserTest {
    public static void main(String[] args) {
        String baseUrl = "https://courses.ultimateqa.com/";
        // launch the Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // get the url
        driver.get(baseUrl);

        // We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // print the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        // print the current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The current url " + currentUrl);

        // print the page source
        System.out.println("The page source : " + driver.getPageSource());

        //click on the sign in link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        //Print the current url
        System.out.println("Current url after clicking Sign In: " + driver.getCurrentUrl() );

        //enter the email in the email filed
        WebElement emailFiled = driver.findElement(By.id("user[email]"));
        emailFiled.sendKeys("xyz.123@gmail.com");

        // enter the password in the password filed
        WebElement passwordFiled = driver.findElement(By.id("user[password]"));
        passwordFiled.sendKeys("1234");

        // Click the login button
        WebElement loginLink = driver.findElement(By.className("g-recaptcha"));
        loginLink.click();

        //Navigate to baseUrl
        driver.navigate().to(baseUrl);

        // Navigate to homepage
        driver.navigate().forward();

        //Navigate back to base Url
        driver.navigate().back();

        // Refresh the page
        driver.navigate().refresh();

        //close the browser
        driver.close();
    }
}
