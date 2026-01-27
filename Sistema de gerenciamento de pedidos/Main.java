import entities.*;

import java.util.Locale;
import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);

        String name,email;
        String birthDate;
        String statusstr;
        System.out.println("Enter client data: ");

        System.out.print("Name: ");
        name=sc.nextLine();
        System.out.print("Email: ");
        email=sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        birthDate=sc.nextLine();
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        statusstr=sc.next();

        OrderStatus status=OrderStatus.valueOf(statusstr.toUpperCase());
        Order order= new Order(status,new Client(name,email,birthDate)); //criação do pedido;

        System.out.println();
        System.out.print("How many items to this order? ");
        int n=sc.nextInt();
        sc.nextLine();

        String productName;
        double productPrice;
        int quantity;
        for(int i=0;i<n;i++){
            System.out.printf("Enter #%d item data:\n",i+1);
            System.out.print("Product name: ");
            productName=sc.nextLine();
            System.out.print("Product price: ");
            productPrice=sc.nextDouble();
            System.out.print("Quantity: ");
            quantity=sc.nextInt();
            sc.nextLine();

            order.addItem(new OrderItem(quantity,new Product(productName,productPrice))); //cria produto e adiciona item
        }

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.print(order);
        
        sc.close();
    }
}