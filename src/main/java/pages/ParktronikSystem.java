package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParktronikSystem extends ParentPage{

    @FindBy (xpath = ".//*[@href='/parktronik-Phantom-BS2515-pod-pokrasku/p6345']")
    private WebElement Phantom_BS2515;

    @FindBy (xpath = ".//*[@class='product__price-container']")
    private WebElement PhantomBS2515;

    @FindBy (id = "slider-4998-from")
    private WebElement from;

    @FindBy (id="slider-4998-to")
    private WebElement to;

    @FindBy (xpath = ".//*[@class='filter__show-diapason btn']")
    private WebElement show;

    @FindBy (xpath = ".//*/a[text()='COBRA']")//.//*[@href='/parktroniki/c15/5000=50026']
    private WebElement cobra;

    @FindBy (xpath = "class='filter__title'")
    private WebElement brend;

    @FindBy (xpath = ".//*[text()=' AudioSourceS ']")
    private WebElement audiosources;

    @FindBy (xpath = ".//*[text()='CYCLON']")
    private WebElement cyclon;

    @FindBy (xpath = "")
    private Object price;


    public ParktronikSystem(WebDriver webDriver) {
        super(webDriver);
    }

    public void findSystem() {
        actionsWithOurElements.moveToElements(PhantomBS2515);
    }

    public void chooseSystem() {
        actionsWithOurElements.clickOnElement(Phantom_BS2515);
    }

    public void enterPrace() throws InterruptedException {

        final String lowPrice = "1000";
        final String higherPrice = "2500";

        actionsWithOurElements.clickOnElement(from);
        actionsWithOurElements.clearText();
        actionsWithOurElements.enterTextIntoElement(from, lowPrice);
        actionsWithOurElements.clickOnElement(to);
        actionsWithOurElements.clearTextTo();
        actionsWithOurElements.enterTextIntoElement(to, higherPrice);
//        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*/a[text()='COBRA']")));
        Thread.sleep(5000);
        actionsWithOurElements.clickOnElement(cobra);
//        actionsWithOurElements.setStatusToCheckBox(audiosources, "check");
        Thread.sleep(5000);
        actionsWithOurElements.clickOnElement(cyclon);
//        Thread.sleep(5000);
//        actionsWithOurElements.comparePrice(price);
    }

//    public void chooseDD() {
////        try {
////            wait(10);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//    }
}
