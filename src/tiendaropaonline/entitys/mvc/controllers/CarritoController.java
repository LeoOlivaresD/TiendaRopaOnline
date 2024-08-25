
package tiendaropaonline.entitys.mvc.controllers;

import tiendaropaonline.entitys.mvc.models.CarritoCompra;
import tiendaropaonline.entitys.mvc.models.Usuarios;
import tiendaropaonline.entitys.mvc.views.VistaCarritoCompra;

public class CarritoController {
    private VistaCarritoCompra vistaCarritoCompra;
    private CarritoCompra carritoCompra;

    public CarritoController() {
    }

    public CarritoController(VistaCarritoCompra vistaCarritoCompra, CarritoCompra carritoCompra) {
        this.vistaCarritoCompra = vistaCarritoCompra;
        this.carritoCompra = carritoCompra;
    }
    public void mostrarCarritoCompra(Usuarios usuario, VistaCarritoCompra vistaCarritoCompra, CarritoCompra carritoCompra){
    vistaCarritoCompra.mostrarCarritoCompra(usuario, carritoCompra);
    }
    public void eliminarProducto(Usuarios usuario, VistaCarritoCompra vistaCarritoCompra, int idProd){
    vistaCarritoCompra.eliminarProductoCarrito(usuario, idProd, carritoCompra);
    }
}
