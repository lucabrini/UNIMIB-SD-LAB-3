package third_lab.first_exercise;

public class SharedObject {

    private int numWrite;
    private String lastWriter;

    public int getNumWrite() {
        return numWrite;
    }

    public void incrementNumWrite() {
        numWrite++;
    }

    public String getLastWriter() {

        return lastWriter;
    }

    public void setLastWriter(String lastWriter) {
        this.lastWriter = lastWriter;
    }

}
