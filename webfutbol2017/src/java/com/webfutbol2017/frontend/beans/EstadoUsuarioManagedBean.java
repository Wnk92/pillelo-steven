package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.EstadoUsuario;
import com.webfutbol2017.backend.persistence.facades.EstadoUsuarioFacade;
import com.webfutbol2017.frontend.utilities.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "estadoUsuarioManagedBean")
@RequestScoped
public class EstadoUsuarioManagedBean implements Serializable, InterfaceController<EstadoUsuario> {

    private EstadoUsuario estadoUsuario;
    @EJB
    private EstadoUsuarioFacade ef;
    
    public EstadoUsuarioManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        estadoUsuario = new EstadoUsuario();
    }
    
    @Override
    public EstadoUsuario getObjectByKey(Integer key) {
        return ef.find(key);
    }
    
    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }
    
    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    
    public List<EstadoUsuario> listar() {
        return ef.findAll();
    }
    
    public void crearEstadoUsuario() {
        ef.create(estadoUsuario);
        
    }
    
}
