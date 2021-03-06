/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.frontend.beans;

import com.webfutbol2017.backend.persistence.entities.Item;
import com.webfutbol2017.backend.persistence.facades.ItemFacade;
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
@Named(value = "itemManagedBean")
@RequestScoped
public class ItemManagedBean implements Serializable, InterfaceController<Item> {

    private Item item;
    @EJB
    private ItemFacade itf;
    
    
    public ItemManagedBean() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    
    @PostConstruct
    public void init(){
        item = new Item();
    }
    
    
    public void registrarItem(){
        itf.create(item);
    }
    
    public void modificarItem(){
        itf.edit(item);
    }
    
    public void eliminarItem(Item i){
        itf.remove(item);
    }
    
    public List<Item> listarItem(){
        return itf.findAll();
    }
    
    public String actualizarItem(Item it){
        item = it;
        return "";
    }
    
    

    @Override
    public Item getObjectByKey(Integer key) {
        return itf.find(key);
    }
    
}
