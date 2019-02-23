/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author corte
 */
public class comun {
    public static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
  
    }
    public static int restaFechas(String fechacomp){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        Date fechaInicial = null;
        Date date = new Date();
        //fechaInicial = dateFormat.parse("2016-02-14 10:00:00");
        //fechaInicial = dateFormat.parse("2019-02-22 22:59:00");
        //fechaInicial = dateFormat.parse(date);
        fechaInicial = date;
        Date fechaFinal = null;
        //System.out.println(fechainim);
   //     System.out.println("fechaInicial: "+fechaInicial);
        try {
            //fechaFinal = dateFormat.parse("2019-02-22 22:59:00");
            fechaFinal = dateFormat.parse(fechacomp);
          //  System.out.println("fechaFinal: "+fechaFinal);
        } catch (ParseException ex) {
            Logger.getLogger(comun.class.getName()).log(Level.SEVERE, null, ex);
        }
        int diferencia=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/1000);
        int dias=0;
        int horas=0;
        int minutos=0;
        if(diferencia>86400) {
            dias=(int)Math.floor(diferencia/86400);
            diferencia=diferencia-(dias*86400);
        }
        if(diferencia>3600) {
            horas=(int)Math.floor(diferencia/3600);
            diferencia=diferencia-(horas*3600);
        }
        if(diferencia>60) {
            minutos=(int)Math.floor(diferencia/60);
            diferencia=diferencia-(minutos*60);
        }
        //System.out.println("Hay "+dias+" dias, "+horas+" horas, "+minutos+" minutos y "+diferencia+" segundos de diferencia");
        return minutos;
        //return horas;
    }
}
