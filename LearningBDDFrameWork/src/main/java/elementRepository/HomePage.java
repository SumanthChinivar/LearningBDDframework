package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement backupAddToCartButton;

	public WebElement getBackupAddToCartButton() {
		return backupAddToCartButton;
	}

	@FindBy(xpath = "//a[@data-test='shopping-cart-link']")
	private WebElement cartIcon;

	public WebElement getCartIcon() {
		return cartIcon;
	}
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuButton;

	public WebElement getMenuButton() {
		return menuButton;
	}
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public void logout() {
		getMenuButton().click();
		getLogoutLink().click();
	}
}
