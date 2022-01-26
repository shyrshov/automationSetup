package ua.com.rozetka.test;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    //я бы переделал на такое, чтобы можно было вызывать любой браузер через Селенид, без использования WebDriverManager
    //и удалил бы WebDriverManager class
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

    @BeforeTest
        public void beforeClassBaseTest() {
//        WebDriverManager driver = new WebDriverManager();
//        driver.setWebDriver("chrome");
    }

    @AfterTest
        public void afterClassBaseClass() {
//            Selenide.closeWebDriver();
    }
}
