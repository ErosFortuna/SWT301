package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public abstract class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    static void setUp() {

        driver = DriverFactory.createDriver();
    }

    @AfterAll
    static void tearDown() {

        driver.quit();
    }
}