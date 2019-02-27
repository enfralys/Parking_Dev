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
import plugins.comun;
import views.RegistroTarjeta;
import views.VisorTarjeta;


public class button_control implements ActionListener, KeyListener{
    
    private Main vista = new Main();
    private registro model;
    private RegistroVehiculo reg;
    private RegistroPeaton regPea;
    private RegistroTarjeta regT;
    private VisorTarjeta vT;
    private int contador = 0;
    private String pass = "controladmin2021";
    private String user = "admin";
    private final conex conn;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public button_control(Main vista, RegistroVehiculo reg,  VisorTarjeta vT){
        this.model=new registro();
        this.vista = vista;
        this.reg = reg;
    //    this.regPea = regPea;
        this.vT=vT;
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
        // Motos
        this.vista.getBtnPuesto51().addActionListener(this);
        this.vista.getBtnPuesto52().addActionListener(this);
        this.vista.getBtnPuesto53().addActionListener(this);
        this.vista.getBtnPuesto54().addActionListener(this);
        this.vista.getBtnPuesto55().addActionListener(this);
        this.vista.getBtnPuesto56().addActionListener(this);
        this.vista.getBtnPuesto57().addActionListener(this);
        this.vista.getBtnPuesto58().addActionListener(this);
        this.vista.getBtnPuesto59().addActionListener(this);
        this.vista.getBtnPuesto60().addActionListener(this);
        this.vista.getBtnPuesto61().addActionListener(this);
        this.vista.getBtnPuesto62().addActionListener(this);
        this.vista.getBtnPuesto63().addActionListener(this);
        this.vista.getBtnPuesto64().addActionListener(this);
        this.vista.getBtnPuesto65().addActionListener(this);
        this.vista.getBtnPuesto66().addActionListener(this);
        this.vista.getBtnPuesto67().addActionListener(this);
        this.vista.getBtnPuesto68().addActionListener(this);
        this.vista.getBtnPuesto69().addActionListener(this);
        this.vista.getBtnPuesto71().addActionListener(this);
        this.vista.getBtnPuesto71().addActionListener(this);
        this.vista.getBtnPuesto72().addActionListener(this);
        this.vista.getBtnPuesto73().addActionListener(this);
        this.vista.getBtnPuesto74().addActionListener(this);
        this.vista.getBtnPuesto75().addActionListener(this);
        this.vista.getBtnPuesto76().addActionListener(this);
        this.vista.getBtnPuesto77().addActionListener(this);
        this.vista.getBtnPuesto78().addActionListener(this);
        this.vista.getBtnPuesto79().addActionListener(this);
        this.vista.getBtnPuesto80().addActionListener(this);
        this.vista.getBtnPuesto81().addActionListener(this);
        this.vista.getBtnPuesto82().addActionListener(this);
        this.vista.getBtnPuesto83().addActionListener(this);
        this.vista.getBtnPuesto84().addActionListener(this);
        this.vista.getBtnPuesto85().addActionListener(this);
        this.vista.getBtnPuesto86().addActionListener(this);
        this.vista.getBtnPuesto87().addActionListener(this);
        this.vista.getBtnPuesto88().addActionListener(this);
        this.vista.getBtnPuesto89().addActionListener(this);
        this.vista.getBtnPuesto90().addActionListener(this);
        this.vista.getBtnPuesto91().addActionListener(this);
        this.vista.getBtnPuesto92().addActionListener(this);
        this.vista.getBtnPuesto93().addActionListener(this);
        this.vista.getBtnPuesto94().addActionListener(this);
        this.vista.getBtnPuesto95().addActionListener(this);
        this.vista.getBtnPuesto96().addActionListener(this);
        this.vista.getBtnPuesto97().addActionListener(this);
        this.vista.getBtnPuesto98().addActionListener(this);
        this.vista.getBtnPuesto99().addActionListener(this);
        this.vista.getBtnPuesto100().addActionListener(this);
        
        this.vista.getBtnTarjetas().addActionListener(this);
        this.vista.getBtnRegistroPeaton().addActionListener(this);
        this.vista.getTxtBuscadorPersona().addKeyListener(this);
        this.vista.getTxtBuscadorPersona1().addKeyListener(this);
        this.vista.getTxtFechaInicial().addKeyListener(this);
        this.vista.getTxtFechaFinal().addKeyListener(this);
        this.vista.getCmbFiltradoDiaVehiculo().addActionListener(this);
        
        this.vista.getBtnrefresh().addActionListener(this);
        //Botones de vista Registro
        this.reg.getBtn_save().addActionListener(this);
        this.reg.getBtnCancelar().addActionListener(this);
        
        //this.regPea.getBtn_save().addActionListener(this);
        //this.regPea.getBtnCancelar().addActionListener(this);
        
    }
    
