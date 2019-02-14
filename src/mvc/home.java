/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.button_control;
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
    public static void main(String[] args) {
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
    }
    
}
