package cop2805;
import java.util.*;

public class HomeWork7
{
    public static void main(String[] args)  {
        int n = 50;
        RecursionThread recursionThread = new RecursionThread();
        DynamicThread dynamicThread = new DynamicThread();
        recursionThread.start();
        dynamicThread.start();
        recursionThread.n=n;
        dynamicThread.n=n;
        recursionThread.time = System.currentTimeMillis();
        dynamicThread.time = System.currentTimeMillis();
        try{
            recursionThread.join();
            dynamicThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}

class RecursionThread extends Thread{
    public int n;
    public long time;

    public void run(){
        int result = fibonacci(n);
        long newTime = System.currentTimeMillis() - time;
        System.out.println("Recursion Thread found the answer: "+ result+" in "+newTime+"ms");
    }
        public static int fibonacci (int x){
            if(x==0) return x;
            if(x==1) return x;
            return fibonacci(x-1)+fibonacci(x-2);

        }
}
class DynamicThread extends Thread {
    public int n;
    public long time;

    public void run() {
        int result = fibonacci(n);
        long newTime = System.currentTimeMillis() - time;
        System.out.println("Dynamic Thread found the answer: "+ result+" in "+newTime+"ms");
    }
    public static int fibonacci(int n){
        int num1 = 0;
        int num2 = 1;
        int num3 = 0;
        for(int i=2;i<=n;i++){
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }
}
