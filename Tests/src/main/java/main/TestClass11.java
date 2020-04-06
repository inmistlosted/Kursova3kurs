package main;

import classes.TestClass3;
import classes.TestClass4;
import classes.TestClass5;
import classes.TestClass6;
import classes.TestClass7;

public class TestClass11 {
    public static void main(String[] args) throws Exception {
        if (args.length > 1) throw new Exception("Error message");
        String fileName = args[0];

        TestClass5 testClass5 = TestClass5.method1();

        int index = testClass5.method15(fileName);
        if (index == -1) throw new Exception("Error " + index + " message");

        boolean isOpened = false;
        for (TestClass6 testClass6 : TestClass7.getMainList(testClass5)){
            if (testClass6.getindex() == index){
                isOpened = true;
                testClass6.method1(testClass5);
                TestClass4 testClass4 = testClass5.method14().get(index);
                Integer[] nums = testClass4.getNums();
                int length = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] != -1){
                        testClass6.method2(testClass5, nums[i]);
                        length += testClass6.method5();
                    }
                }
                testClass5.method12(index, length, nums);
                testClass6.method1(testClass5);
                TestClass7.method3(testClass6);
                break;
            }
        }
        if (!isOpened) throw new Exception("Error " + index + " message");
        System.out.println("Console " + fileName + " message");
    }
}
