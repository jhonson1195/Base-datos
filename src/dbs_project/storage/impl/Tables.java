/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.exceptions.ColumnAlreadyExistsException;
import dbs_project.exceptions.NoSuchColumnException;
import dbs_project.exceptions.NoSuchRowException;
import dbs_project.exceptions.SchemaMismatchException;
import dbs_project.storage.Column;
import dbs_project.storage.ColumnCursor;
import dbs_project.storage.Row;
import dbs_project.storage.RowCursor;
import dbs_project.storage.Table;
import dbs_project.storage.Type;
import dbs_project.structures.DataStructure;
import java.util.Iterator;
import org.apache.commons.collections.primitives.IntIterator;

/**
 *
 * @author jhonson
 */
public class Tables implements Table{
    private Maps<Integer, Columns> tablaEsquema;
    private TableMetaDatas MetaData;
    
    
    public Tables(Maps<Integer, Columns> tablaEsquema, String Name, int Id){
        this.tablaEsquema=tablaEsquema;
         MetaData= new TableMetaDatas(Name, Id);
    }
    
    public void ColumnAlreadyExists(String name)throws ColumnAlreadyExistsException{
        for(int i=0; tablaEsquema.size()>i;++i){
            if(tablaEsquema.get(i).getMetaData().getName()==name){
                throw new ColumnAlreadyExistsException("Columna ya existente");
            }
        } 
    }
    
    public void NoSuchColumn(int indice)throws NoSuchColumnException{
        if(indice==-1){
            throw new NoSuchColumnException("Columna no encontrada");  
        }
    }

    @Override
    public void renameColumn(int columnId, String newColumnName) throws ColumnAlreadyExistsException, NoSuchColumnException {
        int indice=tablaEsquema.findIndex(columnId);
        NoSuchColumn(indice);
        ColumnAlreadyExists(newColumnName);
        tablaEsquema.get(indice).getMetaData().setName(newColumnName);
    }

    @Override
    public int createColumn(String columnName, Type columnType) throws ColumnAlreadyExistsException {
        ColumnAlreadyExists(columnName);
        Columns<Type> columna = new Columns<>(columnName, this, "Columna "+tablaEsquema.size()+1, columnType, tablaEsquema.size()+1);
        tablaEsquema.put(tablaEsquema.size()+1, columna);
        return tablaEsquema.size();
    }

    @Override
    public int addRow(Row row) throws SchemaMismatchException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IntIterator addRows(RowCursor rows) throws SchemaMismatchException {
        for(int i=0; i<this.tablaEsquema.size();i++){
            tablaEsquema.put(i, null);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int addColumn(Columns column) throws SchemaMismatchException, ColumnAlreadyExistsException {
        
        if(tablaEsquema.get(0).getMetaData().getRowCount()!=column.getMetaData().getRowCount()){
            throw new SchemaMismatchException("La columna no coincide con el numero de filas");
        }
        tablaEsquema.put(tablaEsquema.size()+1, column);
        return tablaEsquema.size();
    }

    @Override
    public IntIterator addColumns(ColumnCursor columns) throws SchemaMismatchException, ColumnAlreadyExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRow(int rowID) throws NoSuchRowException {
        if(tablaEsquema.get(0).getList().size()>rowID){
         
        for(int i=0; tablaEsquema.size()>i;++i){
            tablaEsquema.get(i).removeRow(rowID);
        } 
        }
        else{
            throw new NoSuchRowException("Id invalido");
        }
    }

    @Override
    public void deleteRows(IntIterator rowIDs) throws NoSuchRowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dropColumn(int columnId) throws NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dropColumns(IntIterator columnIds) throws NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Columns getColumn(int columnId) throws NoSuchColumnException {
        int indice=tablaEsquema.findIndex(columnId);
        NoSuchColumn(indice);
        return tablaEsquema.get(indice);
    }

    @Override
    public ColumnCursor getColumns(DataStructure type, IntIterator columnIds) throws NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowCursor getRows(DataStructure type, IntIterator rowIds) throws NoSuchRowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Row getRow(int rowId) throws NoSuchRowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRow(int rowID, Row newRow) throws SchemaMismatchException, NoSuchRowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRows(IntIterator rowIDs, RowCursor newRows) throws SchemaMismatchException, NoSuchRowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateColumns(IntIterator columnIDs, ColumnCursor updateColumns) throws SchemaMismatchException, NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateColumn(int columnId, Column updateColumn) throws SchemaMismatchException, NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TableMetaDatas getTableMetaData() {
        return MetaData;
    }

    @Override
    public RowCursor getRows(DataStructure type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ColumnCursor getColumns(DataStructure type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addColumn(Column column) throws SchemaMismatchException, ColumnAlreadyExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
