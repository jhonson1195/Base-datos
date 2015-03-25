/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Column;
import dbs_project.structures.LinearList;


/**
 *aqui pueden hacer las preubas despues que lo copian solo delen clik derecho y ejecutan solo este archivo.
 * @author jhonson
 */
public class Preubas {
    
    public static void main(String[] args) {
                Columns nuevo= new Columns<>("jhonson");
                nuevo.appenElement(4);
                System.out.println(nuevo.getInteger(0));
                System.out.println(nuevo.getMetaData().getName());
                System.out.println(nuevo.getMetaData().getRowCount());
                
                
        
	}
  
}

