package entities;

public class Individual extends TaxPayer {
    private double healthExpenditures;

    public Individual(String name,Double anualIncome,Double healthExpenditures){
        super(name,anualIncome);
        this.healthExpenditures=healthExpenditures;
    }

    @Override
    public Double tax(){
        double resulTax;
        if(anualIncome<20000){
            resulTax= 0.15*anualIncome;
        }else{
            resulTax=0.25*anualIncome;
        }

        if(healthExpenditures!=0){
            resulTax-=healthExpenditures*0.5;
        }
        if(resulTax<0)resulTax=0;

        return resulTax;
    }
}