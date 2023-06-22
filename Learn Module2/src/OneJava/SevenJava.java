package OneJava;

import java.util.Scanner;

public class SevenJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều cao");
        double height = sc.nextDouble();
        System.out.println(" Nhập cân nặng");
        double weight = sc.nextDouble();
        check(height,weight);

    }
    public static void check(double height, double weight){
        double BMI = weight / height / height;
        if (BMI < 18.5){
            System.out.println("Còi xương");
        }
        else if (BMI < 25.0){
            System.out.println("Bình thường");
        }
        else if (BMI < 30.0){
            System.out.println("Thừa cân");
        }
       else {
            System.out.println(" Béo phì");
        }
    }

}
