/*
Clase Controladora
Funcion: control de los botones de menu principal y registro de vehiculos
Autor: 
Creacion: 16/01/2019
Ult Modificacion: 16/02/2019
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
import views.Registro_Tarjeta;


public class button_control implements ActionListener, KeyListener{
    
    private Main vista = new Main();
    private registro model;
    private RegistroVehiculo reg;
    private RegistroPeaton regPea;
    private Registro_Tarjeta regT;
    private int contador = 0;
    private String pass = "controladmin2021";
    private String user = "admin";
    private final conex conn;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public button_control(Main vista, RegistroVehiculo reg, RegistroPeaton regPea, Registro_Tarjeta regT){
        this.model=new registro();
        this.vista = vista;
        this.reg = reg;
        this.regPea = regPea;
        this.regT=regT;
        this.conn= new conex();

        //Botones de vista Main
        this.vista.getBtnSalir().addActionListener(this);
        this.vista.getBtnPuesto1().addActionListener(this);
        this.vista.getBtnPuesto2().addActionListener(this);
        this.vista.getBtnPuesto3().addActionListener(this);
        this.vista.getBtnPuesto4().addActionListener(this);
        this.vista.getBtnPuesto5().addActionListener(this);
        this.vista.getBtnPuesto6().addActionListener(this);
        this.vista.getBtnPuesto7().addActionListener(this);
        this.vista.getBtnPuesto8().addActionListener(this);
        this.vista.getBtnPuesto9().addActionListener(this);
        this.vista.getBtnPuesto10().addActionListener(this);
        this.vista.getBtnPuesto11().addActionListener(this);
        this.vista.getBtnPuesto12().addActionListener(this);
        this.vista.getBtnPuesto13().addActionListener(this);
        this.vista.getBtnPuesto14().addActionListener(this);
        this.vista.getBtnPuesto15().addActionListener(this);
        this.vista.getBtnPuesto16().addActionListener(this);
        this.vista.getBtnPuesto17().addActionListener(this);
        this.vista.getBtnPuesto18().addActionListener(this);
        this.vista.getBtnPuesto19().addActionListener(this);
        this.vista.getBtnPuesto20().addActionListener(this);
        this.vista.getBtnPuesto21().addActionListener(this);
        this.vista.getBtnPuesto22().addActionListener(this);
        this.vista.getBtnPuesto23().addActionListener(this);
        this.vista.getBtnPuesto24().addActionListener(this);
        this.vista.getBtnPuesto25().addActionListener(this);
        this.vista.getBtnPuesto26().addActionListener(this);
        this.vista.getBtnPuesto27().addActionListener(this);
        this.vista.getBtnPuesto28().addActionListener(this);
        this.vista.getBtnPuesto29().addActionListener(this);
        this.vista.getBtnPuesto30().addActionListener(this);
        this.vista.getBtnPuesto31().addActionListener(this);
        this.vista.getBtnPuesto32().addActionListener(this);
        this.vista.getBtnPuesto33().addActionListener(this);
        this.vista.getBtnPuesto34().addActionListener(this);
        this.vista.getBtnPuesto35().addActionListener(this);
        this.vista.getBtnPuesto36().addActionListener(this);
        this.vista.getBtnPuesto37().addActionListener(this);
        this.vista.getBtnPuesto38().addActionListener(this);
        this.vista.getBtnPuesto39().addActionListener(this);
        this.vista.getBtnPuesto40().addActionListener(this);
        this.vista.getBtnPuesto41().addActionListener(this);
        this.vista.getBtnPuesto42().addActionListener(this);
        this.vista.getBtnPuesto43().addActionListener(this);
        this.vista.getBtnPuesto44().addActionListener(this);
        this.vista.getBtnPuesto45().addActionListener(this);
        this.vista.getBtnPuesto46().addActionListener(this);
        this.vista.getBtnPuesto47().addActionListener(this);
        this.vista.getBtnPuesto48().addActionListener(this);
        this.vista.getBtnPuesto49().addActionListener(this);
        this.vista.getBtnPuesto50().addActionListener(this);
        this.vista.getBtnTarjetas().addActionListener(this);
        this.vista.getBtnRegistroPeaton().addActionListener(this);
        this.vista.getTxtBuscadorPersona().addKeyListener(this);
        this.vista.getTxtFechaInicial().addKeyListener(this);
        this.vista.getTxtFechaFinal().addKeyListener(this);
        this.vista.getCmbFiltradoDiaVehiculo().addActionListener(this);
        //Botones de vista Registro
        this.reg.getBtn_save().addActionListener(this);
        this.reg.getBtnCancelar().addActionListener(this);
        this.regPea.getBtn_save().addActionListener(this);
        this.regPea.getBtnCancelar().addActionListener(this);
    }
    
    public void Inicio(){
      
        vista.setLocationRelativeTo(null);
        conn.conectarSQLITE();
            for (int i=1; i<51;i++){
                model=conn.consultar(i);
                if (model.getPuesto()==i){vista.ocupado(i);  }
            }
        conn.desconectar();
        conn.conectarSQLITE();
        vista.setTlbHistorial(conn.CargarTablaHistorias(vista.getTlbHistorial()));
        conn.desconectar();
        
        conn.conectarSQLITE();
        vista.setTlbHistorialDatos(conn.CargarTablaConsulta(vista.getTlbHistorialDatos()));
        conn.desconectar();
        
        // Actualiza tabla peatones
        conn.conectarSQLITE(); 
        vista.setTlbHistorialDatos1(conn.actTablaPea(vista.getTlbHistorialDatos1(),"select * from peatones"));
        conn.desconectar(); 
        
        
        contador = 0;
        Temporizador timerTask = new Temporizador(this.vista);
        Timer timer = new Timer(); 
        timer.scheduleAtFixedRate(timerTask, 0, 3000);
    }
    
    public void InicioReg(){
        reg.setLocationRelativeTo(vista);
        contador++;
    }
    
    public void InicioRegPea(){
        regPea.setLocationRelativeTo(vista);
        //contador++;
    }
    
    public void InicioRegT(){
        regT.setLocationRelativeTo(vista);
        contador++;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        button_control control = null;
        String sql;
        if (e.getSource() == vista.getBtnSalir()) { System.exit(0); }   
        
        if (contador == 0){
            if (e.getSource() == vista.getBtnPuesto1()) { this.actPuesto(1);}
            if (e.getSource() == vista.getBtnPuesto2()) { this.actPuesto(2);}
            if (e.getSource() == vista.getBtnPuesto3()) { this.actPuesto(3);}
            if (e.getSource() == vista.getBtnPuesto4()) { this.actPuesto(4);}
            if (e.getSource() == vista.getBtnPuesto5()) { this.actPuesto(5);}
            if (e.getSource() == vista.getBtnPuesto6()) { this.actPuesto(6);}
            if (e.getSource() == vista.getBtnPuesto7()) { this.actPuesto(7);}
            if (e.getSource() == vista.getBtnPuesto8()) { this.actPuesto(8);}
            if (e.getSource() == vista.getBtnPuesto9()) { this.actPuesto(9);}
            if (e.getSource() == vista.getBtnPuesto10()) { this.actPuesto(10);}
            if (e.getSource() == vista.getBtnPuesto11()) { this.actPuesto(11);}
            if (e.getSource() == vista.getBtnPuesto12()) { this.actPuesto(12);}
            if (e.getSource() == vista.getBtnPuesto13()) { this.actPuesto(13);}
            if (e.getSource() == vista.getBtnPuesto14()) { this.actPuesto(14);}
            if (e.getSource() == vista.getBtnPuesto15()) { this.actPuesto(15);}
            if (e.getSource() == vista.getBtnPuesto16()) { this.actPuesto(16);}
            if (e.getSource() == vista.getBtnPuesto17()) { this.actPuesto(17);}
            if (e.getSource() == vista.getBtnPuesto18()) { this.actPuesto(18);}
            if (e.getSource() == vista.getBtnPuesto19()) { this.actPuesto(19);}
            if (e.getSource() == vista.getBtnPuesto20()) { this.actPuesto(20);}
            if (e.getSource() == vista.getBtnPuesto21()) { this.actPuesto(21);}
            if (e.getSource() == vista.getBtnPuesto22()) { this.actPuesto(22);}
            if (e.getSource() == vista.getBtnPuesto23()) { this.actPuesto(23);}
            if (e.getSource() == vista.getBtnPuesto24()) { this.actPuesto(24);}
            if (e.getSource() == vista.getBtnPuesto25()) { this.actPuesto(25);}
            if (e.getSource() == vista.getBtnPuesto26()) { this.actPuesto(26);}
            if (e.getSource() == vista.getBtnPuesto27()) { this.actPuesto(27);}
            if (e.getSource() == vista.getBtnPuesto28()) { this.actPuesto(28);}
            if (e.getSource() == vista.getBtnPuesto29()) { this.actPuesto(29);}
            if (e.getSource() == vista.getBtnPuesto30()) { this.actPuesto(30);}
            if (e.getSource() == vista.getBtnPuesto31()) { this.actPuesto(31);}
            if (e.getSource() == vista.getBtnPuesto32()) { this.actPuesto(32);}
            if (e.getSource() == vista.getBtnPuesto33()) { this.actPuesto(33);}
            if (e.getSource() == vista.getBtnPuesto34()) { this.actPuesto(34);}
            if (e.getSource() == vista.getBtnPuesto35()) { this.actPuesto(35);}
            if (e.getSource() == vista.getBtnPuesto36()) { this.actPuesto(36);}
            if (e.getSource() == vista.getBtnPuesto37()) { this.actPuesto(37);}
            if (e.getSource() == vista.getBtnPuesto38()) { this.actPuesto(38);}
            if (e.getSource() == vista.getBtnPuesto39()) { this.actPuesto(39);}
            if (e.getSource() == vista.getBtnPuesto40()) { this.actPuesto(40);}
            if (e.getSource() == vista.getBtnPuesto41()) { this.actPuesto(41);}
            if (e.getSource() == vista.getBtnPuesto42()) { this.actPuesto(42);}
            if (e.getSource() == vista.getBtnPuesto43()) { this.actPuesto(43);}
            if (e.getSource() == vista.getBtnPuesto44()) { this.actPuesto(44);}
            if (e.getSource() == vista.getBtnPuesto45()) { this.actPuesto(45);}
            if (e.getSource() == vista.getBtnPuesto46()) { this.actPuesto(46);}
            if (e.getSource() == vista.getBtnPuesto47()) { this.actPuesto(47);}
            if (e.getSource() == vista.getBtnPuesto48()) { this.actPuesto(48);}
            if (e.getSource() == vista.getBtnPuesto49()) { this.actPuesto(49);}
            if (e.getSource() == vista.getBtnPuesto50()) { this.actPuesto(50);}
            if (e.getSource() == vista.getBtnTarjetas()) { this.registro();}
        }    
        
        if (e.getSource() == vista.getBtnRegistroPeaton()){
            regPea = new RegistroPeaton(vista, true);
            CRPeaton controlador = new CRPeaton(vista,regPea);
            controlador.InicioRegPea();
            regPea.setVisible(true);
        }
      //  if (contador == 0){
            if (e.getSource() == reg.getBtn_save()) {
                int a=JOptionPane.showConfirmDialog(vista, "Confirmar");
                if (a==0){ // Si se presiona si se guardan los datos
                    conn.conectarSQLITE(); // conexta a BD sqlite
                    conn.guardar(reg,reg.puesto); // Llama al metodo guardar en la BD
                    conn.desconectar(); // desconexta a BD sqlite
                    vista.ocupado(reg.puesto); // cambia icono del puesto
                    reg.dispose(); // cierra la ventana
                } 
            }
       // }
       // if (contador == 0){
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
       // }
        if (e.getSource() == reg.getBtnCancelar()){ if (contador != 0){ reg.dispose(); } }
        //if (e.getSource() == regPea.getBtnCancelar()){ if (contador != 0){ regPea.dispose(); } }
        if (e.getSource() == regPea.getBtnCancelar()){ 
            regPea.dispose();  
        }
        //if (e.getSource() == regT.getBtnCancelar()){ if (contador != 0){ regPea.dispose(); } }
        if (e.getSource() == vista.getCmbFiltradoDiaVehiculo()){
        
        // SELECT * FROM ordenes WHERE fecha_registro BETWEEN '10/06/2006' AND '16/06/2006'
            int indice=0;
            indice = vista.getCmbFiltradoDiaVehiculo().getSelectedIndex();
            if (indice==0){ sql="select * from  parking where "; }
            else if (indice==1){ sql="select * from  parking where estado like 'entrada' and  ";  }
            else if (indice==2){ sql="select * from  parking where estado like 'salida' and  ";  }
            else if (indice==3){ sql="select * from  parking where estado like 'infractor' and  ";  }
            else { sql="select * from  parking where ";}
            String fechaI[]=vista.getTxtFechaInicial().getText().split("/");
            String fechaF[]=vista.getTxtFechaFinal().getText().split("/");
            //sql=sql+" fechareg> '"+fechaI[2]+"-"+fechaI[1]+"-"+fechaI[0]+"'";
           // sql=sql+" fechareg> {ts '"+fechaI[2]+"-"+fechaI[1]+"-"+fechaI[0]+" 00:00:00.000000000' }";
             sql=sql+" fechareg >= '"+fechaI[2]+"-"+fechaI[1]+"-"+fechaI[0]+" 00:00:00' ";
             sql=sql+" and fechareg <= '"+fechaF[2]+"-"+fechaF[1]+"-"+fechaF[0]+" 00:00:00' ";
            conn.conectarSQLITE();
            conn.ActTabla(1, vista.getTlbHistorialVehiculos(),sql);
            conn.desconectar();
        }
        

    }  
    
    // Meotdo creado para registrar los datos de los visitabtes de todos los puestos
    public void actPuesto(int p){
        reg = new RegistroVehiculo(vista, true);
        button_control control = new button_control(vista,reg,regPea, regT);
        reg.puesto=p;
        control.InicioReg();
        conn.conectarSQLITE();
        model=conn.consultar(p);
        conn.desconectar();
        if (model.getPuesto()==p){
            reg.getTxtPlaca().setText(model.getPlaca());
            reg.getTxtPlaca().setEditable(false);
            reg.getTxtNombreVisitante().setText(model.getNombre_invitado());
            reg.getTxtNombreVisitante().setEditable(false);
            reg.getTxtApartamento().setText(model.getApto());
            reg.getTxtApartamento().setEditable(false);
            reg.getTxtTarjeta().setText(model.getTarjeta());
            reg.getTxtTarjeta().setEditable(false);
            reg.getBtn_save().setVisible(false);
            
        }
       reg.setVisible(true);
    
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        String sql="select * from parking";
        if ((ke.getSource().equals(this.vista.getTxtFechaInicial())) || (ke.getSource().equals(this.vista.getTxtFechaFinal()))){
            int indice=0;
            indice = vista.getCmbFiltradoDiaVehiculo().getSelectedIndex();
            if (indice==0){ sql="select * from  parking where "; }
            else if (indice==1){ sql="select * from  parking where estado like 'entrada' and  ";  }
            else if (indice==2){ sql="select * from  parking where estado like 'salida' and  ";  }
            else if (indice==3){ sql="select * from  parking where estado like 'infractor' and  ";  }
            else { sql="select * from  parking where ";}
            String fechaI[]=vista.getTxtFechaInicial().getText().split("/");
            String fechaF[]=vista.getTxtFechaFinal().getText().split("/");
            //sql=sql+" fechareg> '"+fechaI[2]+"-"+fechaI[1]+"-"+fechaI[0]+"'";
           // sql=sql+" fechareg> {ts '"+fechaI[2]+"-"+fechaI[1]+"-"+fechaI[0]+" 00:00:00.000000000' }";
             sql=sql+" fechareg >= '"+fechaI[2]+"-"+fechaI[1]+"-"+fechaI[0]+" 00:00:00' ";
             sql=sql+" and fechareg <= '"+fechaF[2]+"-"+fechaF[1]+"-"+fechaF[0]+" 00:00:00' ";
            conn.conectarSQLITE();
            conn.ActTabla(1, vista.getTlbHistorialVehiculos(),sql);
            conn.desconectar();
        }
        
    }

    private void registro() {
        JLabel jUserName = new JLabel("Usuario");
        JTextField userName = new JTextField();
        JLabel jPassword = new JLabel("Clave");
        JTextField password = new JPasswordField();
        Object[] ob = {jUserName, userName, jPassword, password};
        int result = JOptionPane.showConfirmDialog(null, ob, "Por Favor ingrese su clabe JOptionPane showConfirmDialog", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String userNameValue = userName.getText();
            String passwordValue = password.getText();
            if ((userNameValue.equals(this.user)) && (passwordValue.equals(this.pass))){
              regT = new Registro_Tarjeta(vista, true);
              button_control control = new button_control(vista,reg,regPea, regT);
              control.InicioRegT();
              regT.setVisible(true);  
            }
            //Here is some validation code
        }
    }

    
}
