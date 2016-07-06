package cn.csbit;

import cn.csbit.common.BaseCertTest;
import com.netease.dagger.GlobalSettings;
//import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * 用户管理
 */
public class UserManagePage extends BaseCertTest {

    String url = "http://www.baidu.com";

    @FindBy(id = "kw")
    private WebElement searchText;

    public UserManagePage(){
        super(GlobalSettings.rootUrl + "user/");
    }

    @Test
    public void test(){
       // Log.info(searchText.getText());
        be.type("//input[@id='kw']", "demo");
        be.click("//input[@id='su']");

        be.expectTextExistOrNot(true, "demo_百度百科", 5000);
        if(be.isElementPresent("//input[@id='kw']",2000)) {
            String k = be.getText("//input[@id='kw']");
            WebElement w = be.getBrowserCore().findElement(By.id("kw"));
            k = w.getAttribute("name");
            Assert.assertEquals(k, "wd");
        }
    }
}