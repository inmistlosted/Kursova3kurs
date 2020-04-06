package classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestClass3Test {
    private static TestClass3 testClass;

    @BeforeAll
    static void init() {
        testClass = new TestClass3("filename", 8);
    }

    @Test
    void getFileName() {
        assertEquals("filename", testClass.getFileName());
    }

    @Test
    void getIndex() {
        assertEquals(8, testClass.getIndex());
    }
}