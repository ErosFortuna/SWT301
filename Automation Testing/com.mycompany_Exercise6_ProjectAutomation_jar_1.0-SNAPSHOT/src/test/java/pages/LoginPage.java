package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailInput = By.cssSelector("input[type='email']");
    private By passwordInput = By.cssSelector("input[type='password']");
    private By loginButton = By.cssSelector("form button[type='submit']");

    public void openLoginPage() {
        navigateTo("http://localhost:3000/dang-nhap");
    }

    public void login(String email, String password) {

        type(emailInput, email);
        type(passwordInput, password);

        click(loginButton);
    }
}
