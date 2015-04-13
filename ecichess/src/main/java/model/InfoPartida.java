/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fercho
 */
public class InfoPartida {
    
    private int idpartidas;
    private int codigofide1;
    private int codigofide2;
    private RondaId ronda;
    private String resultado;

    public InfoPartida() {
    }

    /**
     * @return the idpartidas
     */
    public int getIdpartidas() {
        return idpartidas;
    }

    /**
     * @param idpartidas the idpartidas to set
     */
    public void setIdpartidas(int idpartidas) {
        this.idpartidas = idpartidas;
    }

    /**
     * @return the codigofide1
     */
    public int getCodigofide1() {
        return codigofide1;
    }

    /**
     * @param codigofide1 the codigofide1 to set
     */
    public void setCodigofide1(int codigofide1) {
        this.codigofide1 = codigofide1;
    }

    /**
     * @return the codigofide2
     */
    public int getCodigofide2() {
        return codigofide2;
    }

    /**
     * @param codigofide2 the codigofide2 to set
     */
    public void setCodigofide2(int codigofide2) {
        this.codigofide2 = codigofide2;
    }

    /**
     * @return the ronda
     */
    public RondaId getRonda() {
        return ronda;
    }

    /**
     * @param ronda the ronda to set
     */
    public void setRonda(RondaId ronda) {
        this.ronda = ronda;
    }

    /**
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
    
}
