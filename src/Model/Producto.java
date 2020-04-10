
package Model;

/**
 *
 * @author lflores
 */
public class Producto {
    
    //Atributos de clase producto
    private int id;
    private String nomArticulo;
    private String descripcion;
    private double precio;
    private int cantidad;

    
    //Getters y Setters de la clase Producto
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomArticulo() {
        return nomArticulo;
    }

    public void setNomArticulo(String nomArticulo) {
        this.nomArticulo = nomArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    //Fin de Getters y setters
    
    
}
