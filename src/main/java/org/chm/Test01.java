package org.chm;

/**
 * Created by charming on 2017/1/4.
 */

interface StringFunc{
    String func(String s);
}
class MyStringOps{
    //A static method that reverse a string
    String reverse(String str)
    {
        String result = "";
        for(int i = str.length()-1; i>=0; i--)
            result += str.charAt(i);
        return result;
    }
    String reverse()
    {
        return "hello world";
    }
}

public class Test01{
    static String stringOp(StringFunc sf, String s)
    {
        return sf.func(s);

    }
    public static void main(String[] args)
    {
        String inStr = "lambda add power to java";
        String outStr = stringOp(new MyStringOps()::reverse,inStr);
        System.out.println("string reversed:"+outStr);
    }

}