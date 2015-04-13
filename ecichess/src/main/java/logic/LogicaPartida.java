/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import model.InfoPartida;
import model.Partida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.JugadorRepository;
import persistence.PartidaRepository;
import persistence.RondaRepository;

/**
 *
 * @author fercho
 */
@Service
public class LogicaPartida {
    
    @Autowired
    private PartidaRepository partidaRepository;
    
    @Autowired
    private JugadorRepository jugadorRepository;
    
    @Autowired
    private RondaRepository rondaRepository;
    
    public void registrarPartida(InfoPartida ip){
        Partida p = new Partida(ip.getIdpartidas(), jugadorRepository.findOne(ip.getCodigofide1()),jugadorRepository.findOne(ip.getCodigofide2()), rondaRepository.findOne(ip.getRonda()), ip.getResultado());
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

    public Partida getPartidasById(int id) {
        return partidaRepository.findOne(id);
    }

    public void deletePartidasById(int id) {
        partidaRepository.delete(id);
    }

    public void modificarPartida(InfoPartida ip, int id) {
        Partida p = partidaRepository.findOne(id);
        p.setJugadoresByJugadoresCodigofide(jugadorRepository.findOne(ip.getCodigofide1()));
        p.setJugadoresByJugadoresCodigofide1(jugadorRepository.findOne(ip.getCodigofide2()));
        p.setResultado(ip.getResultado());
        p.setRondas(rondaRepository.findOne(ip.getRonda()));
        partidaRepository.save(p);
        
    }
    
}
