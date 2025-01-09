package SeleniumTestNGFrameWork.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import AshviniPakhare.PageObject.CartPage;
import AshviniPakhare.PageObject.ProductCatalogue;
import SeleniumTestNG.TestComponents.BaseTest;
import SeleniumTestNG.TestComponents.Retry;


public class ErrorValidationTest extends BaseTest

{
	
	@Test(groups= {"ErrorHanding"},retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException
	{
		String productName = "ADIDAS ORIGINAL";
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		landingPage.loginApplication("nehakumari19977@gmail.com", "AAashu@123456");	
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	}
	@Test
	public void productErrorValidation() throws IOException, InterruptedException
	{
		String productName = "ADIDAS ORIGINAL";
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		ProductCatalogue productCatalogue=landingPage.loginApplication("jagruti@gmail.com", "Jagruti@123");		
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage=productCatalogue.goToCart();		
		Boolean match=cartPage.verifyProductDisplay("ADIDAS ORIGINAL 123");
		Assert.assertFalse(match);
		
	}

	

}
