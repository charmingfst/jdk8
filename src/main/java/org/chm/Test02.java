package org.chm;

/**
 * Created by charming on 2017/1/5.
 */

@FunctionalInterface
interface TheInterface
{
    int myMethod(String str, int index);
}

public class Test02 {

    public static void main(String[] args) {
        TheInterface theInterface = String::indexOf;
        //第一参数指的是调用indexOf方法的实例，indexOf(int ch)
        int index = theInterface.myMethod("hello world",'o');
        System.out.println(index);

        theInterface = "hello world"::indexOf;
        //隐含的第一个参数this，indexOf(String str, int fromIndex)
        index = theInterface.myMethod("o", 1);
        System.out.println(index);

        Integer integer = new Integer(6);
        int res = integer.compareTo(new Integer(6));
        System.out.println(res);
        float var= 0.89f;
        System.out.println(var == 0);
    }
}
