package cop2805;

public class HomeWork1 {
    static double basePay = 5000;

    /*This method takes two vales and prints them to the console
    * based on value of "sales". This ensures proper formatting.*/
    public static void print(double sales, double income){

        if(sales>=10000) {
            System.out.printf("$%.2f         $%.2f\n",sales,income);
        }else{
            System.out.printf("$%.2f          $%.2f\n",sales,income);
        }
    }

    /*Tiered base calculation based on the sales value passed.*/
    public static double calculateIncome(double sales){
        double income=0;
        if(sales<=5000){
            income = sales * 0.08;
        }else if (sales>5000 && sales <=10000){
            income = (5000 * 0.08)+((sales-5000) * 0.1);
        }else if(sales>10000 ){
            income = (5000 * 0.08)+(5000 * 0.1)+((sales-10000)*0.12);
        }
        return income+basePay;
    }

    public static void main(String[] args) {

        double income;
        System.out.println("Sales             Income"); //prints the colum header

        /* loops from 1000 to 20000 in 1000-step increments*/
        for(int i= 1000;i<=20000;i+=1000) {
            income = calculateIncome(i); // Calls the calculateIncome method
            print(i, income); // calls the print method

        }
    }
}