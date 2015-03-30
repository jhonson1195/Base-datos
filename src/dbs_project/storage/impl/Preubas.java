/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.exceptions.ColumnAlreadyExistsException;
import dbs_project.storage.Column;
import dbs_project.storage.Table;
import dbs_project.storage.Type;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearList;
import dbs_project.structures.Queue;
import dbs_project.structures.Stack;


/**
 *aqui pueden hacer las preubas despues que lo copian solo delen clik derecho y ejecutan solo este archivo.
 * @author jhonson
 */
public class Preubas {
    
    public static void main(String[] args) throws ColumnAlreadyExistsException {
        
        Maps <Integer, Columns> tabla = new Maps<>();
        Tables tabla1 = new Tables(tabla);
        Columns<Integer> columna = new Columns<>("jhon", tabla1, "label",Type.INTEGER,0);
        
        tabla.put(1, columna);
        
        tabla1.createColumn("d", Type.DATE);
        System.out.println(tabla1.createColumn("d", Type.DATE));
        tabla.get(3).getList().append(1);
        System.out.println(tabla.get(3).getInteger(0));
                 
        
	}
  
}

