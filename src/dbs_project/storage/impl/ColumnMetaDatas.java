/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnMetaData;
import dbs_project.storage.Table;
import dbs_project.storage.Type;

/**
 *
 * @author jhonson
 */
public class ColumnMetaDatas implements ColumnMetaData {
    //Definicion de variables
    private int Count;
    private Table Source;
    private String Label;
    private Type Type;
    private int RowId;
    private int Id;
    private String Name;
    
    
    /**
     * Constructor
     * 
     * @param Name
     */
    public ColumnMetaDatas(String Name){
        Count=0;
        this.Name=Name;
        
    }
    /**
     * Aumenta el numero de elementos de la lista
     */
    public void increaseCount(){
        Count++;
    }
    //get de todas la variables definidas
    @Override
    public int getRowCount() {
        return Count;
    }

    @Override
    public Table getSourceTable() {
        return Source;
    }

    @Override
    public String getLabel() {
        return Label;
    }

    @Override
    public Type getType() {
        return Type;
    }

    @Override
    public int getRowId(int positionInColumn) throws IndexOutOfBoundsException {
        return RowId;
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public String getName() {
        return Name;
    }
    
}
