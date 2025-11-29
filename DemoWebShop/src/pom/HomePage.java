package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//ul[@class='list']//a[contains(text(),'Electronics')]")
	private WebElement ElectronicsLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setElectronics() {
		ElectronicsLink.click();
	}
}
