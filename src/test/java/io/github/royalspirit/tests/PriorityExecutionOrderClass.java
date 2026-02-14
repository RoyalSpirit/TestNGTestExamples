package io.github.royalspirit.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PriorityExecutionOrderClass
{
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeClass
    public void setUp () throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver_mac");
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
    }

    @Test (priority = 1)
    public void signIn () {
        String consentButtonXpath = "//button[contains(@class,'consent')]";

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(consentButtonXpath)));
        WebElement element = driver.findElement(By.xpath(consentButtonXpath));
        element.click();

        driver.findElement(By.xpath("//a[normalize-space(text())='Signup / Login']")).click();

        WebElement emailAddress = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailAddress.sendKeys("TestNGTestUser@example.com");

        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("Qq1234567");

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        System.out.println("1. Sign In");
    }

    @Test (priority = 2)
    public void searchJeans()
    {
        WebElement productsMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space(text())='Products']")));
        productsMenu.click();

        WebElement searchBox = driver.findElement(By.id("search_product"));
        searchBox.sendKeys("Soft Stretch Jeans");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@id='submit_search']"));
        buttonSearch.click();

        System.out.println("2. Search For Jeans");
    }

    @Test (priority = 3)
    public void signOut ()
    {
        WebElement linkSignOut = driver.findElement(By.xpath("//a[normalize-space(text())='Logout']"));
        linkSignOut.click();

        System.out.println("3. Sign Out");
    }

    @AfterClass
    public void tearDown () throws Exception
    {
        driver.quit();
    }
}