package comutimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;


    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        driver.get(baseUrl);
        // We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Print the title of the page
        System.out.println(driver.getTitle());
        //Print the current URL
        System.out.println(driver.getCurrentUrl());
        //Print the page source
        System.out.println(driver.getPageSource());
        //click on the Sign In link
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
