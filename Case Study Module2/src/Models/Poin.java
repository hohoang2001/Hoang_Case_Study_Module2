package Models;

import Sv.*;
import Utils.FileUtils;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Poin implements IModel, Serializable {
    private static final long serialVersionUID = -1322322139926390329L;
    private int studentId;
    private int idClazz;
    private int idModule;
    private double enforcement; // thực hành
    private double theory; // lý thuyết
    private double casePoint; // case study
    private double interviewPoint; // phỏng vấn
    private String isPass; // đã đậu hay chưa
    LocalDate date;

    public Poin() {

    }
//    public Poin(int idModule, double enforcement, double theory, double casePoint, double interviewPoint, String isPass, LocalDate date) {
//        this.idModule = idModule;
//        this.enforcement = enforcement;
//        this.theory = theory;
//        this.casePoint = casePoint;
//        this.interviewPoint = interviewPoint;
//        this.isPass = isPass;
//        this.date = date;
//    }
    public Poin(int studentId, int idClazz, int idModule, double enforcement, double theory, double casePoint, double interviewPoint, String isPass, LocalDate date) {
        this.studentId = studentId;
        this.idClazz = idClazz;
        this.idModule = idModule;
        this.enforcement = enforcement;
        this.theory = theory;
        this.casePoint = casePoint;
        this.interviewPoint = interviewPoint;
        this.isPass = isPass;
        this.date = date;
    }



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getIdClazz() {
        return idClazz;
    }

    public void setIdClazz(int idClazz) {
        this.idClazz = idClazz;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public double getEnforcement() {
        return enforcement;
    }

    public void setEnforcement(double enforcement) {
        this.enforcement = enforcement;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getCasePoint() {
        return casePoint;
    }

    public void setCasePoint(double casePoint) {
        this.casePoint = casePoint;
    }

    public double getInterviewPoint() {
        return interviewPoint;
    }

    public void setInterviewPoint(double interviewPoint) {
        this.interviewPoint = interviewPoint;
    }

    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return studentId + "," +
                idClazz + "," +
                idModule + "," +
                enforcement + "," +
                theory + "," +
                casePoint + "," +
                interviewPoint + "," +
                isPass + "," +
                date;
    }

    @Override
    public void parseData(String line) {
        String[] item = line.split(",");
        this.studentId = Integer.parseInt(item[0]);
        this.idClazz = Integer.parseInt(item[1]);
        this.idModule = Integer.parseInt(item[2]);
        this.enforcement = Double.parseDouble(item[3]);
        this.theory = Double.parseDouble(item[4]);
        this.casePoint = Double.parseDouble(item[5]);
        this.interviewPoint = Double.parseDouble(item[6]);
        this.isPass = item[7];
        this.date = LocalDate.parse(item[8]);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Account();
        List<User> users = Account.users;
        FileUtils.serialize(users, "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/Data/Account.txt");
        Object studentList = FileUtils.deserialize("demo.txt");

    }
}
