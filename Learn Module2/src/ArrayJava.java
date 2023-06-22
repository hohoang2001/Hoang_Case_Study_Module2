import java.util.Scanner;

public class ArrayJava {
    public static void main(String[] args) {
        reverse();
    }
    public static void reverse(){
        Scanner sc = new Scanner(System.in);
        int[] arr;
        System.out.println("Nhập kích thước mảng");
        int size = sc.nextInt();
        if (size <= 20){
            arr = new int[size];
            int i =0;
            while (i < arr.length){
                System.out.println("Nhập phần tử ở vị trí: " + (i+1 ));
                arr[i] = sc.nextInt();
                i++;
            }
            for (int k : arr) {
                System.out.print(k + ", ");
            }
            System.out.println();
            for (int f = 0; f < arr.length / 2; f++){
                int temp = arr[f];
                arr[f] = arr[size-1-f];
                arr[size-1-f] = temp;
            }
            for (int j : arr) {
                System.out.print(j + ", ");
            }
        }

    }
}
