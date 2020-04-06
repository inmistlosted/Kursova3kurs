package main;

import java.io.IOException;
import java.util.ArrayList;

import classes.TestClass3;
import classes.TestClass4;
import classes.TestClass5;
import classes.TestClass6;
import classes.TestClass7;

public class TestClass15 {
    public static void main(String[] args) throws IOException {
        TestClass5 testClass5 = TestClass5.method1();

        ArrayList<TestClass3> list = testClass5.method8();

        if (list.size() == 0) {
            System.out.println("Console message");
            return;
        }

        System.out.println("Console message ");
        for(TestClass3 testClass3 : list){
            TestClass4 testClass4 = testClass5.method14().get(testClass3.getIndex());
            System.out.println(" Console message2: " + testClass3.getFileName() + " Console message3: " + testClass4.getFileLength());
        }
    }
}
