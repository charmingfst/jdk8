package org.chm.inteceptor;

/**
 * Created by charming on 2017/8/12.
 */
public class Client {
    public static void main(String[] args) {
        Inteceptor interceptor = new InteceptorImpl();
        Target target = (Target) interceptor.register(new TargetImpl());
        target.execute1();
        target.execute2();

//        int x = 1, y = 1, z =1;
//        if (x-- ==1 && y++ ==1 || z++ ==1)
//        {
//            System.out.println("x="+x+" y="+y + " z=" +z);
//        }


    }
}
