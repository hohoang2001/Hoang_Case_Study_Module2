package LoopJava;

import java.util.Scanner;

public class ShowPicture {
    public static void main(String[] args) {
        showMenu();
    }
    public static void showMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************");
        System.out.println("1. In hình chữ nhật");
        System.out.println("2. In hình tam giác vuông ở 4 góc khác nhau: trên-trái, trên-phải, dưới-trái, dưới-phải");
        System.out.println("3. In hình tam giác cân");
        System.out.println("4. In hình tam giác cân ngược");
        System.out.println("0. Thoát chương trình");
        int choise = sc.nextInt();
       do {
           switch (choise){
               case 1:
                   for (int i = 0; i < 4; i++){
                       for (int j = 0; j <= 15; j++){
                           System.out.print("*");
                       }
                       System.out.println();
                   }
                   break;
               case 2:
                   System.out.println("1. In hình tam giác vuông  botton-left");
                   System.out.println("2. In hình tam giác vuông  ");
                   System.out.println("3. In hình tam giác vuông  top-left   ");
                   System.out.println("4. In hình tam giác vuông  top-right   ");
                   System.out.println("0. Quay chương trình");
                   int choise1 = sc.nextInt();

                   switch (choise1){
                       case 1:
                           for (int i = 1; i <= 9; i++){
                               for (int j = 1; j < i; j++){
                                   System.out.print("*");
                               }
                               System.out.println();
                           }
                           break;
                       case 2:
                           int n =5;
                           for (int i = 1; i <= n ; i++) {
                               for (int j = 1; j <= n-i; j++){
                                   System.out.print(" ");
                               }
                               for (int k = 1; k <= i; k++ ){
                                   System.out.print("*");
                               }
                               System.out.println();

                           }
                           break;
                       case 3:
                           for (int i = 7;i >= 1; i-- ){
                               for (int j = 1; j <= i; j++){
                                   System.out.print("*");
                               }
                               System.out.println();
                           }
                           break;
                       case 0:
                          showMenu();
                           break;

                   }
                   break;
               case 4:
                   int height = 7;
                   for (int i =1; i < height; i++){
                       for (int j = 0; j < height - i - 1; j++ ){
                           System.out.print(" ");
                       }
                       for (int k = 1; k < 2 * i; k++){
                           System.out.print("*");
                       }
                       System.out.println();
                   }
                   break;
               case 5:
                   int bottom = 7;
                   for (int i = 1; i <= bottom; i++){
                       for (int j = 1; j < i; j++){
                           System.out.print(" ");
                       }
                       for (int k =1; k <= 2 * (bottom - i) + 1; k++){
                           System.out.print("*");
                       }
                       System.out.println();
                   }
                   break;
           }
       }
       while (choise!=0);
    }
}
