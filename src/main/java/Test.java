/**
 * Created by charming on 2018/1/29.
 * 字节码
 */
public class Test {
    private String name="hello";

    public static void main(String[] args) {
//        new Test().test();
        int card = 11;
        switch(card){
            case 11:
                System.out.print("Jack");
                break;
            case 12:
                System.out.print("Queen");
                break;
        }
    }

    public void test()
    {
        int x = 10;
        int y = 12;
        int z = 14;
        int u = 15;
        int t = x + y + z + u;
        System.out.println(t);
    }

    public String getName()
    {
        return this.name;
    }
}
