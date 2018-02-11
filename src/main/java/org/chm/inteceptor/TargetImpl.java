package org.chm.inteceptor;

/**
 * Created by charming on 2017/8/12.
 */
public class TargetImpl implements Target {

    @Override
    public void execute1() {
        System.out.println("Execute1");
    }

    @Override
    public void execute2() {
        System.out.println("Execute2");
    }
}