package io.nefeed.stream.common;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import io.nefeed.stream.base.BaseTests;
import org.junit.Test;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-04-08 17:16
 */
public class CommonTests extends BaseTests {

    public static class BeanExample {
        public static String upper(String abc) {
            return abc.toUpperCase();
        }

        public boolean anyContains(String str, String searchStr) {

            char[] s = str.toCharArray();
            for (char c : s) {
                if (searchStr.contains(c + "")) {
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    public void testFirst() {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a",1);
        context.put("b",2);
        context.put("c",3);
        String express = "a+b*c";
        Object r = null;
        try {
            r = runner.execute(express, context, null, true, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(r);
    }

    @Test
    public void testAddFunction() {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        Object result = null;
        try {
            runner.addFunctionOfClassMethod("取绝对值", Math.class.getName(), "abs",
                    new String[]{"double"}, null);
            runner.addFunctionOfClassMethod("转换为大写", BeanExample.class.getName(),
                    "upper", new String[]{"String"}, null);
            runner.addFunctionOfServiceMethod("打印", System.out, "println", new String[]{"String"}, null);
            runner.addFunctionOfServiceMethod("contains", new BeanExample(), "anyContains",
                    new Class[]{String.class, String.class}, null);

            String exp = "取绝对值(-100);转换为大写(\"hello world\");打印(\"你好吗？\");contains(\"helloworld\",\"aeiou\")";
            result = runner.execute(exp, context, null, false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }


}
