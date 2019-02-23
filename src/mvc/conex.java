/*
Clase Conexion
Funcion: Conexion a base de datos mysql y sqlite
Autor: William Cortez
Creacion: 14/01/2019
Ult Modificacion: 14/02/2019
*/
package mvc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.XmlElement;
import plugins.comun;
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
        	//System.out.println("Error de conexion con la BD");
		e.printStackTrace();
	}
    }
    //Metodo para cerrar conexion a BD
    public void conectarSQLITE() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection( "jdbc:sqlite:parking.sqlite");
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
            sql="CREATE TABLE parking ( id INTEGER NOT NULL DEFAULT 1 PRIMARY KEY AUTOINCREMENT UNIQUE, placa varchar(45) NOT NULL, visitante varchar(45) NOT NULL, puesto int(10) NOT NULL,  apart varchar(12) NOT NULL,  tarjeta varchar(12) NOT NULL,  estado varchar(12) NOT NULL, fechareg TIMESTAMP DEFAULT CURRENT_TIMESTAMP, activo int default 1, tipov int default 1)";
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al crear tabla en Base de Datos",null,0);
        }
        try {
            sql="CREATE TABLE peatones (id INTEGER NOT NULL DEFAULT 1 PRIMARY KEY AUTOINCREMENT UNIQUE, tipo int, cedula int, nombres varchar(25) NOT NULL, apellidos varchar(25) NOT NULL, apart varchar(12) NOT NULL,  fechareg TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al crear tabla en Base de Datos",null,0);
        }
        try {
            sql="CREATE TABLE tarjetas (id INTEGER NOT NULL DEFAULT 1 PRIMARY KEY AUTOINCREMENT UNIQUE, ref varchar(20) NOT NULL, tarjeta varchar(20) NOT NULL )";
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al crear tabla en Base de Datos",null,0);
        }
        try {
            sql="CREATE TABLE config (id INTEGER NOT NULL DEFAULT 1 PRIMARY KEY AUTOINCREMENT UNIQUE, tiempo int default 2)";
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al crear tabla en Base de Datos",null,0);
        }
        try {
            sql="insert into config (tiempo) values (2)";
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al crear tabla en Base de Datos",null,0);
        }
    }
    public void guardar(RegistroVehiculo reg, int puesto) {
        Date date = new Date();
        try {
            pstmt=conn.prepareStatement("insert into parking (placa, visitante, puesto, apart,tarjeta,estado, fechareg, tipov) values (?,?,?,?,?,'entrada', datetime('now','localtime'),?)");
            pstmt.setString(1, reg.getTxtPlaca().getText());
            pstmt.setString(2, reg.getTxtNombreVisitante().getText());
            pstmt.setInt(3, puesto);
            pstmt.setString(4, reg.getTxtApartamento().getText());
            pstmt.setString(5, reg.getTxtTarjeta().getText());
            if (puesto<51){
                pstmt.setInt(6, 1);
            }else {
                pstmt.setInt(6, 2);
                
            }
            
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    public void guardarp(RegistroPeaton reg) {
        try {
            pstmt=conn.prepareStatement("insert into peatones (tipo, cedula, nombres , apellidos , apart )values (?,?,?,?,?)");
            pstmt.setInt(1, reg.getCmbTipoPeaton().getSelectedIndex());
            //System.out.println("Tipo: "+reg.getCmbTipoPeaton().getSelectedIndex());
            if (comun.isNumeric(reg.getTxtCedulaPeaton().getText())==true){
                pstmt.setInt(2, Integer.parseInt(reg.getTxtCedulaPeaton().getText()));
            }
            else {
                pstmt.setInt(2, 0);
            }
            pstmt.setString(3, reg.getTxtNombrePeaton().getText());
            pstmt.setString(4, reg.getjTextArea1().getText());
            pstmt.setString(5, reg.getTxtAptoAVisitar().getText());
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    public void guardarT(RegistroTarjeta regT) {
            try {
            pstmt=conn.prepareStatement("insert into tarjetas (ref, tarjeta)values (?,?)");
            pstmt.setString(1, regT.gettxtRef().getText());
            pstmt.setString(2, regT.getTxtTarjeta().getText());
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    
    public void salida(RegistroVehiculo reg, int puesto) {
        try {
            pstmt=conn.prepareStatement("insert into parking (placa, visitante, puesto, apart,tarjeta,estado, fechareg, activo) values (?,?,?,?,?,'salida', datetime('now','localtime'),0)");
            pstmt.setString(1, reg.getTxtPlaca().getText());
            pstmt.setString(2, reg.getTxtNombreVisitante().getText());
            pstmt.setInt(3, puesto);
            pstmt.setString(4, reg.getTxtApartamento().getText());
            pstmt.setString(5, reg.getTxtTarjeta().getText());
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}

        try {
            pstmt=conn.prepareStatement("update parking set activo=0 where activo=1 and puesto=? and estado like 'entrada'");
            pstmt.setInt(1, puesto);
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    public void salida(int puesto) {
        registro est=new registro();
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement("select * from  parking where puesto=? and estado like 'entrada' and activo=1");
            pstmt.setInt(1, puesto);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {  e.printStackTrace();
           if (e.getErrorCode()==0){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
           if (e.getErrorCode()==1146){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
            System.out.println("Error numero: "+e.getErrorCode());
        }    
        try {
            if (rs.next()){
                est.setApto(rs.getString("apart"));
                est.setNombre_invitado(rs.getString("visitante"));
                est.setPlaca(rs.getString("placa"));
                est.setPuesto(rs.getInt("puesto"));
                est.setTarjeta(rs.getString("tarjeta"));
            }
        } catch (SQLException e) {  e.printStackTrace();}
        try {
            pstmt=conn.prepareStatement("insert into parking (placa, visitante, puesto, apart,tarjeta,estado, fechareg, activo) values (?,?,?,?,?,'salida', datetime('now','localtime'),0)");
            pstmt.setString(1, est.getPlaca());
            pstmt.setString(2, est.getNombre_invitado());
            pstmt.setInt(3, puesto);
            pstmt.setString(4, est.getApto());
            pstmt.setString(5, est.getTarjeta());
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
        try {
            pstmt=conn.prepareStatement("update parking set activo=0 where puesto=? and estado like 'entrada' and activo=1");
            pstmt.setInt(1, puesto);
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    public registro consultar(int puesto) {
        registro est=new registro();
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement("select * from  parking where puesto=? and estado like 'entrada' and activo=1");
            pstmt.setInt(1, puesto);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {  e.printStackTrace();
           if (e.getErrorCode()==0){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
           if (e.getErrorCode()==1146){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
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
            pstmt=conn.prepareStatement("select * from  parking where puesto=? and estado like 'entrada' and activo=1");
            pstmt.setInt(1, puesto);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {  e.printStackTrace();
           if (e.getErrorCode()==0){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
           if (e.getErrorCode()==1146){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
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
    public String buscaTarjeta(String tarj) {
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement("select * from  tarjetas where ref like ?");
            pstmt.setString(1, tarj);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {  e.printStackTrace();
           if (e.getErrorCode()==0){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
           if (e.getErrorCode()==1146){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
            System.out.println("Error numero: "+e.getErrorCode());
        }    
        try {
            if (rs.next()){
                return rs.getString("tarjeta");
            }
        } catch (SQLException e) {  e.printStackTrace();}
        return "";

    }
    public String buscaRef(String tarj) {
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement("select * from  tarjetas where tarjeta like ?");
            pstmt.setString(1, tarj);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {  e.printStackTrace();
           if (e.getErrorCode()==0){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
           if (e.getErrorCode()==1146){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
            System.out.println("Error numero: "+e.getErrorCode());
        }    
        try {
            if (rs.next()){
                return rs.getString("ref");
            }
        } catch (SQLException e) {  e.printStackTrace();}
        return "";

    }
    public ResultSet consultarEntradas() {
        ResultSet rs=null;
        try {
            //pstmt=conn.prepareStatement("select * from  parking where estado like 'entrada' and activo=1");
            pstmt=conn.prepareStatement("select * from  parking where activo=1");
            rs=pstmt.executeQuery();
        } catch (SQLException e) {  e.printStackTrace();
           if (e.getErrorCode()==0){this.CrearTabla(); JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
           if (e.getErrorCode()==1146){this.CrearTabla(); JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
           
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
            String [] Titulos={"Puesto","Visitante","Placa","Apartamento","Estado","Fecha"};
            String[] Registros= new String[6];
            pstmt=conn.prepareStatement("select * from  parking ");
            //pstmt=conn.prepareStatement("select * from  parking where estado like 'entrada'");
            ResultSet rs = pstmt.executeQuery(); 	
            model = new DefaultTableModel(null,Titulos);
            try{
                while(rs.next()){
                    Registros[0]=rs.getString("puesto");
                    Registros[1]=rs.getString("visitante");
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
            String [] Titulos={"Visitante","Tipo","Placa","Apartamento","Estado","Fecha"};
            String[] Registros= new String[6];
            pstmt=conn.prepareStatement("select * from  parking where estado like 'entrada'");
            ResultSet rs = pstmt.executeQuery(); 	
            model = new DefaultTableModel(null,Titulos);
            try{
                while(rs.next()){
                    Registros[0]=rs.getString("visitante");
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
    public JTable actTablaTarjeTa(JTable tabla) {
        DefaultTableModel model;
        try {
            String [] Titulos={"Codigo Externo","Codigo Interno"};
            String[] Registros= new String[2];
            pstmt=conn.prepareStatement("select * from  tarjetas");
            ResultSet rs = pstmt.executeQuery(); 	
            model = new DefaultTableModel(null,Titulos);
            try{
                while(rs.next()){
                    Registros[0]=rs.getString("ref");
                    Registros[1]=rs.getString("tarjeta");
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
            String [] Titulos={"Cedula","Nombres y Apellidos","Observaciones","Apartamento","Tipo","Fecha"};
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
                    else if (rs.getInt("tipo")==1){Registros[4]="Visitante";}
                    else if (rs.getInt("tipo")==2){Registros[4]="Trabajador";}
                    
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
    public void ActTabla(int i, JTable tlbHistorialVehiculos,String sql) {
        DefaultTableModel model;
        try {
            String [] Titulos={"Visitante","Tipo","Placa","Apartamento","Estado","Fecha","Nro Referencia"};
            String[] Registros= new String[7];
            pstmt=conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(); 	
            model = new DefaultTableModel(null,Titulos);
            try{
                while(rs.next()){
                    Registros[0]=rs.getString("visitante");
                    if (rs.getInt("tipov")==1){ Registros[1]="Carro"; }
                    else { Registros[1]="Moto"; }
                    Registros[2]=rs.getString("placa");
                    Registros[3]=rs.getString("apart");
                    Registros[4]=rs.getString("estado");
                    Registros[5]=rs.getString("fechareg");
                    Registros[6]=rs.getString("tarjeta");
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
    public void newsalida() {
        try {
            pstmt=conn.prepareStatement("insert into  acc_monitor_log (card_no,status,device_sn) values ('0',0,'-')");
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    void infractores() {
        ResultSet rs=null;
        PreparedStatement pstmt2;
        try {
            //pstmt=conn.prepareStatement("select * from  parking where estado like 'entrada' and activo=1 and fechareg<datetime('now','-1 day')");
            pstmt=conn.prepareStatement("select * from  parking where estado like 'entrada' and activo=1 ");
            rs=pstmt.executeQuery();
            int controlH=this.tiempo();
            while (rs.next()){
                if (comun.restaFechas(rs.getString("fechareg"))>controlH){
                    pstmt2=conn.prepareStatement("insert into parking (placa, visitante, puesto, apart,tarjeta,estado, fechareg, activo) values (?,?,?,?,?,'infractor', ?,1)");
                    pstmt2.setString(1, rs.getString("placa"));
                    pstmt2.setString(2, rs.getString("visitante"));
                    pstmt2.setInt(3, rs.getInt("puesto"));
                    pstmt2.setString(4, rs.getString("apart"));
                    pstmt2.setString(5, rs.getString("tarjeta"));
                    pstmt2.setString(6, rs.getString("fechareg"));
                    pstmt2.execute();
                
                    pstmt2=conn.prepareStatement("update parking set activo=0 where id=?");
                    pstmt2.setInt(1, rs.getInt("id"));
                    pstmt2.execute();
                }
            }
        } catch (SQLException e) {  e.printStackTrace();
           if (e.getErrorCode()==0){this.CrearTabla(); JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
           if (e.getErrorCode()==1146){this.CrearTabla(); JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
           
        }    
        
    }
   
    public int tiempo() {
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement("select * from  config");
            rs=pstmt.executeQuery();
        } catch (SQLException e) {  e.printStackTrace();
           if (e.getErrorCode()==0){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
           if (e.getErrorCode()==1146){this.CrearTabla(); ; JOptionPane.showMessageDialog(null, "Error con Bd. Inicie nuevamente el programa para solventar error"); System.exit(0);}
            System.out.println("Error numero: "+e.getErrorCode());
        }    
        try {
            if (rs.next()){
                return rs.getInt("tiempo");
            }
        } catch (SQLException e) {  e.printStackTrace();}
        return 0;
    }
    public void actConfig(int horas) {
        try {
            pstmt=conn.prepareStatement("update config set tiempo=?");
            pstmt.setInt(1, horas);
            pstmt.execute();
        } catch (SQLException e) {  e.printStackTrace();}
    }
    


    
}
