package org.chm;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * Created by charming on 2018/2/9.
 */
public class LambdaTest {

    public void test(Consumer<Integer> consumer, Integer value)
    {
        consumer.accept(value);
    }

    public void test(IntConsumer consumer, Integer value)
    {
        consumer.accept(value);
    }
    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
        Consumer<Integer> consumer = i -> System.out.println(i);
        IntConsumer intConsumer = i -> System.out.println(i);

        test.test(consumer, 10);
        test.test((IntConsumer) consumer::accept, 100);


        test.test((Consumer<Integer>) intConsumer::accept, 1000);

        System.out.println();
    }
}
