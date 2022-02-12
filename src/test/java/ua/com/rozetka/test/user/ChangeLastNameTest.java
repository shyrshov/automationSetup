package ua.com.rozetka.test.user;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.framework.modules.PersonDetailsSection;
import ua.com.rozetka.framework.pages.HomePage;
import ua.com.rozetka.test.BaseTest;

public class ChangeLastNameTest extends BaseTest {

	@Test
		//captcha need to be handled manually, added sleep 10 sec
	void loginAndChangeUserLastName() {
		PersonDetailsSection personDetailsSection = new PersonDetailsSection();
		String userEmail = "headofsfdepartment@gmail.com";
		String userPassword = "Test9237259";
		String newLastName = "Сидоров";

		new HomePage().openLeftMenu()
					  .clickLoginButton()
					  .fillUserCredentialsAndLogin(userEmail, userPassword)
					  .openLeftMenu()
					  .clickUserName()
					  .openPersonDetailsSection()
					  .changeLastName(newLastName);
		Assert.assertEquals(personDetailsSection.getUserLastName(), newLastName);

		//change LastName to previous value
		personDetailsSection.changeLastName("Петров");
	}
}
