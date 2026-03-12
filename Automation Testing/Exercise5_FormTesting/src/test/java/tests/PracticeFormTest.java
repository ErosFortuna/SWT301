package tests;

import org.junit.jupiter.api.*;
import pages.PracticeFormPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PracticeFormTest extends BaseTest {

    static PracticeFormPage formPage;

    @BeforeAll
    static void initPage() {

        formPage = new PracticeFormPage(driver);
    }

    @Test
    @Order(1)
    @DisplayName("Submit form successfully")
    void testSubmitFormSuccess() {

        formPage.openPage();

        formPage.fillForm(
                "John",
                "Doe",
                "john@gmail.com",
                "0912345678",
                "Hanoi Vietnam"
        );

        formPage.submitForm();

        assertTrue(formPage.isSubmitSuccess());
    }

    @Test
    @Order(2)
    @DisplayName("Submit form with empty fields")
    void testSubmitEmptyForm() {

        formPage.openPage();

        formPage.submitForm();

        // Nếu submit fail thì modal sẽ không hiện
        assertTrue(driver.getCurrentUrl().contains("automation-practice-form"));
    }
}
