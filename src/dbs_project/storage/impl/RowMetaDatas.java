/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.exceptions.NoSuchColumnException;
import dbs_project.storage.ColumnMetaData;
import dbs_project.storage.RowMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Esteban
 */
/*
* Clase RowMetaDatas Implementada con la Interfaz generica RowMetaData
*/
public class RowMetaDatas implements RowMetaData{

    // Atributos de la Clase "RowMetaDatas"
    // Estos atributos son la informacion de la Fila
    private int Count;
    private int Id;
    Tables tabla;

    // Constructores de Clase "RowMetaDatas"
    public RowMetaDatas(int Id) {
        this.Id = Id;
        this.tabla=tabla;        
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
        try {
            if (positionInTheRow<0 || positionInTheRow>tabla.getColumn(positionInTheRow).getList().size()){
                throw new IndexOutOfBoundsException("Indice invalido");
            }
        } catch (NoSuchColumnException ex) {
            Logger.getLogger(RowMetaDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return tabla.getColumn(positionInTheRow).getMetaData();
        } catch (NoSuchColumnException ex) {
            Logger.getLogger(RowMetaDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
}