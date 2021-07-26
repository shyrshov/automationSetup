package com.customertimes.framework.test.google;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        open("https://google.com");
        assertThat($(By.cssSelector("link+title")).getOwnText()).isEqualTo("Google");
        System.out.println("Hello");
    }
}
