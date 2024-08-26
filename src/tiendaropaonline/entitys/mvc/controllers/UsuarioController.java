package tiendaropaonline.entitys.mvc.controllers;

import tiendaropaonline.entitys.mvc.models.Usuarios;
import tiendaropaonline.entitys.mvc.views.VistaUsuarios;

public class UsuarioController {

    private Usuarios usuario;
    private VistaUsuarios usuarioView;
    
    public UsuarioController(Usuarios usuario, VistaUsuarios usuarioView) {
        this.usuario = usuario;
        this.usuarioView = usuarioView;
    }
    
    public void actualizarUsuario(Integer id, String nombreUser) {
        usuario.setIdUser(id);
        usuario.setNombreUser(nombreUser);
        usuarioView.mostrarUsuario(usuario);
    }
}
