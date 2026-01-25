package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HourContract {
   private LocalDate data;
   private Double valuePerHour;
   private Integer hours;
   private static final DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy"); //para criar a data

    public HourContract() {}

    public HourContract(String data, Integer hours, Double valuePerHour) {
        this.data = LocalDate.parse(data,fmt);
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public Double totalValue(){
        return valuePerHour*hours;  //valor total= horas * valor por horas
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valeuPerHour) {
        this.valuePerHour = valeuPerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}