package com.mccollege.student_MH.util;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumTestHelper {

    /**
     * Takes in a webdriver, goes to a url, verifies the elements exist.
     * @param webDriver 
     * @param url
     * @param myElementSearchBys
     */
    public static void webdriver_element_exists(WebDriver webDriver, String url, List<By> myElementSearchBys) throws Exception{

        // get page
        webDriver.get(url);

        // loop through element search bys
        for(By myElementSearchBy : myElementSearchBys){

            // get element
            WebElement myWebElement = webDriver.findElement(myElementSearchBy);

            // verify element exists
            Assertions.assertThat(myWebElement).isNotNull();

        }

    }


    /**
     * 
     * @param url
     * @param elementId
     * @throws Exception
     */
    public static void element_with_id_exists_on_safari_page(String url, String elementId) throws Exception{

        // build webdriver
        WebDriver myWebDriver =  new SafariDriver();
        
        // get page
        myWebDriver.get(url);

        // build element search by
        By myElementSearchBy = By.id(elementId);

        // get element
        WebElement myWebElement = myWebDriver.findElement(myElementSearchBy);

        // verify element exists
        Assertions.assertThat(myWebElement).isNotNull();


        // close/quit browser connection
        myWebDriver.quit();
    }
    
}
