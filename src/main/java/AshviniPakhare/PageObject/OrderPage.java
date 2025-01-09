package AshviniPakhare.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import AshviniPakhare.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents
{
	WebDriver driver;
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productsName;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;

	public OrderPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}
	
//	List<WebElement> cartProducts =driver.findElements(By.cssSelector(".cartSection h3"));
//	Boolean match=cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
//	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	public Boolean verifyOrderDisplay(String productName)
	{
		Boolean match=productsName.stream().anyMatch(productNames -> productNames.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	
}
