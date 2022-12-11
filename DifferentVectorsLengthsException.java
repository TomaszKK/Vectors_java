
public class DifferentVectorsLengthsException extends Exception {
    private String[] data;

    public DifferentVectorsLengthsException(String message, String[] data) {
        super(message);
        this.data = data;
    }

    public String[] getDataException() {
        return data;
    }
}
