package ua.com.rozetka.test;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    static {
        Configuration.browser = Browsers.CHROME;
        Configuration.baseUrl = "https://rozetka.com.ua";
        Configuration.fastSetValue = true;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @BeforeMethod
        public void beforeMethodBaseTest() {
            open("/");
    }

    @AfterTest
        public void afterClassBaseClass() {
    }
}
