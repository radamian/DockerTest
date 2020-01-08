package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.junit.Assert.assertEquals;

public class DockerWithFirefox {

    public static void main(String args[]) throws MalformedURLException {
        FirefoxOptions cap = new FirefoxOptions();
        cap.setHeadless(true);

        RemoteWebDriver driver;
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("Title of the Home page:" + driver.getTitle());  driver.findElement(By.id("txtUsername")).click();
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).click();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        try {
            assertEquals("Welcome Admin", driver.findElement(By.id("welcome")).getText());
            System.out.println("Logged in" );
        } catch (Error e) {
            System.out.println(e.toString());
        }

        driver.quit();
    }

}