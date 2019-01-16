/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author stalker
 */
public class registro {
    private String placa,nombre_invitado,apto;
    private int puesto;

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the nombre_invitado
     */
    public String getNombre_invitado() {
        return nombre_invitado;
    }

    /**
     * @param nombre_invitado the nombre_invitado to set
     */
    public void setNombre_invitado(String nombre_invitado) {
        this.nombre_invitado = nombre_invitado;
    }

    /**
     * @return the apto
     */
    public String getApto() {
        return apto;
    }

    /**
     * @param apto the apto to set
     */
    public void setApto(String apto) {
        this.apto = apto;
    }

    /**
     * @return the puesto
     */
    public int getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }
}
