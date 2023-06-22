package Array;

import java.util.Scanner;

public class GreatestValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.println("Nhập kích thước mảng");
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int i = 0; i < arr.length; i++){
                System.out.println("Nhập giá trị của vị trí index: " + (i+1) +" :");
                arr[i]= sc.nextInt();
            }
            int max = arr[0];
            int index = 0;
            for (int j = 1; j < arr.length; j++){
                if (arr[j] > max){
                    max = arr[j];
                    index = (j + 1);
                }
            }
        System.out.println("Số lớn nhất là: " + max + " Nằm vị trí " + index);

    }
}
