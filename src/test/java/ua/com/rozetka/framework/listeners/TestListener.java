package ua.com.rozetka.framework.listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestResult;

public class TestListener extends AllureTestNg {

	@Override
	public void onTestFailure(final ITestResult result) {
		final File screenshot = Screenshots.takeScreenShotAsFile();
		try {
			Allure.addAttachment(screenshot.getName(), new FileInputStream(screenshot) {
			});
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
		super.onTestFailure(result);
	}
}
