package Sv;

import Utils.FileUtils;
import models.User;
import models.UserSV;

import java.util.List;

public class AccountSV {
    private List<UserSV> userSVs;
    private final String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/AccountSv.csv";
    public List<UserSV> allUser(){
        return  FileUtils.readFile(PATH, UserSV.class);
    }
    public boolean CheckNameAccount(String Name){
        List<UserSV> users = allUser();
        for (UserSV user:users) {
            if (Name.equals(user.getUseName())){
                return true;
            }
        }
        return false;
    }

}
