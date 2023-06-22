package OneJava;

import java.util.Scanner;

public class SixJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập năm bạn muốn kiểm tra: ");
        int year = sc.nextInt();
       check(checkYear(year),year);

    }
    public static boolean checkYear(int year){
        boolean check = false;
       boolean year4 =  year % 4 ==0;
        if (year4){
            boolean year100 =  year % 100 == 0;
                    if(year100){
                        boolean year400 =  year % 400 == 0;
                        if (year400){
                            check = true;
                        }
                    }
                    else{
                        check = true;
                    }
        }
        else {
            check = false;

        }
        return check;

    }
    public static void check(boolean check, int year){
        if (check){
            System.out.println(year +  " Năm nhuận");
        }
        else
            System.out.println( year + " Năm không nhuận");


    }
}
