package Structural_DesignPatterns_4_DecoratorPattern;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementDecorator implements WebElement {

	private WebElement element;
	private WebDriver driver;
	 private final WebDriverWait wait;


	public ElementDecorator(WebElement element, WebDriver driver) {
		this.element = element;
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	 // Wait + Highlight before any action
    private void highlightElement() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }

    private void takeScreenshot(String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(src.toPath(), new File("./screenshots/" + fileName + ".png").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	@Override
	public void click() {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		    highlightElement();
		System.out.println("[LOG] Clicking element: " + element);
		element.click();
	//	ScreenshotUtil.capture(driver, "click_" + System.currentTimeMillis());
		takeScreenshot("click_" + System.currentTimeMillis());
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		System.out.println("[LOG] Typing: " + String.join("", keysToSend));
		element.sendKeys(keysToSend);
		ScreenshotUtil.capture(driver, "sendKeys_" + System.currentTimeMillis());
	}

	// Other WebElement methods delegate to the real element
	@Override
	public String getText() {
		return element.getText();
	}

	@Override
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	@Override
	public void clear() {
		element.clear();
	}

	@Override
	public String getAttribute(String name) {
		return element.getAttribute(name);
	}

	@Override
	public void submit() {
		element.submit();
	}

	@Override
	public boolean isEnabled() {
		return element.isEnabled();
	}

	@Override
	public boolean isSelected() {
		return element.isSelected();
	}

	
	public void sendKeys(CharSequence keysToSend) {
		element.sendKeys(keysToSend);
	}

	@Override
	public Point getLocation() {
		return element.getLocation();
	}

	@Override
	public Dimension getSize() {
		return element.getSize();
	}

	@Override
	public Rectangle getRect() {
		return element.getRect();
	}

	@Override
	public String getCssValue(String propertyName) {
		return element.getCssValue(propertyName);
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) {
		return element.getScreenshotAs(target);
	}

	 @Override
	    public String getTagName() {
	        return element.getTagName();
	    }

	    @Override
	    public List<WebElement> findElements(By by) {
	        return element.findElements(by);
	    }

	    @Override
	    public WebElement findElement(By by) {
	        return element.findElement(by);
	    }

}
