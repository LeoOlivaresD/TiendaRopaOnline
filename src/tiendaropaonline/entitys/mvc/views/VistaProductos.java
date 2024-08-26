
package tiendaropaonline.entitys.mvc.views;

import tiendaropaonline.entitys.mvc.models.Productos;


public class VistaProductos {
    public void mostrarProducto(Productos producto){
        System.out.println("Detalles del producto: ");
        System.out.println(producto.toString());
    }
}
