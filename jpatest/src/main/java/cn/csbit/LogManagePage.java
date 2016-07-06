package cn.csbit;

import cn.csbit.common.BaseCertTest;
import com.netease.dagger.GlobalSettings;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * 日志管理类别
 */
public class LogManagePage extends BaseCertTest {

    String url = "http://www.baidu.com";

    @FindBy(id = "kw")
    private WebElement searchText;

    public LogManagePage(){
        super(GlobalSettings.rootUrl + "log/");
    }

    @Test
    public void test(){
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

    @Test(dataProvider = "data")
    public void doTest(String keyword, String result) {
        String searchBox = "//input[@id='kw']";
        String searchBtn = "//input[@id='su']";

        be.open(url);
        be.type(searchBox, keyword);
        be.click(searchBtn);
        be.expectTextExistOrNot(true, result, 5000);
    }

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                { "java", "www.java.com" },
                { "github", "github.com" },
        };
    }
}