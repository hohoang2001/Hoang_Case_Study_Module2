package Sv;

import Utils.AppUtils;
import Utils.FileUtils;
import Models.Student;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class StudentList implements Serializable {
    public static List<Student> students;
    static Scanner input = new Scanner(System.in);
    public static int studentId = 0;
    String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.txt";

    public StudentList() throws IOException, ClassNotFoundException {
        students = (List<Student>) FileUtils.deserialize(PATH);
//        students = FileUtils.readFile( "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.csv",Student.class);
        studentId = students.get(students.size() - 1).getStudentId() + 1;

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

        StudentList.students = students;
    }

    //thêm sinh viên vào danh sách
    public static void addStudent(Student sv) {
        students.add(sv);
    }

    //in ra danh sách sv
    public void displayStudent() {
        System.out.printf("%-10s %-20s %-18s %-18s %-18s %-25s %-25s %-25s \n", "ID", "Tên", "Lớp", "Số điện thoại", "Năm sinh", "Địa chỉ", " Trạng thái", "Thời Gian Thêm");
        for (Student student : students) {
            System.out.printf("%-10s %-20s %-18s %-18s %-18s %-25s %-25s %-25s \n", student.getStudentId(), student.getName(), student.getClazz(), student.getPhone(), student.getYearOfBirth(), student.getaddress(), student.getStatus(), student.getDataTime());
        }
    }

    public void fixStudent() throws IOException {
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
        for (Student student : students) {
            if (student.getStudentId() == studenId) {
                System.out.println("Nhập lại Họ Và Tên: ");
                student.setName(AppUtils.retryString());
                System.out.println("Nhập lớp");
                int clazz = AppUtils.seachClazzId();
                student.setClazz(AppUtils.retryClass(AppUtils.retryClasss(clazz)));
                System.out.println("Nhập số điện thoại");
                student.setPhone(AppUtils.phone());
                System.out.println("Nhập lại Năm Sinh: ");
                student.setYearOfBirth(AppUtils.dayOfBird());
                System.out.println("Nhập lại địa chỉ: ");
                student.setAddress(input.nextLine());
                student.setStatus(input.nextLine());
                dataTime();
               FileUtils.serialize(students,PATH );
                a = true;
                break;
            }
            a = false;
        }
        if (!a) {
            System.out.println(" Mã học sinh không có trong danh sách.");
        }
    }


    public void deleteStudent(int sv) throws IOException {
        for (Student sinhvien : students) {
            if (sinhvien.getStudentId() == sv) {
                sinhvien.setStatus("Chờ xoá");
                FileUtils.serialize(students,PATH);
                break;
            }
        }
    }
    public void delete(int sv) throws IOException {
        for (Student sinhvien : students) {
            if (sinhvien.getStudentId() == sv) {
                students.remove(sinhvien);
               FileUtils.serialize(students,PATH);
                break;
            }
        }
    }

    public static LocalDate dataTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Ngày Thêm: " + localDate);
        return localDate;
    }



    public String academicAbility(double diem) {
        if (diem > 75.0 && diem < 100.0) {
            return "Đã Pass Module";
        } else
            return "Chưa Pass Module";
    }

    public int laySoLuongHS() {
        return students.size();
    }


    public static List<Student> searchStudentByName(String filePath, String name) throws IOException, ClassNotFoundException {

        List<Student> studentList = (List<Student>) FileUtils.deserialize(filePath);
        List<Student> foundStudents = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getName().toLowerCase().equalsIgnoreCase(name)) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    public void searchStudent() throws IOException, ClassNotFoundException {
        String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.txt";
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

    public static void addStudent() throws IOException {
        System.out.println(" ⭆ Nhập Tên ");
        String name = AppUtils.retryString();
        System.out.println("⭆ Nhập Id Lớp: ");
        int clazz = AppUtils.seachClazzId();
        String classss = AppUtils.retryClass(AppUtils.retryClasss(clazz));
        System.out.println("Nhập Module");
        int module = AppUtils.retryChooseModule();
        System.out.println("⭆ Nhập Số điện thoại: ");
        String phone = AppUtils.phone();
        System.out.println("⭆ Nhập Năm Sinh: ");
        int yearOfBirth = AppUtils.dayOfBird();
        System.out.println("⭆ Nhập địa chỉ: ");
        String address = input.nextLine();
        System.out.println("⭆ Nhập Trạng Thái: ");
        String status = input.nextLine();

        LocalDate date = dataTime();

        Student sv = new Student(name,
                classss,
                phone,
                yearOfBirth,
                address,
                status,
                clazz,
                module,
                date
        );
        sv.setStudentId(StudentList.studentId++);
        addStudent(sv);
        FileUtils.serialize(students,"/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.txt");
    }
}

