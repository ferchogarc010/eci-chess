/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author fercho
 */
public class InfoRonda {
    
    private RondaId id;
    private Date fecha;

    public InfoRonda() {
    }

    /**
     * @return the id
     */
    public RondaId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(RondaId id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
