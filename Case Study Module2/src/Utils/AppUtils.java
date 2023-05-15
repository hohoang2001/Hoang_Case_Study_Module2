package Utils;

import java.time.LocalDate;
import java.util.Scanner;

public class AppUtils {
    static Scanner scanner = new Scanner(System.in);
    public static String retryString() {
        boolean name = false;
        String fieldName;
        do {

            fieldName = scanner.nextLine();
            try {
                if (fieldName.isEmpty()) {
                    System.out.println("Tên không được để trống");
                    System.out.println(" Nhập lại ⭆ ");
                    continue;
                }
                if (!isValidName(fieldName)) {
                    System.out.println("Tên không chứa ký tự số");
                    System.out.println(" Nhập lại ⭆ ");
                    continue;
                }
                name = true;
            } catch (Exception e) {
                System.out.println("Tên không hợp lệ");
            }
        }
        while (!name);
        return fieldName;
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
                    System.out.println("Bạn nhập sai chức năng vui lòng nhập lai");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Bạn nhập sai chức năng vui lòng nhập lại");
            }
        } while (true);
        return option;
    }
    public static int dayOfBird(){
        int currentYear = LocalDate.now().getYear();
        int dayBird;
        do {
            try {

                dayBird = Integer.parseInt(scanner.nextLine());
                if (dayBird > currentYear || dayBird < currentYear - 120){
                    System.out.println("Năm sinh không thể lớn hơn hoặc nhỏ hơn 120 so với năm hiện tại");
                    System.out.print("Nhập Lại ⭆ ");
                    continue;
                }
               break;
            }
            catch (Exception ex){
                System.out.println("Bạn nhập sai năm sinh vui lòng nhập bằng chữ số");
            }

        }
        while (true);
        return dayBird;
    }
    public static boolean isValidName(String name) {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
