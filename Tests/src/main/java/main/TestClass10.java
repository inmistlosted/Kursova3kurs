package main;

import java.util.Arrays;

import classes.TestClass3;
import classes.TestClass4;
import classes.TestClass5;
import classes.TestClass6;
import classes.TestClass7;

public class TestClass10 {
    public static void main(String[] args) throws Exception {
        if (args.length > 1) throw new Exception("Error message");
        String fileName = args[0];

        TestClass5 testClass5 = TestClass5.method1();

        int index = testClass5.method15(fileName);
        if (index == -1) throw new Exception("Error " + index + " message");

        if (!TestClass7.method4(testClass5, index)) throw new Exception("Error message");

        TestClass6 testClass6 = new TestClass6(0, index);

        TestClass4 testClass4 = testClass5.method14().get(index);
        Integer[] array = testClass4.getNums();
        if (array[0] == -1){
            int newInt = testClass5.method4();
            if (newInt == -1) throw new Exception("Error message");
            Integer[] ints = new Integer[3];
            Arrays.fill(ints, -1);
            ints[0] = newInt;
            testClass5.method12(index, 0, ints);
            testClass6.method2(testClass5, newInt);
            testClass5.method19();
        } else {
            testClass6.method2(testClass5, array[0]);
        }
        TestClass7.method2(testClass5, testClass6);

        System.out.println("Console " + fileName + " message");
    }
}
