package mvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.Main;

public  class Verificador2  {
    private Main Vista;
    Verificador2(Main view) {
       this.Vista=view;
    }
    Verificador2() {
       
    }
    public void verifica() {
        try {
            conex c=new conex();
            conex d=new conex();
            int a=5;
            boolean stop = true;
            c.conectarMSQL();
            while (stop){
                d.conectarSQLITE();
                ResultSet rs= d.consultarEntradas();
                int puesto=0;
                String tarjeta;
                while (rs.next()){
                    puesto=rs.getInt("puesto");
                    tarjeta=rs.getString("tarjeta");
                   if (c.salidas().equals(tarjeta)) {
                        d.salida(puesto);
                        Vista.desocupado(puesto);
                    }
                }
                d.desconectar();
            }
            c.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Verificador2.class.getName()).log(Level.SEVERE, null, ex);
        }

                
    }

}