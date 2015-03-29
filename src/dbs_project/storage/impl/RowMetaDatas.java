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
    private ColumnMetaDatas Metadata;
    private int Id;

    // Constructores de Clase "RowMetaDatas"
    public RowMetaDatas(String Name, Table Source, String Label, Type Type, int IdColumn) {
        Count=0;
        this.Id = Id;
        //no tiene que hacer esto con solo pedir el metadata del la columna ya puede ingresar a los datos
        this.Metadata = new ColumnMetaDatas(Name, Source, Label, Type, IdColumn);
    }
    
    // Metodos de Clase "RowMetaDatas"
    
    // Incrementa el contador
    // +++++++++++++++++++++
    public void increaseCount(){
        Count++;
    }
    
    // ¿?
    // Retorma el ColumnMetaData
    @Override
    public ColumnMetaData getColumnMetaData(int positionInTheRow) throws IndexOutOfBoundsException {
        return Metadata;
    }
    
    // Retorna el Contador
    @Override
    public int getColumnCount() {
        return Count;
    }
    
    // Retorna el Id de la Fila
    @Override
    public int getId() {
        return Id;
    }

    
    
    /*
    // Metodos de Clase "RowMetaDatas"
    #######################################################################
    # Estos metodos son los primeros que yo cree en base a las columnas   #
    # Estan malos, por que no son los principales de interfaz RowMetaData #
    #######################################################################
    
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

    public String getName(){
        return Name;
    }
    */
}