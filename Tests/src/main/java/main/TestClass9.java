package main;

import classes.TestClass3;
import classes.TestClass4;
import classes.TestClass5;
import classes.TestClass6;
import classes.TestClass7;

public class TestClass9 {
    public static void main(String[] args) throws Exception {
        if (args.length > 1) throw new Exception("Error message");
        String fileName = args[0];

        TestClass5 testClass5 = TestClass5.method1();

        int index = testClass5.method15(fileName);
        if (index == -1) throw new Exception("Error " + index + " message");

        if (!testClass5.method7(fileName)) throw new Exception("Error " + index + " message");
        TestClass4 testClass4 = testClass5.method14().get(index);
        Integer[] nums = testClass4.getNums();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1){
                testClass5.method5(nums[i], (byte)0);
            }
        }
        if (!testClass5.method13(index)) throw new Exception("Error " + index + " message");

        testClass5.method19();

        System.out.println("Console " + fileName + " message");
    }
}
