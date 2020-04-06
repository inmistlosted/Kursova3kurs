package classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestClass1Test {
    private static TestClass1 testClass;

    @BeforeAll
    static void init(){
        int n = 5;
        testClass = new TestClass1(n);
    }

    @Test
    void setBytesArr() {
        byte[] bytes = new byte[8];
        testClass.setBytesArr(bytes);
        assertEquals(8, testClass.getBytesArr().length);
    }

    @Test
    void getBytesArr() {
        assertEquals(8, testClass.getBytesArr().length);
    }


}