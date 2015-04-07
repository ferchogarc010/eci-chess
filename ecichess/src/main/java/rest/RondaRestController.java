/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import logic.LogicaRonda;
import model.Ronda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fercho
 */
@RestController
@RequestMapping("/ronda")
public class RondaRestController {
    
    @Autowired
    private LogicaRonda LogicaRonda;
    
    @RequestMapping(value="/",method = RequestMethod.POST)   
    public ResponseEntity<?> guardarJugador(@RequestBody Ronda r){
        LogicaRonda.registrarRonda(r);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/",method = RequestMethod.GET)        
    public List<Ronda> consultarPagos(){       
        return LogicaRonda.getRondas();
    }
    
}
