import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyVector{
    private ArrayList<Integer> vect;

    public MyVector(String inputString, int vectorIndex){
        String[] separatedInput = inputString.split(",");
        vect = convertVectorStringValues(separatedInput);
    }

    public MyVector(ArrayList<Integer> vectors) {
        vect = new ArrayList<Integer>();
        for (int i = 0; i < vectors.size(); i++) {
            vect.add(vectors.get(i));
        }
    }

    public static ArrayList<MyVector> enterInput(Scanner scanner){
        
        ArrayList<MyVector> vectors = new ArrayList<MyVector>();
        int numberofVectors = enterNumberofVetors(scanner);
        for(int i = 0; i < numberofVectors; i++){
            vectors.add(enterVector(scanner, i)); 
        }
       
        return vectors;
    }

    private static int enterNumberofVetors(Scanner sc){
        System.out.println("Enter the number of vectors you want to enter: ");
        boolean valid = false;
        int numberofVectors = 0;
        while(!valid){
            try{
                numberofVectors = sc.nextInt();
                valid = true;
            } catch(InputMismatchException e){
                System.out.println("Please enter a valid number");
                sc.nextLine();
            }
        }          
        return numberofVectors;
    }

    private static MyVector enterVector(Scanner sc, int vectorIndex){
        System.out.println("Enter vector " + vectorIndex + ": ");
        String vectorString = sc.next();
        MyVector vector = new MyVector(vectorString, vectorIndex);
        return vector;
    }

    public ArrayList<Integer> convertVectorStringValues(String [] inputString){
        ArrayList<Integer> vectorBuilder = new ArrayList<Integer>(); 
        for(String eachValue:inputString){
            try{
                vectorBuilder.add(Integer.parseInt(eachValue));
            }catch(NumberFormatException e){
                continue;
            }
        }
        return vectorBuilder;
    }
    
    public static MyVector addVectors(ArrayList<MyVector> vectors) throws DifferentVectorsLengthsException{
        MyVector sum = new MyVector(vectors.get(0).vect);
        checkVectorsLengths(vectors);
        for (int i = 1; i < vectors.size(); i++) {
            for (int j = 0; j < vectors.get(i).vect.size(); j++) {
                sum.vect.set(j, sum.vect.get(j) + vectors.get(i).vect.get(j));
            }
        }
        return sum;
    }

    private static void checkVectorsLengths(ArrayList<MyVector> vectors) throws DifferentVectorsLengthsException{
        for (int i = 1; i < vectors.size(); i++) {
            if(vectors.get(i).vect.size() != vectors.get(i - 1).vect.size()){
                throw new DifferentVectorsLengthsException("The vectors have different lengths", dataforException(vectors.get(i - 1), vectors.get(i), i));
            }
        }
    }    

    public static void printVect(MyVector vector){
        System.out.println("The sum of the vectors is: ");
        String vectorString = "[";
        int i = 0;
        for (; i < vector.getLength() - 1; i++) {
            vectorString += (vector.vect.get(i) + ", ");
        }
        vectorString += (vector.vect.get(i) + "]\n");
        System.out.println(vectorString);
    }

    private int getLength(){
        return this.vect.size();
    }

    private static String[] dataforException(MyVector vector1, MyVector vector2, int index){ 
        String[] data = new String[4];
        data[0] = Integer.toString(vector1.getLength());
        data[1] = Integer.toString(index - 1);
        data[2] = Integer.toString(index);
        data[3] = (vector1.getLength() > vector2.getLength()) ? "greater" : "smaller";
        return data;
    }
}