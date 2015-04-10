/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Column;
import dbs_project.storage.Type;
import dbs_project.structures.DataStructure;
import static dbs_project.structures.DataStructure.LINKEDLIST;
import static dbs_project.structures.DataStructure.QUEUE;
import static dbs_project.structures.DataStructure.STACK;
import dbs_project.structures.LinearDataStructure;
import dbs_project.structures.LinearList;
import dbs_project.structures.Queue;
import dbs_project.structures.Stack;
import java.util.Date;

/**
 *
 * @author jhonson
 * @param <T>
 */
public class Columns <T>implements Column{
    
    private DoublyLinkedList<T> list;
    private ColumnMetaDatas Metadata;
    
    public Columns(String Name, Tables Source, String Label, Type Type, int Id){
         list= new DoublyLinkedList<>();
         Metadata=new ColumnMetaDatas(Name, Source, Label, Type,Id);
    }
    /**
     * Agrega un elemento a la lista
     * @param elemnt
     */
    public void appenElement(T elemnt){
        list.append(elemnt);
        Metadata.increaseCount();
    }
    /**
     * Devuelve la lista utilizada para almacenar elementos
     * @return List
     */
    public LinearList getList(){
        return list;
    }
    
    public void removeRow(int index){
        list.goToPos(index);
        list.remove();
    }

    @Override
    /**
     * Retorna los metadatos de la conlumna
     * @return ColumnMetaData
     */
    public ColumnMetaDatas getMetaData() {
        return Metadata;
    }
    public T getElement(int index){
        list.goToPos(index);
        return list.getElement();
    }
    //Retorna los datos de la lista
    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
            list.goToPos(index);
            return (Integer)list.getElement(); 
    }

    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (Boolean)list.getElement();
    }

    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (Double)list.getElement();
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (Date)list.getElement();
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (String)list.getElement();
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (Object)list.getElement();
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        list.goToPos(index);
        return null==list.getElement();
    }
    
    public int getSize(){
        return list.size();
    }

    @Override
    /**
     * Se pasa de una estrutura de almacenamieto a otra
     * @param type
     * @return LinearDataStructure<?>
     */
    public LinearDataStructure<?> asLinearDataStructure(DataStructure type) {
        if (type==list.getType()){
            return list;
        }
        
        list.goToStart();
        
        if (type==LINKEDLIST){
            LinearList <T> ListaSimple = new LinkedList<>();
            ListaSimple.append(list.getElement());
            while(list.next()){
                ListaSimple.append(list.getElement());
            }
            return ListaSimple;
        }
        if(type==QUEUE){
            Queue<T> Cola = new Queues<>();
            Cola.enqueue(list.getElement());
            while(list.next()){
                Cola.enqueue(list.getElement());
            }
            return Cola;
            
        }
        if(type==STACK){
            Stack<T> Pila = new Stacks<>();
            Pila.push(list.getElement());
            while(list.next()){
                Pila.push(list.getElement());
            }
            return Pila;
        }
        return null;
    }
    
}
