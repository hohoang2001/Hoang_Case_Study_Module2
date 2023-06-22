package Array;

import java.util.Scanner;

public class SearchArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] List = {"Hoàng", "Long", "Khoa", "Hợp", "Thực"};
        System.out.println("Nhập tên muốn tìm");
        String name = sc.nextLine();
        System.out.println(checkName(name,List));

    }
    public static String checkName(String name, String arr[]){
        int i =0;
        while (i < arr.length){
            if (arr[i].equals(name)){
                return name + " Có vị trí index: " + (i +1);
            }

           i++;
        }

        return "HELLO";
    }


}
