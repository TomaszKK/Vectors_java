
public class DifferentVectorsLengthsException extends Exception {
    private int vectorLength1;
    private int vectorLength2;
    private int indxvalue1;
    private int indxvalue2;

    public DifferentVectorsLengthsException(String message, int indxvalue1, int vectorLength1, int indxvalue2, int vectorLength2) {
        super(message);
        this.vectorLength1 = vectorLength1;
        this.vectorLength2 = vectorLength2;
        this.indxvalue1 = indxvalue1;
        this.indxvalue2 = indxvalue2;
    }
    
    public int getVectorLength1() {
        return vectorLength1;
    }

    public int getVectorLength2() {
        return vectorLength2;
    }

    public int getIndxvalue1() {
        return indxvalue1 + 1;
    }

    public int getIndxvalue2() {
        return indxvalue2 + 1;
    }


    /* 
    private int[] data;

    public DifferentVectorsLengthsException(String message, int[] data) {
        super(message);
        this.data = new int[data.length];

        for(int i = 0; i < data.length; i++){
            this.data[i] = data[i];
        }
    }

    public void printMessage1(){
        System.out.println(getMessage());
    }

    public void printMessage2(){
        System.out.println("The vector " + data[0] + " has " + data[1] + " elements");
    }

    public DifferentVectorsLengthsException(String message, int[] data) {
        super(message);
        this.data = new int[data.length];
        for(int i = 0; i < data.length; i++){
            this.data[i] = data[i];
        }
    }

    public String getValueException(int vectindx){
        String text = "The vector " + vectindx + " has " + data[vectindx] + " elements";
        return text;
    }

    public String getDataException(int vectindx1, int vectindx2) {
        String text ;
        if(data[vectindx1] > data[vectindx2]){
            text = "The vector " + vectindx1 + " lenght is bigger than " + vectindx2 + " vector";
        }else if(data[vectindx1] < data[vectindx2]){
            text = "The vector " + vectindx1 + " lenght is smaller than " + vectindx2 + " vector lenght";
        }else{  
            text = "The vector " + vectindx1 + " lenght is equal to " + vectindx2 + " vector lenght";
        }
        return text;
    }

    */
}
