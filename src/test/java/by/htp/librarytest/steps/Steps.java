package by.htp.librarytest.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.librarytest.driver.DriverSingleton;
import by.htp.librarytest.pages.LoginPage;
import by.htp.librarytest.pages.MainPage;
import by.htp.librarytest.pages.OrderAddPage;
import by.htp.librarytest.pages.OrderListPage;

public class Steps {

	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void login(String login, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(login, password);
	}

	public boolean checkLogin(String login) {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickProfileMenu();
		mainPage.clickProfile();
		String actualLogin = mainPage.getLogin().trim().toLowerCase();
		logger.info("Actual login: " + actualLogin);
		return actualLogin.equals(login);
	}

	public boolean checkBookCatalog() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickBookMenu();
		mainPage.clickBookList();
		return mainPage.checkBookList();
	}

	public boolean checkBookFind(String bookTitle) {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickBookMenu();
		mainPage.clickBookList();
		return mainPage.checkBook(bookTitle);
	}

	public void addOrder(String bookTitle, String employeeSurname, int days) {
		OrderAddPage orderPage = new OrderAddPage(driver);
		orderPage.openPage();
		orderPage.clickSelectBook();
		orderPage.inputBookTitle(bookTitle);

		orderPage.clickSelectEmployee();
		orderPage.inputEmployeeSurname(employeeSurname);

		orderPage.inputDays(days);
		orderPage.clickSubmitOrder();
	}

	public boolean checkAddOrder(String checkText) {
		OrderAddPage orderPage = new OrderAddPage(driver);
		return orderPage.checkOrder(checkText);
	}

	public boolean checkEmployeeOrders(String nameSurname) {
		OrderListPage orderLstPage = new OrderListPage(driver);
		orderLstPage.openPage();
		return orderLstPage.checkOrders(nameSurname);
	}

}