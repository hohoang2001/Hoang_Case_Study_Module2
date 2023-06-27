package Utils;

import Models.Clazz;
import Models.Module;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtils {
    private static final List<Clazz> clazzList;

    static {
        try {
            clazzList = (List<Clazz>) FileUtils.deserialize("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Clazz.txt");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static final List<Module> moduleList;

    static {
        try {
            moduleList = (List<Module>) FileUtils.deserialize("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Module.txt");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

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
    public static String retryNameClazz() {
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
                name = true;
            } catch (Exception e) {
                System.out.println("Tên không hợp lệ");
            }
        }
        while (!name);
        return fieldName;
    }

    public static String retryPosition() {
        boolean name = false;
        String fieldName;
        do {
            System.out.printf("%-18s %-18s", "Giáo Viên", "Giáo Vụ");
            fieldName = scanner.nextLine();
            try {
                if (fieldName.isEmpty()) {
                    System.out.println("Chức Vụ không được để trống");
                    System.out.println(" Nhập lại ⭆ ");
                    continue;
                }
                if (!isValidName(fieldName)) {
                    System.out.println("Chức Vụ không chứa ký tự số");
                    System.out.println(" Nhập lại ⭆ ");
                    continue;
                }
                name = true;
            } catch (Exception e) {
                System.out.println("Chức vụ không hợp lệ");
            }
        }
        while (!name);
        return fieldName;
    }

    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String email() {
        String email = null;
        do {
            email = scanner.nextLine();
            try {
                if (!isValidEmail(email)) {
                    System.out.println("Email không hợp lệ ");
                    System.out.println("Vui lòng nhập email bằng cú pháp recipient@example.com ");
                    System.out.println("Nhập lại ⭆");
                    continue;
                }
                if (email.isEmpty()) {
                    System.out.println("Email không được để tống");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Email không hợp lệ");
            }
        }
        while (true);
        return email;
    }

    public static double Point() {
        double option;
        double min = 0.0;
        double max = 100.0;
        do {
            System.out.print(" ⭆ ");
            try {
                option = Double.parseDouble(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Nhập điểm sai vui lòng nhập số điểm từ 0 => 100");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Nhập điểm sai vui lòng nhập số điểm từ 0 => 100");
            }
        } while (true);
        return option;
    }

    public static int retryChooseModule() {
        int option;
        int min = 0;
        int max = 6;
        do {
            try {
                System.out.print(" ⭆ ");
                option = Integer.parseInt(scanner.nextLine());
                for (Module module:moduleList) {
                    if (module.getIdModule() == option){
                        break;
                    }
                }
                if (option > max || option < min) {
                    System.out.println("Bạn nhập sai Module vui lòng nhập lai");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Bạn nhập sai vui lòng nhập id Module bằng số");
            }
        } while (true);
        return option;
    }
    public static int retryChoosePrincipal() {
        int option;
        int min = 0;
        int max = 15;
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
    public static int retryChoose2() {
        int option;
        int min = 0;
        int max = 11;
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

    public static int delete() {

        int id;
        do {
            try {

                id = Integer.parseInt(scanner.nextLine());
                if (id < 0) {
                    System.out.println("Mã sinh viên phải lớn hơn 0");
                    System.out.print("Nhập Lại ⭆ ");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Bạn nhập sai mã sinh viên vui lòng nhập bằng chữ số");
                System.out.print("Nhập Lại ⭆ ");
            }

        }
        while (true);
        return id;
    }
    public static int seachClazzId() {
        int id;
        do {
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id < 0) {
                    System.out.println("Mã Lớp phải lớn hơn 0");
                    System.out.print("Nhập Lại ⭆ ");
                    continue;
                }
                if (id > 0){
                    for (Clazz clazz:clazzList) {
                        if (clazz.getClazzId() == id){
                            return id;
                        }
                    }
                    System.out.println("Mã Lớp Không Có ");
                    System.out.print("Nhập Lại ⭆ ");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Bạn nhập sai mã Lớp vui lòng nhập bằng chữ số");
                System.out.print("Nhập Lại ⭆ ");
            }

        }
        while (true);
        return id;
    }
    public static int seachTeacherId() {
        int id;
        do {
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id < 0) {
                    System.out.println("Mã Giáo viên phải lớn hơn 0");
                    System.out.print("Nhập Lại ⭆ ");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Bạn nhập sai mã Giáo Viên vui lòng nhập bằng chữ số");
                System.out.print("Nhập Lại ⭆ ");
            }

        }
        while (true);
        return id;
    }

    public static int dayOfBird() {
        int currentYear = LocalDate.now().getYear();
        int dayBird;
        do {
            try {

                dayBird = Integer.parseInt(scanner.nextLine());
                if (dayBird > currentYear || dayBird < currentYear - 120) {
                    System.out.println("Năm sinh không thể lớn hơn hoặc nhỏ hơn 120 so với năm hiện tại");
                    System.out.print("Nhập Lại ⭆ ");
                    continue;
                }
                break;
            } catch (Exception ex) {
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

    public static int retryChoose() {
        int option;
        int min = 0;
        int max = 2;
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



    public static String retryClasss(int idClass) {
        for (Clazz clazz : clazzList) {
            if (clazz.getClazzId() == idClass) {
                return clazz.getName();
            }
        }
        return "Không Có Lớp";

    }

    public static String retryClass(String fieldName) {
        boolean clazz = false;

        do {

            try {
                if (fieldName.isEmpty()) {
                    System.out.println("Lớp không được để trống");
                    System.out.println(" Nhập lại ⭆ ");
                    continue;
                }
                clazz = true;
            } catch (Exception e) {
                System.out.println("Lớp không hợp lệ");
            }
        }
        while (!clazz);
        return fieldName;
    }

    public static String phone() {
        String phone = null;
        do {
            phone = scanner.nextLine();
            try {
                if (!checkPhone(phone)) {
                    System.out.println("Số điện thoại không hợp lệ");
                    System.out.println("Vui lòng nhập Số điện thoại bằng 10 số");
                    System.out.println("Nhập lại ⭆");
                    continue;
                }
                if (phone.isEmpty()) {
                    System.out.println("Số điện thoại không được để trống");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Số điện thoại không hợp lệ");
            }
        }
        while (true);
        return phone;
    }

    public static boolean checkPhone(String number) {
        String pattern = "^(\\+?84|0)(3[2-9]|5[2689]|7[06789]|8[1-689]|9[0-46-9])[0-9]{7}$";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(number);

        return matcher.matches();
    }
    public static String partition(){
        boolean name = false;
        String Partition;
        do {
            System.out.println("Bạn muốn tạo tài khoản cho sinh viên hay là giáo viên  ");
            System.out.println("Teacher/Student");
         Partition = scanner.nextLine();
            try {
                if (Partition.isEmpty()) {
                    System.out.println("Không được để trống");
                    System.out.println(" Nhập lại ⭆ ");
                    continue;
                }
                if (!isValidName(Partition)) {
                    System.out.println("Chức Vụ không chứa ký tự số");
                    System.out.println(" Nhập lại ⭆ ");
                    continue;
                }
                if (Partition.equals("Teacher") || Partition.equals("Student")){
                    name = true;
                }

            } catch (Exception e) {
                System.out.println("Chức vụ không hợp lệ");
            }
        }
        while (!name);
        return Partition ;
    }


}
