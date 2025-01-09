package SeleniumTestNGFrameWork.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AshviniPakhare.PageObject.CartPage;
import AshviniPakhare.PageObject.CheckoutPage;
import AshviniPakhare.PageObject.ConfirmationPage;
import AshviniPakhare.PageObject.LandingPage;
import AshviniPakhare.PageObject.OrderPage;
import AshviniPakhare.PageObject.ProductCatalogue;
import SeleniumTestNG.TestComponents.BaseTest;


public class SubmitOrderTest extends BaseTest

{
	String productName = "ADIDAS ORIGINAL";
	
	@Test(dataProvider="getData", groups="Purchase")
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password") );		
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage=productCatalogue.goToCart();		
		Boolean match=cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.seletCountry("india");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();	
		String confrimationMessage=confirmationPage.getConfimationMessage();
		Assert.assertTrue(confrimationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryPage()
	{
		ProductCatalogue productCatalogue=landingPage.loginApplication("nehakumari1997@gmail.com", "Aashu@123456");	
		OrderPage orderPage=productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{

		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir") +"\\src\\test\\java\\SeleniumTestNG\\data\\PurchaseOrder.json");
		
		return new Object[][] { {data.get(0)},{data.get(1)} };
	}


	

}

//HashMap<String ,String> map=new HashMap<String ,String> ();
//map.put("email","nehakumari1997@gmail.com" );
//map.put("password","Aashu@123456" );
//map.put("product","ADIDAS ORIGINAL" );
//
//HashMap<String ,String> map1=new HashMap<String ,String> ();
//map1.put("email","jagruti@gmail.com");
//map1.put("password", "Jagruti@123" );
//map1.put("product","IPHONE 13 PRO" );
