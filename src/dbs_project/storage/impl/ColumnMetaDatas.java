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
    private int Id;
    private String Name;
    
    
    /**
     * Constructor
     * 
     * @param Name
     * @param Source
     * @param Label
     * @param Type
     * @param Id
     */
    public ColumnMetaDatas(String Name, Tables Source, String Label, Type Type,int Id){
        //variables 
        Count=0;
        this.Name=Name;
        this.Source = Source;
        this.Label = Label;
        this.Type = Type;
        this.Id = Id;
        
    }
    /**
     * Aumenta el numero de elementos de la lista
     */
    public void increaseCount(){
        Count++;
    }
    //retorna el numero de Filas en la Columna
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

    //Retorna el tipo de Dato
    @Override
    public Type getType() {
        return Type;
    }

    @Override
    //Retorna el Id de una Fila, lo que seria lo mismo a retornar una posicion
    //de la columna
    public int getRowId(int positionInColumn) throws IndexOutOfBoundsException {
        /**
        if (index<0 || index>list.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }*/
        return positionInColumn;
    }

    //Retorna el id de la Columna
    @Override
    public int getId() {
        return Id;
    }

    //Retorna el nombre la columna
    @Override
    public String getName() {
        return Name;
    }
    
    //Cambia el nombre la columna
    public void setName(String name){
        this.Name=name;
    }
}
