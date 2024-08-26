package tiendaropaonline.entitys.comand;


import tiendaropaonline.interfaces.IComponent;

public class Product implements IComponent {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getDiscount() {
        // Lógica base para aplicar descuentos
        return price;
    }

    @Override
    public String getProd() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}