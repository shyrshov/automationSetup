package ua.com.rozetka.framework.modules;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

public abstract class AbstractModule {

	public static final Condition VISIBLE_AND_CLICKABLE = Condition.and("visible and clickable", Condition.visible, Condition.enabled);

	public static final By PAGE_PRE_LOADER = By.cssSelector(".tile-cats");

	public static final By PRE_LOADERS = By.cssSelector("[class*=preloader]");

	public abstract <T extends AbstractModule> T contentLoaded();


}
