package tiendaropaonline.entitys.mvc.controllers;

import java.util.List;
import tiendaropaonline.entitys.mvc.models.Productos;
import tiendaropaonline.entitys.mvc.views.VistaProductos;

public class ProductoController {

    private Productos productos;
    private VistaProductos vistaProductos;

    public ProductoController(Productos productos, VistaProductos vistaProductos) {
        this.productos = productos;
        this.vistaProductos = vistaProductos;
    }

    public ProductoController() {
    }

    public void guardarProductos(VistaProductos vistaProductos, List<Productos> listaProds, Productos productos) {
        for (Productos productoListdo : listaProds) {
            productos.setIdProd(productoListdo.getIdProd());
            productos.setNombreProd(productoListdo.getNombreProd());
            productos.setPrice(productoListdo.getPrice());
        }
        //Cargado de productos
       
    }
    public void mostrarListaProds(VistaProductos vistaProductos, List<Productos> listaProds){
     System.out.println("Cargando productos...");
        //MOSTRAR PRODUCTOS DESDE VISTA
        for (Productos producto : listaProds) {
            //LLAMO A LA VISTA PARA MOSTRAR MIS PRODUCTOS
            vistaProductos.mostrarProducto(producto);
        }
    }
}
