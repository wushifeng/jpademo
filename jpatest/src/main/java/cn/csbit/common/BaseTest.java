package cn.csbit.common;

import com.netease.dagger.BrowserEmulator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by wushifeng on 2016/7/5.
 */
public abstract class BaseTest {
    protected BrowserEmulator be;

    protected BaseTest(String url) {
        be = new BrowserEmulator();
        be.getBrowserCore().manage().window().maximize();

        PageFactory.initElements(be.getBrowserCore(), this);

        be.open(url);
    }

    @BeforeClass
    public void doBeforeClass() throws Exception {

    }

    @AfterClass(alwaysRun = true)
    public void doAfterClass() {
        be.quit();
    }

}
