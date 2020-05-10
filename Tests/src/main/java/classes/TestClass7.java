package classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TestClass7 {
    private static ArrayList<TestClass6> mainList;

    public TestClass7(){
        mainList = new ArrayList<>();
    }

    public static ArrayList<TestClass6> getMainList(TestClass5 testClass5) throws IOException {
        mainList = new ArrayList<>();
        FileInputStream fin = new FileInputStream("file2.txt");
        int num = fin.read();
        if (num == -1) return mainList;
        int n = Integer.parseInt(String.valueOf((char)num));
        for (int i = 0; i < n; i++) {
            ArrayList<Character> chars = new ArrayList<>();
            char ch;
            while ((ch = (char)fin.read()) != ','){
                chars.add(ch);
            }
            char[] posChars = new char[chars.size()];
            for (int j = 0; j < chars.size(); j++) {
                posChars[j] = chars.get(j);
            }
            int position = Integer.parseInt(new String(posChars));


            chars = new ArrayList<>();
            while ((ch = (char)fin.read()) != ','){
                chars.add(ch);
            }
            char[] indexChars = new char[chars.size()];
            for (int j = 0; j < chars.size(); j++) {
                indexChars[j] = chars.get(j);
            }
            int index = Integer.parseInt(new String(indexChars));

            chars = new ArrayList<>();
            while ((ch = (char)fin.read()) != ','){
                chars.add(ch);
            }
            char[] bufferChars = new char[chars.size()];
            for (int j = 0; j < chars.size(); j++) {
                bufferChars[j] = chars.get(j);
            }
            int bufferAdr = Integer.parseInt(new String(bufferChars));


            TestClass6 testClass6 = new TestClass6(0, index);
            testClass6.method2(testClass5, bufferAdr);
            testClass6.method4(position);
            mainList.add(testClass6);
        }

        return mainList;
    }

    public static void method1() throws IOException {
        String toFile = mainList.size()+"";
        for (TestClass6 entry : mainList){
            int position = entry.getPosition();
            int index = entry.getindex();
            int bufferAddr = entry.getbufferInt();

            toFile += position + "," + index + "," + bufferAddr + ",";
        }

        FileOutputStream fout = new FileOutputStream("file2.txt");
        fout.write(toFile.getBytes());
    }

    public static void method2(TestClass5 testClass5, TestClass6 testClass6) throws IOException {
        getMainList(testClass5);
        mainList.add(testClass6);
        method1();
    }

    public static void method3(TestClass6 testClass) throws IOException {
        mainList.remove(testClass);
        method1();
    }

    public static boolean method4(TestClass5 testClass, int index) throws IOException {
        getMainList(testClass);
        for (TestClass6 entry : mainList){
            if (entry.getindex() == index){
                return false;
            }
        }
        return true;
    }

    public static void method5() throws IOException {
        mainList = new ArrayList<>();
        method1();
    }


}
