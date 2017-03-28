/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.Jugador;
import com.webfutbol2017.backend.persistence.facades.JugadorFacade;
import com.webfutbol2017.frontend.utilities.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Iesua
 */
@Named(value = "jugadorManagedBean")
@RequestScoped
public class JugadorManagedBean implements Serializable, InterfaceController<Jugador>{

    private Jugador jugador;
    @EJB
    private JugadorFacade jugf;
    
    
    public JugadorManagedBean() {
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    
    @PostConstruct
    public void init(){
        jugador = new Jugador();
    }
    
    
    public void registrarJugador(){
        jugf.create(jugador);
    }
    
    public void modificarJugador(){
        jugf.edit(jugador);
    }
    
    public void eliminarJugador(Jugador j){
        jugf.remove(jugador);
    }
    
    public List<Jugador> listarJugador(){
        return jugf.findAll();
    }
    
    public String actualizarJugador(Jugador ju){
        jugador = ju;
        return "";
    }

    @Override
    public Jugador getObjectByKey(Integer key) {
        return jugf.find(key);
    }
    
    
    
    
    
    
    
}
