/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lflores
 */
public class ConexionBD {

    // Propiedades
    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;

    // Constructor
    private ConexionBD() {

        String url = "jdbc:mysql://localhost:3306/remedialu3";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String password = "root";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            //System.err.println(e);
            e.printStackTrace();
        }
    } // Fin constructor

    public static Connection getConnection() throws SQLException {

        if (conn == null) {
            new ConexionBD();
        }

        return conn;
    } // Fin getConnection

    public static Connection cerrarConexion() throws SQLException {
        if (conn != null) {
            conn.close();
        }
        return conn;
    }

}
