package Sv;

import Utils.AppUtils;
import Utils.FileUtils;
import Models.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static views.ProducView.menu;

public class Account {
    Scanner scanner = new Scanner(System.in);
    public static List<User> users;
    static String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.txt";

    public Account() throws IOException, ClassNotFoundException {
        users = (List<User>) FileUtils.deserialize(PATH);
//        users = FileUtils.readFile(PATH,User.class);
    }


    public static boolean CheckNameAccount(String Name) {
        for (User user : users) {
            if (Name.equals(user.getUseName())) {
                return true;
            }
        }
        return false;
    }

    public void inUser() {
        System.out.println("Bạn muốn xem tài khoản của: Student/Teacher");
        String userss = scanner.nextLine();
        System.out.printf("%-10s %-15s\n", "Tài Khoản", "Mật Khẩu");
        for (User user : users) {
            if (user.getPartition().equals(userss)){
                System.out.printf("%-10s %-15s\n", user.getUseName(), user.getPassWord());
            }
            if (user.getPartition().equals(userss)){
                System.out.printf("%-10s %-15s\n", user.getUseName(), user.getPassWord());
            }
        }
    }
    public void registerAccount() {
        Scanner scanner = new Scanner(System.in);
        String path = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.txt";
        try {
            List<User> userSVS = (List<User>) FileUtils.deserialize(path);
            User user = new User();
            do {
                user.setPartition(AppUtils.partition());
                System.out.println("Nhập Tài Khoản");
                String useNew = scanner.nextLine();
                if (CheckNameAccount(useNew)) {
                    System.out.println("Tài khoản đã tồn tại");
                    continue;
                }
                user.setUseName(useNew);
                break;
            }
            while (true);
            System.out.println("Nhập Mật Khẩu");
            do {
                String passNew = scanner.nextLine();
                int lenght = 10;
                if (passNew.length() > lenght) {
                    System.out.println("Vui Lòng Nhập Độ Dài Mật Khẩu 10 Ký Tự");
                    System.out.println("Nhập Lại");
                    continue;
                }

                user.setPassWord(passNew);
                break;
            }
            while (true);
            userSVS.add(user);
            FileUtils.serialize(users,PATH);
            System.out.println("Đăng Ký Tài Khoản Thành Công");
            menu();
        } catch (IOException e) {
            System.out.println("Lỗi Không Thể Tạo Tài Khoản");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}
