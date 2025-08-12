package Structural_DesignPatterns_4_DecoratorPattern;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	 public static void capture(WebDriver driver, String fileName) {
		 try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            File dest = new File("screenshots/" + fileName + ".png");
	            dest.getParentFile().mkdirs(); // Create folder if not exists
	            FileUtils.copyFile(src, dest);
	            System.out.println("[LOG] Screenshot saved: " + dest.getAbsolutePath());
	        } catch (IOException e) {
	            System.err.println("[ERROR] Failed to capture screenshot: " + e.getMessage());
	        }
	    }

}
