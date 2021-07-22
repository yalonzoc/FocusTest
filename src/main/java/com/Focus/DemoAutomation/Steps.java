package com.Focus.DemoAutomation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.Focus.DemoAutomation.Tools;

public class Steps {

	public Steps() {
// TODO Auto-generated constructor stub
	}

	public static void login(WebDriver driver, String mail, String password) throws NoSuchElementException {
		Tools.findElementByXpath("//*[@id='body']/app-root/app-login/div/div/div[2]/div/div[1]/input", driver)
				.sendKeys(mail);
		;
		Tools.findElementByXpath("//*[@id='body']/app-root/app-login/div/div/div[2]/div/div[2]/input", driver)
				.sendKeys(password);
		Tools.findElementByXpath("//*[@id='body']/app-root/app-login/div/div/div[2]/div/div[3]/button", driver)
				.click();
	}

	public static void selectFirstOrganization(WebDriver driver) throws NoSuchElementException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Tools.findElementByXpath(
				"//*[@id='body']/ngb-modal-window/div/div/div[2]/div/div[2]/div[1]/div/div/button", driver).click();
	}

	public static String getUrlNovedades(WebDriver driver, String urlPath) throws NoSuchElementException {
		Tools.findElementByXpath(urlPath, driver).click();
		Set<String> handlesSet = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(handlesSet);
		driver.switchTo().window(handlesList.get(1));
		String urlNovedades = driver.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.close();
		driver.switchTo().window(handlesList.get(0));
		;
		return urlNovedades;
	}
}
