package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddToCart {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("admin123@email.com");
		driver.findElement(By.id("Password")).sendKeys("12345678");
		driver.findElement(By.className("login-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='list']//a[contains(text(),'Electronics')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@title,'category Cell phones')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Smartphone']/../..//input[@value='Add to cart']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,-100)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/cart']//span[text()='Shopping cart']")).click();
		boolean res = driver.findElement(By.xpath("//table[@class='cart']/descendant::a[text()='Smartphone']")).isDisplayed();
		System.out.println(res);
		driver.findElement(By.xpath("//a[text()='Smartphone']/../..//input[@type='checkbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("updatecart")).click();
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(2000);
		driver.quit();
	
	
	}

}
