package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;
    
    public OrderItem(Integer quantity,Product product) {
        this.quantity = quantity;
        this.price = product.getPrice(); //pega o preço do producto
        this.product = product;
    }

    public Double subTotal(){
        return price * quantity;
    }

    public String toString(){
        return String.format("%s, $%.2f, Quantity: %d, Subtotal: $%.2f",product.getName(),price,quantity,subTotal());
    }
}