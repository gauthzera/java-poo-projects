import java.util.*;
import entities.*;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n=sc.nextInt();

        List<Product> list=new ArrayList<>();

        char op;
        String name;    //variáveis product
        double price;

        for(int i=0;i<n;i++){
            System.out.printf("Product #%d data:\n",i+1);
            System.out.print("Common used or imported (c/u/i)? ");
            op=sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            name=sc.nextLine();
            System.out.print("Price: ");
            price=sc.nextDouble();

            if(op=='c'){
                list.add(new Product(name,price));
            }else if(op=='i'){
                System.out.print("Customs fee: ");
                double cf=sc.nextDouble();
                list.add(new ImportedProduct(name,price,cf));
            }else if(op=='u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String data=sc.next();  
                list.add(new UsedProduct(name,price,data));
            }else{
                System.out.println("Invalid option, creating a common product."); //trata entrada inválida
                list.add(new Product(name,price));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for(Product p: list){
            System.out.println(p.priceTag());   //exibe as pricetags
        }

    sc.close();
    }
}
