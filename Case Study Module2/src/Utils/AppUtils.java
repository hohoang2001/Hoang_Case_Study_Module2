package Utils;

import java.util.Scanner;

public class AppUtils {
    static Scanner scanner = new Scanner(System.in);
    public static String retryString(String fieldName) {
        String result = fieldName;
        while (fieldName.isEmpty()) {
            System.out.printf("%s không được để trống\n", fieldName);
            System.out.print(" ⭆ Nhập Lại ");
        }
        return result;
    }
    public static int Point() {
        int option;
        int min =0;
        int max =10;
        do {
            System.out.print(" ⭆ ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Nhập điểm sai vui lòng nhập số điểm từ 0 => 10");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Nhập điểm sai vui lòng nhập số điểm từ 0 => 10");
            }
        } while (true);
        return option;
    }
    public static int retryChoose2() {
        int option;
        int min =0;
        int max =6;
        do {
            try {
            System.out.print(" ⭆ ");
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Bạn nhập sai chức năng vui lòng nhập lại");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Bạn nhập sai chức năng vui lòng nhập lại");
            }
        } while (true);
        return option;
    }
}
