package classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class TestClass5 {
    private int L;
    public int B;
    protected int length1;
    private Integer K;
    public int length2 = 16;
    public TestClass2 testClass2;

    public TestClass5(int L, int B, int K) throws IOException {
        this.L = L;
        this.B = B;
        this.K = K;
        testClass2 = new TestClass2(L, B);
        method2();
    }

    public static TestClass5 method1() throws IOException {
        Properties props = new Properties();
        InputStream is = new FileInputStream("props.conf");
        props.load(is);
        int L = Integer.parseInt(props.getProperty("L"));
        int B = Integer.parseInt(props.getProperty("B"));
        int K = Integer.parseInt(props.getProperty("K"));
        return new TestClass5(L, B, K);
    }

    private void method2() {
        length1 = (L - K) / B;
        int A = (L - K) - length1 * B;

        for (int i = 0; i < length1; i++) {
            TestClass1 currTestClass1 = testClass2.method2(i);
            byte[] bytes = currTestClass1.getBytesArr();
            int l = bytes[bytes.length];
            if (bytes[0] == -1) bytes[0] = (byte)l;
            currTestClass1.setBytesArr(bytes);
            testClass2.method3(i, currTestClass1);
        }

        if (A > 0){
            TestClass1 currTestClass1 = testClass2.method2(length1);
            byte[] bytes = currTestClass1.getBytesArr();
            if (bytes[0] == -1) bytes[0] = 0;
            bytes[A] = -1;
            int l = bytes[bytes.length];
            currTestClass1.setBytesArr(bytes);
            testClass2.method3(length1, currTestClass1);
            ++length1;
        }
    }

    public ArrayList<Byte> method3(){
        ArrayList<Byte> list = new ArrayList<>();
        for (int i = 0; i < length1; i++) {
            TestClass1 currTestClass1 = testClass2.method2(i);
            byte[] bytes = currTestClass1.getBytesArr();
            for (int j = 0; j < B; j++) {
                if (bytes[j] == -1){
                    break;
                }
                list.add(bytes[j]);
            }
        }
        return list;
    }

    public int method4() {
        ArrayList<Byte> list = method3();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0){
                method5(i, (byte)1);
                return i;
            }
        }
        return -1;
    }

    public void method5(int Num, byte set){
        int num = Num / B;
        int numInBlock = Num - num * B;
        TestClass1 currTestClass1 = testClass2.method2(num);
        byte[] bytes = currTestClass1.getBytesArr();
        bytes[numInBlock] = set;
        currTestClass1.setBytesArr(bytes);
        testClass2.method3(num, currTestClass1);
    }

    public boolean method6(String name, Integer index) throws IOException {
        byte[] nameBytes = name.getBytes();
        String indexStr = index.toString();
        byte[] indexBytes = indexStr.getBytes();
        int recordLength = nameBytes.length + indexBytes.length + 2;
        int l = indexBytes[indexBytes.length];

        class InnerTestClass extends TestClass5{
            InnerTestClass(int L, int B, int K) throws IOException {
                super(L, B, K);
            }
        }

        InnerTestClass itc = new InnerTestClass(L, B, K);
        System.out.println(itc.B);

        for (int i = length1; i < length1+(K-length1)/2; i++) {
            TestClass1 currTestClass1 = testClass2.method2(i);

            byte[] bytes = currTestClass1.getBytesArr();
            byte lastByte = bytes[bytes.length];
            String resMess = "last byte is " + lastByte;

            System.out.println(resMess);

            for (int j = 0; j < B; j++) {
                if (bytes[j] == -1){
                    if (j + recordLength < B){
                        bytes[j] = (byte)nameBytes.length;
                        for (int k = 0; k < nameBytes.length; k++) {
                            bytes[j+1+k] = nameBytes[k];
                        }

                        bytes[j + 1 + l + nameBytes.length] = (byte)indexBytes.length;
                        for (int k = 0; k < indexBytes.length; k++) {
                            bytes[j + 1 + nameBytes.length + 1 + k] = indexBytes[k];
                        }

                        bytes[j + recordLength] = -1;

                        currTestClass1.setBytesArr(bytes);
                        testClass2.method3(i, currTestClass1);
                        return true;
                    } else {
                        break;
                    }
                }
            }
        }

        return false;
    }

    public boolean method7(String fileName){
        for (int i = length1; i < length1+(K-length1)/2; i++) {
            TestClass1 currTestClass1 = testClass2.method2(i);
            byte[] bytes = currTestClass1.getBytesArr();
            if (bytes[0]==-1){
                return false;
            }

            for (int j = 0; j < B; j++) {
                if (bytes[j] == -1){
                    break;
                }
                if (bytes[j] == -3){
                    continue;
                }

                int nameLength = bytes[j];
                byte[] name = new byte[nameLength];
                for (int l = 0; l < nameLength; l++) {
                    name[l] = bytes[j + 1 + l];
                }
                String nameStr = new String(name, StandardCharsets.UTF_8);

                int indexLength = bytes[j + 1 + nameLength];
                if (nameStr.equals(fileName)){
                    for (int k = j; k < j + 2 + nameLength + indexLength; k++) {
                        bytes[k] = -3;
                    }

                    currTestClass1.setBytesArr(bytes);
                    testClass2.method3(i, currTestClass1);
                    return true;
                }

                j = j + 1 + nameLength + indexLength;
            }
        }
        return false;
    }

    public ArrayList<TestClass3> method8(){
        ArrayList<TestClass3> list = new ArrayList<>();
        for (int i = length1; i < length1+(K-length1)/2; i++) {
            TestClass1 currTestClass1 = testClass2.method2(i);
            byte[] bytes = currTestClass1.getBytesArr();
            if (bytes[0]==-1){
                break;
            }

            for (int j = 0; j < B; j++) {
                if (bytes[j] == -1){
                    break;
                }
                if (bytes[j] == -3){
                    continue;
                }
                int nameLength = bytes[j];
                byte[] name = new byte[nameLength];
                for (int l = 0; l < nameLength; l++) {
                    name[l] = bytes[j + 1 + l];
                }
                String nameStr = new String(name, StandardCharsets.UTF_8);

                int indexLength = bytes[j + 1 + nameLength];
                byte[] index = new byte[indexLength];
                for (int l = 0; l < indexLength; l++) {
                    index[l] = bytes[j + 1 + nameLength + 1 + l];
                }
                String indexStr = new String(index, StandardCharsets.UTF_8);
                int ind = Integer.parseInt(indexStr);

                list.add(new TestClass3(nameStr, ind));

                j = j + 1 + nameLength + indexLength;
            }
        }
        return list;
    }

    public byte[] method9(Integer length){
        String lengthStr = length.toString();
        byte[] lengthBytes = new byte[4];
        System.arraycopy(lengthStr.getBytes(), 0, lengthBytes, 0, lengthStr.getBytes().length);
        if (lengthStr.getBytes().length != 4){
            for (int i = lengthStr.getBytes().length; i < 4; i++) {
                lengthBytes[i] = -2;
            }
        }

        return lengthBytes;
    }

    private byte[][] method10(Integer[] addressArr){
        byte[][] address = new byte[addressArr.length][4];

        for (int i = 0; i < address.length; i++) {
            if (addressArr[i] == -1){
                Arrays.fill(address[i], (byte) -2);
            } else {
                String addressStr = addressArr[i].toString();
                byte[] addressBytes = addressStr.getBytes();
                switch (addressBytes.length){
                    case 1 :
                        address[i][0] = addressBytes[0];
                        for (int j = 1; j < 4; j++) {
                            address[i][j] = -2;
                        }
                        break;
                    case 2 :
                        System.arraycopy(addressBytes, 0, address[i], 0, 2);
                        for (int j = 2; j < 4; j++) {
                            address[i][j] = -2;
                        }
                        break;
                    case 3 :
                        System.arraycopy(addressBytes, 0, address[i], 0, 3);
                        address[i][3] = -2;
                        break;
                    default:
                        System.arraycopy(addressBytes, 0, address[i], 0, 4);
                        break;
                }
            }
        }
        return address;
    }

    public int method11(Integer length, Integer[] addressArr){
        byte[] lengthBytes = method9(length);
        byte[][] address = method10(addressArr);

        for (int i = length1+(K-length1)/2; i < K; i++) {
            TestClass1 currTestClass1 = testClass2.method2(i);
            byte[] bytes = currTestClass1.getBytesArr();
            int index = 0;
            for (int j = 0; j < B; j+=length2) {
                if (bytes[j] == -1 || bytes[j] == -3){
                    byte flag = bytes[j];
                    if (j + length2 < B){
                        for (int k = 0; k < lengthBytes.length; k++) {
                            bytes[j+k] = lengthBytes[k];
                        }

                        for (int k = 0; k < address.length; k++) {
                            for (int l = 0; l < address[k].length; l++) {
                                bytes[j + lengthBytes.length + (k * 4) + l] = address[k][l];
                            }
                        }

                        long bytes_end = (~0) << 1;

                        if (flag == -1){
                            bytes[j + length2] = -1;
                            bytes[(int)bytes_end] = 0;
                        }

                        currTestClass1.setBytesArr(bytes);
                        testClass2.method3(i, currTestClass1);
                        return index;
                    } else {
                        break;
                    }
                }
                index++;
            }
        }

        return -1;
    }

    public boolean method12(int index, Integer length, Integer[] addressArr){
        byte[] lengthBytes = method9(length);
        byte[][] address = method10(addressArr);

        int currIndex = 0;
        for (int i = length1+(K-length1)/2; i < K; i++) {
            TestClass1 currTestClass1 = testClass2.method2(i);
            byte[] bytes = currTestClass1.getBytesArr();

            for (int j = 0; j < B; j+=length2) {
                if (currIndex == index){
                    for (int k = 0; k < lengthBytes.length; k++) {
                        bytes[j+k] = lengthBytes[k];
                    }

                    for (int k = 0; k < address.length; k++) {
                        for (int l = 0; l < address[k].length; l++) {
                            bytes[j + lengthBytes.length + (k * 4) + l] = address[k][l];
                        }
                    }

                    currTestClass1.setBytesArr(bytes);
                    testClass2.method3(i, currTestClass1);

                    return true;
                }
                currIndex++;
            }
        }

        return false;
    }

    public boolean method13(int index){
        for (int i = length1+(K-length1)/2; i < K; i++) {
            TestClass1 currTestClass1 = testClass2.method2(i);
            byte[] bytes = currTestClass1.getBytesArr();
            if (bytes[0]==-1){
                return false;
            }

            int currIndex = 0;
            for (int j = 0; j < B; j+=length2) {
                if (bytes[j] == -1){
                    break;
                }

                if (currIndex == index){
                    for (int k = j; k < j + length2; k++) {
                        bytes[k] = -3;
                    }
                    currTestClass1.setBytesArr(bytes);
                    testClass2.method3(i, currTestClass1);
                    return true;
                }

                currIndex++;
            }
        }
        return false;
    }

    public ArrayList<TestClass4> method14(){
        ArrayList<TestClass4> list = new ArrayList<>();
        for (int i = length1+(K-length1)/2; i < K; i++) {
            TestClass1 currTestClass1 = testClass2.method2(i);
            byte[] bytes = currTestClass1.getBytesArr();
            if (bytes[0]==-1){
                break;
            }

            for (int j = 0; j < B; j++) {
                if (bytes[j] == -1){
                    break;
                }

                if (bytes[j] == -3){
                    Integer[] fakeAddrs = new Integer[3];
                    Arrays.fill(fakeAddrs, -1);
                    list.add(new TestClass4(-1, fakeAddrs));
                    j = j + length2-1;
                    continue;
                }

                int p = 0;
                ArrayList<Byte> currLength = new ArrayList<>();
                while ((bytes[j + p] != -2 && p != 4)){
                    currLength.add(bytes[j + p]);
                    p++;
                }

                byte[] lengthBytes = new byte[currLength.size()];
                for (int m = 0; m < lengthBytes.length; m++) {
                    lengthBytes[m] = currLength.get(m);
                }
                String lenStr = new String(lengthBytes, StandardCharsets.UTF_8);
                int length = Integer.parseInt(lenStr);

                ArrayList<Integer> abstrAddrs = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                    int l = 0;
                    ArrayList<Byte> currAddress = new ArrayList<>();
                    while (bytes[j + 4 + (k*4) + l] != -2 && l != 4){
                        currAddress.add(bytes[j + 4 + (k*4) + l]);
                        l++;
                    }

                    if (currAddress.size() != 0){
                        byte[] addrBytes = new byte[currAddress.size()];
                        for (int m = 0; m < addrBytes.length; m++) {
                            addrBytes[m] = currAddress.get(m);
                        }
                        String addressStr = new String(addrBytes, StandardCharsets.UTF_8);
                        int addr = Integer.parseInt(addressStr);
                        abstrAddrs.add(addr);
                    } else {
                        abstrAddrs.add(-1);
                    }
                }

                Integer[] addresses = new Integer[abstrAddrs.size()];
                for (int k = 0; k < addresses.length; k++) {
                    addresses[k] = abstrAddrs.get(k);
                }

                list.add(new TestClass4(length, addresses));

                j = j + length2-1;
            }
        }
        return list;
    }


    public int method15(String fileName){
        ArrayList<TestClass3> list = method8();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFileName().equals(fileName)){
                index = list.get(i).getIndex();
                return index;
            };
        }
        return index;
    }

    public int getB() {
        return B;
    }

    public byte[] getTestClass2(int index){
        return testClass2.method2(index + K).getBytesArr();
    }

    public void setTestClass2(int index, byte[] bytes){
        TestClass1 testClass1 = testClass2.method2(index + K);
        testClass1.setBytesArr(bytes);
        testClass2.method3(index + K, testClass1);
    }

    public void method19() throws IOException {
        testClass2.method1();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Final method".intern());
    }
}
