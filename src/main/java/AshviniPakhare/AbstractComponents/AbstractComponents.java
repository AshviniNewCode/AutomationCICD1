package AshviniPakhare.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AshviniPakhare.PageObject.CartPage;
import AshviniPakhare.PageObject.OrderPage;

public class AbstractComponents
{
	WebDriver driver;
 
	public AbstractComponents(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
	@FindBy(css="[routerlink*=cart]")
	WebElement cartHeader;
	//OrderHeader
	@FindBy(css="[routerlink*=myorders]")
	WebElement OrderHeader;
	
	public void waitElementToAppear(By findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitWebElementToAppear(WebElement findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}
	
	public CartPage goToCart()
	{
		cartHeader.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrdersPage()
	{
		OrderHeader.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}
	public void waitElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	
	}
	
	

}
