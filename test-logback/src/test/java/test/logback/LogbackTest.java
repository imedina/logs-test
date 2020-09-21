package test.logback;

import org.junit.Test;
import test.core.MyApplication;

public class LogbackTest {

    @Test
    public void test() throws Exception {
        new MyApplication().run();
    }
}
