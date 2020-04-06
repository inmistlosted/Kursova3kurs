package classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestClass4Test {
    private static TestClass4 testClass;

    @BeforeAll
    static void init() {
        Integer[] nums = new Integer[3];
        testClass = new TestClass4(2, nums);
    }

    @Test
    void getNums() {
        assertEquals(3, testClass.getNums().length);
    }

    @Test
    void getFileLength() {
        assertEquals(2, testClass.getFileLength());
    }
}