/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.InfoJugador;
import model.InfoRonda;
import model.Jugador;
import model.Ronda;
import model.RondaId;
import model.Torneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.JugadorRepository;
import persistence.RondaRepository;
import persistence.TorneoRepository;

/**
 *
 * @author fercho
 */
@Service
public class LogicaTorneo {
    
    @Autowired
    private TorneoRepository torneoRepository;
    
    @Autowired
    private RondaRepository rondaRepository;
    
    @Autowired
    private JugadorRepository jugadorRepository;
    
    public void registrarTorneo(Torneo t){
        torneoRepository.save(t);
    }
    
    public List<Torneo> getTorneos(){
        ArrayList<Torneo> list = new ArrayList();
        Iterable<Torneo> it = torneoRepository.findAll();
        for (Torneo item : it) {
            list.add(item);
        }
        return list;
    }

    public void modificarTorneo(Torneo t, int id) {
        Torneo oldTorneo = torneoRepository.findOne(id);
        oldTorneo.setArbitro(t.getArbitro());
        oldTorneo.setDirector(t.getDirector());
        oldTorneo.setFechafin(t.getFechafin());
        oldTorneo.setFechainicio(t.getFechainicio());
        oldTorneo.setFederacion(t.getFederacion());
        oldTorneo.setLugar(t.getLugar());
        oldTorneo.setNombre(t.getNombre());
        oldTorneo.setOrganizador(t.getOrganizador());
        oldTorneo.setTipo(t.getTipo());
        torneoRepository.save(oldTorneo);
    }

    public Torneo getTorneoById(int id) {
        return torneoRepository.findOne(id);
    }

    public void deleteTorneo(int id) {
        torneoRepository.delete(id);
    }

    public void registrarRondaEnTorneo(InfoRonda ir, int id) {
        Torneo t = torneoRepository.findOne(id);
        Ronda r = new Ronda(ir.getId(), t, ir.getFecha());
        rondaRepository.save(r);
    }

    public List<Ronda> getRondas(int id) {
        return rondaRepository.searchRondasByIdTorneo(id);
    }

    public Ronda getRonda(int torneo, int ronda) {
        return rondaRepository.searchRondaById(torneo, ronda).get(0);
    }

    public void modificarRondaEnTorneo(InfoRonda ir, int ronda, int torneo) {
        Ronda r = rondaRepository.findOne(ir.getId());
        r.setFecha(ir.getFecha());
        rondaRepository.save(r);
    }

    public void deleteRonda(int torneo, int ronda) {
        rondaRepository.delete(new RondaId(ronda, torneo));
    }

    public void registrarJugadorEnTorneo(InfoJugador ij, int id) {
        Torneo t = torneoRepository.findOne(id);
        Jugador j = jugadorRepository.findOne(ij.getCodigofide());
        t.getJugadoreses().add(j);
        torneoRepository.save(t);
    }

    public List<Jugador> getJugadores(int id) {
        ArrayList<Jugador> l = new ArrayList<>();
        l.addAll(torneoRepository.findOne(id).getJugadoreses());
        return l;
    }

    public void deleteJugador(int torneo, int jugador) {
        Torneo t = torneoRepository.findOne(torneo);
        Set<Jugador> s = t.getJugadoreses();
        Jugador oldj = null;
        for (Jugador j : s) {
            if(j.getCodigofide()==jugador){
                oldj = j;
            }
        }
        s.remove(oldj);
        t.setJugadoreses(s);
        torneoRepository.save(t);
    }

    public List<Torneo> getTorneosByJugador(int id) {
        return torneoRepository.searchTorneosByJugador(id);
    }
}
