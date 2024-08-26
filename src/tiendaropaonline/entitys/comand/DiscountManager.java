package tiendaropaonline.entitys.comand;


import java.util.ArrayList;
import java.util.List;
import tiendaropaonline.entitys.decorator.DiscountDecoratorA;
import tiendaropaonline.entitys.decorator.DiscountDecoratorB;
import tiendaropaonline.entitys.mvc.models.Productos;
import tiendaropaonline.interfaces.IComponent;

public class DiscountManager {
    // Declaración de la instancia privada y estática de la propia clase
    private static DiscountManager instance;
    
    // Constructor privado de mi clase
    private DiscountManager() {
    }

    // Atributos únicos de mi clase para concepto de pruebas en el main
    private List<String> listaArticulos = new ArrayList<>();
    private List<Productos> listaProds = new ArrayList<>();
    // Getters & Setters
    public List<String> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<String> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public List<Productos> getListaProds() {
        return listaProds;
    }

    public void setListaProds(List<Productos> listaProds) {
        this.listaProds = listaProds;
    }
    
    // Creación de método estático para retornar mi objeto y en caso de ser nulo, se creará una instancia
    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    public double applyDiscount(double price, String discountType) {
        IComponent product = new Product("Producto", price);
        switch (discountType) {
            case "basico":
                product = new DiscountDecoratorA(product);
                break;
            case "miembro":
                product = new DiscountDecoratorB(product);
                break;
            
            default:
                break;
        }
        return product.getDiscount();
    }
}
