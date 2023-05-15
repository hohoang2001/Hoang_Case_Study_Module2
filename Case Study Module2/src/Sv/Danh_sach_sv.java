package Sv;

import Utils.AppUtils;
import Utils.FileUtils;
import models.SinhVien;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Danh_sach_sv {
    private List<SinhVien> SinhViens;

    public static int studentId = 0;

    public Danh_sach_sv() {
        this.SinhViens = FileUtils.readFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Hocsinh.csv", SinhVien.class);
        studentId = SinhViens.get(SinhViens.size() - 1).getStudentId() + 1;
    }

    public Danh_sach_sv(ArrayList<SinhVien> SinhViens) {
        this.SinhViens = SinhViens;
    }

    //thêm sinh viên vào danh sách
    public void them_sv(SinhVien sv) {
        this.SinhViens.add(sv);
    }

    //in ra danh sách sv
    public void inSv() {
        System.out.printf("%-10s %-15s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s\n", "ID", "Tên", "Năm sinh", "Địa chỉ", "Toán HK 1" , "Toán HK 2","Tiếng Anh HK1","Tiếng Anh HK2", "Văn Học HK1" , "Văn Học HK2", "Thời Gian Thêm", "Điểm Trung Bình");
        for (SinhVien sinhVien:SinhViens){
            System.out.printf("%-10s %-15s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s\n",sinhVien.getStudentId(),sinhVien.getName(),sinhVien.getYearOfBirth(),sinhVien.getaddress(),sinhVien.getMathOne(),sinhVien.getMathTwo(),sinhVien.getEnglishOne(),sinhVien.getEnglishTwo(),sinhVien.getLiteratureOne(),sinhVien.getLiteratureTwo(),sinhVien.getDatatime(),sinhVien.getMediumScore());
        }
    }

    public void kiemtradanhsachsv() {
        if (this.SinhViens.isEmpty()) {
            System.out.println("Danh sách sinh viên rỗng");
        } else
            inSv();
    }

    public void suaSV(int sv) {
        Scanner input = new Scanner(System.in);
        boolean a = true;
        for (SinhVien sinhvien : SinhViens) {
            if (sinhvien.getStudentId() == sv) {
                System.out.println("Nhập lại Họ Và Tên: ");
                sinhvien.setName(input.nextLine());
                System.out.println("Nhập lại Năm Sinh: ");
                sinhvien.setYearOfBirth(Integer.parseInt(input.nextLine()));
                System.out.println("Nhập lại địa chỉ: ");
                sinhvien.setAddress(input.nextLine());
                System.out.println("Nhập điểm trung bình môn Toán học kỳ 1: ");
                sinhvien.setMathOne(AppUtils.Point());
                System.out.println("Nhập điểm trung bình môn Toán học kỳ 2: ");
                sinhvien.setMathTwo(AppUtils.Point());
                System.out.println("Nhập điểm trung bình môn Tếng Anh học kỳ 1: ");
                sinhvien.setEnglishOne(AppUtils.Point());
                System.out.println("Nhập điểm trung bình môn Tếng Anh học kỳ 2: ");
                sinhvien.setEnglishTwo(AppUtils.Point());
                System.out.println("Nhập điểm trung bình môn Văn Học học kỳ 1: ");
                sinhvien.setLiteratureOne(AppUtils.Point());
                System.out.println("Nhập điểm trung bình môn Văn Học học kỳ 2: ");
                sinhvien.setLiteratureTwo(AppUtils.Point());
                datatime();
                double math = averageSubject(sinhvien.getMathOne(), sinhvien.getMathTwo());
                double english = averageSubject(sinhvien.getEnglishOne(), sinhvien.getEnglishTwo());
                double literature = averageSubject(sinhvien.getLiteratureOne(), sinhvien.getLiteratureTwo());
                double RoundAverage = yearRoundAverage(math, english, literature);
                sinhvien.setMediumScore(RoundAverage);
                saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Hocsinh.csv");
                a = true;
                break;
            }
            a = false;
        }
        if (!a) {
            System.out.println(" Mã sinh viên không có trong danh sách.");
        }

    }

    public void xoaSv(int sv) {
        for (SinhVien sinhvien : SinhViens) {
            if (sinhvien.getStudentId() == sv) {

                SinhViens.remove(sinhvien);
                saveToFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Hocsinh.csv");
                break;
            }
        }
    }

    public LocalDate datatime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Ngày Thêm: " + localDate);
        return localDate;
    }

    public double averageSubject(double One, double Two) {
        double average = (One + (Two * 2)) / 3;
        return Math.round(average * 100.0) / 100.0;
    }
    public double yearRoundAverage(double math, double english, double literature){
        double RoundAverage = (math + english + literature) / 3;
        return Math.round(RoundAverage * 100.0) / 100.0;
    }
    public String  academicAbility(double diem){
        if(diem > 4 && diem <=6.5){
           return "Trung bình";
        } else if (diem >= 6.5 && diem<= 7.9) {
           return "Học lực Khá";
        } else if (diem >= 8.0 && diem <= 10) {
           return "Giỏi";
        }
        else
           return "Yếu";
    }
    public int laySoluongsv(){
        return this.SinhViens.size();
    }
    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (SinhVien student : SinhViens) {
                String line = student.toString();
                writer.write(line);
                writer.write("\n");
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    public static void docsv() throws IOException {
//        File sinhvien = new File("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Hocsinh.csv");
//        try {
//            BufferedReader sinhviens = Files.newBufferedReader(sinhvien.toPath(), StandardCharsets.UTF_8);
//            String line = null;
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }

}

