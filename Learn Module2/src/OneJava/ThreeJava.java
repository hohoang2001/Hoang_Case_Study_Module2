package OneJava;

import java.util.Scanner;

public class ThreeJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều rộng: ");
        double with = sc.nextDouble();
        System.out.println("Nhập chiều dài");
        double length = sc.nextDouble();
        System.out.println( "diện tích hình chữ nhật là:  " + acreage(with,length));

    }
    public static double acreage(double width, double length){
        return width * length;
    }
}
