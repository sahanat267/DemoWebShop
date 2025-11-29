package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseClass;
import pom.ElectronicsPage;
import pom.HomePage;
import pom.ShoppingCartPage;
import pom.SmartPhonePage;
@Listeners(generic.ListenerImplementation.class)
public class CartModule extends BaseClass {
	@Test
	public void addToCart() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.setElectronics();
		Thread.sleep(2000);
		ElectronicsPage e = new ElectronicsPage(driver);
		e.setSmartPhone();
		Thread.sleep(2000);
		SmartPhonePage sp = new SmartPhonePage(driver);
		sp.setAddToCart();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,-100)");
		Thread.sleep(2000);
		sp.setShoppingCart();
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		boolean res = sc.getSmartPhoneIsDisplayed();
		Assert.assertTrue(res);
		sc.removeItem();
		Thread.sleep(2000);
		sc.setUpadatedCartList();
	}
}
