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
    }
    
}
