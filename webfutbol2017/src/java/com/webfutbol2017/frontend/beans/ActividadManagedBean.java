/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.ActividadElectiva;
import com.webfutbol2017.backend.persistence.facades.ActividadElectivaFacade;
import com.webfutbol2017.frontend.utilities.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "actividadManagedBean")
@RequestScoped
public class ActividadManagedBean implements Serializable, InterfaceController<ActividadElectiva> {

    /**
     * Creates a new instance of ActividadManagedBean
     */
    public ActividadManagedBean() {
    }

    private ActividadElectiva actividad;
    @EJB
    private ActividadElectivaFacade actividadf;
    
    @PostConstruct
    public void init(){
    actividad = new ActividadElectiva();
    }

    public ActividadElectiva getActividad() {
        return actividad;
    }

    public void setActividad(ActividadElectiva actividad) {
        this.actividad = actividad;
    }
    
    
     public void registrarActividad(){
    actividadf.create(actividad);
    }
    
    public void eliminarActividad(){
    actividadf.remove(actividad);
    }
    
    public void modificarActividad(){
    actividadf.edit(actividad);
    }
    
    public List<ActividadElectiva> listarActividad() {

        return actividadf.findAll();}
    
    @Override
    public ActividadElectiva getObjectByKey(Integer key) {
    return actividadf.find(key);
    }
    
}
