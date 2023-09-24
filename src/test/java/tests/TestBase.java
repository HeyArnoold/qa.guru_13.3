package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PracticeForm;

public class TestBase {
    protected PracticeForm practiceForm = new PracticeForm();

    @BeforeAll
    static void beforeAll() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.pageLoadTimeout = 60000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "2560x1440";

    }
}
