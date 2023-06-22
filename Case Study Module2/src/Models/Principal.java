package Models;

import java.time.LocalDate;

public class Principal extends Teacher {
    public Principal(String name, int yearOfBirth, String phone, String email, String address, String position, LocalDate dataTime) {
        super(name, yearOfBirth, phone, email, address, position, dataTime);
    }

    @Override
    public String toString() {
        return
                name + "," +
                        yearOfBirth + "," +
                        phone + "," +
                        email + "," +
                        address + "," +
                        position + "," +
                        dataTime
                ;
    }
    @Override
    public void parseData(String line) {
        String[] item = line.split(",");
        this.name = item[0];
        this.yearOfBirth = Integer.parseInt(item[1]);
        this.phone = item[2];
        this.email = item[3];
        this.address = item[4];
        this.position = item[5];
        this.dataTime = LocalDate.parse(item[6]);
    }

}
