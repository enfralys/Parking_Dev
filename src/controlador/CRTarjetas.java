/*
Clase Controladora
Funcion: control de los botones de registro de Tarjetas
Autor: 
Creacion: 20/02/2019
Ult Modificacion: 20/02/2019
*/
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import mvc.*;
import views.Main;
import views.RegistroPeaton;
import views.RegistroVehiculo;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import plugins.comun;
import views.RegistroTarjeta;
import views.VisorTarjeta;


public class CRTarjetas implements ActionListener{
    
    private Main vista = new Main();
    private registro model;
    private RegistroTarjeta regT;
    private VisorTarjeta vt;
    private final conex conn;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public CRTarjetas(Main vista, RegistroTarjeta regT,VisorTarjeta vt) {
        this.model=new registro();
        this.vista = vista;
        this.regT=regT;
        this.vt=vt;
        this.conn= new conex();
        this.regT.getBtn_save().addActionListener(this);
        this.regT.getBtnCancelar().addActionListener(this);
        
    }
    public void InicioRegT() {
        regT.setLocationRelativeTo(vista);
    }

    public void actionPerformed(ActionEvent e) {
        CRTarjetas control = null;
        String sql;
        String valor=null;
        if (e.getSource() == vista.getBtnSalir()) { System.exit(0); }   
        if (e.getSource() == regT.getBtn_save()) {
                if ((comun.isNumeric(regT.gettxtRef().getText().trim())) && (comun.isNumeric(regT.getTxtTarjeta().getText().trim()))){
                    conn.conectarSQLITE();
                    valor=conn.buscaRef(regT.gettxtRef().getText());
                    conn.desconectar(); 
                    if (valor.equalsIgnoreCase("")){
                        conn.conectarSQLITE();
                        valor=conn.buscaTarjeta(regT.getTxtTarjeta().getText());
                        conn.desconectar(); 
                        if (valor.equalsIgnoreCase("")){
                            int a=JOptionPane.showConfirmDialog(vista, "Confirmar");
                            if (a==0){ // Si se presiona si se guardan los datos
                                conn.conectarSQLITE(); // conexta a BD sqlite
                                conn.guardarT(regT); // Llama al metodo guardar en la BD
                                sql="select * from tarjetas";
                                this.vt.setTlbHistorialTarjeta(conn.actTablaTarjeTa(vt.getTlbHistorialTarjeta(),sql));
                                conn.desconectar(); 
                                regT.dispose(); // cierra la ventana
                            }
                        } else{ JOptionPane.showMessageDialog(null, "Valor de REFERENCIA ya FUE REGISTRADO");}
                    }else{ JOptionPane.showMessageDialog(null, "Valor de TARJETA ya FUE REGISTRADO");}  
                }else {JOptionPane.showMessageDialog(null, "Valor ingresado debe ser numerico");}
        }
        if (e.getSource() == regT.getBtnCancelar()){ regT.dispose(); }
    }  
   
}
