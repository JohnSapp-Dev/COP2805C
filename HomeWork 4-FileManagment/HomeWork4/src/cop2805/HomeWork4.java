package cop2805;
import java.util.*;
import java.io.*;

public class HomeWork4 {

    public static List<Double> ReadFile(String fileName){
        List<Double> data = new ArrayList<>();
        File file = new File(fileName);

        try {
            Scanner input = new Scanner(file);
            // loops through the file adding each line to the ArrayList
            while (input.hasNextLine()) {
                data.add(Double.parseDouble(input.nextLine()));
            }
        // error handling
        }catch (NumberFormatException e) {
            System.err.println("Error: Unable to parse input as a double.");
        }catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }
        return data;
    }

    public static void WriteFile(List<Double> data,String file){

        try {
            //creates a new file with the same name
            PrintWriter output = new PrintWriter(file);
            //loops through the data ArrayList printing the values to the file
            for(double x : data){
                output.println(x);
            }
            output.close();
        // error handling
        }catch(IOException e){
            System.err.printf("Error: %s\n",e);
        }

    }
    public static void main(String[] args) {

        String fileInName = "data.txt"; // name of input file
        String fileOutName = "Sorted_Data.txt";
        List<Double> data;
        data = ReadFile(fileInName);  // saves the result of the method into an Arraylist
        System.out.print("unsorted data");
        System.out.println(data);   //prints to the unsorted data from file to the screen
        Collections.sort(data);
        System.out.print("sorted data");
        System.out.println(data);   //prints to the sorted data from file to the screen
        WriteFile(data,fileOutName);   //calls method to print to the sorted data to the file
    }
}