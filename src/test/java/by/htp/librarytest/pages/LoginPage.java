package by.htp.librarytest.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://library.mycloud.by/login";

	@FindBy(xpath = "//*[@id='login']")
	private WebElement inputLogin;

	@FindBy(xpath = "//*[@id='password']")
	private WebElement inputPassword;

	@FindBy(xpath = "/html/body/section/div/div/div/div/div[1]/div[2]/form/div[4]/div/button")
	private WebElement buttonSubmit;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String login, String password) {
		inputLogin.sendKeys(login);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed");
	}

}