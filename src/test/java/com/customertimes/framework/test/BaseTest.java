package com.customertimes.framework.test;

import com.codeborne.selenide.Selenide;
import com.customertimes.framework.driver.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
        public void beforeClassBaseTest() {
        WebDriver driver = new WebDriver();
        driver.setWebDriver("chrome");
    }

    @AfterTest
        public void afterClassBaseClass() {
            Selenide.closeWebDriver();
    }
}
