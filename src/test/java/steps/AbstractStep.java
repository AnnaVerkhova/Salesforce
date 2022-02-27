package steps;

import pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbstractStep {
    WebDriver driver;

    public AbstractStep(WebDriver driver) {
        this.driver = driver;
    }

    protected void validatePageIsLoaded(BasePage page) {
        Assert.assertTrue(page.isPageLoaded(), page.getClass().getSimpleName().concat(" is not opened: "));
    }

}
