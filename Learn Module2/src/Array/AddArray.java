package Array;

public class AddArray {
    public static void main(String[] args) {
        String A = "hh1hh3hh5h6l5";
        int count = 0;
        for (int i = 0; i < A.length(); i++){

            char a = 'h';
            if (a == A.charAt(i)){
                count++;
            }

        }
        System.out.println(count);
    }


}
