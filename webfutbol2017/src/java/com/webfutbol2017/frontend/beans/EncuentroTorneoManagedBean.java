/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.EncuentroTorneo;
import com.webfutbol2017.backend.persistence.facades.EncuentroTorneoFacade;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author camila
 */
@Named(value = "encuentroTorneoManagedBean")
@ConversationScoped
public class EncuentroTorneoManagedBean implements Serializable {

    private EncuentroTorneo encuentroTorneo;
    @EJB
    private EncuentroTorneoFacade encuentroTorneoEJB;

    public EncuentroTorneoManagedBean() {
    }

    public EncuentroTorneo getEncuentroTorneo() {
        return encuentroTorneo;
    }

    public void setEncuentroTorneo(EncuentroTorneo encuentroTorneo) {
        this.encuentroTorneo = encuentroTorneo;
    }

    @PostConstruct
    public void init() {

        encuentroTorneo = new EncuentroTorneo();

    }

    public List<EncuentroTorneo> listarEncuentroTorneo() {

        return encuentroTorneoEJB.findAll();

    }

}
