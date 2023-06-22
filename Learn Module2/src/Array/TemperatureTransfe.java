package Array;

import java.util.Scanner;

public class TemperatureTransfe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choise;
        do {
            System.out.println("Menu");
            System.out.println("1. Chuyển độ C sang độ F");
            System.out.println("2. Chuyển độ F sang độ C");
            System.out.println("0. Thoát chương trình");
            choise = sc.nextInt();
            switch (choise){
                case 1:
                    System.out.println("Nhập độ C");
                    double celsius = sc.nextDouble();
                    System.out.println(celsiusToFahrenheit(celsius));
                    break;
                case 2:
                    System.out.println("Nhập độ F");
                    double fahrenheit = sc.nextDouble();
                    System.out.println(fahrenheitToCelsius(fahrenheit));
                    break;
            }
        }
        while (choise!= 0);
    }
    public static double celsiusToFahrenheit(double celsius){
        return (9.0 / 5) * celsius + 32;

    }
    public static double fahrenheitToCelsius(double fahrenheit){
        return (5.0 / 9) * (fahrenheit - 32);
    }
}
