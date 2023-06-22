package Models;

import java.time.LocalDate;

public class Clazz implements IModel<Clazz> {
    private static int maxId = 0;
    private String name;
    private int clazzId;
    private int teacherId;
    private LocalDate date;

    public Clazz() {

    }

    public Clazz(  int teacherId, String name, LocalDate date) {
        this.teacherId = teacherId;
        this.name = name;
        this.date = date;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return  clazzId + ","
                + teacherId + ","
                + name + ","
                + date;
    }

    @Override
    public void parseData(String line) {
        String[] item = line.split(",");
        this.clazzId = Integer.parseInt(item[0]);
        this.teacherId = Integer.parseInt(item[1]);
        this.name = item[2];
        this.date = LocalDate.parse(item[3]);

    }
}
