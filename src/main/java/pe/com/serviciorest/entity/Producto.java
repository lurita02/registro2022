package pe.com.serviciorest.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Builder;

@Builder
@Entity(name = "Producto")
@Table(name = "t_producto")
public class Producto implements Serializable{
	
    private static final long serialVersionUID = 1L;
    //anotaciones
    @Id //para identificar la clave primaria
    @Column(name = "codpro")//para identificar el nombre de la columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement
    private long codigo;
    @Column(name = "nompro")
    private String nombre;
    @Column(name = "precpro")
    private double preciocompra;
    @Column(name = "prevpro")
    private double precioventa;
    @Column(name = "canpro")
    private int cantidad;
    @Column(name = "estpro")
    private boolean estado;
    @ManyToOne
    @JoinColumn(name="codcat",nullable = false)
    private Categoria categoria;

    public Producto() {
    }

    public Producto(long codigo, String nombre,
            double preciocompra, double precioventa,
            int cantidad, boolean estado,
            Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.preciocompra = preciocompra;
        this.precioventa = precioventa;
        this.cantidad = cantidad;
        this.estado = estado;
        this.categoria = categoria;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
