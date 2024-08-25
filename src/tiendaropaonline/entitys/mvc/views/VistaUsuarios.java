
package tiendaropaonline.entitys.mvc.views;

import tiendaropaonline.entitys.mvc.models.Usuarios;

public class VistaUsuarios {
    
    public void registrarUsuario(Usuarios usuarios){
    usuarios.setIdUser(usuarios.getIdUser());
    usuarios.setNombreUser(usuarios.getNombreUser());
    }
   public void mostrarUsuario(Usuarios usuario){
       System.out.println("Datos de usuario actual: \n"
               + "ID:" + usuario.getIdUser() + "\n"
                       + "Nombre: " + usuario.getNombreUser());
   } 
}
