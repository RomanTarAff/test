package ui.page;

import org.openqa.selenium.By;
import ui.BasePage;

public class LogoutPage extends BasePage {

    public LogoutPage() {
        super(By.xpath("//h1[@data-auto='logoutMessage']"));
    }
}
