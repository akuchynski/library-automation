package by.htp.librarytest.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderListPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://library.mycloud.by/order-list";

	@FindBy(xpath = "//*[@id='datatable-status-buttons_filter']/label/input")
	private WebElement inputSearch;

	@FindAll({ @FindBy(xpath = "//*[@id='datatable-status-buttons']/tbody/tr/td[2]") })
	public List<WebElement> listBookOrders;

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Page opened");
	}

	public OrderListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void inputSearchText(String text) {
		inputSearch.sendKeys(text);
	}

	public boolean checkOrders(String nameSurname) {
		boolean result = false;
		inputSearchText(nameSurname);
		logger.info("Employee OrderList size: " + listBookOrders.size());
		if (listBookOrders.size() > 0) {
			result = true;
		}
		return result;
	}

}