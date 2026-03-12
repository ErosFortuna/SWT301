package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    void testLoginSuccess() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();

        loginPage.login("customer@busgo.vn", "123456");

        Thread.sleep(3000);
    }

    @Test
    void testLoginFail() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();

        loginPage.login("wrong@gmail.com", "wrong");

        Thread.sleep(3000);
    }
}
