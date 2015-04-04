/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.exceptions.ColumnAlreadyExistsException;
import dbs_project.exceptions.NoSuchColumnException;
import dbs_project.exceptions.NoSuchRowException;
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
    
    public static void main(String[] args) throws ColumnAlreadyExistsException, NoSuchRowException, NoSuchColumnException {
        
        
        Maps <Integer, Columns> tabla = new Maps<>();
        Tables tabla1 = new Tables(tabla, "Prueba",0);
        Columns<Integer> columna = new Columns<>("jhon", tabla1, "label",Type.INTEGER,0);
        columna.appenElement(1000);
        columna.appenElement(2222);
        columna.appenElement(7777);
        Columns<Integer> columna2 = new Columns<>("jho2", tabla1, "label",Type.INTEGER,1);
        columna2.appenElement(1000);
        columna2.appenElement(2222);
        columna2.appenElement(7777);
        tabla.put(0, columna);
        tabla.put(1, columna2);
        
        tabla1.renameColumn(0, "jhon");
        
        
        
        
             
        
	}
  
}

