package OneJava;

import java.util.Scanner;

public class ReadNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số muốn đọc");
        int number = sc.nextInt();
        if (number >= 0 && number <10) {
            switch (number){
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
        }
        if (number >= 10 && number < 20){
            int numbers = number %   10;
            String numberString;
            switch (numbers){
                case 0:
                    numberString = "Ten";
                    break;
                case 1:
                    numberString = "Eleven";
                    break;
                case 2:
                    numberString = "Twelve";
                    break;
                case 3:
                    numberString = "Thirteen";
                    break;
                case 4:
                    numberString = "Fourteen";
                    break;
                case 5:
                    numberString = "Fifteen";
                    break;
                case 6:
                    numberString = "Sixteen";
                    break;
                case 7:
                    numberString = "Seventeen";
                    break;
                case 8:
                    numberString = "Eighteen";
                    break;
                case 9:
                    numberString = "Nineteen";
                    break;
                default:
                    numberString = "";
            }
            System.out.println(numberString);
        }

    }
}
