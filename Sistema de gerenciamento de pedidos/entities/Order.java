package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime moment=LocalDateTime.now();
    private OrderStatus status;
    private Client client;

    private final List<OrderItem> items=new ArrayList<>();      //criação da lista
    private static final DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //formato para exibir a data

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
    }

    public void addItem(OrderItem x){
        items.add(x);
    }

    public void removeItem(OrderItem x){
        items.remove(x);
    }

    public Double total(){
        Double t=0.0;
        for(OrderItem item: items){
            t+=item.subTotal();     //soma o subtotal de todos os itens adicionados na lista
        }
        return t;
    }


    public String toString(){
        StringBuilder printItem=new StringBuilder();
        for(OrderItem item: items){     //string com todos os itens
            printItem.append(item + "\n");
        }

        return String.format("Order moment: %s \nOrder status: %s\nClient: %s\nOrder Items:\n%sTotal price: $%.2f",moment.format(fmt),status,client,printItem,total());

    }

}