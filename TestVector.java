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
                correctVectors = true;
            } catch (DifferentVectorsLengthsException e) {
                String comparison = e.getVectorLength1() > e.getVectorLength2() ? "bigger" : "smaller";
                System.out.println("Vector " + e.getIndxvalue1() + " lenght is equal " + e.getVectorLength1());
                System.out.println("Vector " + e.getIndxvalue2() + " lenght is equal " + e.getVectorLength2());
                System.out.println("The vector " + e.getIndxvalue1() + " is " + comparison + " than vector" + e.getIndxvalue2());
            
                vectors = MyVector.enterInput(scanner, args);
            }
        }
        
    }
}