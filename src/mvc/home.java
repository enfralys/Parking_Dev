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
import views.Registro_Tarjeta;

// Clase Principal
public class home {
    public static void main(String[] args) throws IOException {
       Main view = new Main();
        RegistroVehiculo reg = new RegistroVehiculo(null, false);
        RegistroPeaton regPea = new RegistroPeaton(null,false);
        Registro_Tarjeta regT = new Registro_Tarjeta(null,false);
        button_control control = new button_control(view, reg, regPea, regT);
      control.Inicio();
        view.setVisible(true);
    }
    
}
