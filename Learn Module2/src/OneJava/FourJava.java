package OneJava;

import java.util.Scanner;

public class FourJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a: ");
        double a = sc.nextDouble();
        System.out.println("Nhập b: ");
        double b = sc.nextDouble();
        System.out.println("Nhập c: ");
        double c = sc.nextDouble();
        perform(a,b,c);
    }
    public static void perform(double a, double b, double c){
        double result;


        if (a != 0){
            result = (c - b) / a;
            System.out.println(result);
        }
        else
            if (b == c){
                System.out.println("a");
            }
            else {
                System.out.println("no result");
            }

    }
}
