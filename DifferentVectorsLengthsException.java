import java.util.ArrayList;

public class DifferentVectorsLengthsException extends Exception {
    private ArrayList<Integer> vectors;

    public DifferentVectorsLengthsException(String message, ArrayList<Integer> data) {
        super(message);
        vectors = data;
    }
    
    public ArrayList<Integer> getSize(){
        return vectors;
    }
}
