package cop2805;

public class HomeWork3 {

    /*This Method find the minimum elements in an Array that is passes when called*/
    public static <E extends Comparable<E>> E min(E[] data){
        E minElement = data[0];

        // If the next element is smaller than the current element the element is updated to the new smallest.
        for(int i=1;i<data.length;i++) {
            if (minElement.compareTo(data[i]) > 0) {
                minElement = data[i];
            }
        }
        return minElement;
    }

    public static void main(String[] args) {
        // create the arrays to be passed
        String[] colors = {"Red","Green","Blue"};
        Integer[] numbers = {1, 2, 3};
        Double[] circleRadius = {3.0, 5.9, 2.9};

        // passes the Arrays in to the min method and print the results with some formatting
        System.out.println("Colors: " +min(colors));
        System.out.println("Numbers: " +min(numbers));
        System.out.println("Circle Radius: "+min(circleRadius));
    }
}