/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearList;

/**
 *
 * @author jhonson
 * @param <T>
 */
public class DoublyLinkedList <T>implements LinearList<T> {
    
    private Node<T> head, current, tail;
    private int position;
    private int size;
    
    public DoublyLinkedList(){
        head=new Node<>();
        current = head;
        tail = head;
        size = 0;
        position = -1;
    }

    @Override
    public void insert(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public void append(T element) {
        Node newnode = new Node<T>(element);
        tail.setNext(newnode);
        newnode.setLast(tail);
        tail=newnode;
        size++;
        position++;
     
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean previous() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goToStart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goToEnd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goToPos(int pos) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPositionOfElement(Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataStructure getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class Node <T>{
        private Node<T> next;
        private Node<T> last;
        private T Date;
        
        public Node(){
            next=null;
            last=null;
            Date=null;
        }
        public Node(T Date){
            next=null;
            last=null;
            this.Date=Date;
        }
        public Node(T Date, Node<T> next,Node<T> last){
            this.Date= Date;
            this.next=next;
            this.last=last; 
        }
        
        public T getDate(){
            return Date;
        }
        public void setDate(T Date){
            this.Date= Date;
        }
        public Node<T> getNext(){
            return next;
        }
        public void setNext(Node<T> next){
            this.next=next;
        }
        public Node<T> getLast(){
            return last;
        }
        public void setLast(Node<T> last){
            this.last=last;
        }
        
    }
}
