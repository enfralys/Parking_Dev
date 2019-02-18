/*
Clase Controladora
Funcion: control de los botones de registro de peatones
Autor: 
Creacion: 18/02/2019
Ult Modificacion: 18/02/2019
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
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import views.Registro_Tarjeta;


public class CRPeaton implements ActionListener{
    
    private Main vista;
    private RegistroPeaton regPea;
    private conex conn;
    public CRPeaton(Main vista, RegistroPeaton regPea){
        this.vista = vista;
        this.regPea = regPea;
        this.conn= new conex();
        this.regPea.getBtn_save().addActionListener(this);
        this.regPea.getBtnCancelar().addActionListener(this);
    }
    
    public void InicioRegPea(){
        regPea.setLocationRelativeTo(vista);
        //contador++;
    }
    
    public void actionPerformed(ActionEvent e) {
        CRPeaton control = null;
        String sql;
        if (e.getSource() == vista.getBtnSalir()) { System.exit(0); }   
        if (e.getSource() == regPea.getBtn_save()) {
           int a=JOptionPane.showConfirmDialog(vista, "Confirmar");
           if (a==0){ // Si se presiona si se guardan los datos
                conn.conectarSQLITE(); // conexta a BD sqlite
                conn.guardarp(regPea); // Llama al metodo guardar en la BD
                vista.setTlbHistorialDatos1(conn.actTablaPea(vista.getTlbHistorialDatos1(),"select * from peatones"));
                conn.desconectar(); // desconexta a BD sqlite
                regPea.dispose(); // cierra la ventana
            } 
        }
        if (e.getSource() == regPea.getBtnCancelar()){ regPea.dispose(); }
    }  
    
}
