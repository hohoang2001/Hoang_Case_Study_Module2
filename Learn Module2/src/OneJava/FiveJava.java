package OneJava;

import java.util.Scanner;

public class FiveJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Tháng: ");
        int month = sc.nextInt();
        month(month);
    }
    public static void month(int month){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + month + " có 31 ngày");
                break;
            case 2:
                System.out.println("Tháng " + month + " có thể có 28 đến 29 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng" + month + " có 30 ngày");
                break;
            default:
                System.out.println(" Bạn Nhập sai");
        }
    }
}
