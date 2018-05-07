package by.htp.librarytest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.librarytest.steps.Steps;

public class LibraryEmployeeOrdersTest {

	private Steps steps;
	private final String LOGIN = "test1";
	private final String PASSWORD = "1234";
	private final String BOOK_TITLE = "BookTest";
	private final String EMPLOYEE_SURNAME = "Surname1";
	private final String EMPLOYEE_NAME_SURNAME = "Name1 Surname1";
	private final int DAYS_TO_RETURN = 30;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Check Employee Orders")
	public void checkBookList() {
		steps.login(LOGIN, PASSWORD);
		steps.addOrder(BOOK_TITLE, EMPLOYEE_SURNAME, DAYS_TO_RETURN);
		Assert.assertTrue(steps.checkEmployeeOrders(EMPLOYEE_NAME_SURNAME));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
