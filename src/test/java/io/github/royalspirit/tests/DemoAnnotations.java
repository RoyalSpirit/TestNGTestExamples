package io.github.royalspirit.tests;

import org.testng.annotations.*;

public class DemoAnnotations {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Chrome - Set up system property for ChromeDriver");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Open Chrome browser and navigate to the application URL");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Open test application");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Sign in to the application");
    }

    @Test
    public void searchCustomer() {
        System.out.println("Search for Customer");
    }

    @Test
    public void searchProduct() {
        System.out.println("Search for Product");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Sign out of the application");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Close test application");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Close Chrome browser");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Chrome - Clean up all Cookies");
    }

}
