package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait10, wait15;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 10);
        wait15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextIntoElement (WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was input into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Cannot work with element" + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            wait10.until(ExpectedConditions.visibilityOf(element));
//            wait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element was clicked");
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            boolean isDisplayed = webElement.isDisplayed();
            logger.info("Element is displayed ->" + isDisplayed);
            return isDisplayed;
        }catch (Exception e) {
            logger.info("Element is displayed -> error");
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + "was selected in drop down");
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    public void selectValueinDD(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info(value + "was selected in drop down");
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void moveToElements(WebElement webElement) {
        Actions action = new Actions(webDriver);
     action.moveToElement(webElement).build().perform();
    }

    public void clearText() {
        webDriver.findElement(By.xpath(".//*[@id='slider-4998-from']")).sendKeys("\b\b\b\b\b\b");
    }

    public void clearTextTo() {
        webDriver.findElement(By.xpath(".//*[@id='slider-4998-to']")).clear();
        webDriver.findElement(By.xpath(".//*[@id='slider-4998-to']")).sendKeys("\b\b\b\b\b\b");
    }

    public void setStatusToCheckBox (WebElement element, String neededState) {
        if ("check".equals(neededState) || "uncheck".equals(neededState)){
            try {
                if (element.isSelected() && "check".equals(neededState)){
                    logger.info("Already check");
                } else if (!element.isSelected() && "check".equals(neededState)) {
                    element.click();
                    logger.info("checkbox checked");
                } else if (element.isSelected() && "uncheck".equals(neededState)) {
                    element.click();
                    logger.info("check box deselected");
                } else  if (!element.isSelected() && "uncheck".equals(neededState)) {
                    logger.info("checkbox is already unchecked");
                }
            }catch (Exception e) {
                printErrorAndStopTest(e);
            }
        } else {
            logger.error("State should be 'check' or 'uncheck'");
            Assert.fail("State should be 'check' or 'uncheck'");
        }
    }

//    public void comparePrice(Object price) {
//          if ( lowPrice < price < higherPrice )
//              logger.info("Work is done");
//          else Assert.fail("Filtr is not work");
//    }
}
