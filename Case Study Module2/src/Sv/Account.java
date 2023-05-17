package Sv;

import Utils.FileUtils;
import models.HocSinh;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<User> users;
    private final String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.csv";
    public List<User> allUser(){
        return  FileUtils.readFile(PATH, User.class);
    }

    public void inUser(){
        System.out.printf("%-10s %-15s\n", "Tài Khoản", "Mật Khẩu");
        for (User user: allUser()) {
            System.out.printf("%-10s %-15s\n", user.getUseName(), user.getPassWord());
        }
    }
    public boolean CheckNameAccount(String Name){
        List<User> users = allUser();
        for (User user:users) {
            if (Name.equals(user.getUseName())){
                return true;
            }
        }
        return false;
    }
}
