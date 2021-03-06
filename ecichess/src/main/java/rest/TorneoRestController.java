/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import logic.LogicaTorneo;
import model.InfoJugador;
import model.InfoRonda;
import model.Jugador;
import model.Ronda;
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
@RequestMapping("/torneo")
public class TorneoRestController {
    
    @Autowired
    private LogicaTorneo logicaTorneo;
    
    @RequestMapping(value="/",method = RequestMethod.POST)
    public ResponseEntity<?> guardarTorneo(@RequestBody Torneo t){
        logicaTorneo.registrarTorneo(t);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> modificarTorneo(@PathVariable int id,@RequestBody Torneo t){
        logicaTorneo.modificarTorneo(t,id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/",method = RequestMethod.GET)        
    public List<Torneo> getTorneos(){
        return logicaTorneo.getTorneos();
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.GET)        
    public Torneo getTorneoById(@PathVariable int id){
        return logicaTorneo.getTorneoById(id);
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)  
    public void deleteTorneo(@PathVariable int id){
        logicaTorneo.deleteTorneo(id);
    }
    
    @RequestMapping(value="/{id}/ronda",method = RequestMethod.POST)
    public ResponseEntity<?> guardarRondaEnTorneo(@PathVariable int id,@RequestBody InfoRonda ir){
        logicaTorneo.registrarRondaEnTorneo(ir, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/{id}/ronda",method = RequestMethod.GET)        
    public List<Ronda> getRondasFromTorneoId(@PathVariable int id){
        return logicaTorneo.getRondas(id);
    }
    
    @RequestMapping(value="/{torneo}/ronda/{ronda}",method = RequestMethod.GET)        
    public Ronda getRonda(@PathVariable int torneo, @PathVariable int ronda){
        return logicaTorneo.getRonda(torneo, ronda);
    }
    
    @RequestMapping(value="/{torneo}/ronda/{ronda}",method = RequestMethod.PUT)
    public ResponseEntity<?> modificarRondaEnTorneo(@PathVariable int torneo, @PathVariable int ronda,@RequestBody InfoRonda ir){
        logicaTorneo.modificarRondaEnTorneo(ir, ronda, torneo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/{torneo}/ronda/{ronda}",method = RequestMethod.DELETE)        
    public void deleteRonda(@PathVariable int torneo, @PathVariable int ronda){
        logicaTorneo.deleteRonda(torneo, ronda);
    }
    
    @RequestMapping(value="/{id}/jugador",method = RequestMethod.POST)
    public ResponseEntity<?> guardarJugadorEnTorneo(@PathVariable int id,@RequestBody InfoJugador ij){
        logicaTorneo.registrarJugadorEnTorneo(ij, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/{id}/jugador",method = RequestMethod.GET)        
    public List<Jugador> getJugadoresFromTorneoId(@PathVariable int id){
        return logicaTorneo.getJugadores(id);
    }
    
    @RequestMapping(value="/{torneo}/jugador/{jugador}",method = RequestMethod.DELETE)        
    public void deleteJugadorFromTorneoId(@PathVariable int torneo, @PathVariable int jugador){
        logicaTorneo.deleteJugador(torneo, jugador);
    }
    
    
    
}
