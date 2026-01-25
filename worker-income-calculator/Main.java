import java.util.Locale;
import java.util.Scanner;
import entities.*;

public class Main{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);

        String dpt,name,level;
        Double base_salary;
        System.out.print("Enter department's name: ");
        dpt=sc.nextLine();

        System.out.print("Name: ");
        name=sc.nextLine();

        System.out.print("Level: ");
        level=sc.next();

        System.out.print("Base salary: ");
        base_salary=sc.nextDouble();
        sc.nextLine();

        WorkerLevel lvl= WorkerLevel.valueOf(level.toUpperCase());

        Worker x=new Worker(name, lvl,base_salary,new Department(dpt));  //cria objeto worker

        System.out.println();
        System.out.print("How many contracts to this worker? ");
        int n=sc.nextInt();

        String date;
        Double value;   //variáveis para criar contrato
        Integer hrs;
        for(int i=0;i<n;i++){
            System.out.printf("Enter the contract #%d data:\n",i+1);
            System.out.print("Date (DD/MM/YYYY): ");
            date=sc.next();
            System.out.print("Value per hour: ");
            value= sc.nextDouble();
            System.out.print("Duration (hours): ");
            hrs=sc.nextInt();
            //adiciona contrato na lista de contatos
            x.addContract(new HourContract(date,hrs,value));
        }

        System.out.println();

        System.out.print("Enter a month and year to calculate income (MM/YYYY): ");
        String date2= sc.next();    //data para consulta

        x.result(date2);    //faz a consulta e exibe resultado

        sc.close();
    }
}