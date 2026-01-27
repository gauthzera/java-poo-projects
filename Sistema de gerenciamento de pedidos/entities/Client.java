package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    private String name;
    private String email;
    private LocalDate birthDate;

    private static final DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Client(String name, String email, String birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = LocalDate.parse(birthDate,fmt);
    }

    public String toString(){
        return String.format("%s (%s) - %s",name,birthDate.format(fmt),email);
    }
}