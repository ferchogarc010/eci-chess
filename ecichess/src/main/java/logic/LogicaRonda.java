/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import model.Ronda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.RondaRepository;

/**
 *
 * @author fercho
 */
@Service
public class LogicaRonda {
    
    @Autowired
    private RondaRepository rondaRepository;
    
    public void registrarRonda(Ronda r){
        rondaRepository.save(r);
    }
    
    public List<Ronda> getRondas(){
        ArrayList<Ronda> list = new ArrayList();
        Iterable<Ronda> it = rondaRepository.findAll();
        for (Ronda item : it) {
            list.add(item);
        }
        return list;
    }
    
}
