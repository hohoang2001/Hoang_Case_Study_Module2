package Sv;

import Utils.FileUtils;
import Models.User;

import java.util.List;
import java.util.Scanner;

public class Account {
    Scanner scanner = new Scanner(System.in);
    private List<User> users;
    private final String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.csv";

    public List<User> allUser() {
        return FileUtils.readFile(PATH, User.class);
    }

    public void inUser() {
        System.out.println("Bạn muốn xem tài khoản của: Student/Teacher");
        String users = scanner.nextLine();
        System.out.printf("%-10s %-15s\n", "Tài Khoản", "Mật Khẩu");
        for (User user : allUser()) {
            if (user.getPartition().equals(users)){
                System.out.printf("%-10s %-15s\n", user.getUseName(), user.getPassWord());
            }
            if (user.getPartition().equals(users)){
                System.out.printf("%-10s %-15s\n", user.getUseName(), user.getPassWord());
            }
        }
    }

    public boolean CheckNameAccount(String Name) {
        List<User> users = allUser();
        for (User user : users) {
            if (Name.equals(user.getUseName())) {
                return true;
            }
        }
        return false;
    }
}
