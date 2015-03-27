/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.structures.DataStructure;
import dbs_project.structures.Queue;

/**
 *
 * @author Esteban
 * @param <T>
 */

/* 
* Clase Queues implementada con la interfaz generica Queue
* Esta clase va a crear una estructura de datos de tipo Cola
*/
public class Queues <T> implements Queue<T> {
    private Node<T> front;//Front siempre va a ser el primer elemento de la Cola
    private Node<T> rear; //Rear va a ser el ultimo elemento agregado a la Cola
                          //ultimo en salir 
    private int size;     //Tamaño de la Cola
    
    //Constructor de la Clase "Queues"
    public Queues(){
        this.front = new Node<>();
        this.rear = this.front;
        this.size = 0;
    }
    
    //Metodos de la Clase "Queues"
    
    //Agregar a la Cola
    @Override
    public void enqueue(T element) {
        this.rear.setNext(new Node<T>(element, null));
        this.rear = rear.getNext();
        this.size++;
    }

    //Borrar/Sacar el primero de la Cola
    @Override
    public T dequeue() {
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return null;
        }
        T temp = this.front.getNext().getElement();
        Node<T> newTemp = this.front.getNext();
        this.front.setNext(newTemp.getNext());
        if (this.rear == newTemp){
            this.rear = this.front;
        }
        this.size--;
        return temp;
    }

    //Retorna el primer elemento de la Cola
    @Override
    public T first() {
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return null;
        }
        return this.front.getNext().getElement();
    }

    //Retorna el tamaño de la cola 
    @Override
    public int size() {
        return this.size;
    }

    //Limpia la Cola
    @Override
    public void clear() {
        this.front = new Node<>();
        this.rear = this.front;
        this.size = 0;
    }

    //Retorna el tipo de Estructura(en este caso es QUEUE)
    @Override
    public DataStructure getType() {
        return DataStructure.QUEUE;
    }

    //Retorna si la Cola esta Vacia
    @Override
    public boolean isEmpty() {
        if (size==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Los datos de la Cola, van a ser ingresados a un String
    @Override
    public String toString(){
        String result= "Lista doblemente enlazada \n";
        Node<T> temp =front.getNext();
        while (temp.getNext()!=null){
            result+=temp.getElement()+ "\n";
            temp=temp.getNext();
            
        }
        return result+=temp.getElement();
    }
    
    //Clase de "Node"
    private class Node<T>{
        private T element; // Elemento del Nodo
        private Node<T> next; //Dirige al siguiente Nodo

        // CONSTRUCTORES "Node"
        public Node(){
            this.element = null;
            this.next = null;
        }

        public Node(T element){
            this.element = element;
            this.next = null;
        }

        public Node(T element, Node<T> next){
            this.element = element;
            this.next = next;
        }

        // METODOS "Node"
        public T getElement(){
            return this.element;
        }

        public void setElement(T element){
            this.element = element;
        }

        public Node<T> getNext(){
            return this.next;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }
    }
}
