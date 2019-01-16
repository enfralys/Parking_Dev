/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.Timer;
import views.VentanaDialogo;

/**
 *
 * @author Ris3TwO
 */
public class Dialogview_control {
    
    private final VentanaDialogo view;

    public Dialogview_control(VentanaDialogo view) {
        this.view = view;
    }
    
    public void Iniciar(JDialog main){
        view.setLocationRelativeTo(main);
        Timer timer = new Timer (3000, (ActionEvent e) -> {
            view.setVisible(false);
        });
        timer.start();
    }
    
}
