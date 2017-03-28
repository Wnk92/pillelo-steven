/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.Barrio;
import com.webfutbol2017.backend.persistence.facades.BarrioFacade;
import com.webfutbol2017.frontend.utilities.converters.InterfaceController;
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
@Named(value = "barrioManagaedBean")
@ConversationScoped
public class BarrioManagaedBean implements Serializable, InterfaceController<Barrio> {

    private Barrio barrio;
    @EJB
    private BarrioFacade barrioEJB;

    public BarrioManagaedBean() {
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    @PostConstruct
    public void init() {

        barrio = new Barrio();

    }

    public void registrarBarrio() {

        try {

            barrioEJB.create(barrio);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Ciudad registrada con éxito"));

        } catch (Exception e) {

        }
    }

    public List<Barrio> listarBarrio() {

        return barrioEJB.findAll();

    }

    @Override
    public Barrio getObjectByKey(Integer key) {
        return barrioEJB.find(key);
    }
}
