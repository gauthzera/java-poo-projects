package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
    private LocalDate manufactureDate;
    private final DateTimeFormatter fmt= DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UsedProduct(String name, Double price, String datastr) {
        super(name, price);
        this.manufactureDate = LocalDate.parse(datastr,fmt);
    }

    @Override
    public String priceTag(){
        return String.format("%s (used) $ %.2f (Manufacture date: %s)",name,price,manufactureDate.format(fmt));
    }
}