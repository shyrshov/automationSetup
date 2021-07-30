package com.customertimes.framework.test;

import com.codeborne.selenide.Selenide;
import com.customertimes.framework.driver.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
        public void beforeClassBaseTest() {
        WebDriverManager driver = new WebDriverManager();
        driver.setWebDriver("chrome");
    }

    @AfterTest
        public void afterClassBaseClass() {
            Selenide.closeWebDriver();
    }
}
