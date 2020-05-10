package classes;

public class TestClass1 {
    private int B;
    private byte[] bytes;
    public String string;
    private boolean ready;

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

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public synchronized double act() {
        if (!isReady())
            throw new IllegalStateException();
        int a = 45;
        int b = 90;
        double c = a * B - b + Math.pow(a, 3);
        return c;
    }

    public synchronized void bad(TestClass1 test) {
        if (test.isReady()) {
            double num = test.act();
        }
    }
}
