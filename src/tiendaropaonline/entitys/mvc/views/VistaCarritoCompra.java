package tiendaropaonline.entitys.mvc.views;

import java.util.Random;
import tiendaropaonline.entitys.mvc.models.CarritoCompra;
import tiendaropaonline.entitys.mvc.models.Productos;
import tiendaropaonline.entitys.mvc.models.Usuarios;

public class VistaCarritoCompra {

    public void mostrarCarritoCompra(Usuarios usuario, CarritoCompra carritoCompra) {
        Random random = new Random();
        int num = random.nextInt(99) + 1; // Genera un número entre 1 y 99
        carritoCompra.setIdCompra(num); //Le doy un id a la compra
        carritoCompra.setUsuario(usuario); //Fijo el usuario que esta comprando para acceder luego a su lista de productos
        System.out.println("Mostrando carrito de compras de: " + usuario.getNombreUser());
        System.out.println(usuario.getListaProductosAComprar()); //Muestro los productos del carrito que lleva el usuario
        double subTotal = 0;
        for (Productos productos : usuario.getListaProductosAComprar()) {
            subTotal += productos.getPrice();
        }
        System.out.println("SubTotal: " + subTotal);
    }

    public void eliminarProductoCarrito(Usuarios usuarios, int idPRodEliminar, CarritoCompra carritoCompra) {
        for (Productos p : usuarios.getListaProductosAComprar()) {
            if (idPRodEliminar == p.getIdProd()) {
                usuarios.getListaProductosAComprar().remove(p);
                System.out.println("Producto eliminado !");
                break;
            }
        }
    }
}
