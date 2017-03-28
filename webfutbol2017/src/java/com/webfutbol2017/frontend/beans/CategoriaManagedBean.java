package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.Categoria;
import com.webfutbol2017.backend.persistence.facades.CategoriaFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "categoriaManagedBean")
@RequestScoped
public class CategoriaManagedBean implements Serializable {

    @EJB
    private CategoriaFacade categoriaEJB;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @PostConstruct
    public void init() {
        categoria = new Categoria();
    }

    public List<Categoria> listCategorias() {
        return categoriaEJB.findAll();
    }

    public void registrarCategoria() {
        try {
            categoriaEJB.create(categoria);
        } catch (Exception e) {
        }
    }

    public CategoriaManagedBean() {
    }

}
