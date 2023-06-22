package LoopJava;

import java.util.Scanner;

public class White {
    public static void main(String[] args) {
        int a;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập số chẵn để dừng vòng lặp");
            a = sc.nextInt();
        }
        while (a % 2 != 0);
    }
}
