import java.util.ArrayList;
import java.util.Scanner;

public class TestVector{
    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<MyVector> vectors = new ArrayList<MyVector>();
        vectors = MyVector.enterInput(scanner, args);
        
        boolean correctVectors = false;
        while(!correctVectors){
            try {
                MyVector sum = MyVector.addVectors(vectors);
                MyVector.printVect(sum);
                scanner.close();
                MyVector.writeToFile(sum);
                correctVectors = true;
            } catch (DifferentVectorsLengthsException e) {
                System.out.println(e.getMessage());
                System.out.println("The lenght of vectors are: " + e.getSize());

            
                vectors = MyVector.enterInput(scanner, args);
            }
        }
        
    }
}