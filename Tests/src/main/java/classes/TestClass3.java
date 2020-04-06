package classes;

public class TestClass3 {
    private String fileName;
    private int Index;

    public TestClass3(String fileName, int index){
        this.Index = index;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public int getIndex() {
        return Index;
    }
}
