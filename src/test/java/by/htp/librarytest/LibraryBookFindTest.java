package by.htp.librarytest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.librarytest.steps.Steps;

public class LibraryBookFindTest {

	private Steps steps;
	private final String LOGIN = "test1";
	private final String PASSWORD = "1234";
	private final String BOOK_TITLE = "BookTest";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Check BookFind")
	public void checkBookList() {
		steps.login(LOGIN, PASSWORD);
		Assert.assertTrue(steps.checkBookFind(BOOK_TITLE));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
