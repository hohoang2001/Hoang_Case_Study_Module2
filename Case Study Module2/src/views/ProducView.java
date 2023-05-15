package views;

import Sv.Danh_sach_sv;
import Utils.AppUtils;
import models.SinhVien;

import java.time.LocalDate;
import java.util.Scanner;

public class ProducView {
        static Scanner input = new Scanner(System.in);
        static Danh_sach_sv dssv = new Danh_sach_sv();
    public static void menu() {
        int choise;
        do {
            System.out.println("--------------MENU---------------");
            System.out.println("______________________________________________\n" +
                    "|" + "1.	Thêm sinh viên vào danh sách.\n" +
                    "|" + "2.	In danh sách sinh viên ra màn hình.\n" +
                    "|" + "3.	Kiểm tra danh sách có rỗng hay không.\n" +
                    "|" + "4.	Sửa thông tin sinh viên.\n" +
                    "|" + "5.	Xoá Sinh Viên.\n" +
                    "|" + "6.	Số lượng học sinh có trong danh sách.\n" +
                    "|" + "0. Thoát khỏi chương trình. \n" +
                    "|" + "_____________________________________________");
            choise = AppUtils.retryChoose2();
            switch (choise) {
                case 1:
                    System.out.println(" ⭆ Nhập Tên ");
                    String name =AppUtils.retryString();
                    System.out.println("⭆ Nhập Năm Sinh: ");
                    int yearOfBirth = AppUtils.dayOfBird();
                    System.out.println("Nhập địa chỉ: ");
                    String address = input.nextLine();
                    System.out.println("Nhập điểm trung bình môn Toán học kỳ 1: ");
                    double mathOne = AppUtils.Point();
                    System.out.println("Nhập điểm trung bình môn Toán học kỳ 2: ");
                    double mathTwo = AppUtils.Point();
                    System.out.println("Nhập điểm trung bình môn Tếng Anh học kỳ 1: ");
                    double englishOne = AppUtils.Point();
                    System.out.println("Nhập điểm trung bình môn Tếng Anh học kỳ 2: ");
                    double englishTwo = AppUtils.Point();
                    System.out.println("Nhập điểm trung bình môn Văn Học học kỳ 1: ");
                    double literatureOne = AppUtils.Point();
                    System.out.println("Nhập điểm trung bình môn Văn Học học kỳ 2: ");
                    double literatureTwo = AppUtils.Point();
                    double math = dssv.averageSubject(mathOne, mathTwo);
                    double english = dssv.averageSubject(englishOne, englishTwo);
                    double literature = dssv.averageSubject(literatureOne, literatureTwo);
                    dssv.yearRoundAverage(math, english, literature);
                    double RoundAverage = dssv.yearRoundAverage(math, english, literature);
                    LocalDate date = dssv.datatime();
                    SinhVien sv = new SinhVien(name,
                            yearOfBirth,
                            address,
                            mathOne,
                            mathTwo,
                            englishOne,
                            englishTwo,
                            literatureOne,
                            literatureTwo,
                            RoundAverage,
                            dssv.academicAbility(RoundAverage),
                            date
                    );
                    System.out.println("Danh_sach_sv.studentId");
                    System.out.println(Danh_sach_sv.studentId);
                    sv.setStudentId(Danh_sach_sv.studentId++);
                    dssv.them_sv(sv);
                    dssv.saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Hocsinh.csv");
                    break;
                case 2:
                    dssv.inSv();
                    break;
                case 3:
                    dssv.kiemtradanhsachsv();
                    break;
                case 4:
                    System.out.println("Nhập Mã Sinh Viên: ");
                    dssv.suaSV(input.nextInt());
                    break;
                case 5:
                    System.out.println("Nhập Mã Sinh Viên: ");
                    dssv.xoaSv(input.nextInt());
                case 6:
                    System.out.println(dssv.laySoluongsv() + " Học sinh có trong danh sách.");
            }
        }
        while (choise != 0);
    }
    public void showMenu(){

    }


}
