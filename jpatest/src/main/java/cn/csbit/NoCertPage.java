package cn.csbit;

import cn.csbit.common.BaseTest;
import com.netease.dagger.BrowserEmulator;
import com.netease.dagger.GlobalSettings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

/**
 * 基础测试，如果这个无法通过，其他的测试不要运行
 */
@Test(groups = {"cert"})
public class NoCertPage extends BaseTest {

    public NoCertPage() {
        super(GlobalSettings.rootUrl);
    }

    //基本的登陆检查
    @Test(enabled = false)
    static public void isCert(BrowserEmulator web) {
        web.getBrowser().windowFocus();
        //Log.info(web.getBrowserCore().getTitle());
        //baidu.com/user 这个地址未授权
        if(web.getBrowserCore().getTitle().contains("您访问的页面不存在"))
            web.open("http://www.baidu.com");
        else {
            web.type("//input[@id='kw']", "demo");
            web.click("//input[@id='su']");
            web.expectTextExistOrNot(true, "demo_百度百科", 5000);
        }
    }

    @FindBy(id = "kw")
    private WebElement searchText;

    public void login() {
        isCert(this.be);
        //Log.info(this.searchText.getText());
    }
}
