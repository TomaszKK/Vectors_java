import java.util.ArrayList;
import java.util.Scanner;

public class TestVector{
    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<MyVector> vectors = new ArrayList<MyVector>();
        vectors = MyVector.enterInput(scanner);
        
        boolean correctVectors = false;
        while(!correctVectors){
            try {
                MyVector sum = MyVector.addVectors(vectors);
                MyVector.printVect(sum);
                scanner.close();
                correctVectors = true;
            } catch (DifferentVectorsLengthsException e) {
                System.out.println(e.getMessage());
                System.out.println("The " + e.getDataException()[1] + " vector length is " + e.getDataException()[0]);
                System.out.println("The " + e.getDataException()[1] + " vector length is " + e.getDataException()[3] + " than the " + e.getDataException()[2] + " vector length");
                vectors = MyVector.enterInput(scanner);
            }
        }
        
    }
}