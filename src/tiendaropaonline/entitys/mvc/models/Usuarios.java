/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaropaonline.entitys.mvc.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ProBook
 */
public class Usuarios {
   private Integer idUser;
   private String nombreUser;
   private List<Productos> listaProductosAComprar = new ArrayList<>();

    public Usuarios() {
    }

    public Usuarios(Integer idUser, String nombreUser) {
        this.idUser = idUser;
        this.nombreUser = nombreUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public List<Productos> getListaProductosAComprar() {
        return listaProductosAComprar;
    }

    public void setListaProductosAComprar(List<Productos> listaProductosAComprar) {
        this.listaProductosAComprar = listaProductosAComprar;
    }
    
    @Override
    public String toString() {
        return "Usuarios{" + "idUser=" + idUser + ", nombreUser=" + nombreUser + ", listaProductosAComprar=" + listaProductosAComprar + '}';
    }
    
}
