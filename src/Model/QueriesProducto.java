
package Model;

import static Model.ConexionBD.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lflores
 */
public class QueriesProducto{
    //Producto p = new Producto();
    ResultSet rs;
    PreparedStatement ps = null;
    ConexionBD con;

    public QueriesProducto() throws SQLException {
        this.con = (ConexionBD) getConnection();
    }

    
    
    public boolean registrar(Producto pro) throws SQLException{
        
        
        
        try {
            String sql = "INSERT INTO articulos(nombre_articulo, descripcion, precio, cantidad) VALUES(?,?,?,?)";
            ps = ConexionBD.getConnection().prepareStatement(sql);
            ps.setString(1, pro.getNomArticulo());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(QueriesProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexionBD.cerrarConexion();
        }
        
        
        
    }
    
    public boolean modificar(Producto pro) throws SQLException{
        
        
        
        try {
            String sql = "UPDATE articulos SET nombre_articulo = ?, descripcion = ?, precio = ?, cantidad = ? WHERE id = ? ";
            ps = ConexionBD.getConnection().prepareStatement(sql);
            ps.setString(1, pro.getNomArticulo());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.setInt(5, pro.getId());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(QueriesProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexionBD.cerrarConexion();
        }
        
        
        
    }
    
    public boolean eliminar(Producto pro) throws SQLException{
        
        
        
        try {
            String sql = "DELETE FROM articulo WHERE id = ? ";
            ps = ConexionBD.getConnection().prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(QueriesProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexionBD.cerrarConexion();
            
        }
        
        
        
    }
    
    public boolean buscar(Producto pro) throws SQLException{
        
        
        
        try {
            String sql = "SELECT * FROM articulos WHERE nombre_articulo = ?";
            ps = ConexionBD.getConnection().prepareStatement(sql);
            ps.setInt(1, pro.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setNomArticulo(rs.getString("nombre_articulo"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                return true;
            }
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(QueriesProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexionBD.cerrarConexion();
        }
        
        
        
    }
    
}
