/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.List;
import model.Ronda;
import model.RondaId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author fercho
 */
public interface RondaRepository extends CrudRepository<Ronda, RondaId>{
    
    @Query("from Ronda r where r.id.torneosIdtorneos = :id")
    public List<Ronda> searchRondasByIdTorneo(@Param("id") int id);
    
}
