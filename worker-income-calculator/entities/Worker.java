package entities;
import java.util.ArrayList;
import java.util.List;

public class Worker {
   private String name;
   private WorkerLevel level;
   private Double baseSalary;
   private Department dept;

   private List<HourContract> contractList= new ArrayList<>();  //cria lista  de contrato

    public Worker(String name, WorkerLevel level, Double baseSalary, Department dept) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.dept = dept;
    }

    public void addContract(HourContract contract){
        contractList.add(contract);
    }
    public void removeContract(HourContract contract){
        contractList.remove(contract);
    }

    public Double income(int month, int year){
        Double total=baseSalary;
        for(HourContract contract : contractList){
            if(month==contract.getData().getMonthValue() && year==contract.getData().getYear()){
                total+=contract.totalValue(); //adiciona valor do contrato no tptal
            }
        }
        return total;
    }

    public void result(String data){
        String[] dateArr=data.split("/");
        int month=Integer.parseInt(dateArr[0]);
        int year=Integer.parseInt(dateArr[1]);
        System.out.printf("Name: %s\nDepartment: %s\nIncome for %02d/%d: %.2f\n",name,dept,month,year,income(month,year));
    }

}


