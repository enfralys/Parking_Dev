/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.propietario;
import views.Main;

/**
 *
 * @author corte
 */
public class Temporizador extends TimerTask{

    private Main Vista;
    private conex c,d;
    private propietario p;
    
    public Temporizador(Main view) {
       this.Vista=view;
       c=new conex();
       d=new conex();
       p=new propietario();
      
    }
    public Temporizador() {
        c=new conex();
        d=new conex();
    }
    public void run() {
         try {
            boolean stop = true;
            c.conectarMSQL();
            d.conectarSQLITE();
            d.infractores();
            ResultSet rs= d.consultarEntradas();
            int puesto=0;
            String tarjeta;
            if (d.existeRegistro(c.salidas(), c.getid_monitor_log(),c)==false){
                if (c.userinfo(c.salidas(),p,d.getconn(),c.getid_monitor_log())){
                    Vista.actPropietario(p);
                }
            }
            if (Vista.bandera==false){
                Vista.setTlbHistorialDatos2(d.actTablaPropietarios(Vista.getTlbHistorialDatos2(),"select * from propietarios order by id desc"));           
                d.getUltPropietario(p);
                if (p!=null){
                    Vista.actPropietario(p);
                }
            }
            while (rs.next()){
                puesto=rs.getInt("puesto");
                tarjeta=rs.getString("tarjeta");
                tarjeta=d.buscaTarjeta(tarjeta);
                if (c.salidas().equals(tarjeta)) {
                    d.salida(puesto);
                    Vista.desocupado(puesto);
                    c.newsalida();
                }
            }
           // Vista.getlblplaca().setText(d.ultimaplana());
       ///     Vista.setTlbHistorialDatos2(d.actTablaPropietarios(Vista.getTlbHistorialDatos2(),"select * from parking"));
            //   Vista.setTlbHistorial(d.CargarTablaHistorias(Vista.getTlbHistorial()));
            
            d.desconectar();
            c.desconectar();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
    
}
