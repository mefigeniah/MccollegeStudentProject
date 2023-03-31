package com.mccollege.student_MH.target.homepage.chrome;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mccollege.student_MH.target.Targethelper;
import com.mccollege.student_MH.util.SeleniumTestHelper;

@SpringBootTest
public class HomePageElementsExistChromeTest {

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
    public void chrome_amazon_homepage_main_navbar_elements_exists() throws Exception{
        Targethelper.target_homepage_main__elements_exists(this.myWebDriver);
    }
}
