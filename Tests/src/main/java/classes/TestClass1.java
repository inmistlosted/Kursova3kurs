package classes;

public class TestClass1 {
    private int B;
    private byte[] bytes;
    public String string;

    public TestClass1(int B){
        this.B = B;
        bytes = new byte[B];
        bytes[0] = -1;
    }

    public byte[] getBytesArr(){
        return bytes;
    }

    public void setBytesArr(byte[] bytes) {
        this.bytes = bytes;
    }
}
