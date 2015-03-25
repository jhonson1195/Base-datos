/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Column;
import dbs_project.storage.ColumnMetaData;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;
import dbs_project.structures.LinearList;
import java.util.Date;

/**
 *
 * @author jhonson
 * @param <T>
 */
public class Columns <T>implements Column{
    
    private LinearList<T> list;
    private ColumnMetaDatas Metadata;
    
    public Columns(String Name){
         list= new DoublyLinkedList<>();
         Metadata=new ColumnMetaDatas(Name);
    }
    
    public void appenElement(T elemnt){
        list.append(elemnt);
        Metadata.increaseCount();
        
    }

    @Override
    public ColumnMetaData getMetaData() {
        return Metadata;
    }

    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        list.goToPos(index);
        return (Integer)list.getElement();
    }

    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        list.goToPos(index);
        return (Boolean)list.getElement();
    }

    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        list.goToPos(index);
        return (Double)list.getElement();
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        list.goToPos(index);
        return (Date)list.getElement();
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        list.goToPos(index);
        return (String)list.getElement();
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        list.goToPos(index);
        return (Object)list.getElement();
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        list.goToPos(index);
        return null==list.getElement();
    }

    @Override
    public LinearDataStructure<?> asLinearDataStructure(DataStructure type) {
        return null;
    }
    
}
