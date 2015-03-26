/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

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
    
    public static void main(String[] args) {
                Table tabla = new Tables();
                Columns nuevo= new Columns<>("jhonson", tabla,"Label",Type.INTEGER, 1, 2);
                nuevo.appenElement(4);
                nuevo.appenElement(5);
                nuevo.appenElement(6);
                nuevo.appenElement(7);
                nuevo.appenElement(8);
                Stack <Integer> Lista;
                //Lista.enqueue(5);
                //Lista.enqueue(56);
                Lista= (Stack<Integer>) nuevo.asLinearDataStructure(DataStructure.STACK);
                System.out.println(Lista.toString());
                
                
                //Lista= (Queues<Integer>)nuevo.asLinearDataStructure(DataStructure.QUEUE);
                //Lista.toString();
                
                
                
                
        
	}
  
}

