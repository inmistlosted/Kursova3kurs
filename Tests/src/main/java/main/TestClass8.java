package main;

import java.util.ArrayList;
import java.util.Arrays;

import classes.TestClass3;
import classes.TestClass4;
import classes.TestClass5;
import classes.TestClass6;
import classes.TestClass7;

public class TestClass8 {
    public static void main(String[] args) throws Exception {
        if (args.length > 1) throw new Exception("Error message");
        String fileName = args[0];

        TestClass5 testClass5 = TestClass5.method1();

        Integer[] array = new Integer[3];
        Arrays.fill(array, -1);

        int index = testClass5.method11(0, array);

        ArrayList<TestClass3> list = testClass5.method8();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFileName().equals(fileName)) throw new Exception("Error " + index + " message");
        }

        if (!testClass5.method6(fileName, index)){
            throw new Exception("Error message");
        }

        testClass5.method19();

        System.out.println("Console " + fileName + " message");
    }
}
