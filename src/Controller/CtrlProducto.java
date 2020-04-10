
package Controller;

import Model.Producto;
import Model.QueriesProducto;
import View.Articulos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lflores
 */
public class CtrlProducto implements ActionListener{
    private Producto prod;
    private Articulos art;
    private QueriesProducto qp;

    public CtrlProducto(Producto prod, Articulos art, QueriesProducto qp) {
        this.prod = prod;
        this.art = art;
        this.qp = qp;
        this.art.btnBuscar.addActionListener(this);
        this.art.btnEliminar.addActionListener(this);
        this.art.btnGuardar.addActionListener(this);
        this.art.btnLimpiar.addActionListener(this);
        this.art.btnModificar.addActionListener(this);
        
    }
    
    public void iniciarVistaArticulos(){
        art.setTitle("Articulos");
        art.setLocationRelativeTo(null);
        //art.txtId.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == art.btnGuardar){
            try {
                prod.setNomArticulo(art.txtArticulo.getText());
                prod.setDescripcion(art.txtDesc.getText());
                prod.setPrecio(Double.parseDouble(art.txtPrecio.getText()));
                prod.setCantidad(Integer.parseInt(art.txtPrecio.getText()));
                
                if(qp.registrar(prod)){
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Registrar Articulo");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == art.btnModificar){
            try {
                prod.setId(Integer.parseInt(art.txtId.getText()));
                prod.setNomArticulo(art.txtArticulo.getText());
                prod.setDescripcion(art.txtDesc.getText());
                prod.setPrecio(Double.parseDouble(art.txtPrecio.getText()));
                prod.setCantidad(Integer.parseInt(art.txtPrecio.getText()));
                
                if(qp.registrar(prod)){
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Registrar Articulo");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == art.btnEliminar){
            try {
                prod.setId(Integer.parseInt(art.txtId.getText()));
                
                
                if(qp.eliminar(prod)){
                    JOptionPane.showMessageDialog(null, "Registro eliminado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar registro");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == art.btnBuscar){
            try {
                prod.setId(Integer.parseInt(art.txtId.getText()));
                
                
                if(qp.buscar(prod)){
                    art.txtId.setText(String.valueOf(prod.getId()));
                    art.txtArticulo.setText(String.valueOf(prod.getNomArticulo()));
                    art.txtDesc.setText(String.valueOf(prod.getDescripcion()));
                    art.txtPrecio.setText(String.valueOf(prod.getPrecio()));
                    art.txtCant.setText(String.valueOf(prod.getCantidad()));
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se encuentra articulo");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == art.btnLimpiar){
            limpiar();
        }
        
        
        
    }
    
    
    
    
    
    
    public void limpiar(){
        art.txtArticulo.setText(null);
        art.txtDesc.setText(null);
        art.txtPrecio.setText(null);
        art.txtCant.setText(null);
        art.txtId.setText(null);
    }
    
    
    
    
    
    
}
