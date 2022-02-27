package steps;

import components.buttons.menu.ContactButton;
import io.qameta.allure.Step;
import pages.AccountPage;
import pages.ContactPage;
import pages.HomePage;
import components.buttons.menu.AccountsButton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.SalesforceLoginPage;

public class MainSteps extends AbstractStep{

    private SalesforceLoginPage loginPage;
    private HomePage homePage;

    private AccountsButton accountsButton;
    private ContactButton contactButton;

    private static final String VALID_LOGIN = System.getProperty("login");
    private static final String VALID_PASSWORD = System.getProperty("password");


    public MainSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Открывается страница логина")
    public MainSteps openSalesforceLoginPage() {
        loginPage = new SalesforceLoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Ввод логина и пароля")
    public MainSteps loginWithValidCreds() {
        loginPage.authentication(VALID_LOGIN, VALID_PASSWORD);
        homePage = new HomePage(driver);
        validatePageIsLoaded(homePage);
        return this;
    }

    @Step("Открывается страница аккаунта")
    public AccountsSteps openAccountPage() {
        accountsButton = new AccountsButton(driver);
        Assert.assertTrue(
                accountsButton.isComponentDisplayed(),
                accountsButton.getClass().getSimpleName().concat(" not displayed")
        );
        accountsButton.click();
        validatePageIsLoaded(new AccountPage(driver));
        return new AccountsSteps(driver);
    }

    @Step("Открывается страница контакта")
    public ContactStep openContactPage(){
        contactButton=new ContactButton(driver);
        Assert.assertTrue(
                contactButton.isComponentDisplayed(),
                contactButton.getClass().getSimpleName().concat(" not displayed")
        );
        contactButton.click();
        validatePageIsLoaded(new ContactPage(driver));
        return new ContactStep(driver);

    }
}


