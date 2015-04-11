/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import model.Torneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.TorneoRepository;

/**
 *
 * @author fercho
 */
@Service
public class LogicaTorneo {
    
    @Autowired
    private TorneoRepository torneoRepository;
    
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
}
