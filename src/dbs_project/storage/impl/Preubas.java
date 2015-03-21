/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.structures.LinearList;

/**
 *aqui pueden hacer las preubas despues que lo copian solo delen clik derecho y ejecutan solo este archivo.
 * @author jhonson
 */
public class Preubas {
    
    public static void main(String[] args) {
        LinearList<Integer> nuevo= new DoublyLinkedList<>();
        nuevo.append(6);
        nuevo.append(3);
        nuevo.append(9);
        nuevo.append(8);
        nuevo.append(7);
        nuevo.insert(22);
        nuevo.previous();
        nuevo.insert(23);
        nuevo.previous();
        nuevo.insert(24);
        nuevo.previous();
        nuevo.insert(25);
        nuevo.previous();
        nuevo.remove();
        nuevo.goToPos(4);
        System.out.println(nuevo.toString());
        System.out.println("Elemen: "+nuevo.getElement()+" "+"pos: "+nuevo.getPosition());
        System.out.println(nuevo.getPositionOfElement(3));
        nuevo.clear();
        nuevo.append(7);
        System.out.println(nuevo.toString());
        nuevo.clear();
        System.out.println(nuevo.isEmpty());
    }
    
}
