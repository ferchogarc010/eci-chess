/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import model.Jugador;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fercho
 */
public interface JugadorRepository extends CrudRepository<Jugador, Integer>{
    
}
