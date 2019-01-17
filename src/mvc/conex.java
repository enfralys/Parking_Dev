/*
Clase Conexion
Funcion: Conexion a base de datos mysql y sqlite
Autor: William Cortez
Creacion: 14/01/2019
Ult Modificacion: 16/01/2019
*/
package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import views.RegistroVehiculo;

public class conex {
    private Connection conn;
    private PreparedStatement pstmt;
    // Metodo para conectar a Bd
    
    public void conectarMSQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/prg2","root","");
	} catch (Exception e) {
        	System.out.println("Error de conexion con la BD");
		//e.printStackTrace();
	}
    }
    //Metodo para cerrar conexion a BD
    public void conectarSQLITE() {
        try {
            //para sqlite
            //Class.forName("org.sqlite.jdbc");
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection( "jdbc:sqlite:BD.sqlite");
            System.out.print("Conexion realizada");
         } catch (Exception e) {e.printStackTrace();}        
    }
    public void desconectar() {
        try { conn.close(); } catch (SQLException e) {	e.printStackTrace();}
    } 
    public void BorrarTabla() {
        String sql;
        try {
            sql="DROP TABLE parking";
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al borrsr tabla en Base de Datos",null,0);
        }
    }
    public void CrearTabla() {
        String sql;
        try {
            sql="CREATE TABLE parking ( placa varchar(45) NOT NULL, visitante varchar(45) NOT NULL, puesto int(10) NOT NULL,  apart varchar(12) NOT NULL)";
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al crear tabla en Base de Datos",null,0);
        }
    }
    public void guardar(RegistroVehiculo reg, int puesto) {
        try {
            pstmt=conn.prepareStatement("insert into parking (placa, visitante, puesto, apart) values (?,?,?,?)");
            pstmt.setString(1, reg.getTxtPlaca().getText());
            pstmt.setString(2, reg.getTxtNombreVisitante().getText());
            pstmt.setInt(3, puesto);
            pstmt.setString(4, reg.getTxtApartamento().getText());
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    public registro consultar(int puesto) {
        registro est=new registro();
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement("select * from  parking where puesto=?");
            pstmt.setInt(1, puesto);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {  e.printStackTrace();
           if (e.getErrorCode()==0){this.CrearTabla();}
           if (e.getErrorCode()==1146){this.CrearTabla();}
            System.out.println("Error numero: "+e.getErrorCode());
        }    
        try {
            while (rs.next()){
                est.setApto(rs.getString("apart"));
                est.setNombre_invitado(rs.getString("visitante"));
                est.setPlaca(rs.getString("placa"));
                est.setPuesto(rs.getInt("puesto"));
                System.out.println("Puesto: "+rs.getInt("puesto"));
            }
        } catch (SQLException e) {  e.printStackTrace();}
        return est;
    }
    
}
