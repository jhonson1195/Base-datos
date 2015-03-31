/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearList;

/**
 *Lista simplemente enlazada implementada con la interfaz LinearList generica
 * @author Carlos Ramirez
 * @param <T>
 */
public class LinkedList<T> implements LinearList <T> {
        
/**
 * Se declaran los atributos, los tipo nodo son genericos
 */
    Node<T> head, current, tail; 
    private int position;
    private int size;
    /**
     * contructor que inicializa las variables
     * En este caso se creara una lista vacia
     */
    public LinkedList(){
        head=new Node<>();
        current = head;
        tail = head;
        size = 0;
        position = -1;
    }
    
    @Override
    /**
     * Inserta un elemento en la lista despues del nodo actual.
     * @param <T> variable generica
     */
    
    public void insert(T element) {
        Node<T> newNode = new Node<T>(element, this.current.getNext());
	this.current.setNext(newNode);
	if (this.current == this.tail) {
            this.tail = current.getNext();
            }
	this.size++;
    }
    
     /**
     * Agrega un nodo despues del ultimo nodo
     * @param element
     */

    @Override
    public void append(T element) {
	Node<T> newNode = new Node<>(element);
	this.tail.setNext(newNode);
	this.tail = newNode;
	this.size++;        
        
    }

    @Override
    
    /**
     * Elimina el nodo actual nodo
     */
    public void remove() {
        if ((this.head == this.current) && (this.head == this.tail)){
        	System.out.println("Lista vacía, no se puede remover ningún elemento");
		return;
	}
        Node<T> temp = head;
    	while (temp.getNext() != this.current) {
            temp = temp.getNext();
	}
        temp.setNext(this.current.getNext());
    	if (this.current == this.tail) {   
            this.current = this.tail = temp;
            this.position--;
	}
			
	else
            this.current = this.current.getNext();
        this.size--;

    }

    @Override
    /**
     * Devuelve el elemento contenido en el nodo actual
     * @return <T> element
     */
    public T getElement() {
        return this.current.getElement(); 
    }

    @Override
    
    /**
     * Devuelve true o false para avanzar el nodo de posicion actual
     * @return boolean
     */
    public boolean next() {
       if(this.current==this.tail){
           System.out.println("no se puede avanzar");
           return false;
       }
       this.current=this.current.getNext();
       position++;
       return true;
    }

    
    @Override
     /**
     * Devuelve true o false para retroceder el nodo de posicion actual
     * @return boolean
     */
    public boolean previous() {
        if (this.current == this.head) {
            System.out.println("Actualmente en primer nodo, no se puede retroceder");
            return false;
	}
	Node<T> temp = this.head;
            this.position = -1;
            while (temp.getNext() != this.current) {
		temp = temp.getNext();
		this.position++;
            }
	this.current = temp;
        return true;
    }


    @Override 
    
     /**
     * Retorna la posicion actual del nodo
     * @return int
     */
    
    public int getPosition() {
        return this.position;
    }

    @Override
    
     /**
     * El puntero actual se convierte al primer nodo de la lista
     * Mueve el puntero current al inicio de la lista
     */
    public void goToStart() {
    this.current = this.head;
    this.position = -1;
    }

    @Override
    /**
     * El puntero actual se convierte al ultimo nodo de la lista
     * Mueve el puntero current al final de la lista
     */
    public void goToEnd() {
	this.current = this.tail;
        this.position = this.size - 1;       
    }
    
    @Override
    /**
     * Mueve el nodo actual a la posicion indicada
     * @param pos
     */
    public void goToPos(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= this.size) {
            System.out.println("Posición inválida");
            return;
        }
        if (pos > this.position) {
            while (pos > this.position) {
                this.next();
            }
        } else if (pos < this.position) {
            while (pos < this.position) {
                this.previous();
            }
        }
    }

    @Override
     /**
     * Busca el elemento en la lista y devuelve su indice
     * @param <T>
     */
    public int getPositionOfElement(T element) {
        Node<T> tempNode = this.head;
	int position = -1;
	while (tempNode != null) { 
            if (tempNode.getElement() != null && tempNode.getElement().equals(element)){
                return position;
            }
	tempNode = tempNode.getNext();
	position++;
        }
	return -1;
    }

    @Override
     /**
     * Devuelve el tipo de lista
     */
    public DataStructure getType() {
        return DataStructure.LINKEDLIST;
    }

    @Override  
     /**
     * Devuelve el tamaño de la lista
     * @return size
     */
    public int size() {
        return this.size;
    }

    @Override
     /**
     * Borra todos los nodos de la lista y crea una nueva
     */
    public void clear() {
        this.head=new Node<>();
        this.current = this.tail = this.head;
        this.size = 0;
        this.position = -1; 
    }

    @Override
      /**
     * Comprueba si la lista esta vacia
     * @return boolean
     */
    public boolean isEmpty() {
        if(this.size>0){
            return false;
        }
        else{
            return true;
        }
    }
    
      /**
     * Clase para crear una variable de tipo Nodo
     * 
     * @return StringBuffer 
     */
    
    @Override
    public String toString() {
		Node currentNode = this.head.getNext();
		
		StringBuffer result = new StringBuffer();
        
        for (int i = 0; currentNode != null; i++) 
		{
        	if (i > 0) 
			{
        		result.append(",");
        	}
        	Object element = currentNode.getElement();
			
        	result.append(element == null ? "" : element);
        	currentNode = currentNode.getNext();
        }
        return result.toString();
    }
    
    public class Node <T>{
        private Node<T> next; 
        private T Element;
        
        /**
         * Contrutor que inicializa las variables
         */
        public Node(){
            this.next=null;
            this.Element=null;
        }
         /**
         * Contrutor que inicializa las variables
         * @param Element
         */
        public Node(T Element){
            this.next=null;
            this.Element=Element;
        }
         /**
         * Contrutor que inicializa las variables
         * @param Element
         * @param next         */
        public Node(T Element, Node<T> next){
            this.Element= Element;
            this.next=next; 
        }
         /**
         * Devuelve el elemento del nodo
         * @return Date
         */
        public T getElement(){
            return this.Element;
        }
         /**
         * Define la varialbe del nodo
         * @param Element
         */
        public void setElement(T Element){
            this.Element= Element;
        }
         /**
         * Devuelve el Nodo de la variable next
         * @return next
         */
        public Node<T> getNext(){
            return this.next;
        }
         /**
         * Define el noso siguiente
         * @param next
         */
        public void setNext(Node<T> next){
            this.next=next;
        }
    }
}
