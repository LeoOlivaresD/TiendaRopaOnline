package tiendaropaonline.entitys;

import java.util.ArrayList;
import java.util.List;

public class DiscountManager {
    //Declaracion de la instancia privada y estatica de la propia clase
    private static DiscountManager instance;

    //Constructor privado de mi clase
    private DiscountManager() {
    }
    //Atributos unicos de mi clase para concepto de pruebas en el main
    private String descuentos = "30%";
    private List<String> listaArticulos = new ArrayList<>();
    // Getters & Setters
    public String getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(String descuentos) {
        this.descuentos = descuentos;
    }

    public List<String> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<String> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }
    
    
    //Cracion de metodo statico ñpara retornar mi objeto y en caso de ser nulo , se creara una instancia
    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }
    
    public double applyDiscount(double price, String discountType) {
        
        switch (discountType) {
            case "basico":
                return price * 0.9; // 10% 
            case "miembro":
                return price * 0.80; // 20% 
            case "vip":
                return price * 0.70; // 30%
            default:
                return price; // Sin descuento
        }
    }
}
