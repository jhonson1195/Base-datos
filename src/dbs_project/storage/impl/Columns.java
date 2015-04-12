/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Column;
import dbs_project.storage.Type;
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
 * En esta clase se van a crear las columnas con sus respectivos datos
 * 
 * @author jhonson
 * @param <T>
 */
public class Columns <T>implements Column{
    //Atributos de Columns
    private LinearList<T> list;
    private ColumnMetaDatas Metadata;
    
    //Se Crean una Columna
    
    //Debe tener como entradas= El Nombre, Tabla a la que pertenece, un Tipo,
    //un Id y el tipo de Estructura
    public Columns(String Name, Tables Source, String Label, Type Type, int Id, DataStructure tipoLista){
        if(tipoLista==DataStructure.LINKEDLIST){
            list= new LinkedList<>();
        }
        else{
           list= new DoublyLinkedList<>(); 
        }
         
         Metadata=new ColumnMetaDatas(Name, Source, Label, Type,Id);
    }
    //Metodos de Columns
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
    
    //Quita una Fila en especifico de la Columna
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
    
    //Retorna un elemnto en una posicion en especifico
    public T getElement(int index){
        list.goToPos(index);
        return list.getElement();
    }
    
    //Metodos para retornar los datos de la lista
    //Pueden ser Integer, String, Booolean, Date, Double, Object
    @Override
    public Integer getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
            list.goToPos(index);
            return (Integer)list.getElement(); 
    }

    @Override
    public Boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (Boolean)list.getElement();
    }

    @Override
    public Double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
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

    //Retorna Tamaño
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
        
        if (type==DOUBLYLINKEDLIST){
            LinearList <T> ListaDoble = new DoublyLinkedList<>();
            ListaDoble.append(list.getElement());
            while(list.next()){
                ListaDoble.append(list.getElement());
            }
            return ListaDoble;
        }
        
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
