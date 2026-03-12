package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import pages.LoginPage;
import pages.ProfilePage;

public class ChangePasswordTest extends BaseTest {

    @Test
    void testChangePasswordSuccessfully() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.openLoginPage();

        loginPage.login("customer@busgo.vn", "123456");
        System.out.println(driver.getCurrentUrl());

        // đợi React login xong
        Thread.sleep(3000);

        System.out.println(driver.getCurrentUrl());

        // vào profile
        driver.get("http://localhost:3000/thong-tin-ca-nhan");

        Thread.sleep(2000);

        profilePage.changePassword("123456", "1234567", "1234567");

        assertTrue(profilePage.isChangePasswordSuccess());
    }
}
