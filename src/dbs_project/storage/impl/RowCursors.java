/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.RowCursor;
import dbs_project.storage.RowMetaData;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;
import java.util.Date;

/**
 *
 * @author Esteban
 * @param <T>
 */
/*
* Clase RowCursors Implementada con la Interfaz generica RowCursor
*/
public class RowCursors <T>implements RowCursor{
    // Atributos de la Clase "RowCursors"
    private Rows<T> Fila;

    // Constructores de Clase "RowCursors"
    public RowCursors(Rows <T> Fila){
        this.Fila = Fila;
    }

    // Metodos de Clase "RowCursors"
    
    // Retorna el MetaData de la Fila
    @Override
    public RowMetaData getMetaData(){
        return Fila.getMetaData();
    }

    /*
    * Utiliza los metodos de la Clase "Rows", para retornar los datos
    */
    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        return Fila.getInteger(index);
    }

    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        return Fila.getBoolean(index);
    }

    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        return Fila.getDouble(index);
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        return Fila.getDate(index);
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        return Fila.getString(index);
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        return Fila.getObject(index);
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        return Fila.isNull(index);
    }

    @Override
    public LinearDataStructure<?> asLinearDataStructure (DataStructure type) {
        return Fila.asLinearDataStructure(type);
    }

    @Override
    public boolean next(){
        return Fila.getList().next();
    }

    @Override
    public int getCursorPosition(){
        return Fila.getList().getPosition();
    }

    public void close(){
        Fila.getList().clear();
    }

    @Override
    public DataStructure getType() {
        return Fila.getList().getType();
    }
}