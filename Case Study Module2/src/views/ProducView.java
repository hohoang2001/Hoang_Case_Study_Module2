package views;

import Sv.Account;
import Sv.AccountSV;
import Sv.DanhSachHS;
import Utils.AppUtils;
import models.HocSinh;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class ProducView {
    private static Account account = new Account();
    private static AccountSV accountsv = new AccountSV();
        static Scanner input = new Scanner(System.in);
        static DanhSachHS dssv = new DanhSachHS();
    static boolean exit = false;
    public static void menuHs() throws IOException {
        int choise;
        do {
            System.out.println("      --------------MENU---------------");
            System.out.println("______________________________________________\n" +
                    "|" + "1.	Xem danh sách học sinh.                     |\n" +
                    "|" + "2.	Tìm học sinh theo tên.                      |\n" +
                    "|" + "3.	Số lượng học sinh có trong danh sách.       |\n" +
                    "|" + "0. Quay lại chương trình đăng nhập.            | \n" +
                    "|" + "_____________________________________________  |");
            choise = AppUtils.retryChoose2();
            switch (choise){
                case 1:
                    dssv.inSv();
                    break;
                case 2:
                    dssv.timKiemHs();;
                    break;
                case 3:
                    System.out.println(dssv.laySoLuongHS() + " Học sinh có trong danh sách.");
                    break;
                case 0:
                    System.out.println("Quay lại chương trình đăng nhập");
                    account();
                    break;
            }
        }
        while (choise !=0);
    }
    public static void menu() throws IOException {
        int choise;
        do {
            System.out.println("      --------------MENU---------------");
            System.out.println("______________________________________________\n" +
                    "|" + "1.	Thêm học sinh vào danh sách.                |\n" +
                    "|" + "2.	Tìm học sinh.                               |\n" +
                    "|" + "3.	In học sinh                                 |\n" +
                    "|" + "4.	Sửa thông tin học sinh.                     |\n" +
                    "|" + "5.	Xoá học sinh.                               |\n" +
                    "|" + "6.	Số lượng học sinh có trong danh sách.       |\n" +
                    "|" + "7.	Xem Tài Khoản ADMIN.                        |\n" +
                    "|" + "8. Xếp danh sách điểm từ cao đến thấp          |\n" +
                    "|" + "0. Quay lại chương trình đăng nhập.            | \n" +
                    "|" + "_____________________________________________  |");
            choise = AppUtils.retryChoose2();
            switch (choise) {
                case 1:
                    System.out.println(" ⭆ Nhập Tên ");
                    String name =AppUtils.retryString();
                    System.out.println("⭆ Nhập Năm Sinh: ");
                    int yearOfBirth = AppUtils.dayOfBird();
                    System.out.println("⭆ Nhập địa chỉ: ");
                    String address = input.nextLine();
                    System.out.println("⭆ Nhập điểm trung bình môn Toán học kỳ 1: ");
                    double mathOne = AppUtils.Point();
                    System.out.println("⭆ Nhập điểm trung bình môn Toán học kỳ 2: ");
                    double mathTwo = AppUtils.Point();
                    System.out.println("⭆ Nhập điểm trung bình môn Tếng Anh học kỳ 1: ");
                    double englishOne = AppUtils.Point();
                    System.out.println("⭆ Nhập điểm trung bình môn Tếng Anh học kỳ 2: ");
                    double englishTwo = AppUtils.Point();
                    System.out.println("⭆ Nhập điểm trung bình môn Văn Học học kỳ 1: ");
                    double literatureOne = AppUtils.Point();
                    System.out.println("⭆ Nhập điểm trung bình môn Văn Học học kỳ 2: ");
                    double literatureTwo = AppUtils.Point();
                    double math = dssv.averageSubject(mathOne, mathTwo);
                    double english = dssv.averageSubject(englishOne, englishTwo);
                    double literature = dssv.averageSubject(literatureOne, literatureTwo);
                    dssv.yearRoundAverage(math, english, literature);
                    double RoundAverage = dssv.yearRoundAverage(math, english, literature);
                    LocalDate date = dssv.dataTime();
                    HocSinh sv = new HocSinh(name,
                            yearOfBirth,
                            address,
                            mathOne,
                            mathTwo,
                            englishOne,
                            englishTwo,
                            literatureOne,
                            literatureTwo,
                            RoundAverage,
                            dssv.academicAbility(RoundAverage),
                            date
                    );
                    sv.setStudentId(DanhSachHS.studentId++);
                    dssv.themSv(sv);
                    dssv.saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Hocsinh.csv");
                    break;
                case 2:
                    dssv.timKiemHs();
                    break;
                case 3:
                    dssv.kiemTraDanhSachHS();
                    break;
                case 4:
                    dssv.suaHS();
                    break;
                case 5:
                    dssv.inSv();
                    System.out.println("Nhập mã học sinh muốn xoá: ");
                    dssv.deleteHS(input.nextInt());
                    break;
                case 6:
                    System.out.println(dssv.laySoLuongHS() + " Học sinh có trong danh sách.");
                    break;
                case 7:
                    account.inUser();
                    break;
                case 8:
                    dssv.xepHs();
                    break;
                case 0:
                    System.out.println("Quay lại chương trình đăng nhập");
                    account();
                    break;
            }
        }
        while (choise != 0);
    }
    public void showMenu(){

    }
    public static void account(){

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bạn đã có tài khoản?");
            System.out.println("1 Đã có tài khoản");
            System.out.println("2 Đăng Ký");
            System.out.println("0 Thoát chương trình");
            int Select = AppUtils.retryChoose();

            switch (Select){
                case 1:
                    System.out.println("1 Đăng nhập Tài Khoản Admin");
                    System.out.println("2 Đăng nhập tài khoản sinh viên");
                    System.out.println("0 Quay Lại chương trình");
                    int choose = AppUtils.retryChoose();
                    switch (choose) {
                        case 1:
                            Login();
                            break;
                        case 2:
                            LoginSV();
                            break;
                        case 0:
                            exit = false;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1 Đăng ký Tài Khoản Admin");
                    System.out.println("2 Đăng ký tài khoản sinh viên");
                    System.out.println("0 Quay Lại chương trình");
                    int chossse = AppUtils.retryChoose();
                    switch (chossse){
                        case 1:
                            registerAccount();
                            break;
                        case 2:
                            registerAccountSV();
                            break;
                        case 0:
                            exit = false;
                            break;
                    }
                    break;
                case 0:
                    exit = true;
                    break;
        }

        }
        while (!exit);
    }
    public static boolean Login() {
        boolean loggedIn = false;
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.csv"))) {
            String line;
            boolean found = false;

            System.out.println("Nhập tên đăng nhập: ");
            String username = scanner.nextLine();
            System.out.println("Nhập mật khẩu: ");
            String password = scanner.nextLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    found = true;
                    loggedIn = true;
                    menu();
                    break;
                }
            }

            if (!found) {
                System.out.println("Tài khoản hoặc mật khẩu không đúng.");
                exit = true;
                account();
            }
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể đọc file.");
            exit = true;
            account();
        }

        return loggedIn;
    }
    public static boolean LoginSV() {
        boolean loggedIn = false;
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/AccountSv.csv"))) {
            String line;
            boolean found = false;

            System.out.println("Nhập tên đăng nhập: ");
            String username = scanner.nextLine();
            System.out.println("Nhập mật khẩu: ");
            String password = scanner.nextLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    found = true;
                    loggedIn = true;
                    menuHs();
                    break;
                }
            }

            if (!found) {
                System.out.println("Tài khoản hoặc mật khẩu không đúng.");
                exit = true;
                account();
            }
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể đọc file.");
            exit = true;
            account();
        }

        return loggedIn;
    }
    public static int id = 0;
    public static void registerAccount(){

        Scanner scanner = new Scanner(System.in);
        try(PrintWriter writer = new PrintWriter(new FileWriter("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.csv", true))) {
            do {
                writer.println();
                System.out.println("Nhập Tài Khoản");
                String useNew = scanner.nextLine();
                if (account.CheckNameAccount(useNew)){
                    System.out.println("Tài khoản đã tồn tại");
                    continue;
                }
                writer.print(useNew);
                break;
            }
            while (true);
            System.out.println("Nhập Mật Khẩu");
            do {
                String passNew = scanner.nextLine();
                int lenght = 10;
                if (passNew.length() > lenght){
                    System.out.println("Vui Lòng Nhập Độ Dài Mật Khẩu 10 Ký Tự");
                    System.out.println("Nhập Lại");
                    continue;
                }
                writer.print("," + passNew);
                writer.close();
                break;
            }
            while (true);
            System.out.println("Đăng Ký Tài Khoản Thành Công");
            Login();
        } catch (IOException e) {
            System.out.println("Lỗi Không Thể Tạo Tài Khoản");
        }

    }
    public static void registerAccountSV(){
        Scanner scanner = new Scanner(System.in);
        try(PrintWriter writer = new PrintWriter(new FileWriter("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/AccountSv.csv", true))) {
            do {
                writer.println();
                System.out.println("Nhập Tài Khoản");
                String useNew = scanner.nextLine();
                if (accountsv.CheckNameAccount(useNew)){
                    System.out.println("Tài khoản đã tồn tại");
                    continue;
                }
                writer.print(useNew);
                break;
            }
            while (true);
            System.out.println("Nhập Mật Khẩu");
            do {
                String passNew = scanner.nextLine();
                int lenght = 10;
                if (passNew.length() > lenght){
                    System.out.println("Vui Lòng Nhập Độ Dài Mật Khẩu 10 Ký Tự");
                    System.out.println("Nhập Lại");
                    continue;
                }
                writer.print("," + passNew);
                writer.close();
                break;
            }
            while (true);
            System.out.println("Đăng Ký Tài Khoản Thành Công");
            LoginSV();
        } catch (IOException e) {
            System.out.println("Lỗi Không Thể Tạo Tài Khoản");
        }

    }


}
