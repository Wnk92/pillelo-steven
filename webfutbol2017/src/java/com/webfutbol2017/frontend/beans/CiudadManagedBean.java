/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.Ciudad;
import com.webfutbol2017.backend.persistence.facades.CiudadFacade;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author camila
 */
@Named(value = "ciudadManagedBean")
@ConversationScoped
public class CiudadManagedBean implements Serializable {

   
    private Ciudad ciudad;
    @EJB
    private CiudadFacade ciudadEJB;
    
    public CiudadManagedBean() {
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    @PostConstruct
    public void init(){
    
        ciudad = new Ciudad();
    
    }


     public void registrarCiudad() {

        try {

            ciudadEJB.create(ciudad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Ciudad registrada con éxito"));

        } catch (Exception e) {

        }
    }
     
     public List<Ciudad> listarCiudad(){
     
     return ciudadEJB.findAll();
     
     }
}

