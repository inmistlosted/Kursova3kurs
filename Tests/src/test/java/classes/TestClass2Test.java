package classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestClass2Test {
    private static TestClass2 testClass;

    @BeforeAll
    static void init() throws IOException {
        int n1 = 5, n2 = 8;
        testClass = new TestClass2(1000, 1024);
    }

    @Test
    void method2() {
        assertEquals(1024, testClass.method2(0).getBytesArr().length);
    }

    @Test
    void method3() {
        TestClass1 testClass1 = new TestClass1(8);
        byte[] bytes = testClass1.getBytesArr();
        bytes[1] = 10;
        testClass1.setBytesArr(bytes);
        testClass.method3(1, testClass1);
        assertEquals(10, testClass.method2(1).getBytesArr()[1]);
    }

    @Test
    void method1() throws IOException {
        TestClass1 testClass1 = testClass.method2(0);
        byte[] bytes = testClass1.getBytesArr();
        bytes[0] = 5;
        testClass1.setBytesArr(bytes);
        testClass.method3(0, testClass1);
        testClass.method1();
        TestClass2 testClass2 = new TestClass2(1000, 1024);
        assertEquals(5, testClass2.method2(0).getBytesArr()[0]);
    }
}