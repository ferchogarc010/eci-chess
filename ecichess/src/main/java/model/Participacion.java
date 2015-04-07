package model;
// Generated Apr 3, 2015 6:07:00 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Participacion generated by hbm2java
 */
@Entity
@Table(name="Participaciones")
public class Participacion  implements java.io.Serializable {


    private ParticipacionId id;

    public Participacion() {
    }

    public Participacion(ParticipacionId id) {
       this.id = id;
    }
   
    @EmbeddedId
    @AttributeOverrides( {
        @AttributeOverride(name="jugadoresCodigoFide", column=@Column(name="Jugadores_codigoFide", nullable=false) ), 
        @AttributeOverride(name="torneosIdTorneos", column=@Column(name="Torneos_idTorneos", nullable=false) ) } )
    public ParticipacionId getId() {
        return this.id;
    }
    
    public void setId(ParticipacionId id) {
        this.id = id;
    }




}


