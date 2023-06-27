package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Student implements Comparable<Student>, IModel, Serializable {
    private static final long serialVersionUID = -1322322139926390329L;
    private static int maxid = 0;
    private int studentId;
    private String clazz;
    private String name;
    private String phone;
    private int yearOfBirth;
    private String address;
    private LocalDate dataTime;
    private String status;
    private int clazzId;
    private int moduleId;

    private Clazz clazzStuding;

    private List<Clazz> clazzes;

    public Student() {

    }


    public Student(String name,
                   String clazz,
                   String phone,
                   int yearOfBirth,
                   String address,
                   String status,
                   int clazzId,
                   int moduleId,
                   LocalDate Datatime

    ) {
        this.name = name;
        this.clazz = clazz;
        this.phone = phone;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.status = status;
        this.clazzId = clazzId;
        this.moduleId = moduleId;
        this.dataTime = Datatime;


    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getaddress() {
        return address;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }











    public LocalDate getDataTime() {
        return dataTime;
    }

    public int getClazzId() {
        return clazzId;
    }


    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return
                clazzId + "," +
                        moduleId + "," +
                        studentId + "," +
                        name + "," +
                        clazz + "," +
                        phone + "," +
                        yearOfBirth + "," +
                        address + "," +
                        status + "," +
                        dataTime
                ;
    }

    @Override
    public int compareTo(Student o) {

        return Integer.compare(this.studentId, o.studentId);
    }


    @Override
    public void parseData(String line) {
        String[] item = line.split(",");
        this.clazzId = Integer.parseInt(item[0]);
        this.moduleId = Integer.parseInt(item[1]);
        this.studentId = Integer.parseInt(item[2]);
        this.name = item[3];
        this.clazz = item[4];
        this.phone = item[5];
        this.yearOfBirth = Integer.parseInt(item[6]);
        this.address = item[7];
        this.status = item[8];
        this.dataTime = LocalDate.parse(item[9]);
    }
}
