
package remedialu3;

import Controller.CtrlProducto;
import Model.Producto;
import Model.QueriesProducto;
import View.Articulos;
import java.sql.SQLException;



/**
 *
 * @author lflores
 */
public class RemedialU3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Producto p = new Producto();
        Articulos art = new Articulos();
        QueriesProducto qp = new QueriesProducto();
        
        CtrlProducto cp = new CtrlProducto(p, art, qp);
        
        cp.iniciarVistaArticulos();
        art.setVisible(true);
        
        
    }
    
}
