package classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestClass7Test {
    private static TestClass7 testClass;

    @BeforeAll
    static void init()  {
        testClass = new TestClass7();
    }

    @Test
    void getMainList() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        ArrayList<TestClass6> list = TestClass7.getMainList(testClass5);
        assertEquals(0, list.size());
    }

    @Test
    void method2() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        TestClass6 testClass6 = new TestClass6(0, 0);
        TestClass7.method2(testClass5, testClass6);
        ArrayList<TestClass6> list = TestClass7.getMainList(testClass5);
        assertEquals(0, list.get(0).getPosition());
        TestClass7.method5();
    }

    @Test
    void method3() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        TestClass6 testClass6_1 = new TestClass6(0, 0);
        TestClass6 testClass6_2 = new TestClass6(3, 0);
        TestClass7.method2(testClass5, testClass6_1);
        TestClass7.method2(testClass5, testClass6_2);
        ArrayList<TestClass6> list = TestClass7.getMainList(testClass5);
        assertEquals(2, list.size());
        TestClass7.method3(testClass6_1);
        list = TestClass7.getMainList(testClass5);
        assertEquals(2, list.size());
        TestClass7.method5();
    }

    @Test
    void method4() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        TestClass6 testClass6 = new TestClass6(0, 0);
        TestClass7.method2(testClass5, testClass6);
        assertEquals(false, TestClass7.method4(testClass5, 0));
        TestClass7.method5();
    }
}