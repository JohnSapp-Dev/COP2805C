package cop2805;

import java.util.ArrayList;
import java.util.Collections;

public class HomeWork2 {

    /*A method that prints an ArrayList of doubles that are passed when called*/
    public static void PrintList(ArrayList<Double> list){
        for(double number : list){
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        /*Creates the ArrayList object*/
        ArrayList<Double> list = new ArrayList<>();
        /* Adds the double values to the ArrayList*/
        list.add(1.5);
        list.add(2.35);
        list.add(-4.7);
        list.add(0.01);

        System.out.println("Original List:");
        PrintList(list); //prints the original list

        /*Built in method to sort a Collection*/
        Collections.sort(list);

        System.out.println("\nSorted list");
        PrintList(list); // prints the sorted list

        /*prints the value were looking for and the index where it was found*/
        System.out.println("\nFound 1.5 at index "+ Collections.binarySearch(list,1.5));

        /*Replaces all the values in the ArrayList with 0.0*/
        Collections.fill(list,0.0);
        System.out.println("Zero List:");
        PrintList(list); // prints the new 0.0 list


    }
}