package dataProviderFactory;

public class DataProviderFactory {
	
	//configdataprovider is nothing
	
	public static  CongfigDataProvider getConfig()
	{
		CongfigDataProvider config = new CongfigDataProvider();
		return config;
	}
	
	public static ExcellDataProvider getExcel()
	{
		ExcellDataProvider excel = new ExcellDataProvider();
		return excel;
	}
}