/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Row;
import dbs_project.storage.RowMetaData;
import dbs_project.storage.Table;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;
import dbs_project.structures.LinearList;
import java.util.Date;

/**
 *
 * @author Esteban
 * @param <T>
 */
public class Rows <T> implements Row{
    private LinearList<T> list;
    private RowMetaDatas MetaData;

    /*
    Las entradas del constructor rows dependen de los datos que se asignen
    en RowMetaData
    */
    public Rows(String Name, Table Source, int ColumnID, int Id){
        list= new DoublyLinkedList<>();
        MetaData= new RowMetaDatas(Name, Source, ColumnID, Id);
    }

    public void appentElement(T element){
        list.append(element);
    //    MetaData.increaseCount();
    }

    public LinearList getList(){
        return list;
    }

    @Override
    public RowMetaData getMetaData(){
        return MetaData;
    }

    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        list.goToPos(index);
        return (Integer) list.getElement();
    }

    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        list.goToPos(index);
        return (Boolean) list.getElement();
    }

    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException{
        list.goToPos(index);
        return (Double) list.getElement();
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException{
        list.goToPos(index);
        return (Date) list.getElement();
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        list.goToPos(index);
        return (String) list.getElement();
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException{
        list.goToPos(index);
        return (Object) list.getElement();
}

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException{
        list.goToPos(index);
        return null==list.getElement();
    }

    @Override
    public LinearDataStructure<?> asLinearDataStructure(DataStructure type){
        return null;
    }
}