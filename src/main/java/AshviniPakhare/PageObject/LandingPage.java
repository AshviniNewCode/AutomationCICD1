package AshviniPakhare.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AshviniPakhare.AbstractComponents.AbstractComponents;


public class LandingPage extends AbstractComponents
{
	WebDriver driver;
	
	public  LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//For UserEmailId
    //driver.findElement(By.id("userEmail")).sendKeys("nehakumari1997@gmail.com");
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//For UserPassword
	//driver.findElement(By.id("userPassword")).sendKeys("Aashu@123456");
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	//Clicking on the submitbutton
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement submit;	
	
	//error validation test (Incorect username or password)
	//.ng-tns-c4-3.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;	
	
	public ProductCatalogue loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue =new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage()
	{
		waitWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	

}
