/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnMetaData;
import dbs_project.storage.RowMetaData;
import dbs_project.storage.Table;
import dbs_project.storage.Type;

/**
 *
 * @author Esteban
 */
public class RowMetaDatas implements RowMetaData{
    /*
    Todo depende de los tipos de datos que se guarden en el MetaData, 
    aqui se dejan solo esos para probar.... pero me imagino que hay que
    cambiarlos xq no van a ser los mismos usados en columna
    */
    
    
    //private int Count;
    private Table Source;
    //private String Label;
    //private Type Type;
    private int ColumnId;
    private int Id;
    private String Name;

    public RowMetaDatas(String Name){
    //    Count=0;
        this.Name=Name;
    }

    RowMetaDatas(String Name, Table Source, int ColumnID, int Id) {
        this.Name=Name;
        this.Source = Source;
        this.ColumnId = ColumnID;
        this.Id = Id;
    }

    //public void increaseCount(){
    //    Count++;
    //}

    //@Override
    //public int getRowCount(){
    //    return Count;
    //}

    public Table getSourceTable(){
        return Source;
    }

    //public String getLabel(){
    //    return Label;
    //}

    //public Type getType(){
    //    return Type;
    //}

    public int getColumnId(int positionInRow) throws IndexOutOfBoundsException {
        return ColumnId;
    }

    @Override
    public int getId(){
        return Id;
    }

    public String getName(){
        return Name;
    }

    @Override
    public ColumnMetaData getColumnMetaData(int positionInTheRow) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}