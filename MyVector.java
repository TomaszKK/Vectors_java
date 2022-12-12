import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public static ArrayList<MyVector> enterInput(Scanner scanner, String[] args){
        
        ArrayList<MyVector> vectors = new ArrayList<MyVector>();
        int numberofVectors = enterNumberofVetors(args);
        for(int i = 0; i < numberofVectors; i++){
            vectors.add(enterVector(scanner, i)); 
        }
       
        return vectors;
    }

    private static int enterNumberofVetors(String[] args){
        int numberofVectors = 0;
        try{
            numberofVectors = Integer.parseInt(args[0]);
            return numberofVectors;
        }catch(NumberFormatException e){
            System.out.println("The first argument must be an integer");
            System.exit(0);
        }
        return numberofVectors;
    }

    private static MyVector enterVector(Scanner sc, int vectorIndex){
        System.out.println("Enter vector " + vectorIndex + ": ");
        String vectorString = sc.next();
        MyVector vector = new MyVector(vectorString, vectorIndex);
        return vector;
    }

    private ArrayList<Integer> convertVectorStringValues(String [] inputString){
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
        ArrayList <Integer> data = new ArrayList<Integer>();
        boolean correctVectors = true;
        for (int i = 0; i < vectors.size() - 1; i++) {
            if(vectors.get(i).vect.size() != vectors.get(i + 1).vect.size()){
                correctVectors = false;
                break;
            }
        }

        if( !correctVectors ){
            for (int i = 0; i < vectors.size(); i++) {
                data.add(vectors.get(i).vect.size());
            }
            throw new DifferentVectorsLengthsException("Valid size of vector", data);
        }
    }    

    public static void printVect(MyVector vector){
        System.out.println("The sum of the vectors is: ");
        String vectorString = vector.makeString();
        System.out.println(vectorString);
    }

    private int getLength(){
        return this.vect.size();
    }

    private String makeString(){
        String vectorString = "[";
        int i = 0;
        for (; i < this.getLength() - 1; i++) {
            vectorString += (this.vect.get(i) + ", ");
        }
        vectorString += (this.vect.get(i) + "]\n");
        return vectorString;
    }

    public static void writeToFile(MyVector vector){
        File file = new File("output.txt");
        try {
            FileWriter writer = new FileWriter(file);
            String vectorString = vector.makeString();
            writer.write(vectorString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}