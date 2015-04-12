/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.List;
import model.Torneo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author fercho
 */
public interface TorneoRepository  extends CrudRepository<Torneo, Integer>{
    
    @Query("from Torneo t where t.jugadoreses.codigofide = :id")
    public List<Torneo> searchTorneosByJugador(@Param("id") int id);
}
