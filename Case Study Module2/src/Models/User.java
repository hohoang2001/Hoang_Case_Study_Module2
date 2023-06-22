package Models;

public class User implements IModel<User> {

    private String useName;
    private String passWord;
    private String partition;

    public User() {

    }

    public String getPartition() {
        return partition;
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

    public User(String partition, String useName, String passWord) {
        this.partition = partition;
        this.useName = useName;
        this.passWord = passWord;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }

    @Override
    public String toString() {
        return partition + "," +
                useName + "," + passWord;
    }

    @Override
    public void parseData(String line) {
        String[] item = line.split(",");
        this.partition = item[0];
        this.useName = item[1];
        this.passWord = item[2];

    }
}
