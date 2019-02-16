/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.button_control;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import views.Main;
import views.RegistroPeaton;
import views.RegistroVehiculo;

/**
 *
 * @author Ris3TwO
 */
public class home {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       Main view = new Main();
        RegistroVehiculo reg = new RegistroVehiculo(null, false);
        RegistroPeaton regPea = new RegistroPeaton(null,false);
        button_control control = new button_control(view, reg, regPea);
      control.Inicio();
        view.setVisible(true);
    //    Verificador2 obj= new Verificador2(view);
     //   obj.verifica();
     /*   Verificador R1 = new Verificador("Verificador",view);
        R1.start();*/
    /* String link_name = "parking.sqlite";
        File dirLog= new File( link_name );
        System.out.println("Path: " + dirLog.getPath());
        String canonicalPath = null;
        try {
            canonicalPath = dirLog.getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Canonical path: " + canonicalPath);
         System.out.println("\nAbsolute path: " + dirLog.getAbsolutePath());
        try {
            System.out.println("Canonical path: " + dirLog.getCanonicalPath());
        } catch (IOException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
  JOptionPane.showMessageDialog(null,"\nAbsolute path: " + dirLog.getAbsolutePath());
  JOptionPane.showMessageDialog(null,"Canonical path: " + dirLog.getCanonicalPath());
       */
    }
    
}
