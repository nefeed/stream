package io.nefeed.stream.base;

import org.junit.After;
import org.junit.Before;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-04-08 17:18
 */
public class BaseTests {

    private Date mStartTime;
    protected static SimpleDateFormat SDFTime = new SimpleDateFormat("HH:mm:ss");

    @Before
    public void beforeJunitTest() {
        mStartTime = new Date();
        System.out.println("========================= 单元测试开始时间：" + SDFTime.format(mStartTime) + " ==========================");
    }

    @After
    public void afterJunitTest() {
        Date endTime = new Date();
        System.out.println("========================= 单元测试结束时间：" + SDFTime.format(endTime) + " ==========================");
        System.out.println("*********************** 累计用时：" + (endTime.getTime() - mStartTime.getTime()) + "ms ************************");
    }
}
