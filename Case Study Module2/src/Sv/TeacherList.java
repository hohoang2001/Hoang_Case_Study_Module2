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
    static Scanner input = new Scanner(System.in);
    static String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.txt";
    public static List<Student> students;

    static {
        try {
            students = (List<Student>) FileUtils.deserialize(PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Teacher> teachers;
    public static int teacherId = 0;
    String Path = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Teacher.txt";

    public TeacherList() throws IOException, ClassNotFoundException {
        teachers = (List<Teacher>) FileUtils.deserialize(Path);
//        teachers = FileUtils.readFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Teacher.csv",Teacher.class);
        teacherId = teachers.get(teachers.size() - 1).getTeacherId() + 1;
    }

    public static void addTeacher(Teacher teacher) {
        teachers.add(teacher);
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
    public void fixTeacher() throws IOException {
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
                FileUtils.serialize(teachers, Path);
                a = true;
                break;
            }
            a = false;
        }
        if (!a) {
            System.out.println(" Mã Giáo Viên không có trong danh sách.");
        }
    }
    public static LocalDate dataTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Ngày Thêm: " + localDate);
        return localDate;
    }
    public static boolean checkTeacher(int id){
        for (Teacher teacher:teachers) {
            if (id == teacher.getTeacherId()){
                return true;
            }
        }
        return false;
    }
    public static void showTeacher(){
        System.out.printf("%-10s %-25s %-28s %-18s %-18s %-18s %-25s %-25s \n", "ID", "Tên", "Email", "Số điện thoại", "Năm sinh", "Địa chỉ", " Chức Vụ", "Thời Gian Thêm");
        for (Teacher teacher:teachers) {
            System.out.printf("%-10s %-25s %-28s %-18s %-18s %-18s %-25s %-25s \n", teacher.getTeacherId(), teacher.getName(),teacher.getEmail(),teacher.getPhone(),teacher.getYearOfBirth(),teacher.getAddress(),teacher.getPosition(),teacher.getDataTime());
        }
    }

    public static void addTeacher() throws IOException {
        System.out.println("Nhập Họ Và Tên");
        String name = AppUtils.retryString();
        System.out.println("Nhập chức vụ");
        String position = AppUtils.retryPosition();
        System.out.println("⭆ Nhập Số điện thoại: ");
        String phone = AppUtils.phone();
        System.out.println("Nhập Email");
        String email = AppUtils.email();
        System.out.println("⭆ Nhập Năm Sinh: ");
        int yearOfBirth = AppUtils.dayOfBird();
        System.out.println("⭆ Nhập địa chỉ: ");
        String address = input.nextLine();
        LocalDate date = dataTime();
        Teacher teacher = new Teacher(
                name,
                yearOfBirth,
                phone,
                email,
                address,
                position,
                date);
        teacher.setTeacherId(teacherId++);
        addTeacher(teacher);
        FileUtils.serialize(teachers,"/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Teacher.txt");
    }
}
