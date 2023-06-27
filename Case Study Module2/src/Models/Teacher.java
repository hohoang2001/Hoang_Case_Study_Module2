package Models;

import java.io.Serializable;
import java.time.LocalDate;

public class Teacher implements Comparable<Teacher>, IModel, Serializable {
    private static final long serialVersionUID = -1322322139926390329L;

    protected static int maxid = 0;
    protected int teacherId;
    protected String name;
    protected int yearOfBirth;
    protected String phone;
    protected String email;
    protected String position;
    protected String address;
    protected LocalDate dataTime;

    public Teacher() {

    }

    public Teacher(String name, int yearOfBirth, String phone , String email,String address, String position,LocalDate dataTime) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.dataTime = dataTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDate dataTime) {
        this.dataTime = dataTime;
    }

    @Override
    public String toString() {
        return
                teacherId + "," +
                        name + "," +
                        yearOfBirth + "," +
                        phone + "," +
                        email + "," +
                        position + "," +
                        address + "," +
                        dataTime;
    }

    @Override
    public int compareTo(Teacher o) {
        return 0;
    }

    @Override
    public void parseData(String line) {
        String[] item = line.split(",");
        this.teacherId = Integer.parseInt(item[0]);
        this.name = item[1];
        this.yearOfBirth = Integer.parseInt(item[2]);
        this.phone = item[3];
        this.email = item[4];
        this.position = item[5];
        this.address = item[6];
        this.dataTime = LocalDate.parse(item[7]);
    }
}
