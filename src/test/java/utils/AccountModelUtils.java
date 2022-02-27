package utils;

import model.AccountModel;

public class AccountModelUtils {

    public static AccountModel getDefaultAccountModel() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName("Anna");
        accountModel.setPhone("+375336920790");
        accountModel.setWebsite("teachmeskills.by");
        accountModel.setEmployees(10);
        accountModel.setType("Customer");
        accountModel.setIndustry("Banking");
        return accountModel;

    }
}
