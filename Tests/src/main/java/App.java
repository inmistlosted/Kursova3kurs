import java.util.ArrayList;
import java.util.List;

public class App {

    public App(){
        System.out.println("Constructor");
    }

    public void m1(){
        String s = "Some text";
        s = s.intern();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list = null;
        list.add(2);
        Object obj = getData();
        System.out.println(obj.toString());
    }

    public void m2(int d){
        if (true){
            System.out.println(d);
        } else {
            System.out.println(d-1);
        }
    }

    public Object getData(){
        return null;
    }


    public static void main(String[] args) {
        System.out.println("hello world");
        App app = new App();
        app.m1();
        String s = "";
        //app.m2(s);
    }
}
