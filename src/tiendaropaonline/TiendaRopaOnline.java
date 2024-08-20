package tiendaropaonline;

import java.util.Scanner;
import tiendaropaonline.entitys.DiscountManager;

public class TiendaRopaOnline {

    static int opcionMenu;
    static Scanner sc = new Scanner(System.in);
    static DiscountManager discountManager = DiscountManager.getInstance();
    static boolean salirDoWhile = false;

    public static void main(String[] args) {
         //Demostramos que tiene una instancia unica
        DiscountManager anotherDiscountManager = DiscountManager.getInstance();
        System.out.println("¿Es la misma instancia? " + (discountManager == anotherDiscountManager));
        
        System.out.println("Bienvenido a ShopyOnline, tu tienda de ropas online");
        discountManager.getListaArticulos().add("Poleras");
        discountManager.getListaArticulos().add("Pantalones");
        discountManager.getListaArticulos().add("Chaquetas");
        discountManager.getListaArticulos().add("Zapatos");
        menu();
    }

    public static void menu() {
        do {
            System.out.println("Elija alguna de las siguiente opciones escribiendo el numero segun corresponda:");
            System.out.println("1: Ver descuentos.\n"
                    + "2: Ver articulos.\n"
                    + "3: Salir.");
            opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                //DESCUENTOS
                case 1:
                    System.out.println("Descuento disponible en cualquier compra por: ");
                    verDescuentos();
                    break;
                //VER ARTICULOS
                case 2:
                    for(String s : discountManager.getListaArticulos()){
                        System.out.println(s);
                    }
                    break;
                //SALIR
                case 3:
                    salirDoWhile = true;
                    System.out.println("Saliendo del programa, hasta luego ..");
                    break;
                default:
                    System.out.println("Opcion invalida, vuelva a intentarlo");
            }
        } while (!salirDoWhile);
    }
    
    public static void verDescuentos(){
    double precioBase = 100.0;
        System.out.println("Precio original: $" + precioBase);
        System.out.println("Precio con descuento normal: $" + discountManager.applyDiscount(precioBase, "basico"));
        System.out.println("Precio con descuento VIP: $" + discountManager.applyDiscount(precioBase, "miembro"));
        System.out.println("Precio con descuento especial: $" + discountManager.applyDiscount(precioBase, "vip"));
        System.out.println("Precio sin descuento: $" + discountManager.applyDiscount(precioBase, "ninguno"));

    }
}
