package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mvc.conex;
import mvc.registro;
import views.Main;
import views.RegistroVehiculo;

public class button_control implements ActionListener{
    
    private Main vista = new Main();
    private registro model;
    private RegistroVehiculo reg;
    private int contador = 0;
    private conex conn;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public button_control(Main vista, RegistroVehiculo reg){
        this.model=new registro();
        this.vista = vista;
        this.reg = reg;
        this.conn= new conex();
       /* conn.conectarSQLITE();
        conn.CrearTabla();
        conn.desconectar();
        */
        //Botones de vista Main
        this.vista.getBtnSalir().addActionListener(this);
        this.vista.getBtnPuesto10().addActionListener(this);
        this.vista.getBtnPuesto11().addActionListener(this);
        
        //Botones de vista Registro
        this.reg.getBtn_save().addActionListener(this);
        this.reg.getBtnCancelar().addActionListener(this);
    }
    
    public void Inicio(){
        vista.setLocationRelativeTo(null);
        conn.conectarSQLITE();
                model=conn.consultar(10);
                conn.desconectar();
                
         if (model.getPuesto()==10){vista.ocupado10();}
        contador = 0;
    }
    
    public void InicioReg(){
        reg.setLocationRelativeTo(vista);
        contador++;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.getBtnSalir()) {
            System.exit(0);
        }   
        
        if (contador == 0){
            if (e.getSource() == vista.getBtnPuesto10()) {
                reg = new RegistroVehiculo(vista, true);
                button_control control = new button_control(vista,reg);
                if (model.getPuesto()==10){vista.ocupado10();}
                else {
                    model.setPuesto(10);
                    control.InicioReg();
                    reg.setVisible(true);
                }
            }
            if (e.getSource() == vista.getBtnPuesto11()) {
                reg = new RegistroVehiculo(vista, true);
                button_control control = new button_control(vista,reg);
                if (model.getPuesto()==11){vista.ocupado11();}
                else {
                    model.setPuesto(11);
                    control.InicioReg();
                    reg.setVisible(true);
                }
            }

        }
        
        if (e.getSource() == reg.getBtn_save()) {
          
            //JOptionPane.showInputDialog("Confirmed");
            
            int a=JOptionPane.showConfirmDialog(vista, "Confirmar");
            if (a==0){
              //  System.out.println("valor a: "+a+" Que te pasa cv guardas "+ reg.getTxtApartamento().getText());
                conn.conectarSQLITE();
                conn.guardar(reg,10);
                conn.desconectar();
                vista.ocupado10();
                reg.dispose();
            } 
            
        }
        if (e.getSource() == reg.getBtnCancelar()){
            if (contador != 0){ reg.dispose(); } 
        }
    }  
}
