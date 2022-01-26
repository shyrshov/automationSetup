package ua.com.rozetka.framework.pages;

import static com.codeborne.selenide.Selenide.open;

public class HomePage extends AbstractPage {


	@Override
	public void openPage() {
		open("/");
	}
}
