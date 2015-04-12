/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import logic.LogicaJugador;
import logic.LogicaTorneo;
import model.Jugador;
import model.Torneo;
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
    
    @Autowired
    private LogicaTorneo logicaTorneo;
    
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
    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)   
    public void eliminarJugadorPorId(@PathVariable int id){       
        logicaJugador.deleteJugadorById(id);
    }
    
    @RequestMapping(value="/{id}/torneo",method = RequestMethod.GET)        
    public List<Torneo> consultarTorneosporJugador(@PathVariable int id){       
        return logicaTorneo.getTorneosByJugador(id);
    }
    
    
}
