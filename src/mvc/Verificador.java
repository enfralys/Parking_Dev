package mvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.Main;

public  class Verificador implements Runnable {
    private Thread t;
    private String threadName;
    private Main Vista;
    public Verificador( String name){
        threadName = name;
        System.out.println("Creando Verificador " + threadName );
    }

    Verificador(String verificador, Main view) {
        threadName = verificador;
        System.out.println("Creando Verificador " + threadName );
        this.Vista=view;

    }
    public void run() {
        try {
            conex c=new conex();
            conex d=new conex();
            System.out.println("Ejecutando " + threadName );
            int a=5;
            boolean stop = true;
            d.conectarSQLITE();
            ResultSet rs= d.consultarEntradas();
            int puesto=0;
            while (rs.next()){
                puesto=rs.getInt("puesto");
                c.conectarMSQL();
                if (c.salidas().equals(String.valueOf(puesto))) {
                    d.salida(puesto);
                    System.out.println("Puesto:" +puesto+" cerrado " );
                    Vista.desocupado(puesto);
                }
                c.desconectar();
            }
            d.desconectar();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
        }

                
    }
    public void start (){
        System.out.println("Iniciando " + threadName );
            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
    }
}