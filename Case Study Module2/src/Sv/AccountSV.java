package Sv;

import Utils.FileUtils;
import Models.User;
import Models.UserSV;

import java.util.List;

public class AccountSV {
    private List<UserSV> userSVs;
    private final String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.csv";

    public List<User> allUser() {
        return FileUtils.readFile(PATH, User.class);
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
