package Sv;

import Utils.AppUtils;
import Utils.FileUtils;
import Models.Student;
import Models.Teacher;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TeacherList {
    private List<Student> students = FileUtils.readFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.csv", Student.class);
    private List<Teacher> teachers;
    public static int teacherId = 0;

    public TeacherList() {
        this.teachers = FileUtils.readFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Teacher.csv", Teacher.class);
        teacherId = teachers.get(teachers.size() - 1).getTeacherId() + 1;
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (Teacher teacher : teachers) {
                String line = teacher.toString();
                writer.write(line);
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == id) {
                teachers.remove(teacher);
                saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Teacher.csv");
                break;
            }
        }
    }
    public void displayDelete() {
        System.out.printf("%-10s %-15s %-18s %-18s %-18s %-18s %-25s %-25s\n", "ID", "Tên", "Lớp", "Số điện thoại", "Năm sinh", "Địa chỉ", " Trạng Thái", "Thời Gian Thêm");
        for (Student student : students) {
                if (student.getStatus().equals("Chờ Xoá")) {
                    System.out.printf("%-10s %-15s %-18s %-18s %-18s %-18s %-27s %-25s \n", student.getStudentId(), student.getName(), student.getClazz(), student.getPhone(), student.getYearOfBirth(), student.getaddress(),student.getStatus(), student.getDataTime());
                }
        }
    }
    public void fixTeacher() {
        Scanner input = new Scanner(System.in);
        boolean a = true;
        int TeacherId;
        do {
            try {
                System.out.println("Nhập Mã Giáo Viên: ");
                TeacherId = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Mã Giáo không hợp lệ vui lòng nhập bằng số");
            }
        }
        while (true);
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == TeacherId) {
                System.out.println("Nhập lại Họ Và Tên: ");
                teacher.setName(AppUtils.retryString());
                System.out.println("Nhập số điện thoại");
                teacher.setPhone(AppUtils.phone());
                System.out.println("Nhập lại Năm Sinh: ");
                teacher.setYearOfBirth(AppUtils.dayOfBird());
                System.out.println("Nhập lại địa chỉ: ");
                teacher.setAddress(input.nextLine());

                dataTime();
                saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Teacher.csv");
                a = true;
                break;
            }
            a = false;
        }
        if (!a) {
            System.out.println(" Mã Giáo Viên không có trong danh sách.");
        }
    }
    public LocalDate dataTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Ngày Thêm: " + localDate);
        return localDate;
    }


}
