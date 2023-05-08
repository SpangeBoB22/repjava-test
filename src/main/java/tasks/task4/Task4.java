package tasks.task4;

import java.lang.reflect.InvocationTargetException;

public class Task4 {
    public void run() throws InterruptedException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        CountDownLatchExample countDownLatchExample = new CountDownLatchExample();
        countDownLatchExample.run();
        CustomClassExample customClassExample = new CustomClassExample();
        customClassExample.run();
        GenericMethodExample genericMethodExample = new GenericMethodExample();
        genericMethodExample.run();
    }
}
