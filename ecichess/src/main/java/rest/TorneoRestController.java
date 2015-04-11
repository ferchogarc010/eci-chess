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
    
    
}
