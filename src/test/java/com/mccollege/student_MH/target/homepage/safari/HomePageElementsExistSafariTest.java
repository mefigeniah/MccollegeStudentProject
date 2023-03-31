package com.mccollege.student_MH.target.homepage.safari;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mccollege.student_MH.target.Targethelper;
import com.mccollege.student_MH.util.SeleniumTestHelper;

@SpringBootTest
public class HomePageElementsExistSafariTest {
    WebDriver myWebDriver;

    @BeforeEach
    public void setup(){
        // create webdriver
        this.myWebDriver = new SafariDriver();
    }

    @AfterEach
    public void cleanup(){

        // close/quit browser connection
        this.myWebDriver.quit();
    }


    @Test
    public void safari_target_homepage_navbar_exists() throws Exception{


        // build list of element queries
        final List<By> myElementSearchBys = new ArrayList<By>();
        myElementSearchBys.add(By.id("searchMobile"));

        // verify elements exists
        SeleniumTestHelper.webdriver_element_exists(this.myWebDriver, Targethelper.PAGE_URL_HOME, myElementSearchBys);

    }


    @Test
    public void safari_target_homepage_navbar_search_exists() throws Exception{


        // build list of element queries
        final List<By> myElementSearchBys = new ArrayList<By>();
        myElementSearchBys.add(By.id("search"));

        // verify elements exists
        SeleniumTestHelper.webdriver_element_exists(this.myWebDriver, Targethelper.PAGE_URL_HOME, myElementSearchBys);

    }


    @Test
    public void safari_target_homepage_main_navbar_elements_exists() throws Exception{
        Targethelper.target_homepage_main__elements_exists(this.myWebDriver);
    }
}
