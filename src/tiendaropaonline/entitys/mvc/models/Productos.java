/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaropaonline.entitys.mvc.models;

/**
 *
 * @author ProBook
 */
public class Productos {
    private Integer idProd;
    private String nombreProd;
    private double price;
    private Usuarios usuario;

    public Productos() {
    }

    public Productos(Integer idProd, String nombreProd, double price, Usuarios usuario) {
        this.idProd = idProd;
        this.nombreProd = nombreProd;
        this.price = price;
        this.usuario = usuario;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Productos{" + "idProd=" + idProd + ", nombreProd=" + nombreProd + ", price=" + price + ", usuario=" + usuario + '}';
    }
    
    
}
