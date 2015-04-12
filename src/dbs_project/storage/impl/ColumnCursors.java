/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnCursor;
import dbs_project.storage.ColumnMetaData;
import dbs_project.structures.DataStructure;
import static dbs_project.structures.DataStructure.DOUBLYLINKEDLIST;
import static dbs_project.structures.DataStructure.LINKEDLIST;
import static dbs_project.structures.DataStructure.QUEUE;
import static dbs_project.structures.DataStructure.STACK;
import dbs_project.structures.LinearDataStructure;
import dbs_project.structures.LinearList;
import dbs_project.structures.Queue;
import dbs_project.structures.Stack;
import java.util.Date;

/**
 * Crea una estructura de columnas
 * @author jhonson
 */
public class ColumnCursors implements ColumnCursor{
    private DoublyLinkedList<Columns> ListaColum;
    /**
     * Constructor que recibe la una lists de columnas para manipularla
     * @param ListaColum
     */
    public ColumnCursors(){
        this.ListaColum=new DoublyLinkedList<>();
    }
    public void append(Columns Date){
        ListaColum.append(Date);
    }
    public Columns getElement(){
        return ListaColum.getElement();
    }
    
    @Override
    /**
     * Devuelve los metadatos de la columna
     * @return ColumnMetaData
     */
    public ColumnMetaData getMetaData() {
        return ListaColum.getElement().getMetaData();
    }

    //Metodos que retornan los tipos de datos relizando una convercion o comprovacion del dato
    @Override
    public Integer getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        return ListaColum.getElement().getInteger(index);
    }

    @Override
    public Boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        return ListaColum.getElement().getBoolean(index);
    }

    @Override
    public Double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        return ListaColum.getElement().getDouble(index);
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        return ListaColum.getElement().getDate(index);
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        return ListaColum.getElement().getString(index);
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        return ListaColum.getElement().getObject(index);
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        return ListaColum.getElement().isNull(index);
    }

    @Override
    /**
     * Se pasa de una estrutura de almacenamieto a otra
     * @param type
     * @return LinearDataStructure<?>
     */
    public LinearDataStructure<?> asLinearDataStructure(DataStructure type) {
        if (type==ListaColum.getType()){
            return ListaColum;
        }
        
        ListaColum.goToStart();
        
        if (type==DOUBLYLINKEDLIST){
            LinearList <Columns> ListaDoble = new DoublyLinkedList<>();
            ListaDoble.append(ListaColum.getElement());
            while(ListaColum.next()){
                ListaDoble.append(ListaColum.getElement());
            }
            return ListaDoble;
        }
        
        if (type==LINKEDLIST){
            LinearList <Columns> ListaSimple = new LinkedList<>();
            ListaSimple.append(ListaColum.getElement());
            while(ListaColum.next()){
                ListaSimple.append(ListaColum.getElement());
            }
            return ListaSimple;
        }
        if(type==QUEUE){
            Queue<Columns> Cola = new Queues<>();
            Cola.enqueue(ListaColum.getElement());
            while(ListaColum.next()){
                Cola.enqueue(ListaColum.getElement());
            }
            return Cola;
            
        }
        if(type==STACK){
            Stack<Columns> Pila = new Stacks<>();
            Pila.push(ListaColum.getElement());
            while(ListaColum.next()){
                Pila.push(ListaColum.getElement());
            }
            return Pila;
        }
        return null;
    }

    @Override
    /**
     * Avanza la posicion del elemento en la lista
     * @return boolean
     */
    public boolean next() {
        return ListaColum.next();
    }

    @Override
    /**
     * retorna la posicion del actual en la lista
     * @return int
     */
    public int getCursorPosition() {
        return ListaColum.getPosition();
    }

    @Override
    /**
     * Vacia la lista
     */
    public void close() {
        ListaColum.clear();
    }

    @Override
    /**
     * Devuelve la estructura de datos en la que se basa la columna
     * @return DataStructure
     */
    public DataStructure getType() {
        return ListaColum.getType();
    }

}
