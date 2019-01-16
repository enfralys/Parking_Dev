/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins;

import java.awt.*;
import java.net.*;
import javax.swing.*;



/**
 *
 * @author Ris3TwO
 */
public class CustomPanelMoto extends JPanel{ 
    //Creo una URL personalizada obteniendo la imagen
    private URL url = getClass().getResource("/images/background_moto.jpg");
    //Creo una nueva propiedad imagen y le asigno la que obtengo por URL
    Image image = new ImageIcon(url).getImage();
 
    @Override
    //Pinto de la imagen todo el panel en alto y ancho
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        //g.setOpaque(false);
        super.paint(g);
    }
}
