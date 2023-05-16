package models;

import java.time.LocalDate;

public class HocSinh implements Comparable<HocSinh>, IModel {
    private static int maxid = 0;
    private int studentId;
    private String name;
    private int yearOfBirth;

    private String academicAbility;
    private String address;
    private LocalDate dataTime;
    private double mathOne;
    private double mathTwo;
    private double engLishOne;
    private double engLishTwo;
    private double literatureOne;
    private double literatureTwo;
    private double mediumScore;

    public HocSinh() {
    }


    public String getaddress() {
        return address;
    }


    public HocSinh(String name,
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
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.mathOne = mathOne;
        this.mathTwo = mathTwo;
        this.engLishOne = englishOne;
        this.engLishTwo = englishTwo;
        this.literatureOne = literatureOne;
        this.literatureTwo = literatureTwo;
        this.address = address;
        this.mediumScore = mediumScore;
        this.academicAbility = academicAbility;
        this.dataTime = Datatime;

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public double getEngLishOne() {
        return engLishOne;
    }

    public void setEngLishOne(double engLishOne) {
        this.engLishOne = engLishOne;
    }

    public double getEngLishTwo() {
        return engLishTwo;
    }

    public void setEngLishTwo(double engLishTwo) {
        this.engLishTwo = engLishTwo;
    }

    public double getLiteratureOne() {
        return literatureOne;
    }

    public void setLiteratureOne(double literatureOne) {
        this.literatureOne = literatureOne;
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
    public LocalDate getDataTime() {
        return dataTime;
    }


    @Override
    public String toString() {
        return
                studentId + "," +
                        name + "," +
                        yearOfBirth + "," +
                        address + "," +
                        mathOne + "," +
                        mathTwo + "," +
                        engLishOne + "," +
                        engLishTwo + "," +
                        literatureOne + "," +
                        literatureOne + "," +
                        mediumScore + "," +
                        academicAbility + "," +
                        dataTime
                ;
    }

    @Override
    public int compareTo(HocSinh o) {
        return Integer.compare(this.studentId, o.studentId);
    }


    @Override
    public void parseData(String line) {
        String[] item = line.split(",");
        this.studentId = Integer.parseInt(item[0]);
        this.name = item[1];
        this.yearOfBirth = Integer.parseInt(item[2]);
        this.address = item[3];
        this.mathOne = Double.parseDouble(item[4]);
        this.mathTwo = Double.parseDouble(item[5]);
        this.engLishOne = Double.parseDouble(item[6]);
        this.engLishTwo = Double.parseDouble(item[7]);
        this.literatureOne = Double.parseDouble(item[8]);
        this.literatureTwo = Double.parseDouble(item[9]);
        this.mediumScore = Double.parseDouble(item[10]);
        this.academicAbility = item[11];
        this.dataTime = LocalDate.parse(item[12]);
    }
}
