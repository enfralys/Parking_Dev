/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.button_control;
import views.Main;
import views.RegistroVehiculo;

/**
 *
 * @author Ris3TwO
 */
public class home {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main view = new Main();
        RegistroVehiculo reg = new RegistroVehiculo(null, false);
        button_control control = new button_control(view, reg);
        control.Inicio();
        
        view.setVisible(true);
    }
    
}
