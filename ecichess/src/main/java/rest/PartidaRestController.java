/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import logic.LogicaPartida;
import model.InfoPartida;
import model.Partida;
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
@RequestMapping("/partida")
public class PartidaRestController {
    
    @Autowired
    private LogicaPartida logicaPartida;
    
    @RequestMapping(value="/",method = RequestMethod.POST)   
    public ResponseEntity<?> guardarPartida(@RequestBody InfoPartida ip){
        logicaPartida.registrarPartida(ip);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)   
    public ResponseEntity<?> modificarPartida(@PathVariable int id, @RequestBody InfoPartida ip){
        logicaPartida.modificarPartida(ip, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/",method = RequestMethod.GET)        
    public List<Partida> consultarpartidas(){       
        return logicaPartida.getPartidas();
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.GET)        
    public Partida consultarPartidasById(@PathVariable int id){       
        return logicaPartida.getPartidasById(id);
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)        
    public void eliminarPartidasById(@PathVariable int id){       
        logicaPartida.deletePartidasById(id);
    }
    
}
