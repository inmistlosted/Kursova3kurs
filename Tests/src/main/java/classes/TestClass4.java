package classes;

public class TestClass4 {
    private int fileLength;
    private Integer[] Nums;

    public TestClass4(int fileLengt, Integer[] nums){
        this.fileLength = fileLength;
        this.Nums = nums;
    }

    public TestClass4(int fileLengt){
        this.fileLength = fileLength;
    }

    public Integer[] getNums() {
        return Nums;
    }

    public int getFileLength() {
        return fileLength;
    }
}
