package by.htp.librarytest.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://library.mycloud.by/order-add";

	@FindBy(xpath = "//*[@id='select2-selectBook-container']")
	private WebElement selectBook;

	@FindBy(xpath = "//*[@id='select2-selectEmployee-container']")
	private WebElement selectEmployee;

	@FindBy(xpath = "/html/body/span/span/span[1]/input")
	private WebElement inputFormSelect;

	@FindBy(xpath = "//*[@id='days']")
	private WebElement inputFormDays;

	@FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/div/div/div/form/div[5]/button")
	private WebElement submitOrder;

	@FindBy(xpath = "//*[@id='page-right-content']/div[1]/div/div/div/div/div/strong")
	private WebElement textAlert;

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Page opened");
	}

	public OrderAddPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickSelectBook() {
		selectBook.click();
	}

	public void inputEmployeeSurname(String employeeSurname) {
		inputFormSelect.sendKeys(employeeSurname);
		inputFormSelect.sendKeys(Keys.ENTER);
	}

	public void clickSelectEmployee() {
		selectEmployee.click();
	}

	public void inputBookTitle(String bookTitle) {
		inputFormSelect.sendKeys(bookTitle);
		inputFormSelect.sendKeys(Keys.ENTER);
	}

	public void inputDays(int days) {
		inputFormDays.sendKeys(String.valueOf(days));
	}

	public void clickSubmitOrder() {
		submitOrder.click();
		logger.info("Order submited");
	}

	public boolean checkOrder(String checkText) {
		boolean result = false;
		if (textAlert.getText().equals(checkText)) {
			result = true;
			logger.info("Order success message - true");
		}
		return result;
	}

}