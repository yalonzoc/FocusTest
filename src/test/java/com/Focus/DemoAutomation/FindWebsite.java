package com.Focus.DemoAutomation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		   //open and seaching web page
		   driver.get("https://www.google.com/");
		   driver.manage().window().maximize();
		   Tools.findElementByXpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input",driver).sendKeys("Focus Services");
		   Tools.findElementByXpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input",driver).sendKeys(Keys.ENTER);
	       driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]")).click();   
	       
	       //Scroll down to bottom page
	       Robot robot = new Robot();
	       robot.keyPress(KeyEvent.VK_CONTROL);
	       robot.keyPress(KeyEvent.VK_END);
	       robot.keyRelease(KeyEvent.VK_END);
	       robot.keyRelease(KeyEvent.VK_CONTROL);
	       
	       //Click button Now Hiring
	       driver.findElement(By.xpath("//*[@id=\"menu-item-4726\"]/a/span[2]")).click();
	       
	       //Validating North America Link 
	       if(Tools.findElementByXpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[1]/span[1]", driver).isDisplayed()) {	
				System.out.println("North America link exist");
			}else {
				System.out.println("Error, North America not exist");
			}
	       
	       //Validating Central America and El Salvador & Nicaragua exist       
	       if(Tools.findElementByXpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[2]/span[1]", driver).isDisplayed()) {
	    	   
	    	    driver.findElement(By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[2]/span[1]")).click(); 
				String label = Tools.findElementByXpath("//*[@id=\"av-tab-section-1\"]/div/div[2]/div[2]/div/div/section/div/h2", driver).getText();	
				assertEquals("El Salvador & Nicaragua", label);
				System.out.println("El Salvador & Nicaragua exist");
			}else {
				System.out.println("El Salvador & Nicaragua not exist");
			}
	       
	       //Validating Asia and Bacolod City, Philippines exist
	       if(Tools.findElementByXpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[3]/span[1]", driver).isDisplayed()) {
	    	   driver.findElement(By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[3]/span[1]")).click(); 
				String label = Tools.findElementByXpath("//*[@id=\"av-tab-section-1\"]/div/div[2]/div[3]/div/div/div[2]/section/div/h3/b", driver).getText();	
				assertEquals("Bacolod City, Philippines", label);
				System.out.println("Bacolod City, Philippines exist");
			}else {
				System.out.println("Bacolod City, Philippines exist");
			}
	      
		  }


	  @Test
	  public void fillCarrersForm() throws Exception {
		   //open and seaching web page
		   driver.get("https://www.focusservices.com/");
		   driver.manage().window().maximize();
	       driver.findElement(By.xpath("//*[@id=\"menu-item-6497\"]/a/span[2]")).click();
	       driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	       driver.findElement(By.xpath("//*[@id=\"agentListings\"]/li[1]")).click();  
	       driver.findElement(By.xpath("//*[@id=\"jobsSidebar\"]/a/input")).click();
	       
	       
	       //Filling job Position form
	       //Filling name field
	       Tools.findElementByXpath("//*[@id=\"first_name\"]",driver).clear();
	       Tools.findElementByXpath("//*[@id=\"first_name\"]",driver).sendKeys("Yuri");
	       //Filling lastname field
	       Tools.findElementByXpath("//*[@id=\"last_name\"]",driver).clear();
	       Tools.findElementByXpath("//*[@id=\"last_name\"]",driver).sendKeys("Alonzo");
	       //Filling email field
	       Tools.findElementByXpath("//*[@id=\"email\"]",driver).clear();
	       Tools.findElementByXpath("//*[@id=\"email\"]",driver).sendKeys("yalonzo@prueba.com");
	       //Filling confirm email field
	       Tools.findElementByXpath("//*[@id=\"email_confirm\"]",driver).clear();
	       Tools.findElementByXpath("//*[@id=\"email_confirm\"]",driver).sendKeys("yalonzo@prueba.com");
	       //Filling phone field
	       Tools.findElementByXpath("//*[@id=\"contact_number\"]",driver).clear();
	       Tools.findElementByXpath("//*[@id=\"contact_number\"]",driver).sendKeys("2222-2222");
	       //Selecting number type
	       Tools.findElementByXpath("//*[@id=\"contact_number_type\"]/option[2]",driver).click();     
	       //Filling address 1
	       Tools.findElementByXpath("//*[@id=\"street1\"]",driver).clear();
	       Tools.findElementByXpath("//*[@id=\"street1\"]",driver).sendKeys("Direccion prueba 2");
	       //Filling address 2
	       Tools.findElementByXpath("//*[@id=\"street2\"]",driver).clear();
	       Tools.findElementByXpath("//*[@id=\"street2\"]",driver).sendKeys("Direccion de prueba 1");
	       //Selecting country
	       Tools.findElementByXpath("//*[@id=\"country_id\"]/option[71]",driver).click();
	       //Selecting city
	       Tools.findElementByXpath("//*[@id=\"state_id\"]/option[11]",driver).click();
	       //filling city field     	       
	       Tools.findElementByXpath("//*[@id=\"city\"]",driver).clear();
	       Tools.findElementByXpath("//*[@id=\"city\"]",driver).sendKeys("San Salvador");
	       //Filling zip code
	       Tools.findElementByXpath("//*[@id=\"zip_code\"]",driver).sendKeys("1101");
	       //Filling password field
	       Tools.findElementByXpath("//*[@id=\"password\"]",driver).clear();
	       Tools.findElementByXpath("//*[@id=\"password\"]",driver).sendKeys("Password1");
	       //Filling confirm password field
	       Tools.findElementByXpath("//*[@id=\"password_confirm\"]",driver).clear();
	       Tools.findElementByXpath("//*[@id=\"password_confirm\"]",driver).sendKeys("Password1");
	       
	       //Save and Proceed to next step not included
	       
	   	  
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


