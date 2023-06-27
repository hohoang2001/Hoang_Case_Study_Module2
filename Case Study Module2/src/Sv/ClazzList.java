package Sv;

import Models.User;
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
    private List<Teacher> teachers = (List<Teacher>) FileUtils.deserialize("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Teacher.txt");
    public static List<Clazz> clazzList;
    private List<Student> students;
    public static int clazzId = 0;
    String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Clazz.txt";
    public ClazzList() throws IOException, ClassNotFoundException {
        clazzList = (List<Clazz>) FileUtils.deserialize(PATH);
//        clazzList = FileUtils.readFile(PATH, Clazz.class);
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
            for (Teacher teacher: teachers){
                if (clazz.getTeacherId() == teacher.getTeacherId()){
                    System.out.println(clazz.getName());
                    System.out.println(teacher.getName());
                }
            }
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
            System.out.printf("%-18s %-18s \n", clazz.getName(), clazz.getTeacherId());
        }
    }
    public boolean checkClazzz(int clazzId){
        for (Clazz clazz:clazzList) {
            if (clazz.getClazzId() == clazzId){
                return true;
            }
        }
        return false;
    }

    public void fixClazz() throws IOException {
        Scanner input = new Scanner(System.in);
        boolean a = true;
        int clazzId = 0;
        int teacherId;
        do {
            try {
                System.out.println("Nhập Mã Lớp: ");
                clazzId = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Mã lớp không hợp lệ vui lòng nhập bằng số");
            }

            if (checkClazz(clazzId)){
                for (Clazz clazz : clazzList) {
                    if (clazz.getClazzId() == clazzId) {
                        System.out.println("Nhập Id Giáo Viên Quản lý Muốn Thay Đổi");
                        teacherId = AppUtils.seachTeacherId();
                        for (Teacher teacher :teachers) {
                            if(teacher.getTeacherId() == teacherId){
                                clazz.setTeacherId(teacherId);
                                dataTime();
                                FileUtils.serialize(clazzList,"/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Clazz.txt");
                                return;
                            }
                            else  {
                                System.out.println(" Mã Giáo Viên không có trong danh sách.");
                            }
                        }

                    }
                }

            }
            else {
                System.out.println("Bạn Nhập Sai ID Lớp");
            }
        }
        while (true);

        }

    public LocalDate dataTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Ngày Thêm: " + localDate);
        return localDate;
    }
    public void themSv(Clazz clazz) {
        clazzList.add(clazz);
    }

    public void addClazz() throws IOException {
        System.out.println("Nhập Tên Lớp");
        String name = AppUtils.retryNameClazz();
        System.out.println("Nhập Id Giáo Viên Quản lý ");
        int idTeacher = input.nextInt();
        LocalDate date = dataTime();
        Clazz clazz = new Clazz(idTeacher, name,date);
        clazz.setClazzId(clazzId++);
        themSv(clazz);
        FileUtils.serialize(clazzList,"/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Clazz.txt");

    }
    public static void showClazz(){
        for (Clazz clazz:clazzList) {
            System.out.println(clazz.getName());
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
