package AshviniPakhare.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AshviniPakhare.AbstractComponents.AbstractComponents;


public class ProductCatalogue extends AbstractComponents
{
	WebDriver driver;
	
	public  ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products ;
	@FindBy(css=".ng-animating")
	WebElement spinner ;
	
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".w-10");
	By toastMessage=By.cssSelector("#toast-container");
	public List<WebElement> getProductList()
	{
		waitElementToAppear(productsBy);
		return products;
		//Dynamically taking the list of all products
	}
	
	public WebElement getProductByName(String productName) throws InterruptedException
	{
		WebElement prod=products.stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		Thread.sleep(5000);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException 
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		waitElementToAppear(toastMessage);
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		waitElementToDisappear(spinner);
	}

	
	
	
	
	

}
