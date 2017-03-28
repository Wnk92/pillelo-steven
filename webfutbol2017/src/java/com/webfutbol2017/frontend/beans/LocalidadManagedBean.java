/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.Localidad;
import com.webfutbol2017.backend.persistence.facades.LocalidadFacade;
import com.webfutbol2017.frontend.utilities.converters.InterfaceController;
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
@Named(value = "localidadManagedBean")
@ConversationScoped
public class LocalidadManagedBean implements Serializable, InterfaceController<Localidad> {

    private Localidad localidad;
    @EJB
    private LocalidadFacade localidadEJB;

    public LocalidadManagedBean() {
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @PostConstruct
    public void init() {

        localidad = new Localidad();

    }

    public void registrarLocalidad() {

        localidadEJB.create(localidad);

    }

    public List<Localidad> listarLocalidad() {

        return localidadEJB.findAll();
    }

    @Override
    public Localidad getObjectByKey(Integer key) {
        return localidadEJB.find(key);
    }
}
