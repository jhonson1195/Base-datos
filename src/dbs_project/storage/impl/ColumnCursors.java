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
 *
 * @author jhonson
 * @param <T>
 */
public class ColumnCursors <T>implements ColumnCursor{
    
    private Columns<T> Columna;
    
    public ColumnCursors(Columns<T> Columna){
        this.Columna=Columna;
    }

    @Override
    public ColumnMetaData getMetaData() {
        return Columna.getMetaData();
    }

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
    public LinearDataStructure<?> asLinearDataStructure(DataStructure type) {
        return Columna.asLinearDataStructure(type);
    }

    @Override
    public boolean next() {
        return Columna.getList().next();
    }

    @Override
    public int getCursorPosition() {
        return Columna.getList().getPosition();
    }

    @Override
    public void close() {
        Columna.getList().clear();
    }

    @Override
    public DataStructure getType() {
        return Columna.getList().getType();
    }
    
}
