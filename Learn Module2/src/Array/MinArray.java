package Array;

public class MinArray {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 2;
        arr[1] = 5;
        arr[2] = 1;
        arr[3] = 8;
        arr[4] = 9;
        System.out.println(checkMin(arr));
    }
    public static int checkMin(int arr[]){
        int index = 0;
        int min = arr[index];
        for (int i = 0; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
                index = i;
            }

        }
        System.out.println("vị trí tại " + index);
        return min;
    }


}
