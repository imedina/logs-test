package test.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApplication {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyApplication.class);

    public MyApplication() {
    }

    public void run() throws InterruptedException {
        LOGGER.info("Hello World!");
        Thread t = new Thread("my-thread") {
            @Override
            public void run() {
                myFunction4();
                LOGGER.warn("Try again");
                myFunction2();
            }
        };
        t.start();
        t.join();
    }

    public void myFunction4() {
        myFunction3();
    }
    public void myFunction3() {
        myFunction2();
    }
    public void myFunction2() {
        myFunction1();
    }
    public void myFunction1() {
        myFunction();
    }

    public void myFunction(){
        try {
            otherFunction2();
        } catch (Exception e) {
            LOGGER.error("This is an exception", new Exception("DummyException", e));
        }
    }

    private void otherFunction2() {
        otherFunction1();
    }

    private void otherFunction1() {
        throw new IllegalArgumentException("Nested exception");
    }
}
