package main;

import classes.TestClass4;
import classes.TestClass5;
import classes.TestClass6;
import classes.TestClass7;

import java.util.Arrays;

public class TestClass13 {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        String text = args[1];

        if (text.length() == 1){
            int num = Integer.parseInt(args[2]);
            char[] textChars = new char[num];
            Arrays.fill(textChars, text.charAt(0));
            text = new String(textChars);
        }

        TestClass5 testClass5 = TestClass5.method1();

        int index = testClass5.method15(fileName);
        if (index == -1) throw new Exception("Error " + index + " message");

        boolean isOpened = false;
        for (TestClass6 testClass6 : TestClass7.getMainList(testClass5)){
            if (testClass6.getindex() == index){
                isOpened = true;
                Integer[] nums = null;
                byte[] textBytes = text.getBytes();
                if (textBytes.length + testClass6.getPosition() > 3 * testClass5.getB()) throw new Exception("Error message");
                int numToWrite = testClass6.getPosition() / testClass5.getB();
                int startPosInBuffer = testClass6.getPosition() - numToWrite * testClass5.getB();
                int numToEndWrite = (testClass6.getPosition() + textBytes.length) / testClass5.getB();
                if (numToWrite == numToEndWrite){
                    int t = 0, j = 0;
                    byte[] bytes = testClass6.getBuffer();
                    for (int i = startPosInBuffer; i < startPosInBuffer + textBytes.length; i++) {
                        bytes[i] = textBytes[t];
                        t++;
                        j = i + 1;
                    }
                    if (j < testClass5.getB()) bytes[j] = -1;
                    testClass6.writeInBuffer(bytes);
                    nums = testClass5.method14().get(index).getNums();
                } else {
                    int currTextLength = textBytes.length;
                    int t = 0;
                    for (int i = numToWrite; i < numToEndWrite; i++) {
                        byte[] bytes = testClass6.getBuffer();
                        boolean flag = false;
                        for (int j = startPosInBuffer; j < testClass5.getB(); j++) {
                            bytes[j] = textBytes[t];
                            t++;
                            if (--currTextLength == 0) {
                                flag = true;
                                if (j+1 < testClass5.getB()) bytes[j+1] = -1;
                                break;
                            }
                        }
                        if (flag) break;
                        testClass6.writeInBuffer(bytes);
                        testClass6.method1(testClass5);
                        TestClass4 testClass4 = testClass5.method14().get(index);
                        Integer[] ints = testClass4.getNums();
                        if (ints[i+1] != -1){
                            testClass6.method2(testClass5, ints[i+1]);
                        } else {
                            int newInt = testClass5.method4();
                            if (newInt == -1) throw new Exception("Error message");
                            ints[i+1] = newInt;
                            testClass5.method12(index, 0, ints);
                            testClass6.method2(testClass5, newInt);
                        }
                        nums = testClass5.method14().get(index).getNums();
                        startPosInBuffer = 0;
                    }
                }
                testClass5.method12(index, testClass6.getPosition() + textBytes.length, nums);
                testClass6.method4(testClass6.getPosition() + textBytes.length);

                testClass6.method3(testClass5);
                break;
            }
        }
        if (!isOpened) throw new Exception("Error " + index + " message");
        TestClass7.method1();
        testClass5.method19();
        System.out.println("Console message");
    }

}
