package com.Focus.DemoAutomation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Focus.DemoAutomation.Tools;

import junit.framework.Assert;

public class FindWebsite {
	  private WebDriver driver = null;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	   
		  //System.setProperty("webdriver.chrome.driver","C:\\Users\\yalonzo\\Desktop\\eclipse\\chromedriver.exe");
		  System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
		  driver = new ChromeDriver();

	  }

	  @Test
	  public void openWebsiteForLocations() throws Exception {
		   driver.get("https://www.focusservices.com/");
	       driver.findElement(By.xpath("//*[@id=\"text-4\"]/div/p/a/span")).click();
	       driver.findElement(By.xpath("//*[@id=\"menu-item-4726\"]/a/span[2]")).click();
	       
	       
	       if(Tools.findElementByXpath("//*[@id=\\\"av-tab-section-1\\\"]/div/div[1]/a[2]/span[1]", driver).isDisplayed()) {
				String label = Tools.findElementByXpath("//*[@id=\"text-4\"]/div/p/a/span", driver).getText();
				
				assertEquals("El Salvador & Nicaragua", label);
			}else {
				Assert.fail("Error, In the error label ");
			}
	       
	       
	       if(Tools.findElementByXpath("//*[@id=\"av-tab-section-1\"]/div/div[2]/div[2]/div/div/section/div/h2", driver).isDisplayed()) {
				String label = Tools.findElementByXpath("//*[@id=\"av-tab-section-1\"]/div/div[2]/div[2]/div/div/section/div/h2", driver).getText();
				assertEquals("El Salvador & Nicaragua", label);
			}else {
				Assert.fail("Error, In the error label ");
			}

	  
		  }

	  @After
	  public void tearDown() throws Exception {
	    //driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}


