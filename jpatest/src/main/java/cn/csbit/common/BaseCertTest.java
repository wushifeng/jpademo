package cn.csbit.common;

import org.testng.annotations.Test;

/**
 * Created by wushifeng on 2016/7/5.
 */
@Test(dependsOnGroups = {"cert"})
public abstract class BaseCertTest extends BaseTest {
    protected BaseCertTest(String url) {
        super(url);

        cn.csbit.NoCertPage.isCert(this.be);
    }
}
