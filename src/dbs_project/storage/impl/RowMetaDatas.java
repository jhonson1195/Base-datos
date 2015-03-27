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
/*
* Clase RowMetaDatas Implementada con la Interfaz generica RowMetaData
*/
public class RowMetaDatas implements RowMetaData{
    /*
    Todo depende de los tipos de datos que se guarden en el MetaData, 
    aqui se dejan solo esos para probar.... pero me imagino que hay que
    cambiarlos xq no van a ser los mismos usados en columna
    */
    
    // Atributos de la Clase "RowMetaDatas"
    // Estos atributos son la informacion de la Fila
    private int Count;
    private Table Source;
    //private String Label;
    //private Type Type;
    private int ColumnId;
    private int Id;
    private String Name;

    // Constructores de Clase "RowMetaDatas"
    public RowMetaDatas(String Name){
        Count=0;
        this.Name=Name;
    }

    RowMetaDatas(String Name, Table Source, int ColumnID, int Id) {
        Count=0;
        this.Name=Name;
        this.Source = Source;
        this.ColumnId = ColumnID;
        this.Id = Id;
    }

    // Metodos de Clase "RowMetaDatas"
    // Incrementa el contador
    public void increaseCount(){
        Count++;
    }
    
    // Retorna el Contador
    public int getRowCount(){
        return Count;
    }

    // Retorna el nombre de la tabla ¿?
    public Table getSourceTable(){
        return Source;
    }

    //public String getLabel(){
    //    return Label;
    //}

    //public Type getType(){
    //    return Type;
    //}

    // Retorna el ColumnId, de la fila en la que se encuentra
    public int getColumnId(int positionInRow) throws IndexOutOfBoundsException {
        return ColumnId;
    }

    // Retorna el Id de la Fila ¿?
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
        return ColumnId;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}