/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnCursor;
import dbs_project.storage.ColumnMetaData;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;
import java.util.Date;

/**
 *Creacion de una columna
 * @author jhonson
 * @param <T>
 */
public class ColumnCursors <T>implements ColumnCursor{
    
    private Columns<T> Columna;
    /**
     * Constructor que recibe la columna para manipularla
     * @param Columna
     */
    public ColumnCursors(Columns<T> Columna){
        this.Columna=Columna;
    }
    
    @Override
    /**
     * Devuelve los metadatos de la columna
     * @return ColumnMetaData
     */
    public ColumnMetaData getMetaData() {
        return Columna.getMetaData();
    }

    //Metodos que retornan los tipos de datos relizando una convercion o comprovacion del dato
    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        return Columna.getInteger(index);
    }

    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        return Columna.getBoolean(index);
    }

    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        return Columna.getDouble(index);
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        return Columna.getDate(index);
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        return Columna.getString(index);
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        return Columna.getObject(index);
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        return Columna.isNull(index);
    }

    @Override
    /**
     * Se pasa de una estrutura de almacenamieto a otra
     * @param type
     * @return LinearDataStructure<?>
     */
    public LinearDataStructure<?> asLinearDataStructure(DataStructure type) {
        return Columna.asLinearDataStructure(type);
    }

    @Override
    /**
     * Avanza la posicion del elemento en la lista
     * @return boolean
     */
    public boolean next() {
        return Columna.getList().next();
    }

    @Override
    /**
     * retorna la posicion del actual en la lista
     * @return int
     */
    public int getCursorPosition() {
        return Columna.getList().getPosition();
    }

    @Override
    /**
     * Vacia la lista
     */
    public void close() {
        Columna.getList().clear();
    }

    @Override
    /**
     * Devuelve la estructura de datos en la que se basa la columna
     * @return DataStructure
     */
    public DataStructure getType() {
        return Columna.getList().getType();
    }

}
