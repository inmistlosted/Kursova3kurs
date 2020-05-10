package classes;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TestClass6 {
    private byte[] buffer;
    public int bufferInt;
    private int Position;
    private int index;
    private int num;
    private int bufferLength;

    public TestClass6(int position, int index){
        this.Position = position;
        this.index = index;
        num = 0;
    }

    public void method1(TestClass5 testClass){
        testClass.setTestClass2(bufferInt, buffer);
        buffer = null;
        bufferInt = -1;
    }

    public void method2(TestClass5 testClass, int index){
        buffer = testClass.getTestClass2(index);
        bufferInt = index;
        bufferLength = buffer.length;
    }

    public void method3(TestClass5 testClass){
        testClass.setTestClass2(bufferInt, buffer);
    }

    public void method4(int position){
        num = position / bufferLength;
        Position = position - num * bufferLength;
    }

    public int getnum() {
        return num;
    }

    public int getindex() {
        return index;
    }

    public void writeInBuffer(byte[] buffer){
        this.buffer = buffer;
    }

    public int getPosition(){
        return bufferLength * num + Position;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getbufferInt() {
        return bufferInt;
    }

    public int getCurrPosInBuffer(){
        return Position;
    }

    public int getBufferLength() {
        return bufferLength;
    }

    public int method5(){
        int length = 0;
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == -1) break;
            length++;
        }
        return length;
    }

    public String method6(){
        ArrayList<Byte> list = new ArrayList<>();
        while (buffer[Position] != -1){
            list.add(buffer[Position]);
            Position++;
            if (Position == buffer.length){
                Position = 0;
                num++;
                break;
            }
        }

        return method8(list);
    }

    public String method7(int count){
        ArrayList<Byte> list = new ArrayList<>();
        while (buffer[Position] != -1 && count != 0){
            list.add(buffer[Position]);
            Position++;
            count--;
            if (Position == buffer.length){
                Position = 0;
                num++;
                break;
            }
        }

        return method8(list);
    }

    private String method8(ArrayList<Byte> bytes){
        byte[] resultBytes = new byte[bytes.size()];
        for (int i = 0; i < resultBytes.length; i++) {
            resultBytes[i] = bytes.get(i);
        }
        String result = new String(resultBytes, StandardCharsets.UTF_8);
        return result;
    }

    private synchronized void method9() {
        if (num < 5)
            throw new IllegalStateException();
        method5();
        method6();
    }

    public synchronized void method10(TestClass6 test) {
        if (test.getnum() >= 5) {
            test.method9();
        }
    }
}