    public void Inicio(){
      
        vista.setLocationRelativeTo(null);
        conn.conectarSQLITE();
            for (int i=1; i<101;i++){
                model=conn.consultar(i);
                if (model.getPuesto()==i){
                    if (i<51){vista.ocupado(i); }
                    else {vista.ocupadoM(i);  }
                    
                }
            }
        conn.desconectar();
        conn.conectarSQLITE();
        vista.setTlbHistorial(conn.CargarTablaHistorias(vista.getTlbHistorial()));
        conn.desconectar();
        
      
        
        // Actualiza tabla peatones
        conn.conectarSQLITE(); 
        vista.setTlbHistorialDatos1(conn.actTablaPea(vista.getTlbHistorialDatos1(),"select * from peatones order by id desc"));
        conn.desconectar(); 
        
        conn.conectarSQLITE(); 
        vista.setTlbHistorialDatos2(conn.actTablaPropietarios(vista.getTlbHistorialDatos2(),"select * from parking "));
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
    
    public void InicioVisorT(){
        vT.getBtnRegistroTarjeta().addActionListener(this);
        vT.getTxtBuscaT().addKeyListener(this);
        vT.getbtnconfig().addActionListener(this);
        vT.setLocationRelativeTo(vista);
        contador++;
        conn.conectarSQLITE(); 
        String sql="select * from tarjetas";
        this.vT.setTlbHistorialTarjeta(conn.actTablaTarjeTa(vT.getTlbHistorialTarjeta(),sql));
        vT.getlbltiempo().setText(conn.tiempo()+" H");
        conn.desconectar(); 
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
            
            //Motos
            if (e.getSource() == vista.getBtnPuesto51()) { this.actPuesto(51);}
            if (e.getSource() == vista.getBtnPuesto52()) { this.actPuesto(52);}
            if (e.getSource() == vista.getBtnPuesto53()) { this.actPuesto(53);}
            if (e.getSource() == vista.getBtnPuesto54()) { this.actPuesto(54);}
            if (e.getSource() == vista.getBtnPuesto55()) { this.actPuesto(55);}
            if (e.getSource() == vista.getBtnPuesto56()) { this.actPuesto(56);}
            if (e.getSource() == vista.getBtnPuesto57()) { this.actPuesto(57);}
            if (e.getSource() == vista.getBtnPuesto58()) { this.actPuesto(58);}
            if (e.getSource() == vista.getBtnPuesto59()) { this.actPuesto(59);}
            if (e.getSource() == vista.getBtnPuesto60()) { this.actPuesto(60);}
            if (e.getSource() == vista.getBtnPuesto61()) { this.actPuesto(61);}
            if (e.getSource() == vista.getBtnPuesto62()) { this.actPuesto(62);}
            if (e.getSource() == vista.getBtnPuesto63()) { this.actPuesto(63);}
            if (e.getSource() == vista.getBtnPuesto64()) { this.actPuesto(64);}
            if (e.getSource() == vista.getBtnPuesto65()) { this.actPuesto(65);}
            if (e.getSource() == vista.getBtnPuesto66()) { this.actPuesto(66);}
            if (e.getSource() == vista.getBtnPuesto67()) { this.actPuesto(67);}
            if (e.getSource() == vista.getBtnPuesto68()) { this.actPuesto(68);}
            if (e.getSource() == vista.getBtnPuesto69()) { this.actPuesto(69);}
            if (e.getSource() == vista.getBtnPuesto70()) { this.actPuesto(70);}
            if (e.getSource() == vista.getBtnPuesto71()) { this.actPuesto(71);}
            if (e.getSource() == vista.getBtnPuesto72()) { this.actPuesto(72);}
            if (e.getSource() == vista.getBtnPuesto73()) { this.actPuesto(73);}
            if (e.getSource() == vista.getBtnPuesto74()) { this.actPuesto(74);}
            if (e.getSource() == vista.getBtnPuesto75()) { this.actPuesto(75);}
            if (e.getSource() == vista.getBtnPuesto76()) { this.actPuesto(76);}
            if (e.getSource() == vista.getBtnPuesto77()) { this.actPuesto(77);}
            if (e.getSource() == vista.getBtnPuesto78()) { this.actPuesto(78);}
            if (e.getSource() == vista.getBtnPuesto79()) { this.actPuesto(79);}
            if (e.getSource() == vista.getBtnPuesto80()) { this.actPuesto(80);}
            if (e.getSource() == vista.getBtnPuesto81()) { this.actPuesto(81);}
            if (e.getSource() == vista.getBtnPuesto82()) { this.actPuesto(82);}
            if (e.getSource() == vista.getBtnPuesto83()) { this.actPuesto(83);}
            if (e.getSource() == vista.getBtnPuesto84()) { this.actPuesto(84);}
            if (e.getSource() == vista.getBtnPuesto85()) { this.actPuesto(85);}
            if (e.getSource() == vista.getBtnPuesto86()) { this.actPuesto(86);}
            if (e.getSource() == vista.getBtnPuesto87()) { this.actPuesto(87);}
            if (e.getSource() == vista.getBtnPuesto88()) { this.actPuesto(88);}
            if (e.getSource() == vista.getBtnPuesto89()) { this.actPuesto(89);}
            if (e.getSource() == vista.getBtnPuesto90()) { this.actPuesto(90);}
            if (e.getSource() == vista.getBtnPuesto91()) { this.actPuesto(91);}
            if (e.getSource() == vista.getBtnPuesto92()) { this.actPuesto(92);}
            if (e.getSource() == vista.getBtnPuesto93()) { this.actPuesto(93);}
            if (e.getSource() == vista.getBtnPuesto94()) { this.actPuesto(94);}
            if (e.getSource() == vista.getBtnPuesto95()) { this.actPuesto(95);}
            if (e.getSource() == vista.getBtnPuesto96()) { this.actPuesto(96);}
            if (e.getSource() == vista.getBtnPuesto97()) { this.actPuesto(97);}
            if (e.getSource() == vista.getBtnPuesto98()) { this.actPuesto(98);}
            if (e.getSource() == vista.getBtnPuesto99()) { this.actPuesto(99);}
            if (e.getSource() == vista.getBtnPuesto100()) { this.actPuesto(100);} 
            
            if (e.getSource() == vista.getBtnTarjetas()) { this.registro();}
            
        }    
        if (e.getSource() == vista.getBtnrefresh()) { this.actHistorial();}
        if (e.getSource() == vT.getbtnconfig()) {
            int a;
             if (comun.isNumeric(vT.getTxtConfig().getText().trim())){
                a=JOptionPane.showConfirmDialog(vista, "Confirmar");                
                if (a==0){ // Si se presiona si se guardan los datos
                    conn.conectarSQLITE(); // conexta a BD sqlite
                    conn.actConfig(Integer.parseInt(vT.getTxtConfig().getText().trim()));
                    //matches("[0-9]*")
                    vT.getlbltiempo().setText(conn.tiempo()+" H");
                    conn.desconectar(); // desconexta a BD sqlite
                } 
            }
            else{JOptionPane.showMessageDialog(null, "Ingrese un dato valido");}

        }
         
        if (e.getSource() == vT.getBtnRegistroTarjeta()){
            regT = new RegistroTarjeta(vista, true);
            CRTarjetas controlador = new CRTarjetas(vista,regT,vT);
            controlador.InicioRegT();
            regT.setVisible(true);
        }
         if (contador == 0){
        if (e.getSource() == vista.getBtnRegistroPeaton()){
            regPea = new RegistroPeaton(vista, true);
            CRPeaton controlador = new CRPeaton(vista,regPea);
            controlador.InicioRegPea();
            regPea.setVisible(true);
        } 
         }
        if (e.getSource() == reg.getBtn_save()) {
                String msg=validar();
                if (msg.equalsIgnoreCase("")){
                    int a=JOptionPane.showConfirmDialog(vista, "Confirmar");
                    if (a==0){ // Si se presiona si se guardan los datos
                        conn.conectarSQLITE(); // conexta a BD sqlite
                        conn.guardar(reg,reg.puesto); // Llama al metodo guardar en la BD
                        conn.desconectar(); // desconexta a BD sqlite
                        if (reg.puesto<51) {vista.ocupado(reg.puesto);}
                        else {vista.ocupadoM(reg.puesto);}
                        reg.dispose(); 
                    }
                }else {JOptionPane.showMessageDialog(vista, msg);} 
        }
        if (e.getSource() == reg.getBtnCancelar()){ if (contador != 0){ reg.dispose(); } }

        if (e.getSource() == vista.getCmbFiltradoDiaVehiculo()){
            int indice=0;
            indice = vista.getCmbFiltradoDiaVehiculo().getSelectedIndex();
            if (indice==0){ sql="select * from  parking where "; }
            else if (indice==1){ sql="select * from  parking where estado like 'entrada' and  ";  }
            else if (indice==2){ sql="select * from  parking where estado like 'salida' and  ";  }
            else if (indice==3){ sql="select * from  parking where estado like 'infractor' and  ";  }
            else { sql="select * from  parking where ";}
            String fechaI[]=vista.getTxtFechaInicial().getText().split("/");
            String fechaF[]=vista.getTxtFechaFinal().getText().split("/");
             sql=sql+" fechareg >= '"+fechaI[2]+"-"+fechaI[1]+"-"+fechaI[0]+" 00:00:00' ";
             sql=sql+" and fechareg <= '"+fechaF[2]+"-"+fechaF[1]+"-"+fechaF[0]+" 00:00:00' ";
             sql=sql+" order by id desc";
            conn.conectarSQLITE();
            conn.ActTabla(1, vista.getTlbHistorialVehiculos(),sql);
            conn.desconectar();
        }
    }  
    
