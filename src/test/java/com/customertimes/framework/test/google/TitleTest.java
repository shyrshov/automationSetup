package com.customertimes.framework.test.google;
import com.customertimes.framework.test.BaseTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class TitleTest extends BaseTest {

    @Test
    public void checkSiteTitle() {
        open("https://google.com");
        assertThat($("title").getOwnText()).isEqualTo("Google");
    }
}
