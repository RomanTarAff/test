package core.control;

import core.selenium.Element;
import org.openqa.selenium.By;

public class Button extends BaseControl {

    public Button(String buttonText){
        super(By.xpath(String.format("//button[text()='%s']", buttonText)));
    }

    public Button(By by) {
        super(by);
    }

    public Button(Element element) {
        super(element);
    }

    public void press(){
        getElement().click();
    }
}
