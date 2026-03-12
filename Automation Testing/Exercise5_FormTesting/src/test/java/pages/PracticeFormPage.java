package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By genderMale = By.xpath("//label[text()='Male']");
    private By mobile = By.id("userNumber");

    private By subject = By.id("subjectsInput");

    private By hobbySport = By.xpath("//label[text()='Sports']");

    private By uploadPicture = By.id("uploadPicture");

    private By address = By.id("currentAddress");

    private By submitBtn = By.id("submit");

    private By successModal = By.id("example-modal-sizes-title-lg");

    public void openPage() {
        navigateTo("https://demoqa.com/automation-practice-form");

    }

    public void fillForm(String fName, String lName, String mail, String phone, String addr) {

        type(firstName, fName);
        type(lastName, lName);
        type(email, mail);

        click(genderMale);

        type(mobile, phone);

        driver.findElement(subject).sendKeys("Maths");
        driver.findElement(subject).sendKeys(Keys.ENTER);

        click(hobbySport);

        type(address, addr);
    }

    public void submitForm() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(submitBtn));

        js.executeScript("arguments[0].click();", driver.findElement(submitBtn));
    }

    public boolean isSubmitSuccess() {
        return isElementVisible(successModal);
    }

    private boolean isElementVisible(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
