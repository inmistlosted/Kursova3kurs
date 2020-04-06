package main;

import java.io.IOException;

import classes.TestClass3;
import classes.TestClass4;
import classes.TestClass5;
import classes.TestClass6;
import classes.TestClass7;

public class TestClass14 {
    public static void main(String[] args) throws Exception {
        if (args.length > 2) throw new Exception("Error message");
        String fileName = args[0];
        int newPosition = Integer.parseInt(args[1]);

        TestClass5 testClass5 = TestClass5.method1();

        int index = testClass5.method15(fileName);
        if (index == -1) throw new Exception("Error " + index + " message");

        boolean isOpened = false;
        for (TestClass6 testClass6 : TestClass7.getMainList(testClass5)){
            if (testClass6.getindex() == index){
                isOpened = true;
                int oldNum= testClass6.getnum();
                testClass6.method4(newPosition);
                int newNum = testClass6.getnum();
                if (oldNum == newNum){
                    break;
                } else {
                    TestClass4 testClass4 = testClass5.method14().get(index);
                    Integer[] nums = testClass4.getNums();
                    if (nums[newNum] == -1) throw new Exception("Error message " + newPosition);
                    testClass6.method1(testClass5);
                    testClass6.method2(testClass5, nums[newNum]);
                }
            }
        }
        if (!isOpened) throw new Exception("Error " + fileName + " message");
        TestClass7.method1();
        testClass5.method19();
        System.out.println("Console message " + newPosition);
    }

    private boolean method1() throws Exception {
        String string = "";
        TestClass5 testClass5 = TestClass5.method1();

        int index = 9;
        if (index == -1) throw new Exception("Error " + index + " message");

        boolean isOpened = false;
        for (TestClass6 testClass6 : TestClass7.getMainList(testClass5)){
            if (testClass6.getindex() == index){
                isOpened = true;
                int oldNum= testClass6.getnum();
                testClass6.method4(index);
                int newNum = testClass6.getnum();
                if (oldNum == newNum){
                    break;
                } else {
                    TestClass4 testClass4 = testClass5.method14().get(index);
                    Integer[] nums = testClass4.getNums();
                    if (nums[newNum] == -1) throw new Exception("Error message " + newNum);
                    testClass6.method1(testClass5);
                    testClass6.method2(testClass5, nums[newNum]);
                }
            }
        }
        return true;
    }
}
