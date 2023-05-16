package views;

import Sv.DanhSachHS;
import Utils.AppUtils;
import models.HocSinh;

import java.time.LocalDate;
import java.util.Scanner;

public class ProducView {
        static Scanner input = new Scanner(System.in);
        static DanhSachHS dssv = new DanhSachHS();
    public static void menu() {
        int choise;
        do {
            System.out.println("--------------MENU---------------");
            System.out.println("______________________________________________\n" +
                    "|" + "1.	Thêm học sinh vào danh sách.\n" +
                    "|" + "2.	In danh sách học sinh ra màn hình.\n" +
                    "|" + "3.	Kiểm tra danh sách có rỗng hay không.\n" +
                    "|" + "4.	Sửa thông tin học sinh.\n" +
                    "|" + "5.	Xoá học sinh.\n" +
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
                    LocalDate date = dssv.dataTime();
                    HocSinh sv = new HocSinh(name,
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
                    System.out.println(DanhSachHS.studentId);
                    sv.setStudentId(DanhSachHS.studentId++);
                    dssv.themSv(sv);
                    dssv.saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Hocsinh.csv");
                    break;
                case 2:
                    dssv.inSv();
                    break;
                case 3:
                    dssv.kiemTraDanhSachHS();
                    break;
                case 4:
                    System.out.println("Nhập Mã học sinh: ");
                    dssv.suaHS(input.nextInt());
                    break;
                case 5:
                    dssv.inSv();
                    System.out.println("Nhập mã học sinh muốn xoá: ");
                    dssv.deleteHS(input.nextInt());
                case 6:
                    System.out.println(dssv.laySoLuongHS() + " Học sinh có trong danh sách.");
            }
        }
        while (choise != 0);
    }
    public void showMenu(){

    }


}
