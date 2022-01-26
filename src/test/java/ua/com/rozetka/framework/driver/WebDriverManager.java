package ua.com.rozetka.framework.driver;

public class WebDriverManager {
    public void setWebDriver (String browserName){
        switch (browserName){
            case "chrome":
                System.setProperty("selenide.browser", "chrome");
               break;
            case "firefox":
                System.setProperty("selenide.browser", "firefox");
                break;
            case "opera":
                System.setProperty("selenide.browser", "opera");
                break;
            case "ie":
                System.setProperty("selenide.browser", "ie");
                break;
            default:
                System.setProperty("selenide.browser", "chrome");
        }
    }
}
