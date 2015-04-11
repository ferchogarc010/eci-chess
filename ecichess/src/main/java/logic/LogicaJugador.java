/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.JugadorRepository;

/**
 *
 * @author fercho
 */
@Service
public class LogicaJugador {

    @Autowired
    private JugadorRepository jugadorRepository;
    
    public void registrarJugador(Jugador j){
        jugadorRepository.save(j);
    }
    
    public List<Jugador> getJugadores(){
        ArrayList<Jugador> list = new ArrayList();
        Iterable<Jugador> it = jugadorRepository.findAll();
        for (Jugador item : it) {
            list.add(item);
        }
        return list;
    }

    public Jugador getJugadorById(int id) {
        return jugadorRepository.findOne(id);
    }
}
