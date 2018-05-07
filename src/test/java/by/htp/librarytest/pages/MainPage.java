package by.htp.librarytest.pages;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://library.mycloud.by/dashboard";

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div/ul[2]/li[3]/a")
	private WebElement linkProfileMenu;

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div/ul[2]/li[3]/ul/li[1]/a")
	private WebElement linkProfile;

	@FindBy(xpath = "//*[@id='login']")
	private WebElement inputLoginText;

	@FindBy(xpath = "/html/body/div/div[2]/aside/div/div/ul/li[3]/a")
	private WebElement linkBookMenu;

	@FindBy(xpath = "/html/body/div/div[2]/aside/div/div/ul/li[3]/ul/li[1]/a")
	private WebElement linkBookList;

	@FindAll({ @FindBy(xpath = "//*[@id='datatable']/tbody/tr/td[2]") })
	public List<WebElement> listBookTitles;

	@FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/div/div/div/div[1]/div[2]/div/label/input")
	private WebElement inputSearch;

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Page opened");
	}

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickProfileMenu() {
		linkProfileMenu.click();
	}

	public void clickProfile() {
		linkProfile.click();
	}

	public String getLogin() {
		String loginText = inputLoginText.getAttribute("value");
		logger.info("Login cheched");
		return loginText;
	}

	public void clickBookMenu() {
		linkBookMenu.click();
	}

	public void clickBookList() {
		linkBookList.click();
	}

	public void inputSearchText(String text) {
		inputSearch.sendKeys(text);
	}

	public boolean checkBookList() {
		boolean result = false;
		logger.info("BookList size:" + listBookTitles.size());
		if (listBookTitles.size() > 0) {
			result = true;
		}
		return result;
	}

	public boolean checkBook(String bookTitle) {
		boolean result = false;
		inputSearchText(bookTitle);
		logger.info("BookList size: " + listBookTitles.size() + " BookTitle: " + listBookTitles.get(0).getText());
		if (listBookTitles.size() == 1 && listBookTitles.get(0).getText().equals(bookTitle)) {
			result = true;
		}
		return result;
	}

}