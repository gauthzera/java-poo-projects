import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n=sc.nextInt();

        List<TaxPayer> list=new ArrayList<>();

        char op;
        String name;        //variáveis gerais
        double anualIncome;

        for(int i=0;i<n;i++){
            System.out.printf("Tax payer #%d:\n",i+1);
            System.out.print("Individual or company (i/c)? ");
            op=sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            name=sc.nextLine();

            System.out.print("Anual income: " );
            anualIncome=sc.nextDouble();

            if(op=='i'){
                System.out.print("Health expenditures: ");
                double healtExenp=sc.nextDouble();
                list.add(new Individual(name,anualIncome,healtExenp));  
            }else if(op=='c'){
                System.out.print("Number of employees: ");
                int numberEmp=sc.nextInt();
                list.add(new Company(name,anualIncome,numberEmp));
            }
        }
        double totalTaxes=0;    //soma das taxas
        System.out.println("\nTAXES PAID:");
        for(TaxPayer x: list){
            System.out.println(x);
            totalTaxes+=x.tax();
        }

        System.out.printf("\nTOTAL TAXES: $ %.2f",totalTaxes);

        sc.close();
    }
}