/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.frontend.utilities.converters;

import com.webfutbol2017.backend.persistence.entities.Barrio;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author camila
 */
@FacesConverter(forClass = Barrio.class)
public class BarrioConverter extends AbstractConverter {

    public BarrioConverter() {
        this.nameManagedBean = "barrioManagedBean";
    }

}
