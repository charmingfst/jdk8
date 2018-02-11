package org.chm;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.ParseException;

/**
 * Created by charming on 2016/12/30.
 */
public class MyTest {
    public static void main(String[] args){
        int[] array = new int[]{1,2,3};
        System.out.println(array.length);
        int[] array2 = (int[]) resizeArray(array, 5);
        array2[3] = 4;
        System.out.println(array2.length+":"+array2[3]);
        try {
            java.util.Date date = java.text.DateFormat.getDateInstance().parse("2012-11-02");
            System.out.println(date);
            captureScreen("screen.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static Object resizeArray (Object oldArray, int newSize) {
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(elementType,newSize);
        int preserveLength = Math.min(oldSize,newSize);
        if (preserveLength > 0)
            System.arraycopy (oldArray,0,newArray,0,preserveLength);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName);
        return newArray;
    }
    public static void captureScreen(String fileName) throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "png", new File(fileName));
    }
}
