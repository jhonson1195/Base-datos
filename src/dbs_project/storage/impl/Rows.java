/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Row;
import dbs_project.storage.RowMetaData;
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
 * @author Esteban
 * @param <T>
 */
/*
* Clase Rows Implementada con la Interfaz generica Row
* Esta clase a crear las filas
*/
public class Rows <T> implements Row{
    // Atributos de la Clase "Rows"
    private LinearList<T> list;
    private RowMetaDatas MetaData;

    /*
    Las entradas del constructor rows dependen de los datos que se asignen
    en RowMetaData
    */
    // Constructores de Clase "Rows"
    public Rows(int Id){
        list= new DoublyLinkedList<>(); //Lista de la fila
        MetaData= new RowMetaDatas(Id);
    }
    
    // Metodos de Clase "Rows"
    
    //Agrega a la fila
    // ++++++++++++++++
    public void appentElement(T element){
        list.append(element);
        MetaData.increaseCount();
    }

    // Retorna la lista de la fila
    // ++++++++++++++++++
    public LinearList getList(){
        return list;
    }
    
    public boolean getNext(){
        return list.next();
    }
    public T getElement(){
        return list.getElement();
    }

    // Retorna el metadata de la fila
    @Override
    public RowMetaData getMetaData(){
        return MetaData;
    }

    // Retorna un Integer en una posicion especifica
    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (Integer) list.getElement();
    }

    // Retorna un boolean en una posicion especifica
    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (Boolean) list.getElement();
    }

    // Retorna un double en una posicion especifica
    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException{
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (Double) list.getElement();
    }

    // Retorna una fecha en una posicion especifica
    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException{
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (Date) list.getElement();
    }

    // Retorna un string en una posicion especifica
    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (String) list.getElement();
    }

    // Retorna un objeto en una posicion especifica
    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException{
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return (Object) list.getElement();
}

    // Retorna si una posicion especifica, esta vacia
    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException{
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        list.goToPos(index);
        return null==list.getElement();
    }
    
    public int getSize(){
        return list.size();
    }

    // Convierte la lista de la Fila, 
    // en algun otro tipo de estructura
    //(LINKEDLIST, QUEUE, STACK)
    @Override
    public LinearDataStructure<?> asLinearDataStructure(DataStructure type){
        if(type==list.getType()){
            return list;
        }
        
        list.goToStart();
        
        if (type==LINKEDLIST){
            LinearList <T> ListaSimple = new LinkedList<>();
            do{
                ListaSimple.append(list.getElement());
            }while(list.next());
            return ListaSimple;
        }
        
        if(type==QUEUE){
            Queue<T> Cola = new Queues<>();
            do{
                Cola.enqueue(list.getElement());
            }while(list.next());
            return Cola;
        }
        
        if(type==STACK){
            Stack<T> Pila = new Stacks<>();
            do{
                Pila.push(list.getElement());
            }while(list.next());
            return Pila;
        }
        
        return null;
    }    
}