package tiendaropaonline.entitys.mvc.models;

public class CarritoCompra {

    private Integer idCompra;
    private Usuarios usuario;
    private Integer subTotal;
    private Integer total;

    public CarritoCompra() {
    }

    public CarritoCompra(Integer idCompra, Usuarios usuario, Integer subTotal, Integer total) {
        this.idCompra = idCompra;
        this.usuario = usuario;
        this.subTotal = subTotal;
        this.total = total;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CarritoCompra{" + "idCompra=" + idCompra + ", usuario=" + usuario + ", subTotal=" + subTotal + ", total=" + total + '}';
    }

    
}
