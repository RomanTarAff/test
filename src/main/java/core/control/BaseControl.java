package core.control;

import core.selenium.Element;
import core.selenium.wait.DriverWait;
import org.openqa.selenium.By;

public abstract class BaseControl {

    private Element element;

    public BaseControl(Element element){
        this.element = element;
    }

    public BaseControl(By by) {
        element = new Element(by);
    }

    public Element getElement() {
        return element;
    }

    public boolean isDisplayed(){
        return isDisplayed(false);
    }

    public boolean isPresent() {
        return element.isPresent();
    }

    public boolean isEnabled(){
        return element.isEnabled();
    }

    public String getText(){
        return getElement().getText();
    }

    public String getValue(){
        return getElement().getAttribute("value");
    }

    public boolean isDisplayed(boolean withoutWait){
        if(withoutWait) {
            DriverWait.turnOffImplicitWaits();
            try {
                return getElement().isDisplayed(false);
            } finally {
                DriverWait.turnOnImplicitWaits();
            }
        }else
            return getElement().isDisplayed();
    }
}
