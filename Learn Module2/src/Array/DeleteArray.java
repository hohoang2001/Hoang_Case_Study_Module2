package Array;

import java.util.Arrays;

public class DeleteArray {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 3;
        arr[1] = 4;
        arr[2] = 9;
        arr[3] = 4;
        arr[4] = 7;
        for (int i = 0; i < deleteArray(arr, 4).length; i++) {
            System.out.println(deleteArray(arr, 4)[i]);
        }
    }

    public static int[] deleteArray(int arr[], int index) {
        for (int i = 0; i < arr.length; i++) {
            if (index == arr[i]) {

                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[index] = 0;
            }


        }

        return Arrays.copyOf(arr, arr.length);

    }
}
