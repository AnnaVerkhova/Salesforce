package steps;

import io.qameta.allure.Step;
import pages.AccountPage;
import components.account.AccountDetailsComponent;
import components.forms.CreateAccountFormComponent;
import components.forms.Dropdown;
import components.forms.Input;
import model.AccountModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountsSteps extends AbstractStep {

    private AccountPage accountPage;

    public AccountsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Создание нового аккаунта")
    public AccountsSteps createNewAccount(AccountModel accountModel) {
        accountPage = new AccountPage(driver);
        accountPage.openNewAccountForm();
        CreateAccountFormComponent form = new CreateAccountFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        fillAccountForm(accountModel);
        form.save();
        validatePageIsLoaded(accountPage);
        return this;
    }

    @Step("Заполнение данными созданного аккаунта")
    private void fillAccountForm(AccountModel accountModel) {
        Input accountNameInput = new Input(driver, "Account Name");
        accountNameInput.insert(accountModel.getAccountName());
        Input phoneInput = new Input(driver, "Phone");
        phoneInput.insert(accountModel.getPhone());
        new Input(driver, "Website").insert(accountModel.getWebsite());
        new Input(driver, "Employees").insert(String.valueOf(accountModel.getEmployees()));
        new Dropdown(driver, "Type").selectOption(accountModel.getType());
        new Dropdown(driver, "Industry").selectOption(accountModel.getIndustry());
    }

    @Step("Проверка созданного аккаунта")
    public void validateAccountCreated(AccountModel expectedModel) {
        accountPage.openDetails();
        AccountModel actualModel = getActualAccount();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Account is not valid: %s", actualModel)
        );
    }


    private AccountModel getActualAccount( ) {
        AccountModel actualModel = new AccountModel();
        actualModel.setAccountName(new AccountDetailsComponent(driver, "Account Name").getValue());
        actualModel.setPhone(new AccountDetailsComponent(driver, "Phone").getValue());
        actualModel.setWebsite(new AccountDetailsComponent(driver, "Website").getValue());
        actualModel.setEmployees(Integer.parseInt(new AccountDetailsComponent(driver, "Employees").getValue()));
        actualModel.setType(new AccountDetailsComponent(driver, "Type").getValue());
        actualModel.setIndustry(new AccountDetailsComponent(driver, "Industry").getValue());
        return actualModel;
    }
}
