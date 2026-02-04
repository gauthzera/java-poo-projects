package entities;

public class Company extends TaxPayer{
    private int numberOfEmployees;

    public Company(String name,Double anualIncome,int numberOfEmployees){
        super(name,anualIncome);
        this.numberOfEmployees=numberOfEmployees;
    }

    @Override
    public Double tax(){
        double resultTax;
        if(numberOfEmployees>10){
            resultTax=anualIncome*0.14;
        }else{
            resultTax=anualIncome*0.16;
        }
        return resultTax;
    }


}