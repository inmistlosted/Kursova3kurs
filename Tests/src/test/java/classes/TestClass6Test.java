package classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestClass6Test {
    private static TestClass6 testClass;

    @BeforeAll
    static void init()  {
        testClass = new TestClass6(0, 7);
    }

    @Test
    void method1() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        testClass.method1(testClass5);
        assertEquals(-1, testClass.bufferInt);
    }

    @Test
    void method2() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        testClass.method2(testClass5, 2);
        assertEquals(2, testClass.bufferInt);
    }

    @Test
    void method4() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        testClass.method2(testClass5, 2);
        testClass.method4(1028);
        assertEquals(4, testClass.getCurrPosInBuffer());
    }

    @Test
    void getnum() {
        assertEquals(1, testClass.getnum());
    }

    @Test
    void getindex() {
        assertEquals(7, testClass.getindex());
    }

    @Test
    void writeInBuffer() {
        byte[] bytes = new byte[1024];
        bytes[7] = 7;
        testClass.writeInBuffer(bytes);
        assertEquals(7, testClass.getBuffer()[7]);
    }

    @Test
    void getPosition() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        testClass.method2(testClass5, 2);
        testClass.method4(1028);
        assertEquals(1028, testClass.getPosition());
    }

    @Test
    void getBuffer() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        testClass.method2(testClass5, 2);
        assertEquals(1024, testClass.getBuffer().length);
    }

    @Test
    void getbufferInt() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        testClass.method2(testClass5, 2);
        assertEquals(2, testClass.getbufferInt());
    }

    @Test
    void getCurrPosInBuffer() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        testClass.method2(testClass5, 2);
        testClass.method4(1546);
        assertEquals(522, testClass.getCurrPosInBuffer());
    }

    @Test
    void getBufferLength() throws IOException {
        TestClass5 testClass5 = new TestClass5(1000, 1024, 20);
        testClass.method2(testClass5, 2);
        assertEquals(1024, testClass.getBufferLength());
    }

    @Test
    void method5() {
        byte[] bytes = new byte[1024];
        bytes[0] = "t".getBytes()[0];
        bytes[1] = "e".getBytes()[0];
        bytes[2] = "s".getBytes()[0];
        bytes[3] = "t".getBytes()[0];
        bytes[4] = -1;
        testClass.writeInBuffer(bytes);
        assertEquals(4, testClass.method5());
    }

    @Test
    void method6() {
        byte[] bytes = new byte[1024];
        bytes[0] = "t".getBytes()[0];
        bytes[1] = "e".getBytes()[0];
        bytes[2] = "s".getBytes()[0];
        bytes[3] = "t".getBytes()[0];
        bytes[4] = -1;
        testClass.writeInBuffer(bytes);
        testClass.method4(0);
        assertEquals("test", testClass.method6());
    }

    @Test
    void method7() {
        byte[] bytes = new byte[1024];
        bytes[0] = "t".getBytes()[0];
        bytes[1] = "e".getBytes()[0];
        bytes[2] = "s".getBytes()[0];
        bytes[3] = "t".getBytes()[0];
        bytes[4] = -1;
        testClass.writeInBuffer(bytes);
        testClass.method4(0);
        assertEquals("te", testClass.method7(2));
    }
}