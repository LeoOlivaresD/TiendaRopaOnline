
import java.util.Scanner;
import tiendaropaonline.entitys.comand.ApplyBasicDiscountCommand;
import tiendaropaonline.entitys.comand.ApplyMemberDiscountCommand;
import tiendaropaonline.entitys.comand.DiscountManager;
import tiendaropaonline.entitys.comand.Invoker;
import tiendaropaonline.entitys.comand.Product;
import tiendaropaonline.entitys.decorator.DiscountDecoratorA;
import tiendaropaonline.entitys.decorator.DiscountDecoratorB;
import tiendaropaonline.interfaces.IComponent;

public class TiendaRopaOnline {

    static int opcionMenu;
    static Scanner sc = new Scanner(System.in);
    static DiscountManager discountManager = DiscountManager.getInstance();
    static boolean salirDoWhile = false;

    public static void main(String[] args) {
        // Demostramos que tiene una instancia única
        DiscountManager anotherDiscountManager = DiscountManager.getInstance();
        System.out.println("¿Es la misma instancia? " + (discountManager == anotherDiscountManager));

        System.out.println("Bienvenido a ShopyOnline, tu tienda de ropas online");
        discountManager.getListaArticulos().add("Poleras");
        discountManager.getListaArticulos().add("Pantalones");
        discountManager.getListaArticulos().add("Chaquetas");
        discountManager.getListaArticulos().add("Zapatos");

        // Uso del patrón Decorator
        IComponent product = new Product("Polera", 100.0);
        IComponent discountedProduct = new DiscountDecoratorA(product);
        System.out.println("Producto: " + discountedProduct.getProd() + ", Precio con descuento: $" + discountedProduct.getDiscount());

        //Uso del patrón Command
        Invoker invoker = new Invoker();
        invoker.agregarComando(new ApplyBasicDiscountCommand(product));
        invoker.agregarComando(new ApplyMemberDiscountCommand(product));
        invoker.ejecutarComando();

        menu();
    }

    public static void menu() {
        do {
            System.out.println("Elija alguna de las siguiente opciones escribiendo el número según corresponda:");
            System.out.println("1: Ver descuentos.\n"
                    + "2: Ver artículos.\n"
                    + "3: Aplicar descuentos usando Decorator.\n"
                    + "4: Aplicar descuentos usando Command.\n"
                    + "5: Salir.");
            opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                // DESCUENTOS
                case 1:
                    System.out.println("Descuento disponible en cualquier compra por: ");
                    verDescuentos();
                    break;
                // VER ARTÍCULOS
                case 2:
                    for (String s : discountManager.getListaArticulos()) {
                        System.out.println(s);
                    }
                    break;
                // APLICAR DESCUENTOS USANDO DECORATOR
                case 3:
                    aplicarDescuentosDecorator();
                    break;
                // APLICAR DESCUENTOS USANDO COMMAND
                case 4:
                    aplicarDescuentosCommand();
                    break;
                // SALIR
                case 5:
                    salirDoWhile = true;
                    System.out.println("Saliendo del programa, hasta luego ..");
                    break;
                default:
                    System.out.println("Opción inválida, vuelva a intentarlo");
            }
        } while (!salirDoWhile);
    }

    public static void verDescuentos() {
        double precioBase = 100.0;
        System.out.println("Precio original: $" + precioBase);
        System.out.println("Precio con descuento normal: $" + discountManager.applyDiscount(precioBase, "basico"));
        System.out.println("Precio con descuento VIP: $" + discountManager.applyDiscount(precioBase, "miembro"));
        System.out.println("Precio con descuento especial: $" + discountManager.applyDiscount(precioBase, "vip"));
        System.out.println("Precio sin descuento: $" + discountManager.applyDiscount(precioBase, "ninguno"));
    }

    public static void aplicarDescuentosDecorator() {
        IComponent product = new Product("Polera", 100.0);
        IComponent discountedProductA = new DiscountDecoratorA(product);
        IComponent discountedProductB = new DiscountDecoratorB(product);
        System.out.println("Producto: " + discountedProductA.getProd() + ", Precio con descuento A: $" + discountedProductA.getDiscount());
        System.out.println("Producto: " + discountedProductB.getProd() + ", Precio con descuento B: $" + discountedProductB.getDiscount());
    }

    public static void aplicarDescuentosCommand() {
        IComponent product = new Product("Polera", 100.0);
        Invoker invoker = new Invoker();
        invoker.agregarComando(new ApplyBasicDiscountCommand(product));
        invoker.agregarComando(new ApplyMemberDiscountCommand(product));
        invoker.ejecutarComando();
    }

}
