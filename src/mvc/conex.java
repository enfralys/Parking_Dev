/*
Clase Conexion
Funcion: Conexion a base de datos mysql y sqlite
Autor: William Cortez
Creacion: 14/01/2019
Ult Modificacion: 14/02/2019
*/
package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.XmlElement;
import views.*;

public class conex {
    private Connection conn;
    private PreparedStatement pstmt;
    // Metodo para conectar a Bd
    
    public void conectarMSQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:17770/zkeco_db","root","");
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
            sql="CREATE TABLE parking ( placa varchar(45) NOT NULL, visitante varchar(45) NOT NULL, puesto int(10) NOT NULL,  apart varchar(12) NOT NULL,  tarjeta varchar(12) NOT NULL,  estado varchar(12) NOT NULL, fechareg DATETIME DEFAULT CURRENT_TIMESTAMP)";
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al crear tabla en Base de Datos",null,0);
        }
        try {
            sql="CREATE TABLE peatones ( tipo int, cedula int, nombres varchar(25) NOT NULL, apellidos varchar(25) NOT NULL, apart varchar(12) NOT NULL,  fechareg DATETIME DEFAULT CURRENT_TIMESTAMP)";
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al crear tabla en Base de Datos",null,0);
        }
    }
    public void guardar(RegistroVehiculo reg, int puesto) {
        try {
            pstmt=conn.prepareStatement("insert into parking (placa, visitante, puesto, apart,tarjeta,estado) values (?,?,?,?,?,'entrada')");
            pstmt.setString(1, reg.getTxtPlaca().getText());
            pstmt.setString(2, reg.getTxtNombreVisitante().getText());
            pstmt.setInt(3, puesto);
            pstmt.setString(4, reg.getTxtApartamento().getText());
            pstmt.setString(5, reg.getTxtTarjeta().getText());
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    public void guardarp(RegistroPeaton reg) {
        try {
            pstmt=conn.prepareStatement("insert into peatones (tipo, cedula, nombres , apellidos , apart )values (?,?,?,?,?)");
            pstmt.setInt(1, reg.getCmbTipoPeaton().getSelectedIndex());
            pstmt.setInt(2, Integer.parseInt(reg.getTxtCedulaPeaton().getText()));
            pstmt.setString(3, reg.getTxtNombrePeaton().getText());
            pstmt.setString(4, reg.getTxtApellidoPeaton().getText());
            pstmt.setString(5, reg.getTxtAptoAVisitar().getText());
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    public void salida(RegistroVehiculo reg, int puesto) {
        try {
            pstmt=conn.prepareStatement("update parking set estado='salida' where puesto=? and estado like 'entrada'");
            pstmt.setString(1, reg.getTxtPlaca().getText());
            pstmt.setString(2, reg.getTxtNombreVisitante().getText());
            pstmt.setInt(3, puesto);
            pstmt.setString(4, reg.getTxtApartamento().getText());
            pstmt.setString(5, String.valueOf(puesto));
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
     public void salida(int puesto) {
        try {
            pstmt=conn.prepareStatement("update parking set estado='salida' where puesto=? and estado like 'entrada'");
            pstmt.setInt(1, puesto);
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    public registro consultar(int puesto) {
        registro est=new registro();
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement("select * from  parking where puesto=? and estado like 'entrada'");
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
                est.setTarjeta(rs.getString("tarjeta"));
            }
        } catch (SQLException e) {  e.printStackTrace();}
        return est;
    }
    public registro consultarEntradas(int puesto) {
        registro est=new registro();
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement("select * from  parking where puesto=? and estado like 'entrada'");
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
    public ResultSet consultarEntradas() {
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement("select * from  parking where estado like 'entrada'");
            rs=pstmt.executeQuery();
        } catch (SQLException e) {  e.printStackTrace();
           if (e.getErrorCode()==0){this.CrearTabla();}
           if (e.getErrorCode()==1146){this.CrearTabla();}
           System.out.println("Error numero: "+e.getErrorCode());
        }    
        return rs;
    }
    public String salidas(){
        registro est=new registro();
        String a = "";
	ResultSet rs=null;
	try {
	    pstmt=conn.prepareStatement("select * from  acc_monitor_log ");	          
	    rs=pstmt.executeQuery(); 	
        } catch (SQLException e) {  e.printStackTrace(); }    
	try {
            if (rs.last()){ a= rs.getString("card_no");}
	} catch (SQLException e) {  e.printStackTrace();}
	return a;
    }
    public JTable CargarTablaHistorias(JTable tabla){
        DefaultTableModel model;
        try {
            String [] Titulos={"Puesto","Tarjeta","Placa","Apartamento","Estado","Fecha"};
            String[] Registros= new String[6];
            pstmt=conn.prepareStatement("select * from  parking ");
            //pstmt=conn.prepareStatement("select * from  parking where estado like 'entrada'");
            ResultSet rs = pstmt.executeQuery(); 	
            model = new DefaultTableModel(null,Titulos);
            try{
                while(rs.next()){
                    Registros[0]=rs.getString("puesto");
                    Registros[1]=rs.getString("tarjeta");
                    Registros[2]=rs.getString("placa");
                    Registros[3]=rs.getString("apart");
                    Registros[4]=rs.getString("estado");
                    Registros[5]=rs.getString("fechareg");
                    model.addRow(Registros);
                }
            }catch(SQLException e){ 
                System.out.print("Error:"+e.getMessage());
                e.printStackTrace();
            }
            tabla.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tabla;
    }
    public JTable CargarTablaConsulta(JTable tabla){
        DefaultTableModel model;
        try {
            String [] Titulos={"Tarjeta","Tipo","Placa","Apartamento","Estado","Fecha"};
            String[] Registros= new String[6];
            pstmt=conn.prepareStatement("select * from  parking where estado like 'entrada'");
            ResultSet rs = pstmt.executeQuery(); 	
            model = new DefaultTableModel(null,Titulos);
            try{
                while(rs.next()){
                    Registros[0]=rs.getString("tarjeta");
                    Registros[1]=rs.getString("puesto");
                    Registros[2]=rs.getString("placa");
                    Registros[3]=rs.getString("apart");
                    Registros[4]=rs.getString("puesto");
                    Registros[5]=rs.getString("visitante");
                    model.addRow(Registros);
                }
            }catch(SQLException e){ 
                System.out.print("Error:"+e.getMessage());
                e.printStackTrace();
            }
            tabla.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tabla;
    }
    public JTable actTablaPea(JTable tabla, String sql){
        DefaultTableModel model;
        try {
            String [] Titulos={"Cedula","Nombre","Apellido","Apartamento","Tipo","Fecha"};
            String[] Registros= new String[6];
            pstmt=conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(); 	
            model = new DefaultTableModel(null,Titulos);
            try{
                while(rs.next()){
                    Registros[0]=rs.getString("cedula");
                    Registros[1]=rs.getString("nombres");
                    Registros[2]=rs.getString("apellidos");
                    Registros[3]=rs.getString("apart");
                    if (rs.getInt("tipo")==0){Registros[4]="Visitante";}
                    else{Registros[4]="Trabajador";}
                    
                    Registros[5]=rs.getString("fechareg");
                    model.addRow(Registros);
                }
            }catch(SQLException e){ 
                System.out.print("Error:"+e.getMessage());
                e.printStackTrace();
            }
            tabla.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tabla;
    }
    public void ActTabla(int i, JTable tlbHistorialVehiculos) {
        DefaultTableModel model;
        try {
            String [] Titulos={"Tarjeta","Tipo","Placa","Apartamento","Estado","Fecha"};
            String[] Registros= new String[6];
            //pstmt=conn.prepareStatement("select * from  parking where estado like 'salida'");
            // SELECT * FROM ordenes WHERE fecha_registro BETWEEN '10/06/2006' AND '16/06/2006'
            pstmt=conn.prepareStatement("select * from  parking where fechareg>=?");
             //Date miDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
             /*
        
//Caso 1: obtener la hora y salida por pantalla con formato:
DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
System.out.println("Hora: "+hourFormat.format(date));
//Caso 2: obtener la fecha y salida por pantalla con formato:

System.out.println("Fecha: "+dateFormat.format(date));
//Caso 3: obtenerhora y fecha y salida por pantalla con formato:
DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
System.out.println("Hora y fecha: "+hourdateFormat.format(date));
        
        */
           Date date = new Date();
            //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat dia = new SimpleDateFormat("dd");
            DateFormat mes = new SimpleDateFormat("MM");
            DateFormat anio = new SimpleDateFormat("yyyy");
            System.out.println(dateFormat.format(date));
            pstmt.setString(1, dateFormat.format(date));
            ResultSet rs = pstmt.executeQuery(); 	
            model = new DefaultTableModel(null,Titulos);
            try{
                while(rs.next()){
                    Registros[0]=rs.getString("tarjeta");
                    Registros[1]=rs.getString("puesto");
                    Registros[2]=rs.getString("placa");
                    Registros[3]=rs.getString("apart");
                    Registros[4]=rs.getString("puesto");
                    Registros[5]=rs.getString("visitante");
                    model.addRow(Registros);
                }
            }catch(SQLException e){ 
                System.out.print("Error:"+e.getMessage());
                e.printStackTrace();
            }
            tlbHistorialVehiculos.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      //  return tabla;
    }
}
