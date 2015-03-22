/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.structures.DataStructure;
import dbs_project.structures.Queue;

public class Queues <T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;
    
    public Queues(){
        this.front = new Node<>();
        this.rear = this.front;
        this.size = 0;
    }

    public void enqueue(T element) {
        this.rear.setNext(new Node<T>(element, null));
        this.rear = rear.getNext();
        this.size++;
    }

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

    public T first() {
        if(this.size == 0){
            System.out.println("Cola esta vacia");
            return null;
        }
        return this.front.getNext().getElement();
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.front = new Node<>();
        this.rear = this.front;
        this.size = 0;
    }

    public DataStructure getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isEmpty() {
        return size==0;
    }
    
    private class Node<T>{
        private T element;
        private Node<T> next;

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
