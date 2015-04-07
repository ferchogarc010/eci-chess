/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import model.Partida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.PartidaRepository;

/**
 *
 * @author fercho
 */
@Service
public class LogicaPartida {
    
    @Autowired
    private PartidaRepository partidaRepository;
    
    public void registrarPartida(Partida p){
        partidaRepository.save(p);
    }
    
    public List<Partida> getPartidas(){
        ArrayList<Partida> list = new ArrayList();
        Iterable<Partida> it = partidaRepository.findAll();
        for (Partida item : it) {
            list.add(item);
        }
        return list;
    }
    
}
