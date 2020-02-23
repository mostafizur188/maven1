package testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import dataProviderFactory.DataProviderFactory;
import helper.BaseClass;
import pages.Login;
public class LoginTestWithDataProvider extends BaseClass{
Login login;
// this is example if we need just create the class for log out
@Test(dataProvider= "LoginData")
public void loginToAP(String uname, String ipassword)
{
login = PageFactory.initElements(driver, Login.class);
logger = report.createTest("Login Test for AP");
login.validateHomePage();
logger.pass("Home page Validated");
login.enterUserName(uname);
logger.info("username entered");
login.enterPassWord(ipassword);
logger.info("Password entered");
login.clickButton();
logger.info("clicked on login button");

}
@DataProvider(name="LoginData")
public Object[][]getDataFromSoureces()
{
System.out.println("LOG INFO: Running Data Provider First to generate the data");

int rows = DataProviderFactory.getExcel().getRows("Sheet1");// this is going to be sheet name

System.out.println("Total rows in Excel "+ rows);
Object[][]arr=new Object[rows-1][2]; //-1 means starts with 0

for(int i =0; i<rows-1; i++)
{
arr[i][0]=DataProviderFactory.getExcel().getCellData("Sheet1", i+1, 0); //log in is the class name extended

arr[i][1]=DataProviderFactory.getExcel().getCellData("Sheet1", i+1, 1);
}
System.out.println("LOG: INFO- Data provider is ready for usage");
return arr;
}

}