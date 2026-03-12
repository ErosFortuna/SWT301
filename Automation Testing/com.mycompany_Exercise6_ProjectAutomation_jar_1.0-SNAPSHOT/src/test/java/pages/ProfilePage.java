package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private By currentPassword = By.name("currentPassword");
    private By newPassword = By.name("newPassword");
    private By confirmPassword = By.name("confirmPassword");

    private By changePasswordBtn
            = By.xpath("//button[contains(text(),'Đổi mật khẩu')]");

    private By successMessage = By.xpath("//*[contains(text(),'Đổi mật khẩu thành công')]");

    public void openProfile() {
        navigateTo("http://localhost:3000/thong-tin-ca-nhan");
    }

    public void changePassword(String currentPass, String newPass, String confirmPass) {

        type(currentPassword, currentPass);

        scrollToElement(newPassword);
        type(newPassword, newPass);

        scrollToElement(confirmPassword);
        type(confirmPassword, confirmPass);

        scrollToElement(changePasswordBtn);
        click(changePasswordBtn);
    }

    public boolean isChangePasswordSuccess() {
        return waitForVisibility(successMessage).isDisplayed();
    }
}
