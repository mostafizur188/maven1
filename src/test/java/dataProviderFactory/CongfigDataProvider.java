package dataProviderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CongfigDataProvider {
	
	Properties pro; 
		public CongfigDataProvider(){
	try{
		pro=new Properties();
		pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/ConfigurationFile/config.properties")));
	}catch(IOException e){
		System.out.println("unable to load file:"+e.getMessage());
	}
}
 public String getBrowser()
{
	
	return pro.getProperty("browser");
}
 public String getStagingURL()
 {
	 
	 return pro.getProperty("stagingURL");
 }
 public String getValueFromproperties(String key)
 {
	 return pro.getProperty(key);
 }
 
}