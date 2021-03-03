package JD_OrangeHRA_Maven.JD_OrangeHRA_Maven;

import org.testng.annotations.DataProvider;

public class OrangeHraTestData {
	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Admin", "admin123" },
				{"Aparna", "admin123" },
				{"Aparna1", "admin123" }
				};

	}
	@DataProvider(name = "LoginScenario")
	public Object[][] getDataforLogin2() {
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Admin", "admin123" },
				{"Aparna", "admin123" },
				{"Aparna1", "admin123" }
				};

	}
	//-------------------------------------------- This is to read Excel Data------------

		@DataProvider(name = "LoginExcelData")
		public Object[][] Authentication() throws Exception{
			ReadExcel excel = new ReadExcel();
			String RelativePath = System.getProperty("user.dir");
			//Object[][] testObjArray = excel.getExcelData("C:\\Users\\adixit\\git\\abhikdixit-Maven_Selenium_WebDriver_4\\Maven_Selenium_WebDriver_4\\OrangeHRM_TestData.xlsx","SignIn");
			Object[][] testObjArray = excel.getExcelData(RelativePath+"\\OrangeHRM_TestData.xlsx","SignIn");
			System.out.println(testObjArray);
			return testObjArray;

		}

}
