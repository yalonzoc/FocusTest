package com.Focus.DemoAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tools {

public Tools() {
// TODO Auto-generated constructor stub
}

public static WebElement findElementByXpath(String xpath, WebDriver driver) throws NoSuchElementException{
return driver.findElement(By.xpath(xpath));
}

public static WebElement findElementById(String id, WebDriver driver) throws NoSuchElementException{
return driver.findElement(By.id(id));
}

public static void implicitlyWait(long time, TimeUnit timeUnit, WebDriver driver){
driver.manage().timeouts().implicitlyWait(time,timeUnit);
}

public static void get(String url, WebDriver driver){
driver.get(url);
}

}
