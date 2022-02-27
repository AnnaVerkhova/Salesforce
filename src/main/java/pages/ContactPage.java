package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {

    private static final String BASE_URN = "https://teachmeskills.lightning.force.com/lightning/o/Contact/list?filterName=Recent";
    private static final By HEADER_CONTACT = By.xpath("//h1[contains(.,'Contact')]");
    private static final By NEW_BUTTON = By.cssSelector("[title='New']");

    private static final By DETAILS_BUTTON = By.xpath("//a[@data-label='Details']");
    private static final By DETAILS_TAB_PANEL = By.xpath("//div[@class='slds-tabs_default']");


    public ContactPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void waitPageLoaded()  {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_CONTACT));

    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URN);
        return this;
    }

    public void openNewContactForm() {
        driver.findElement(NEW_BUTTON).click();
    }

    public void openDetails() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_BUTTON));
        By by = DETAILS_BUTTON;
        driver.findElement(by).click();
        explicitlyWait.until(ExpectedConditions.attributeContains(DETAILS_BUTTON, "aria-selected", "true"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_TAB_PANEL));
    }




}
