package Sv;

import Models.Clazz;
import Models.Module;
import Models.Poin;

import Models.Student;
import Utils.FileUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class PoinService {
    private List<Student> students = FileUtils.readFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/Data/Student.csv",Student.class);
    private List<Clazz> clazzes = FileUtils.readFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/Data/Clazz.csv",Clazz.class);
    private List<Module> modules = FileUtils.readFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/Data/Module.csv",Module.class);


    private List<Poin> poinList ;
    String PATH = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/Data/Poin.csv";
    public PoinService(){
        this.poinList = FileUtils.readFile(PATH,Poin.class);
    }
    public LocalDate dataTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Ngày Thêm: " + localDate);
        return localDate;
    }
    public String classification(Double enforcement, Double theory, Double casePoint, Double interviewPoint ){
        if (enforcement >= 75.0 && theory >= 75.0 && casePoint >= 75.0 && interviewPoint >= 75.0 ){
            return "Đã Pass Module";
        }
        return "Chưa Pass Module";
    }
    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (Poin poin : poinList) {
                String line = poin.toString();
                writer.write(line);
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addPoint(Poin poin) {
        this.poinList.add(poin);
    }
    public void displayStudent(int idStudent, int idClazz, int idModule){
        boolean a = true;
        do {
            for (Student student:students) {
                if (student.getStudentId() == idStudent){
                    for (Module module:modules) {
                        if (module.getIdModule() == idModule){
                            for (Clazz clazz: clazzes) {
                                if (clazz.getClazzId() == idClazz){
                                    System.out.printf("%-10s %-15s %-18s  \n", "ID", "Tên", "Lớp");
                                    System.out.printf("%-10s %-15s %-18s  \n",student.getStudentId(), student.getName(), student.getClazz());
                                    System.out.printf("%-20s %-20s %-20s %-20s %-25s \n", "Điểm Thực Hành", "Điểm Lý Thuyết", "Điểm Case Study", "Điểm Phỏng Vấn","Thời Gian Thêm");
                                    for (Poin point:poinList) {
                                        if (point.getStudentId() == idStudent && point.getIdClazz() == idClazz && point.getIdModule() == idModule){
                                            System.out.printf("%-20s %-20s %-20s %-20s %-25s \n", point.getEnforcement(), point.getTheory(), point.getCasePoint(), point.getInterviewPoint(), point.getDate());
                                        }
                                    }
                                    a = false;
                                    return;
                                }
                                else {
                                    System.out.println("Bạn Nhập Sai Lớp");
                                }
                            }
                        }
                        else {
                            System.out.println("Bạn Nhập Sai Module");
                            System.out.println("Vui Lòng Nhập Module Từ 1 => 6");
                        }
                    }
                }
                else {
                    System.out.println("Không Có Học Sinh Trong Danh Sách");
                }
            }
        }
        while (a);
    }

}
