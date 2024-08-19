package tiendaropaonline;

import java.util.Scanner;
import tiendaropaonline.entitys.DiscountManager;

/*Que tal profesor Alberto, en esta ocacion realice lo propuesto por la pauta de manera sencilla
llamando a la clase DiscountManager aca en el main, para evidenciar sus atributos y darle un poco mas de funcionamiento
,ademas de su propia estructura como tal, siguiendo el patron singleton.
De antemano muchas gracias por la revision y feedback.
*/
public class TiendaRopaOnline {

    static int opcionMenu;
    static Scanner sc = new Scanner(System.in);
    static DiscountManager discountManager = DiscountManager.getInstance();
    static boolean salirDoWhile = false;

    public static void main(String[] args) {
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
                    System.out.println(discountManager.getDescuentos());
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
}
