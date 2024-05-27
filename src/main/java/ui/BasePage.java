package ui;

import core.selenium.wait.DriverWait;
import org.openqa.selenium.By;

public abstract class BasePage {

    protected BasePage(By by){
        DriverWait.waitForPageLoaded();
        DriverWait.waitElementPresent(by);
    }

}
