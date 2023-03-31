package com.mccollege.student_MH.target.homepage.chrome;

import org.junit.jupiter.api.AfterEach;

import java.time.Duration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.boot.test.context.SpringBootTest;

import com.mccollege.student_MH.target.Targethelper;

public class HomePageSearchSubmissionChromeTest {

    WebDriver myWebDriver;


    @BeforeEach
    public void setup(){

        // linking the chrome driver to the driver within this project
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/.drivers/chromedriver");
    
        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");

        // create webdriver
        this.myWebDriver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void cleanup(){

        // close/quit browser connection
        this.myWebDriver.quit();
    }


    @Test
    public void chrome_target_homepage_user_can_perform_basic_search() throws Exception{

        // get page
        this.myWebDriver.get(Targethelper.PAGE_URL_HOME);

        // query object
        By myTextInputSearchBy = By.id("searchMobile");

        // get element
        WebElement myTextInputElement = this.myWebDriver.findElement(myTextInputSearchBy);

        // set value
        myTextInputElement.sendKeys("coffee cups");

        // query object
        By mySearchSubmitButtonBy = By.className("styles__SearchButton-sc-wnzihy-3 kAYQBc");

        // get element
        WebElement mySearchSubmitElement = this.myWebDriver.findElement(mySearchSubmitButtonBy);

        // click button
        mySearchSubmitElement.click();

        // query object
        By mySearchResultWidgetBy = By.className("styles__StyledCol-sc-fw90uk-0 hjiGwz");
       
        // Waiting 30 seconds for an element to be present on the page, checking for its presence once every 5 seconds.
        // https://www.selenium.dev/documentation/webdriver/waits/
        Wait<WebDriver> myWait = new FluentWait<WebDriver>(this.myWebDriver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofSeconds(5))
        .ignoring(NoSuchElementException.class);

        // get object via wait
        WebElement mySearchResultElement = myWait.until(driver -> {
            return driver.findElement(mySearchResultWidgetBy);
        });

        // verify element exists
        Assertions.assertThat(mySearchResultElement).isNotNull();
    }
    
}
