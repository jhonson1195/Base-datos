/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.structures.LinearList;
import dbs_project.structures.Stack;

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
        Stack<Integer> pilaEnteros = new Stacks<>();
        pilaEnteros.push(5);
        pilaEnteros.push(3);
        System.out.println(pilaEnteros.toString());
        pilaEnteros.pop();
        pilaEnteros.push(7);
        System.out.println(pilaEnteros.toString());
        pilaEnteros.top();
        System.out.println(pilaEnteros.toString());
    
  
        
        
        	System.out.println("**** LikedList");
		System.out.println("**** Agregando elementos....");
		LinkedList<Integer> lista = new LinkedList<>();
		lista.append(9);
		lista.append(11);
		lista.append(13);
		
		System.out.println("**** Tamaño: " + lista.size());
		System.out.println("**** Representación gráfica: " + lista.toString());
		
		System.out.println("**** Recorrer la lista");
		for(lista.goToStart(); lista.getPosition() < lista.size(); lista.next()) {
			System.out.println("Pos actual:" + lista.getPosition());
			System.out.println("Valor actual:" + lista.getElement());
			System.out.println("@");
			if (lista.getPosition() == lista.size() -1) {
				break;
			}
		}
		System.out.println("**** Insertar el 12, de forma ordenada y luego al final el 14");
		System.out.println("**** Pos actual " + lista.getPosition());
		for(lista.goToStart(); lista.getPosition() < lista.size(); lista.next()) {
			if ((lista.getElement()) != null) {
				if (lista.getElement().equals(11)) {
					lista.insert(12);
					lista.append(14);
					break;
					}
			}
		}
		System.out.println("**** Tamaño: " + lista.size());
		System.out.println("**** Representación gráfica: " + lista.toString());
		/*System.out.println("Reverseeeeeeee");
		lista.reverse();
		System.out.println("**** Representación gráfica: " + lista.toString());
		System.out.println("**** Head: " + lista.head.getElement());
		System.out.println("**** Current: " + lista.current.getElement());
		System.out.println("**** Tail: " + lista.tail.getElement());
		System.out.println("**** Pos: " + lista.getPosition());
		System.out.println("**** Size: " + lista.getSize());*/
		System.out.println("**** Pos actual luego de insertar: " + lista.getPosition());
		System.out.println("**** Buscar el elemento 9, la pos es: " + lista.getPositionOfElement(9));
		System.out.println("**** Buscar el elemento 14, la pos es: " + lista.getPositionOfElement(14));
		System.out.println("**** Buscar el elemento 15, la pos es: " + lista.getPositionOfElement(15));
		System.out.println("**** Obtener elemento en la posición actual (1), el elemento es: " + lista.getElement());
		lista.goToPos(4);
		System.out.println("**** Ir a la posición (4), el elemento es: " + lista.getElement());
		System.out.println("**** Borrando elemento actual ... " + lista.getElement());
		lista.remove();
		System.out.println("*** El  elemento en el tail es: " + lista.tail.getElement());
		System.out.println("*** La posición actual es " + lista.getPosition());
		System.out.println("**** Tamaño: " + lista.size());
		System.out.println("**** Representación gráfica: " + lista.toString());
		lista.previous();
		System.out.println("**** Retroceder una posición, el elemento actual es: " + lista.getElement());
		System.out.println("*** La posición actual es " + lista.getPosition());
		System.out.println("**** Borrando elemento actual ... " + lista.getElement());
		lista.remove();
		System.out.println("**** Tamaño: " + lista.size());
		System.out.println("**** Representación gráfica: " + lista.toString());
		System.out.println("*** La posición actual es " + lista.getPosition());
		System.out.println("**** El elemento actual es ... " + lista.getElement());
		System.out.println("**** Borrando elemento actual ... " + lista.getElement());
		lista.remove();
		System.out.println("**** Tamaño: " + lista.size());
		System.out.println("**** Representación gráfica: " + lista.toString());
		System.out.println("**** Head: " + lista.head.getElement());
		System.out.println("**** Current: " + lista.current.getElement());
		System.out.println("**** Tail: " + lista.tail.getElement());
		System.out.println("**** Pos: " + lista.getPosition());
		System.out.println("**** Size: " + lista.size());
		System.out.println("**** Limpiando lista... ");
		lista.clear();
		System.out.println("**** Tamaño: " + lista.size());
		System.out.println("**** Representación gráfica: " + lista.toString());
	}
  
}

