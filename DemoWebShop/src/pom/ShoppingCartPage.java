package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	@FindBy(xpath = "//table[@class='cart']/descendant::a[text()='Smartphone']")
	private WebElement smartPhoneInCart;
	
	@FindBy(xpath = "//a[text()='Smartphone']/../..//input[@type='checkbox']")
	private WebElement removeFromCart;
	
	@FindBy(name = "updatecart")
	private WebElement updateCartButtoon;
	
	@FindBy(linkText = "Log out")
	private WebElement logOutLink;
	
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean getSmartPhoneIsDisplayed() {
		return this.smartPhoneInCart.isDisplayed();
	}
	public void removeItem() {
		removeFromCart.click();
	}
	public void setUpadatedCartList() {
		updateCartButtoon.click();
	}
	public void setLogout() {
		logOutLink.click();
	}
}
