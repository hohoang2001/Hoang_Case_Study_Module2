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
    static String pathUser = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.txt";
    public static List<User> users;
    public static List<Teacher> teachers;


    static {
        try {
            teachers = (List<Teacher>) FileUtils.deserialize("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/Data/Teacher.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            users = (List<User>) FileUtils.deserialize(pathUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Account account;

    static {
        try {
            account = new Account();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static String Path = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/Data/Poin.txt";
    public static List<Poin> poinList;

    static {
        try {
            poinList = (List<Poin>) FileUtils.deserialize(Path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static final AccountSV accountsv = new AccountSV();
    static Scanner input = new Scanner(System.in);
    static String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Student.txt";
    static List<Student> students;

    static {
        try {
            students = (List<Student>) FileUtils.deserialize(PATH);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static StudentList student;

    static {
        try {
            student = new StudentList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static TeacherList teacherList;

    static {
        try {
            teacherList = new TeacherList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static ClazzList clazzList;

    static {
        try {
            clazzList = new ClazzList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static PoinService poinService;

    static {
        try {
            poinService = new PoinService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean exit = false;

    public static void menuHs() throws IOException, ClassNotFoundException {
        int choise;
        do {
            menuStudent();
            choise = AppUtils.retryChoose2();
            switch (choise) {
                case 1:
                    student.displayStudent();
                    break;
                case 2:
                    System.out.println("Nhập Id Student");
                    int idStudent = AppUtils.delete();
                    System.out.println("Nhập Id Clazz");
                    int idClazz = AppUtils.seachClazzId();
                    System.out.println("Nhập Id Module");
                    int idModule = AppUtils.retryChooseModule();
                    poinService.displayStudent(idStudent, idClazz, idModule);
                    break;
                case 3:
                    student.searchStudent();
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

    public static void menuPrincipal() throws IOException, ClassNotFoundException {
        int chose;
        do {
            showMenuPrincipal();
            chose = AppUtils.retryChoosePrincipal();
            switch (chose) {
                case 1:
                    TeacherList.addTeacher();
                    break;
                case 2:
                    student.searchStudent();
                    break;
                case 3:
                    student.displayStudent();
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
                    account.registerAccount();
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
                    clazzList.fixClazz();
                    break;
                case 13:
                    clazzList.addClazz();
                    break;
                case 14:
                    System.out.println("Nhập Id Student");
                    int idStudent = AppUtils.delete();
                    System.out.println("Nhập Id Clazz");
                    int idClazz = AppUtils.seachClazzId();
                    System.out.println("Nhập Id Module");
                    int idModule = AppUtils.retryChooseModule();
                    poinService.displayStudent(idStudent, idClazz, idModule);
                    break;
                case 15:
                    TeacherList.showTeacher();
            }
        }
        while (chose != 0);
    }

    public static void menu() throws IOException, ClassNotFoundException {
        int chose;
        do {
            showMenuTeacher();
            chose = AppUtils.retryChoose2();
            switch (chose) {
                case 1:
                    StudentList.addStudent();
                    break;
                case 2:
                    student.searchStudent();
                    break;
                case 3:
                    student.displayStudent();
                    break;
                case 4:
                    student.fixStudent();
                    break;
                case 5:
                    student.displayStudent();
                    System.out.println("Nhập mã học sinh muốn xoá: ");
                    student.deleteStudent(AppUtils.delete());
                    System.out.println("Đã Gửi Danh Sách Học Sinh Chờ Xoá Lên Giám Đốc / Chờ xác nhận");
                    break;
                case 6:
                    ClazzList.showClazz();
                    break;
                case 7:
                    System.out.println(student.laySoLuongHS() + " Học sinh có trong danh sách.");
                    break;
                case 8:
                    account.inUser();
                    break;
                case 9:

                    break;
                case 10:
                    account.registerAccount();
                    break;
                case 11:
                    addPoint();
                case 0:
                    System.out.println("Quay lại chương trình đăng nhập");
                    account();
                    break;
            }
        }
        while (chose != 0);
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
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Account.txt"))) {
            boolean found = false;
            System.out.println("Nhập tên đăng nhập: ");
            String username = scanner.nextLine();
            System.out.println("Nhập mật khẩu: ");
            String password = scanner.nextLine();

            for (User user : users) {
                if (user.getPartition().equals("Student") && user.getUseName().equals(username) && user.getPassWord().equals(password)) {
                    found = true;
                    menuHs();
                    break;
                }
                if (user.getPartition().equals("Teacher") && user.getUseName().equals(username) && user.getPassWord().equals(password)) {
                    found = true;
                    menu();
                    break;
                }
                if (user.getPartition().equals("Principal") && user.getUseName().equals(username) && user.getPassWord().equals(password)) {
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
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi: Không thể đọc file.");
            exit = true;
            account();
        }

    }



    public static void showMenuPrincipal() {
        System.out.println("                               ╔════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                               ║                                    Giao diện Giám Đốc                                          ║");
        System.out.println("                               ║                                 1.	 Thêm giáo viên.                                            ║");
        System.out.println("                               ║                                 2.	 Tìm học sinh.                                              ║");
        System.out.println("                               ║                                 3.	 In danh sách học sinh.                                     ║");
        System.out.println("                               ║                                 4.	 Xem danh sách học sinh chờ xoá.                            ║");
        System.out.println("                               ║                                 5.	 Xoá học sinh.                                              ║");
        System.out.println("                               ║                                 6.	 Số lượng học sinh toàn trường.                             ║");
        System.out.println("                               ║                                 7.	 Xem tài khoản giáo viên.                                   ║");
        System.out.println("                               ║                                 8.	 Đăng ký tài khoản giáo viên.                               ║");
        System.out.println("                               ║                                 9.  Xoá giáo viên.                                             ║");
        System.out.println("                               ║                                 10. Sửa thông tin giáo viên.                                   ║");
        System.out.println("                               ║                                 11. Xem danh sách lớp và giáo viên đang quản lý lớp.           ║");
        System.out.println("                               ║                                 12. Thay đổi giáo viên quản lý của lớp.                        ║");
        System.out.println("                               ║                                 13. Thêm lớp.                                                  ║");
        System.out.println("                               ║                                 14. Xem điểm từng học sinh.                                    ║");
        System.out.println("                               ║                                 15. Hiển thị danh sách Giáo viên.                              ║");
        System.out.println("                               ║                                 0.  Quay lại chương trình đăng nhập.                           ║");
        System.out.println("                               ╚════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public static void showMenuTeacher() {
        System.out.println("                               ╔════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                               ║                                    Giao diện Teacher                                           ║");
        System.out.println("                               ║                                 1.	Thêm học sinh.                                              ║");
        System.out.println("                               ║                                 2.	Tìm học sinh.                                               ║");
        System.out.println("                               ║                                 3.	In danh sách học sinh                                       ║");
        System.out.println("                               ║                                 4.	Sửa thông tin học sinh.                                     ║");
        System.out.println("                               ║                                 5. Xoá học sinh.                                               ║");
        System.out.println("                               ║                                 6.	Xem danh sách các lớp.                                      ║");
        System.out.println("                               ║                                 7.	Xem Tài Khoản ADMIN.                                        ║");
        System.out.println("                               ║                                 8. Xếp danh sách điểm từ cao đến thấp theo lớp.                ║");
        System.out.println("                               ║                                 9. Xếp danh sách điểm từ cao đến thấp cho toàn bộ học sinh.    ║");
        System.out.println("                               ║                                 10. Đăng ký tài khoản học sinh.                                ║");
        System.out.println("                               ║                                 0. Quay lại chương trình đăng nhập.                            ║");
        System.out.println("                               ╚════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }
public static void addPoint() throws IOException, ClassNotFoundException {
    boolean success = false;
    do {
        try {
            System.out.println("Nhập mã học sinh muốn thêm điểm");
            int idStudent = AppUtils.delete();
            for (Student student1 : students) {
                if (student1.getStudentId() == idStudent) {
                    System.out.println("Nhập Module muốn thêm");
                    int module = AppUtils.retryChooseModule();
                    if (ModuleList.searchCheckModule(module)) {
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
                            Poin poin = new Poin(idStudent, clazz, module, enforcement, theory, casePoint, interviewPoint, isPass, date);
                            poinService.addPoint(poin);
                            FileUtils.serialize(poinList,"/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/Data/Poin.txt");
                            success = true;
                            break;
                        } else {
                            System.out.println("Không tìm thấy lớp học");
                        }
                    } else {
                        System.out.println("Module không tồn tại");
                    }
                }
            }
            if (!success) {
                System.out.println("Mã học sinh không có trong danh sách.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    } while (!success);
    menu();
}
public static void menuStudent(){
    System.out.println("                               ╔═══════════════════════════════════════════════════════════════════════════════════╗");
    System.out.println("                               ║                                    Giao diện Học Sinh                             ║");
    System.out.println("                               ║                                 [1] Xem danh sách học sinh                        ║");
    System.out.println("                               ║                                 [2] Xem điểm                                      ║");
    System.out.println("                               ║                                 [3] Tìm học sinh theo tên                         ║");
    System.out.println("                               ║                                 [4] Số lượng học sinh                             ║");
    System.out.println("                               ║                                 [5] Đăng xuất                                     ║");
    System.out.println("                               ╚═══════════════════════════════════════════════════════════════════════════════════╝");
}
}