    // Meotdo creado para registrar los datos de los visitabtes de todos los puestos
    public void actPuesto(int p){
        reg = new RegistroVehiculo(vista, true);
        button_control control = new button_control(vista,reg, vT);
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

    public void keyTyped(KeyEvent ke) {  }

    public void keyPressed(KeyEvent ke) {  }

    public void keyReleased(KeyEvent ke) {
       String sql="select * from peatones";
       if (ke.getSource().equals(this.vista.getTxtBuscadorPersona1())){
           JTextField txt= (JTextField) ke.getSource();
           sql="select * from parking where placa LIKE '"+txt.getText()+"%' ";
           conn.conectarSQLITE(); 
            vista.setTlbHistorialDatos2(conn.actTablaPropietarios(vista.getTlbHistorialDatos2(),sql));           
           conn.desconectar(); //
       }
       if (ke.getSource().equals(this.vista.getTxtBuscadorPersona())){
           JTextField txt= (JTextField) ke.getSource();
           sql="select * from peatones where apart LIKE '"+txt.getText()+"%' ";
           conn.conectarSQLITE(); 
           vista.setTlbHistorialDatos1(conn.actTablaPea(vista.getTlbHistorialDatos1(),sql));
           conn.desconectar(); //
       }
       if (ke.getSource().equals(this.vT.getTxtBuscaT())){
           JTextField txt= (JTextField) ke.getSource();
           sql="select * from tarjetas where tarjeta LIKE '"+txt.getText()+"%' ";
           conn.conectarSQLITE(); 
           vT.setTlbHistorialTarjeta(conn.actTablaTarjeTa(vT.getTlbHistorialTarjeta(),sql));
           conn.desconectar(); //
       }
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
             sql=sql+" fechareg >= '"+fechaI[2]+"-"+fechaI[1]+"-"+fechaI[0]+" 00:00:00' ";
             sql=sql+" and fechareg <= '"+fechaF[2]+"-"+fechaF[1]+"-"+fechaF[0]+" 00:00:00' ";
             sql=sql+" order by id desc";
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
              vT = new VisorTarjeta(vista, true);
              button_control control = new button_control(vista,reg, vT);
              control.InicioVisorT();
              vT.setVisible(true);  
            }else { JOptionPane.showMessageDialog(null, "Clave incorrecta"); }
            //Here is some validation code
        }
    }
    public String validar(){
    String mensaje="";
        if (reg.getTxtApartamento().getText().equalsIgnoreCase("")){
            return "Debe ingresar un Apartamento";
        }
        if (reg.getTxtNombreVisitante().getText().equalsIgnoreCase("")){
            return "Debe ingresar datos del Visitante";
        }
        if (reg.getTxtPlaca().getText().equalsIgnoreCase("")){
            return "Debe ingresar una Placa";
        }
        if (reg.getTxtTarjeta().getText().equalsIgnoreCase("")){
            return "Debe ingresar una tarjeta";
        }
        conn.conectarSQLITE(); 
        if (conn.consultarPlaca(reg.getTxtPlaca().getText())){
            conn.desconectar();
            return "Placa registrada verifique la informacion";
        }
        if (conn.consultarTarj(reg.getTxtTarjeta().getText())){
            conn.desconectar();
            return "TARJETA registrada verifique la informacion";
        }else {conn.desconectar();}
        
        return mensaje;
    }

    private void actHistorial() {
        conn.conectarSQLITE();
        vista.setTlbHistorial(conn.CargarTablaHistorias(vista.getTlbHistorial()));
        conn.desconectar();
    }

    
}
