package main;

import classes.TestClass3;
import classes.TestClass4;
import classes.TestClass5;
import classes.TestClass6;
import classes.TestClass7;

public class TestClass12 {
    public static void main(String[] args) throws Exception {
        if (args.length > 2) throw new Exception("Error message");
        String fileName = args[0];
        int count = Integer.parseInt(args[1]);

        TestClass5 testClass5 = TestClass5.method1();

        int index = testClass5.method15(fileName);
        if (index == -1) throw new Exception("Error " + index + " message");

        boolean isOpened = false;
        for (TestClass6 testClass6 : TestClass7.getMainList(testClass5)){
            if (testClass6.getindex() == index){
                isOpened = true;
                String result = "";
                TestClass4 testClass4 = testClass5.method14().get(index);
                Integer[] nums = testClass4.getNums();
                for (int i = testClass6.getnum(); i < nums.length; i++) {
                    if (nums[i] != -1){
                        testClass6.method2(testClass5, nums[i]);
                        if (count == -1){
                            result += testClass6.method6();
                        } else {
                            if (testClass6.getCurrPosInBuffer() + count > testClass6.getBufferLength()){
                                result += testClass6.method7(count);
                                count -= testClass6.getCurrPosInBuffer();
                            } else {
                                result += testClass6.method7(count);
                                break;
                            }
                        }
                    }
                }

                System.out.println(result);

                break;
            }
        }
        if (!isOpened) throw new Exception("Error " + index + " message");
        TestClass7.method1();
    }
}
