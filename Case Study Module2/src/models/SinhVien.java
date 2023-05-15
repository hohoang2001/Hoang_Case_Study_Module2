package models;

import java.time.LocalDate;

public class SinhVien implements Comparable<SinhVien>, IModel {
    private static int maxid = 0;
    private int studenId;
    private String name;
    private int yearOfBirth;

    private String academicAbility;
    private String address;
    private LocalDate Datatime;
    private double mathOne;
    private double mathTwo;
    private double EnglishOne;
    private double EnglishTwo;
    private double literatureOne;
    private double literatureTwo;
    private double mediumScore;

    public SinhVien() {
    }


    public String getaddress() {
        return address;
    }


    public SinhVien(String name,
                    int yearOfBirth,
                    String address,
                    double mathOne,
                    double mathTwo,
                    double englishOne,
                    double englishTwo,
                    double literatureOne,
                    double literatureTwo,
                    double mediumScore,
                    String academicAbility,
                    LocalDate Datatime
    ) {
        this.studenId = ++maxid;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.mathOne = mathOne;
        this.mathTwo = mathTwo;
        this.EnglishOne = englishOne;
        this.EnglishTwo = englishTwo;
        this.literatureOne = literatureOne;
        this.literatureTwo = literatureTwo;
        this.address = address;
        this.mediumScore = mediumScore;
        this.academicAbility = academicAbility;
        this.Datatime = Datatime;

    }

    public int getStudenId() {
        return studenId;
    }

    public void setStudenId(int ma_sv) {
        studenId = studenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMathOne() {
        return mathOne;
    }

    public void setMathOne(double mathOne) {
        this.mathOne = mathOne;
    }

    public double getMathTwo() {
        return mathTwo;
    }

    public void setMathTwo(double mathTwo) {
        this.mathTwo = mathTwo;
    }

    public double getEnglishOne() {
        return EnglishOne;
    }

    public void setEnglishOne(double englishOne) {
        EnglishOne = englishOne;
    }

    public double getEnglishTwo() {
        return EnglishTwo;
    }

    public void setEnglishTwo(double englishTwo) {
        EnglishTwo = englishTwo;
    }

    public double getLiteratureOne() {
        return literatureOne;
    }

    public void setLiteratureOne(double literatureOne) {
        this.literatureOne = literatureOne;
    }

    public static int getMaxid() {
        return maxid;
    }

    public static void setMaxid(int maxid) {
        SinhVien.maxid = maxid;
    }

    public double getLiteratureTwo() {
        return literatureTwo;
    }

    public void setLiteratureTwo(double literatureTwo) {
        this.literatureTwo = literatureTwo;
    }

    public double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(double mediumScore) {
        this.mediumScore = mediumScore;
    }

    public String getAcademicAbility() {
        return academicAbility;
    }


    public LocalDate getDatatime() {
        return Datatime;
    }


    @Override
    public String toString() {
        return
                studenId + "," +
                        name + "," +
                        yearOfBirth + "," +
                        address + "," +
                        mathOne + "," +
                        mathTwo + "," +
                        EnglishOne + "," +
                        EnglishTwo + "," +
                        literatureOne + "," +
                        literatureOne + "," +
                        mediumScore + "," +
                        academicAbility + "," +
                        Datatime
                ;
    }

    @Override
    public int compareTo(SinhVien o) {
        return Integer.compare(this.studenId, o.studenId);
    }


    @Override
    public void parseData(String line) {
        String[] item = line.split(",");
        this.studenId = Integer.parseInt(item[0]);
        this.name = item[1];
        this.yearOfBirth = Integer.parseInt(item[2]);
        this.address = item[3];
        this.mathOne = Double.parseDouble(item[4]);
        this.mathTwo = Double.parseDouble(item[5]);
        this.EnglishOne = Double.parseDouble(item[6]);
        this.EnglishTwo = Double.parseDouble(item[7]);
        this.literatureOne = Double.parseDouble(item[8]);
        this.literatureTwo = Double.parseDouble(item[9]);
        this.mediumScore = Double.parseDouble(item[10]);
        this.academicAbility = item[11];
        this.Datatime = LocalDate.parse(item[12]);
    }
}
