package views;

import Models.Poin;
import Sv.*;
import Utils.AppUtils;
import Utils.FileUtils;
import Models.Student;
import Models.Teacher;
import Models.User;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProducView {

    private static final Account account = new Account();
    private static final AccountSV accountsv = new AccountSV();
    static Scanner input = new Scanner(System.in);
     static List<Student> students = FileUtils.readFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.csv", Student.class);

    private static StudentList student = new StudentList();
    static TeacherList teacherList = new TeacherList();
    static ClazzList clazzList = new ClazzList();
    static PoinService poinService = new PoinService();
    static boolean exit = false;

    public static void menuHs() throws IOException {
        int choise;
        do {
            System.out.println("      --------------MENU---------------");
            System.out.println("______________________________________________\n" +
                    "|" + "1.	Xem danh sách học sinh.                     |\n" +
                    "|" + "2.	Xem Điểm .                     |\n" +
                    "|" + "3.	Tìm học sinh theo tên.                      |\n" +
                    "|" + "4.	Số lượng học sinh có trong danh sách.       |\n" +
                    "|" + "0. Quay lại chương trình đăng nhập.            | \n" +
                    "|" + "_____________________________________________  |");
            choise = AppUtils.retryChoose2();
            switch (choise) {
                case 1:
                    student.inSv();
                    break;
                case 2:

                case 3:
                    student.timKiemHs();
                    break;
                case 4:
                    System.out.println(student.laySoLuongHS() + " Học sinh có trong danh sách.");
                    break;
                case 0:
                    System.out.println("Quay lại chương trình đăng nhập");
                    account();
                    break;
            }
        }
        while (choise != 0);
    }

    public static void menuPrincipal() throws IOException {
        int choise;
        do {
            showMenuPrincipal();
            choise = AppUtils.retryChoosePrincipal();
            switch (choise) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    student.timKiemHs();
                    break;
                case 3:
                    student.inSv();
                    break;
                case 4:
                    teacherList.displayDelete();
                    break;
                case 5:
                    System.out.println("Nhập Id sinh viên muốn xoá");
                    int id = input.nextInt();
                    student.delete(id);
                    break;
                case 6:
                    student.laySoLuongHS();
                    break;
                case 7:
                    account.inUser();
                    break;
                case 8:
                    registerAccount();
                    break;
                case 9:
                    System.out.println("Nhập Id Giáo Viên Muốn Xoá");
                    int idTeacher = input.nextInt();
                    teacherList.delete(idTeacher);
                    break;
                case 10:
                    teacherList.fixTeacher();
                    break;
                case 11:
                    clazzList.displayClazz();
                    break;
                case 12:
                    System.out.println("Nhập id của lớp muốn sửa");
                    int idClazz = input.nextInt();
                    clazzList.fixClazz(idClazz);
                case 13:
                    clazzList.addClazz();
                    break;
                case 14:
                    poinService.displayStudent(1,1,1);
            }
        }
        while (choise != 0);
    }

    public static void menu() throws IOException {
        int choise;
        do {
            showMenuTeacher();
            choise = AppUtils.retryChoose2();
            switch (choise) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    student.timKiemHs();
                    break;
                case 3:
                    student.inSv();
                    break;
                case 4:
                    student.suaHS();
                    break;
                case 5:
                    student.inSv();
                    System.out.println("Nhập mã học sinh muốn xoá: ");
                    student.deleteStudent(AppUtils.delete());
                    System.out.println("Đã Gửi Danh Sách Học Sinh Chờ Xoá Lên Giám Đốc / Chờ xác nhận");
                    break;
                case 6:

                case 7:
                    System.out.println(student.laySoLuongHS() + " Học sinh có trong danh sách.");
                    break;
                case 8:
                    account.inUser();
                    break;
                case 9:

                    break;
                case 10:
                    registerAccount();
                    break;
                case 11:
                    addPoin();
                case 0:
                    System.out.println("Quay lại chương trình đăng nhập");
                    account();
                    break;
            }
        }
        while (choise != 0);
    }

    public static void account() {


        do {
            System.out.println("1 Đăng nhập ");
            System.out.println("0 Thoát chương trình");
            int choose = AppUtils.retryChoose();
            switch (choose) {
                case 1:
                    Login();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
        while (!exit);
    }

    public static void Login() {
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.csv"))) {
            String line;
            boolean found = false;
            System.out.println("Nhập tên đăng nhập: ");
            String username = scanner.nextLine();
            System.out.println("Nhập mật khẩu: ");
            String password = scanner.nextLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].equals("Student") && parts[1].equals(username) && parts[2].equals(password)) {
                    found = true;
                    menuHs();
                    break;
                }
                if (parts.length == 3 && parts[0].equals("Teacher") && parts[1].equals(username) && parts[2].equals(password)) {
                    found = true;
                    menu();
                    break;
                }
                if (parts.length == 3 && parts[0].equals("Principal") && parts[1].equals(username) && parts[2].equals(password)) {
                    found = true;
                    menuPrincipal();
                    break;
                }
            }

            if (!found) {
                System.out.println("Tài khoản hoặc mật khẩu không đúng.");
                exit = true;
                account();
            }
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể đọc file.");
            exit = true;
            account();
        }

    }

    public static void registerAccount() {
        Scanner scanner = new Scanner(System.in);
        String path = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.csv";
        try {
            List<User> userSVS = FileUtils.readFile(path, User.class);
            User user = new User();
            do {
                user.setPartition(AppUtils.partition());
                System.out.println("Nhập Tài Khoản");
                String useNew = scanner.nextLine();
                if (accountsv.CheckNameAccount(useNew)) {
                    System.out.println("Tài khoản đã tồn tại");
                    continue;
                }
                user.setUseName(useNew);
                break;
            }
            while (true);
            System.out.println("Nhập Mật Khẩu");
            do {
                String passNew = scanner.nextLine();
                int lenght = 10;
                if (passNew.length() > lenght) {
                    System.out.println("Vui Lòng Nhập Độ Dài Mật Khẩu 10 Ký Tự");
                    System.out.println("Nhập Lại");
                    continue;
                }

                user.setPassWord(passNew);
                break;
            }
            while (true);
            userSVS.add(user);


            FileUtils.saveData(path, userSVS);
            System.out.println("Đăng Ký Tài Khoản Thành Công");
            menu();
        } catch (IOException e) {
            System.out.println("Lỗi Không Thể Tạo Tài Khoản");
        }
    }

    public static void addTeacher() {
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
        LocalDate date = student.dataTime();
        Teacher teacher = new Teacher(
                name,
                yearOfBirth,
                phone,
                email,
                address,
                position,
                date);
        teacher.setTeacherId(TeacherList.teacherId++);
        teacherList.addTeacher(teacher);
        teacherList.saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Teacher.csv");
    }


    public static void showMenuPrincipal() {
        System.out.println("      --------------MENU---------------");
        System.out.println("______________________________________________\n" +
                "|" + "1.	Thêm  Giáo viên.                |\n" +
                "|" + "2.	Tìm học sinh.                               |\n" +
                "|" + "3.	Xuất Danh Sách học sinh                                 |\n" +
                "|" + "4.	Xem danh sách học sinh chờ xoá.             |\n" +
                "|" + "5.	Xoá Học Sinh.                               |\n" +
                "|" + "6.	Số lượng học sinh.       |\n" +
                "|" + "7.	Xem Tài Khoản Giáo Viên.                    |\n" +
                "|" + "8. Đăng ký tài khoản Giáo viên.                  |\n" +
                "|" + "9. Xoá Giáo Viên                  |\n" +
                "|" + "10. Sửa Thông Tin Giáo Viên.                  |\n" +
                "|" + "11. Xem Danh Sách Lớp Và Giáo Viên Đang Quản Lý Lớp Đó.                  |\n" +
                "|" + "12. Thay Đổi Giáo Viên Quản Lý Của lớp.                  |\n" +
                "|" + "13. Thêm Lớp.                  |\n" +
                "|" + "14. Xem Điểm Từng Học Sinh.                  |\n" +
                "|" + "0. Quay lại chương trình đăng nhập.            | \n" +
                "|" + "_____________________________________________  |");
    }

    public static void showMenuTeacher() {
        System.out.println("      --------------MENU---------------");
        System.out.println("______________________________________________\n" +
                "|" + "1.	Thêm học sinh.                |\n" +
                "|" + "2.	Tìm học sinh.                               |\n" +
                "|" + "3.	In học sinh                                 |\n" +
                "|" + "4.	Sửa thông tin học sinh.                     |\n" +
                "|" + "5.	Xoá học sinh.                               |\n" +
                "|" + "6.	Xem danh sách các lớp.                      |\n" +
                "|" + "7.	Xem Tài Khoản ADMIN.                        |\n" +
                "|" + "8. Xếp danh sách điểm từ cao đến thấp theo lớp.  |\n" +
                "|" + "9. Xếp danh sách điểm từ cao đến thấp cho toàn bộ học sinh.  |\n" +
                "|" + "10. Đăng ký tài khoản học sinh.                  |\n" +
                "|" + "0. Quay lại chương trình đăng nhập.            | \n" +
                "|" + "_____________________________________________  |");
    }

    public static void addStudent() {
        System.out.println(" ⭆ Nhập Tên ");
        String name = AppUtils.retryString();
        System.out.println("⭆ Nhập Lớp: ");
        int clazz = input.nextInt();
        String classss = AppUtils.retryClass(AppUtils.retryClasss(clazz));
        System.out.println("⭆ Nhập Số điện thoại: ");
        String phone = AppUtils.phone();
        System.out.println("⭆ Nhập Năm Sinh: ");
        int yearOfBirth = AppUtils.dayOfBird();
        System.out.println("⭆ Nhập địa chỉ: ");
        String address = input.nextLine();
        System.out.println("⭆ Nhập Trạng Thái: ");
        String status = input.nextLine();
        System.out.println("Nhập Module");
        int module = input.nextInt();
        LocalDate date = student.dataTime();

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
        student.themSv(sv);
        student.saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.csv");
    }

    public static void addPoin() {
        boolean a = false;
        int idStudent;
        do {
            try {
                System.out.println("Nhập mã học sinh muốn thêm điểm");
                idStudent = AppUtils.delete();
                for (Student student1 : students) {
                    if (student1.getStudentId() == idStudent) {
                        System.out.println("Nhập Module muốn thêm");
                        int Module = AppUtils.retryChooseModule();
                        if (ModuleList.searchCheckModule(Module)) {
                            System.out.println("Nhập Id Lớp Muốn Thêm");
                            int clazz = AppUtils.seachClazzId();
                            if (ClazzList.checkClazz(clazz)) {
                                System.out.println("Nhập điểm thực hành");
                                double enforcement = AppUtils.Point();
                                System.out.println("Nhập điểm lý thuyết");
                                double theory = AppUtils.Point();
                                System.out.println("Nhập điểm case study");
                                double casePoint = AppUtils.Point();
                                System.out.println("Nhập điểm phỏng vấn");
                                double interviewPoint = AppUtils.Point();
                                String isPass = poinService.classification(enforcement, theory, casePoint, interviewPoint);
                                LocalDate date = poinService.dataTime();
                                Poin poin = new Poin(idStudent, clazz, Module, enforcement, theory, casePoint, interviewPoint, isPass, date);
                                poinService.addPoint(poin);
                                poinService.saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/Data/Poin.csv");
                                a = true;
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    a = true;
                }
                menu();
                if (!a) {
                    System.out.println(" Mã học sinh không có trong danh sách.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }

        while (!true);

    }
}
