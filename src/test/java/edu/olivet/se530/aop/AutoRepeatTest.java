package edu.olivet.se530.aop;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.olivet.se530.annotations.Repeat;
import edu.olivet.se530.modules.RepeatModule;
import org.apache.commons.lang3.RandomUtils;

/**
 * 自动重复拦截器使用示例
 * <a href="mailto:nathanael4ever@gmail.com>Nathanael Yang</a> 4/12/2016 4:14 PM
 */
public class AutoRepeatTest {

    private void execute() {
        int number = RandomUtils.nextInt(0, 4);
        if (number % 3 == 2) {
            System.out.println("Good day! You are so lucky to have this 1/3 chance.");
        } else {
            throw new RuntimeException("Unfortunately you are not allowed to do this right now with code " + number + ".");
        }
    }

    @Repeat(times = 12)
    void justDoIt() {
        this.execute();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new RepeatModule());
        AutoRepeatTest bean = injector.getInstance(AutoRepeatTest.class);
        try {
            bean.execute();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                // -> Who cares?
            }
        }

        System.out.println("--------------------------------------------------");

        try {
            bean.justDoIt();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(4);
        }

        System.exit(0);
    }
}
