import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by charming on 2017/2/28.
 */
public class MyTest1 {
    public static void main(String[] args) {
//        String[] strs = (String[]) new Object[]{"aa", "bb"};

//        Object[] objs =  new Object[]{1, 2};
//        for (int i = 0; i < objs.length; i++) {
//            String str = (String) objs[i];
//            System.out.println(str);
//        }
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("aa", "bb");
//        map.put(null, "cc");
//        map.put("dd", null);
//
//        System.out.println(map);
//        System.out.println(map.get(null));
//        System.out.println(map.get("dd"));
//        System.out.println("--------");
//        Set<Map.Entry<Object, Object>> set = map.entrySet();
//        for (Map.Entry<Object, Object> objs : set)
//        {
//            Object value = objs.getValue();
//            System.out.println(value);
//            System.out.println(objs.getKey());
//        }

        ArrayList<String> list = new ArrayList<>(3);

        list.add("11"); list.add("22"); list.add("33");

        list.remove(1);
        list.add(1, "aa");
        list.remove(0);
        list.add(0, "bb");
        list.remove(2);
        list.add(2, "cc");
        list.forEach(System.out::println);



//        Object[] objs = new String[2];\
//        Map<String, String> map1 = new HashMap<String, String>();
//
//        map1.put("1", "1");
//        map1.put("2", "2");
//        map1.put("3", "3");
//
//        String[] str = map1.keySet().toArray(new String[map1.size()]);
//
//        for(int i=0; i<str.length;i++) {
//            System.out.println(str[i]);
//        }
    }
}
