package Sv;

import Utils.AppUtils;
import Utils.FileUtils;
import Models.Clazz;
import Models.Student;
import Models.Teacher;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ClazzList {
    private List<Teacher> teachers;
    private static List<Clazz> clazzList;
    private List<Student> students;
    public static int clazzId = 0;
    String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Clazz.csv";
    public ClazzList() {
        this.clazzList = FileUtils.readFile(PATH, Clazz.class);
        clazzId = clazzList.get(clazzList.size() - 1).getClazzId() + 1;
    }
    Scanner input = new Scanner(System.in);

    public void displaySv(int idClass) {
        boolean check = false;
        for (Clazz clazz : clazzList) {
            check = true;
            if (clazz.getClazzId() == idClass) {
                System.out.println(clazz.getName());
                for (Student students : students) {
                    if (students.getClazzId() == clazz.getClazzId()) {
                        System.out.printf("%-10s %-15s %-18s %-18s %-18s %-18s %-25s %-25s \n", "ID", "Tên", "Lớp", "Số điện thoại", "Năm sinh", "Địa chỉ", " Trạng thái", "Thời Gian Thêm");
                        System.out.printf("%-10s %-15s %-18s %-18s %-18s %-18s %-25s %-25s \n", students.getStudentId(), students.getName(), students.getClazz(), students.getPhone(), students.getYearOfBirth(), students.getaddress(), students.getStatus(), students.getDataTime());
                    }
                }
            }
            break;
        }
        if (!check) {
            System.out.println("không tìm thấy lớp có id" + idClass);
        }
    }

    public void displayClazz() {
        for (Clazz clazz : clazzList) {
            System.out.println(clazz.getName());
        }
    }

    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (Student student : students) {
                String line = student.toString();
                writer.write(line);
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String displayTeacher(int id){
        for (Teacher teacher:teachers) {
            if (id == teacher.getTeacherId()){
                return teacher.getName();
            }
        }
        return "Lớp Chưa Có Giáo Viên Quản Lý";
    }
    public void display(){
        System.out.printf("%-18s %-18s \n", "Lớp", "Giáo Viên Quản lý" );
        for (Clazz clazz:clazzList) {
            System.out.printf("%-18s %-18s \n", clazz.getName());
        }
    }
    public void fixClazz(int id){
        for (Clazz clazz:clazzList) {
           if (id == clazz.getClazzId()){
               System.out.println("Nhập Id Giáo Viên Quản lý");
               int idTeacher = input.nextInt();
               clazz.setTeacherId(idTeacher);
           }
        }
    }
    public LocalDate dataTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Ngày Thêm: " + localDate);
        return localDate;
    }
    public void themSv(Clazz clazz) {
        this.clazzList.add(clazz);
    }

    public void addClazz(){
        System.out.println("Nhập Tên Lớp");
        String name = AppUtils.retryNameClazz();
        System.out.println("Nhập Id Giáo Viên Quản lý ");
        int idTeacher = input.nextInt();
        LocalDate date = dataTime();
        Clazz clazz = new Clazz(idTeacher, name,date);
        clazz.setClazzId(clazzId++);
        themSv(clazz);
        saveFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Clazz.csv");

    }
    public void saveFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (Clazz clazz : clazzList) {
                String line = clazz.toString();
                writer.write(line);
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean checkClazz(int clazzId){
        for (Clazz clazz:clazzList) {
            if (clazz.getClazzId() == clazzId){
                return true;
            }
        }
        return false;
    }

}
