package classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestClass2 {
    private List<TestClass1> ldisk;

    public TestClass2(int L, int B) throws IOException {
        FileInputStream fin = new FileInputStream("file1.txt");
        byte[] allBytes = fin.readAllBytes();
        if (allBytes.length == 0){
            ldisk = new ArrayList<>();
            for (int i = 0; i < L; i++) {
                TestClass1 testClass1 = new TestClass1(B);
                byte[] bytes = testClass1.getBytesArr();
                bytes[0] = -1;
                testClass1.setBytesArr(bytes);
                ldisk.add(testClass1);
            }
        } else {
            ldisk = new ArrayList<>();
            for (int i = 0; i < L; i++) {
                TestClass1 testClass1 = new TestClass1(B);
                byte[] bytes = testClass1.getBytesArr();
                for (int j = 0; j < B; j++) {
                    bytes[j] = allBytes[i * B + j];
                }
                testClass1.setBytesArr(bytes);
                ldisk.add(testClass1);
            }
        }
    }

    public void method1() throws IOException {
        FileOutputStream fout = new FileOutputStream("file1.txt");
        byte[] allBytes = new byte[ldisk.size() * ldisk.get(0).getBytesArr().length];
        for (int i = 0; i < ldisk.size(); i++) {
            for (int j = 0; j < ldisk.get(i).getBytesArr().length; j++) {
                allBytes[i * ldisk.get(i).getBytesArr().length + j] = ldisk.get(i).getBytesArr()[j];
            }
        }
        fout.write(allBytes);
    }

    public TestClass1 method2(int i){
        return ldisk.get(i);
    }

    public void method3(int i, TestClass1 testClass1){
        ldisk.set(i, testClass1);
    }
}
