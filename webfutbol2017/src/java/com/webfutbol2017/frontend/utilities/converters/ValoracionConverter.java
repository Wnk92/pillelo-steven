/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.frontend.utilities.converters;

import com.webfutbol2017.backend.persistence.entities.Valoracion;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Iesua
 */
@FacesConverter(forClass = Valoracion.class)
public class ValoracionConverter extends AbstractConverter{
    
    public ValoracionConverter(){
        this.nameManagedBean = "valoracionManagedBean";
    }
}
