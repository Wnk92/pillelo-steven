/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.SeguimientoEncuentro;
import com.webfutbol2017.backend.persistence.facades.SeguimientoEncuentroFacade;
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
@Named(value = "seguimientoEncuentroManagedBean")
@RequestScoped
public class SeguimientoEncuentroManagedBean implements Serializable, InterfaceController<SeguimientoEncuentro>{

    private SeguimientoEncuentro seguimientoencuentro;
    @EJB
    private SeguimientoEncuentroFacade segef;
    
    
    public SeguimientoEncuentroManagedBean() {
    }

    public SeguimientoEncuentro getSeguimientoencuentro() {
        return seguimientoencuentro;
    }

    public void setSeguimientoencuentro(SeguimientoEncuentro seguimientoencuentro) {
        this.seguimientoencuentro = seguimientoencuentro;
    }
    
     @PostConstruct
     public void init(){
         seguimientoencuentro = new SeguimientoEncuentro();
     }
     
     public void registrarSeguimientoEncuentro(){
         segef.create(seguimientoencuentro);
     }
     
     public void modificarSeguimientoEncuentro(){
         segef.edit(seguimientoencuentro);
     }
     
     public void eliminarSeguimientoEncuentro(SeguimientoEncuentro sf){
         segef.remove(seguimientoencuentro);
     }
     
     public List<SeguimientoEncuentro> listarSeguimientoEncuentro(){
         return segef.findAll();
     }
     
     public String actulizarSeguimientoEncuentro (SeguimientoEncuentro segenc){
         seguimientoencuentro = segenc;
         return "";
     }

    @Override
    public SeguimientoEncuentro getObjectByKey(Integer key) {
        return segef.find(key);
    }
     
     
     
     
     
     
     
     
     
     
    
}
