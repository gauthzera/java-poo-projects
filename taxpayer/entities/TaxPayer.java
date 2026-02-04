package entities;

public abstract class TaxPayer {
    protected String name;
    protected Double anualIncome;

    public TaxPayer(String name,Double anualIncome){
        this.name=name;
        this.anualIncome=anualIncome;
    }

    public abstract Double tax();

    public String toString(){
        return String.format("%s: $ %.2f",name,tax());
    }

}