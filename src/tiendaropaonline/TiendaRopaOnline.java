
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import tiendaropaonline.entitys.comand.ApplyBasicDiscountCommand;
import tiendaropaonline.entitys.comand.ApplyMemberDiscountCommand;
import tiendaropaonline.entitys.comand.DiscountManager;
import tiendaropaonline.entitys.comand.Invoker;
import tiendaropaonline.entitys.comand.Product;
import tiendaropaonline.entitys.decorator.DiscountDecoratorA;
import tiendaropaonline.entitys.decorator.DiscountDecoratorB;
import tiendaropaonline.entitys.mvc.controllers.CarritoController;
import tiendaropaonline.entitys.mvc.controllers.ProductoController;
import tiendaropaonline.entitys.mvc.controllers.UsuarioController;
import tiendaropaonline.entitys.mvc.models.CarritoCompra;
import tiendaropaonline.entitys.mvc.models.Productos;
import tiendaropaonline.entitys.mvc.models.Usuarios;
import tiendaropaonline.entitys.mvc.views.VistaCarritoCompra;
import tiendaropaonline.entitys.mvc.views.VistaProductos;
import tiendaropaonline.entitys.mvc.views.VistaUsuarios;
import tiendaropaonline.interfaces.IComponent;

public class TiendaRopaOnline {

    static int opcionMenu;
    static Scanner sc = new Scanner(System.in);
    static DiscountManager discountManager = DiscountManager.getInstance();
    static boolean salirDoWhile = false;
    //Instancias para MVC

    //USUARIO
    static Usuarios usuario = new Usuarios();
    static VistaUsuarios vistaUsuarios = new VistaUsuarios();
    static UsuarioController usuarioController = new UsuarioController(usuario, vistaUsuarios);

    //CARRITO DE COMPRAS
    static CarritoCompra carritoCompra = new CarritoCompra();
    static VistaCarritoCompra vistaCarritoCompra = new VistaCarritoCompra();
    static CarritoController carritoControllerc = new CarritoController(vistaCarritoCompra, carritoCompra);

    public static void main(String[] args) {

        //PRODUCTOS
        VistaProductos vistaProductos = new VistaProductos();
        Productos productos = new Productos();
        ProductoController productoController = new ProductoController(productos, vistaProductos);

        List<Productos> listaProductos = new ArrayList<>();
        Productos producto1 = new Productos(1, "Polera Nike", 14000.0);
        Productos producto2 = new Productos(2, "Polera Adidas", 12000.0);
        Productos producto3 = new Productos(3, "Casaca", 60000.0);
        Productos producto4 = new Productos(4, "Jeans Americanino", 25000.0);
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);

        productoController.guardarProductos(vistaProductos, listaProductos, productos);

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

        menu(productoController, vistaProductos, listaProductos);
    }

    public static void menu(ProductoController productoController, VistaProductos vistaProductos, List<Productos> listaProductos) {
        do {
            System.out.println("Elija alguna de las siguiente opciones escribiendo el número según corresponda:");
            System.out.println("1: Ver descuentos.\n"
                    + "2: Ver artículos.\n"
                    + "3: Aplicar descuentos usando Decorator.\n"
                    + "4: Aplicar descuentos usando Command.\n"
                    + "5: Registrar Usuario.\n"
                    + "6: Mostrar Usuario actual.\n"
                    + "7: Ir a carrito de compras.\n"
                    + "8: Eliminar producto de carrito.\n"
                    + "9: Salir.");
            opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                // DESCUENTOS
                case 1:
                    System.out.println("Descuento disponible en cualquier compra por: ");
                    verDescuentos();
                    break;
                // VER ARTÍCULOS
                case 2:
                    productoController.mostrarListaProds(vistaProductos, listaProductos);
                    System.out.println("Si deseas comprar algo porfavor registrate. \n"
                            + "pulsa \"ENTER\" para continuar");
                    sc.nextLine();
                    sc.nextLine();
                    if (usuario.getIdUser() != null) {
                        System.out.println("Desea comprar algun producto ? (Responda \"1\" si su respuesta es si y 2 para \"no\")");
                        int respuesta = sc.nextInt();
                        switch (respuesta) {
                            case 1:
                                System.out.println("Ingrese el id del producto para agregar a carrito. (Numero entero que aparece en pantalla)");
                                productoController.mostrarListaProds(vistaProductos, listaProductos);
                                respuesta = sc.nextInt();
                                boolean productoEncontrado = false;

                                for (Productos prodBuscado : listaProductos) {
                                    if (respuesta == prodBuscado.getIdProd()) {
                                        usuario.getListaProductosAComprar().add(prodBuscado);
                                        System.out.println("Producto agregado con éxito!");
                                        productoEncontrado = true;
                                        break;
                                    }
                                }

                                if (!productoEncontrado) {
                                    System.out.println("Opción no válida");
                                }
                                break;
                            default:
                                System.out.println("Saliendo al menu principal");
                        }
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
                //REGISTRAR USUARIO
                case 5:
                    String nombreUsuario;
                    int idUsuario;
                    try {
                        System.out.println("Registrando usuario...");
                        System.out.println("Por favor ingrese un numero entero, el cual sera su identificador unico");
                        idUsuario = sc.nextInt();
                        sc.nextLine();
                        usuario.setIdUser(idUsuario);
                    } catch (InputMismatchException exception) {
                        System.out.println("Error !, por favor elige un numero valido e intentelo nuevamente");
                        sc.next(); //limpio buffer
                    }
                    System.out.println("Id registrado con exito !");
                    System.out.println("Ingrese el nombre de usuario a registrar");
                    nombreUsuario = sc.nextLine();
                    usuario.setNombreUser(nombreUsuario);
                    vistaUsuarios.registrarUsuario(usuario);
                    System.out.println("Usuario registrado con exito");
                    break;
                //MOSTRAR USUARIO ACTUAL
                case 6:
                    vistaUsuarios.mostrarUsuario(usuario);
                    break;
                //CARRITO DE COMPRAS
                case 7:
                    carritoControllerc.mostrarCarritoCompra(usuario, vistaCarritoCompra, carritoCompra);
                    break;
                //ELIMINAR PRODUCTO DE CARRITO  
                case 8:
                    carritoControllerc.mostrarCarritoCompra(usuario, vistaCarritoCompra, carritoCompra);
                    System.out.println("Escribe el numero de id del producto que deseas eliminar");
                    int idProd = sc.nextInt();
                    carritoControllerc.eliminarProducto(usuario, vistaCarritoCompra, idProd);
                    break;
                // SALIR
                case 9:
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
