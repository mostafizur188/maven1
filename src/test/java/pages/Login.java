package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import helper.Utility;
public class Login {
WebDriver driver;
public Login(WebDriver Idriver)
{
this.driver=Idriver;
}
/*
@FindBy(xpath="//a[@class='login']")
WebElement SignIn;
@FindBy(xpath="//input[@id='email']")
WebElement username;
@FindBy(xpath="//input[@id='passwd']")
WebElement Password;
@FindBy(xpath="//button[@id='SubmitLogin']")
WebElement SignInButton; this is for automation practice
*/
@FindBy(xpath="//input[@id='email']") WebElement username;
@FindBy(xpath="//input[@id='passwd']") WebElement Password;

@FindBy(xpath="//button[@id='SubmitLogin']") WebElement SignInButton;
/*public void signIn()
{
Utility.waitForWebElement(driver, SignIn).click();
System.out.println("Log:info sign in");
}*/
public void validateHomePage()
{
Utility.validateContainsTitle(driver, "Login - My Store");
}
public void enterUserName(String uname)
{
System.out.println("Log: info username entered");
Utility.waitForWebElement(driver, username).sendKeys(uname);
}
public void enterPassWord(String ipassword)
{
System.out.println("Log:info password entered");
Utility.waitForWebElement(driver, Password).sendKeys(ipassword);
}
public void clickButton()
{
	Utility.waitForWebElement(driver, SignInButton).click();
	System.out.println("Log:info clicked");
	}
	}