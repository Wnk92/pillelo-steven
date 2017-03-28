package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.Usuario;
import com.webfutbol2017.backend.persistence.facades.UsuarioFacade;
import com.webfutbol2017.frontend.utilities.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "usuarioManagedBean")
@RequestScoped
public class UsuarioManagedBean implements Serializable, InterfaceController<Usuario> {

    private Usuario usuario;
    @EJB
    private UsuarioFacade uf;
    @Inject
    private EstadoUsuarioManagedBean estadoUsuarioManagedBean;
    @Inject
    private RolManagedBean rolManagedBean;

    public UsuarioManagedBean() {
    }

    @PostConstruct
    public void init() {

        usuario = new Usuario();
    }

    @Override
    public Usuario getObjectByKey(Integer key) {
        return uf.find(key);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoUsuarioManagedBean getEstadoUsuarioManagedBean() {
        return estadoUsuarioManagedBean;
    }

    public void setEstadoUsuarioManagedBean(EstadoUsuarioManagedBean estadoUsuarioManagedBean) {
        this.estadoUsuarioManagedBean = estadoUsuarioManagedBean;
    }

    public RolManagedBean getRolManagedBean() {
        return rolManagedBean;
    }

    public void setRolManagedBean(RolManagedBean rolManagedBean) {
        this.rolManagedBean = rolManagedBean;
    }

    public List<Usuario> listUsers() {

        return uf.findAll();
    }

    public void crearUsuario() {
        try {
            uf.create(usuario);
        } catch (Exception e) {
        }

    }
    
    
    
    public void crearUsuarioAcudiente(){
        try {
            usuario.setIdEstado(getEstadoUsuarioManagedBean().getObjectByKey(1));
            usuario.setIdTipoRol(getRolManagedBean().getObjectByKey(4));
            uf.create(usuario);
        } catch (Exception e) {
        }
    
    }

}
