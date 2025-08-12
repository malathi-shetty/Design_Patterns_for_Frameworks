package Structural_DesignPatterns_3_DataDrivenFramework;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	
	String filePath = System.getProperty("user.dir") + "/src/main/java/Structural_DesignPatterns_3_DataDrivenFramework/LoginData.xlsx";

	@DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
      //  return ExcelDataProvider.readExcelData("./testdata/LoginData.xlsx", "Sheet1");
		  return ExcelDataProvider.readExcelData(filePath, "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.out.println("Username: " + username + " | Password: " + password);
        // Here you can call your login page methods
    }
}
