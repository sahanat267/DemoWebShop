package generic;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pom.DashBoardPage;
import pom.LoginPage;
import pom.ShoppingCartPage;

public class BaseClass {
	public WebDriver driver;
	public FileLib f = new FileLib();
@BeforeTest	
public void openBrowser() throws IOException {
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--incognito");
	driver = new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String url = f.getPropertyData("url");
	driver.get(url);
	Reporter.log("Open browser",true);
}
@BeforeMethod
public void login() throws IOException {
	DashBoardPage  d = new DashBoardPage(driver);
	d.setLogin();
	
	String un = f.getPropertyData("email");
	String pwd = f.getPropertyData("password");
	
	LoginPage l = new LoginPage(driver);
	l.setLogin(un,pwd);
	
	Reporter.log("login to browser",true);
}
@AfterMethod
public void logout() {
	ShoppingCartPage s = new ShoppingCartPage(driver);
	s.setLogout();
	Reporter.log("logout from browser",true);
}
@AfterTest
public void closeBrowser() {
	driver.quit();
	Reporter.log("close browser",true);
}

}
