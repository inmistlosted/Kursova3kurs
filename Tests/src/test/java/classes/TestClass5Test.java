package classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TestClass5Test {
    private static TestClass5 testClass;

    @BeforeAll
    static void init() throws IOException {
        testClass = new TestClass5(1000, 1024, 20);
    }

    @Test
    void method1() throws IOException {
        TestClass5 testClass5 = TestClass5.method1();
        assertEquals(1024, testClass5.B);
    }

    @Test
    void method3() {
        ArrayList<Byte> list = testClass.method3();
        assertEquals(980, list.size());
    }

    @Test
    void method4() {
        int index = testClass.method4();
        assertEquals(1, index);
    }

    @Test
    void method5() {
        int num = 10;
        testClass.method5(num, (byte)1);
        int index = 10 / testClass.B;
        int numInBlock = num - index * testClass.B;
        TestClass1 currTestClass1 = testClass.testClass2.method2(index);
        assertEquals(1, currTestClass1.getBytesArr()[numInBlock]);
    }

    @Test
    void method6() {
        boolean done = testClass.method6("name", 0);
        assertTrue(done);
        ArrayList<TestClass3> list = testClass.method8();
        assertEquals(1, list.size());
        done = testClass.method7("name");
        assertTrue(done);
    }

    @Test
    void method7() {
        boolean done = testClass.method6("name1", 0);
        assertTrue(done);
        done = testClass.method6("name2", 1);
        assertTrue(done);
        done = testClass.method7("name1");
        assertTrue(done);
        ArrayList<TestClass3> list = testClass.method8();
        assertEquals("name2", list.get(0).getFileName());
        done = testClass.method7("name2");
        assertTrue(done);
    }

    @Test
    void method8() {
        boolean done = testClass.method6("name1", 0);
        assertTrue(done);
        done = testClass.method6("name2", 1);
        assertTrue(done);
        done = testClass.method6("name3", 2);
        assertTrue(done);
        ArrayList<TestClass3> list = testClass.method8();
        assertEquals(3, list.size());
        done = testClass.method7("name1");
        assertTrue(done);
        done = testClass.method7("name2");
        assertTrue(done);
        done = testClass.method7("name3");
        assertTrue(done);
    }

    @Test
    void method9() {
        Integer num = 123;
        byte[] bytes = testClass.method9(num);
        assertEquals(-2, bytes[3]);
    }

    @Test
    void method11() {
        Integer[] nums = new Integer[3];
        Arrays.fill(nums, -1);
        int index = testClass.method11(12, nums);
        assertEquals(0, index);
        ArrayList<TestClass4> list = testClass.method14();
        assertEquals(1, list.size());
    }

    @Test
    void method12() {
        Integer[] nums = new Integer[3];
        Arrays.fill(nums, -1);
        int index = testClass.method11(12, nums);
        assertEquals(1, index);
        ArrayList<TestClass4> list = testClass.method14();
        assertEquals(12, list.get(index).getFileLength());
        boolean done = testClass.method12(index, 14, nums);
        assertEquals(true, done);
        list = testClass.method14();
        assertEquals(14, list.get(index).getFileLength());
    }

    @Test
    void method13() {
        Integer[] nums = new Integer[3];
        Arrays.fill(nums, -1);
        int index1 = testClass.method11(12, nums);
        assertEquals(2, index1);
        int index2 = testClass.method11(13, nums);
        assertEquals(3, index2);
        ArrayList<TestClass4> list = testClass.method14();
        assertEquals(4, list.size());
        boolean done = testClass.method13(index1);
        assertEquals(true, done);
        list = testClass.method14();
        assertEquals(-1, list.get(index1).getFileLength());
    }

    @Test
    void method14() {
        Integer[] nums = new Integer[3];
        Arrays.fill(nums, -1);
        int index1 = testClass.method11(12, nums);
        assertEquals(2, index1);
        int index2 = testClass.method11(13, nums);
        assertEquals(4, index2);
        int index3 = testClass.method11(14, nums);
        assertEquals(5, index3);
        ArrayList<TestClass4> list = testClass.method14();
        assertEquals(6, list.size());
    }

    @Test
    void method15() {
        boolean done = testClass.method6("name1", 0);
        assertEquals(true, done);
        done = testClass.method6("name2", 1);
        assertEquals(true, done);
        assertEquals(1, testClass.method15("name2"));
        done = testClass.method7("name1");
        assertTrue(done);
        done = testClass.method7("name2");
        assertTrue(done);
    }

    @Test
    void getB() {
        assertEquals(1024, testClass.getB());
    }

    @Test
    void getTestClass2() {
        assertEquals(-1, testClass.getTestClass2(50)[0]);
    }

    @Test
    void setTestClass2() {
        byte[] bytes = new byte[testClass.getB()];
        bytes[7] = 8;
        testClass.setTestClass2(50, bytes);
        assertEquals(8, testClass.getTestClass2(50)[7]);
    }
}