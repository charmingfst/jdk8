package org.chm;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by charming on 2017/1/7.
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        System.out.println(test.computer(3, value -> value+value, value -> value*value));

        System.out.println(test.computer2(2,3, (value1, value2) -> value1+value2, value -> value*value));
    }

    public int computer(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2)
    {
        return function1.compose(function2).apply(a);
    }

    public int computer2(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function)
    {
        return biFunction.andThen(function).apply(a, b);
    }
}
