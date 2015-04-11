/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import logic.LogicaJugador;
import model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fercho
 */
@RestController
@RequestMapping("/jugador")
public class JugadorRestController {
    
    @Autowired
    private LogicaJugador logicaJugador;
    
    @RequestMapping(value="/",method = RequestMethod.POST)   
    public ResponseEntity<?> guardarJugador(@RequestBody Jugador j){
        logicaJugador.registrarJugador(j);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)   
    public ResponseEntity<?> modificarJugador(@PathVariable int id,@RequestBody Jugador j){
        logicaJugador.modificarJugador(j, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/",method = RequestMethod.GET)        
    public List<Jugador> consultarJugador(){       
        return logicaJugador.getJugadores();
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.GET)        
    public Jugador consultarJugadorPorId(@PathVariable int id){       
        return logicaJugador.getJugadorById(id);
    }
    
    
}
