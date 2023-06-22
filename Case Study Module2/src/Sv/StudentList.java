package Sv;

import Utils.AppUtils;
import Utils.FileUtils;
import Models.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class StudentList {
    private static List<Student> students;

    public static int studentId = 0;

    public StudentList() {
        this.students = FileUtils.readFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.csv", Student.class);
        studentId = students.get(students.size() - 1).getStudentId() + 1;
    }







    public static List<Student> allhocsinh() {
        String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.csv";
        return FileUtils.readFile(PATH, Student.class);
    }
public static boolean searchCheckId(int id){
    for (Student student:students) {
        if (student.getStudentId() == id) {
            return true;
        }
    }
    return false;
}


    public StudentList(ArrayList<Student> students) {

        this.students = students;
    }

    //thêm sinh viên vào danh sách
    public void themSv(Student sv) {
        this.students.add(sv);
    }

    //in ra danh sách sv
    public void inSv() {
        System.out.printf("%-10s %-15s %-18s %-18s %-18s %-18s %-25s %-25s \n", "ID", "Tên", "Lớp", "Số điện thoại", "Năm sinh", "Địa chỉ", " Trạng thái", "Thời Gian Thêm");
        for (Student student : students) {
            System.out.printf("%-10s %-15s %-18s %-18s %-18s %-18s %-25s %-25s \n", student.getStudentId(), student.getName(), student.getClazz(), student.getPhone(), student.getYearOfBirth(), student.getaddress(), student.getStatus(), student.getDataTime());
        }
    }

    public void suaHS() {
        Scanner input = new Scanner(System.in);
        boolean a = true;
        int studenId;
        do {
            try {
                System.out.println("Nhập Mã học sinh: ");
                studenId = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Mã học sinh không hợp lệ vui lòng nhập bằng số");
            }
        }
        while (true);
        for (Student sinhvien : students) {
            if (sinhvien.getStudentId() == studenId) {
                System.out.println("Nhập lại Họ Và Tên: ");
                sinhvien.setName(AppUtils.retryString());
                System.out.println("Nhập lớp");
                int clazz = input.nextInt();
                sinhvien.setClazz(AppUtils.retryClass(AppUtils.retryClasss(clazz)));
                System.out.println("Nhập số điện thoại");
                sinhvien.setPhone(AppUtils.phone());
                System.out.println("Nhập lại Năm Sinh: ");
                sinhvien.setYearOfBirth(AppUtils.dayOfBird());
                System.out.println("Nhập lại địa chỉ: ");
                sinhvien.setAddress(input.nextLine());
// còn thiếu set trạng thái
                dataTime();
                saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.csv");
                a = true;
                break;
            }
            a = false;
        }
        if (!a) {
            System.out.println(" Mã học sinh không có trong danh sách.");
        }
    }


    public void deleteStudent(int sv) {
        for (Student sinhvien : students) {
            if (sinhvien.getStudentId() == sv) {
                sinhvien.setStatus("Chờ xoá");
                saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.csv");
                break;
            }
        }
    }
    public void delete(int sv) {
        for (Student sinhvien : students) {
            if (sinhvien.getStudentId() == sv) {
                students.remove(sinhvien);
                saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.csv");
                break;
            }
        }
    }

    public LocalDate dataTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Ngày Thêm: " + localDate);
        return localDate;
    }

    public double averageSubject(double One, double Two) {
        double average = (One + (Two * 2)) / 3;
        return Math.round(average * 100.0) / 100.0;
    }

    public double yearRoundAverage(double enforcement, double theory) {
        double RoundAverage = (enforcement + theory) / 2;
        return Math.round(RoundAverage * 100.0) / 100.0;
    }

    public String academicAbility(double diem) {
        if (diem > 75.0 && diem < 100.0) {
            return "Đã Pass Module";
        } else
            return "Chưa Pass Module";
    }

    public int laySoLuongHS() {
        return this.students.size();
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

    public static List<Student> searchStudentByName(String filePath, String name) throws IOException {

        List<Student> studentList = FileUtils.readFile(filePath, Student.class);
        List<Student> foundStudents = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getName().toLowerCase().equalsIgnoreCase(name)) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    public void timKiemHs() throws IOException {
        String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.csv";
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập Tên Học Sinh");
        String name = input.nextLine();
        List<Student> foundStudents = searchStudentByName(PATH, name);
        if (!foundStudents.isEmpty()) {
            System.out.printf("%-10s %-15s %-15s %-15s %-18s %-18s %-18s %-18s \n", "ID", "Tên", "Lớp", "Số điện thoại", "Năm sinh", "Địa chỉ", "Trạng Thái", "Thời Gian Thêm");
            for (Student hocsinh : foundStudents) {
                System.out.printf("%-10s %-15s %-15s %-15s %-18s %-18s %-18s %-18s \n", hocsinh.getStudentId(), hocsinh.getName(), hocsinh.getClazz(), hocsinh.getPhone(), hocsinh.getYearOfBirth(), hocsinh.getaddress(), hocsinh.getStatus(), hocsinh.getDataTime());
            }
        } else {
            System.out.println("Không tìm thấy học sinh có tên: " + name);
        }
    }

    public void checkStudent(int id) {
        for (Student studen : students) {
            if (studen.getClazzId() == id) {

            }
        }
    }
}

