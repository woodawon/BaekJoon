// Fibonacci sequences
// 0 1 1 2 3 5 8 13 21 34 55 89 144 ...

import java.util.Scanner;

public class Fibonacci_sequences10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(method(sc.nextInt()));
        sc.close();
    }
    public static int method(int num){
        if(num == 0) {
            return 0;
        }
        if(num == 1) {
            return 1;
        }
        return method(num-1) + method(num-2);
    }
}
