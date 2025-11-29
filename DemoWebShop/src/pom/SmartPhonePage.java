package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartPhonePage {
	
	@FindBy(xpath = "//a[text()='Smartphone']/../..//input[@value='Add to cart']")
	private WebElement smartPhoneLink;
	
	@FindBy(xpath = "//a[@href='/cart']//span[text()='Shopping cart']")
	private WebElement shoppingCartLink;
	
	public SmartPhonePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	public void setAddToCart() {
		smartPhoneLink.click();
	}
	public void setShoppingCart() {
		shoppingCartLink.click();
	}

}
