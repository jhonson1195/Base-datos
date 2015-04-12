/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.RowCursor;
import dbs_project.storage.RowMetaData;
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
 *
 * @author Esteban
 * @param <T>
 */
/*
* Clase RowCursors Implementada con la Interfaz generica RowCursor
*/
public class RowCursors implements RowCursor{
    // Atributos de la Clase "RowCursors"
    private DoublyLinkedList<Rows> ListaFila;

    // Constructores de Clase "RowCursors"
    public RowCursors(){
        this.ListaFila =new DoublyLinkedList();
    }
    
    public void append(Rows Date){
        ListaFila.append(Date);
    }
    public Rows getElement(){
        return ListaFila.getElement();
    }
        
    // Metodos de Clase "RowCursors, Utiliza los metodos de la Clase "Rows", para retornar los datos
    // Retorna el MetaData de la Fila
    @Override
    public RowMetaData getMetaData(){
        return ListaFila.getElement().getMetaData();
    }

    @Override
    public Integer getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        return ListaFila.getElement().getInteger(index);
    }

    @Override
    public Boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        return ListaFila.getElement().getBoolean(index);
    }

    @Override
    public Double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        return ListaFila.getElement().getDouble(index);
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        return ListaFila.getElement().getDate(index);
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        return ListaFila.getElement().getString(index);
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        return ListaFila.getElement().getObject(index);
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        return ListaFila.getElement().isNull(index);
    }

    @Override
    public LinearDataStructure<?> asLinearDataStructure (DataStructure type) {
        if (type==ListaFila.getType()){
            return ListaFila;
        }
        
        ListaFila.goToStart();
        
        if (type==DOUBLYLINKEDLIST){
            LinearList <Rows> ListaDoble = new DoublyLinkedList<>();
            ListaDoble.append(ListaFila.getElement());
            while(ListaFila.next()){
                ListaDoble.append(ListaFila.getElement());
            }
            return ListaDoble;
        }
        
        if (type==LINKEDLIST){
            LinearList <Rows> ListaSimple = new LinkedList<>();
            ListaSimple.append(ListaFila.getElement());
            while(ListaFila.next()){
                ListaSimple.append(ListaFila.getElement());
            }
            return ListaSimple;
        }
        if(type==QUEUE){
            Queue<Rows> Cola = new Queues<>();
            Cola.enqueue(ListaFila.getElement());
            while(ListaFila.next()){
                Cola.enqueue(ListaFila.getElement());
            }
            return Cola;
            
        }
        if(type==STACK){
            Stack<Rows> Pila = new Stacks<>();
            Pila.push(ListaFila.getElement());
            while(ListaFila.next()){
                Pila.push(ListaFila.getElement());
            }
            return Pila;
        }
        return null;
    }

    @Override
    public boolean next(){
        return ListaFila.next();
    }

    @Override
    public int getCursorPosition(){
        return ListaFila.getPosition();
    }
    
    // Close es igual a limpiar???
    @Override
    public void close(){
        ListaFila.clear();
    }

    @Override
    public DataStructure getType() {
        return ListaFila.getType();
    }   
}