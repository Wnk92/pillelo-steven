/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.login.beans;

import com.futbolweb.persistence.entities.Usuario;
import com.futbolweb.persistence.facades.UsuarioFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "seguridadManagedBean")
@Dependent
public class SeguridadManagedBean {

      private Usuario usuario;
    @EJB
    private UsuarioFacade usuarioFacade;
    
    public SeguridadManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
     @PostConstruct
    public void init() {
        usuario = new Usuario();
    }
    
    
    
      public void verificarSesion() {
        try {
            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            if (user == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../permisos.xhtml");
            }
        } catch (Exception e) {

        }

    }
      
      
         public String cerrarSesion(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuario");
        context.getExternalContext().invalidateSession();
        return "/paginaprincipal.xhtml?faces-redirect=true";
    }
      
      
      
//          public void cerrarSesion() {
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//    }
    
    
}
