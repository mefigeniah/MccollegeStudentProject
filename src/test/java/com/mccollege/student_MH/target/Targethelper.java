package com.mccollege.student_MH.target;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mccollege.student_MH.util.SeleniumTestHelper;

public class Targethelper {
    public static String PAGE_URL_HOME = "https://www.target.com/";

    public static By getFirstNameSearchBy(){
        return By.id("inf_field_FirstName");
}
public static void target_homepage_main__elements_exists(WebDriver webDriver) throws Exception{

    // build list of element queries
    final List<By> myElementSearchBys = new ArrayList<By>();
    myElementSearchBys.add(By.id("search"));
    myElementSearchBys.add(By.id("searchMobile"));
    myElementSearchBys.add(By.id("zip-code-id-btn"));
    myElementSearchBys.add(By.id("web-store-id-msg-btn"));
    myElementSearchBys.add(By.id("utilityNav-registries"));
    myElementSearchBys.add(By.id("utilityNav-findStores"));

    // verify elements exists
    SeleniumTestHelper.webdriver_element_exists(webDriver, Targethelper.PAGE_URL_HOME, myElementSearchBys);

}

}