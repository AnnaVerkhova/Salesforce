package salesforce;

import builders.AccountBuilder;
import model.AccountModel;
import org.testng.annotations.Test;
import utils.AccountModelUtils;

public class AddAccountTest extends BaseTest {

    AccountModel testAccount = AccountModelUtils.getDefaultAccountModel();
    AccountModel testAccount2 = AccountBuilder
            .defaultAccount()
            .setPhone("232")
            .build();

    @Test(description ="Тестирование нового аккаунта")
            public void addNewAccountTest() {
        mainSteps
                .openSalesforceLoginPage()
                .loginWithValidCreds()
                .openAccountPage()
                .createNewAccount(testAccount)
                .validateAccountCreated(testAccount);
    }

    private AccountModel getTestAccount() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("Anna");
        accountModel.setPhone("++375336920790");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setEmployees(10);
        accountModel.setType("Customer");
        accountModel.setIndustry("Banking");
        return accountModel;
    }
}

