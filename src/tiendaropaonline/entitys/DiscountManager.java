package tiendaropaonline.entitys;

public class DiscountManager {
    //Declaracion de la instancia privada y estatica de la propia clase
    private static DiscountManager instance;

    //Constructor privado de mi clase
    private DiscountManager() {
    }
    
    //Cracion de metodo statico
    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }
}
