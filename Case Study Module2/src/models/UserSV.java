package models;

public class UserSV implements IModel<UserSV> {
    private String useName;
    private String passWord;

    public UserSV(String useName, String passWord) {
        this.useName = useName;
        this.passWord = passWord;
    }

    public UserSV() {
    }
    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    @Override
    public String toString() {
        return useName + "," + passWord;
    }

    @Override
    public void parseData(String line) {
        String[] item = line.split(",");
        this.useName = item[0];
        this.passWord = item[1];

    }
}
