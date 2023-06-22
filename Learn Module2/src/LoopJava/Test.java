package LoopJava;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in ra");
        int number = sc.nextInt();
        int count=0;
        int N=2;
        while (count < number) {
            if (check(N)){
                System.out.println("số nguyên tố "+ N);
                count++;
            }
            N++;
        }
    }
    public static boolean check(int number){
        if (number < 2){
           return false;
        }
        for (int i = 2; i < number; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
