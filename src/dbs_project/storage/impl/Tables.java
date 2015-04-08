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
import java.util.HashMap;
import org.apache.commons.collections.primitives.IntIterator;
import java.util.Map;

/**
 *
 * @author jhonson
 */
public class Tables implements Table{
    private Map<Integer, Columns> tablaEsquema;
    private TableMetaDatas MetaData;
    int countID;
    
    
    public Tables(Map <Integer, Columns> tablaEsquema, String Name, int Id,int countID){
        this.tablaEsquema= tablaEsquema;
        MetaData= new TableMetaDatas(Name, Id);
        this.countID= countID-1;
    }
    
    public void SchemaMismatchRow(int countRow) throws SchemaMismatchException{
        
        if(tablaEsquema.size()!=countRow){
            throw new SchemaMismatchException("La fila no concuerda con el numero de columnas");
        }
    }
    
    public void ColumnAlreadyExists(String name)throws ColumnAlreadyExistsException{
        Object [] values=tablaEsquema.values().toArray();
        for(int i=0;values.length>i;++i){
            Columns temp =(Columns)values[i];
            if(temp.getMetaData().getName()== name){
                throw new ColumnAlreadyExistsException("La tabla ya existe");
            }
        }  
    }
    
    public void NoSuchColumn(int indice)throws NoSuchColumnException{
        if(!tablaEsquema.containsKey(indice)){
            throw new NoSuchColumnException("Columna no encontrada");  
        }
    }

    @Override
    public void renameColumn(int columnId, String newColumnName) throws ColumnAlreadyExistsException, NoSuchColumnException {
        ColumnAlreadyExists(newColumnName);
        tablaEsquema.get(columnId).getMetaData().setName(newColumnName);
    }

    @Override
    public int createColumn(String columnName, Type columnType) throws ColumnAlreadyExistsException {
        ColumnAlreadyExists(columnName);
        Columns<Type> columna = new Columns<>(columnName, this, MetaData.getName()+"."+columnName, columnType, countID++);
        tablaEsquema.put(countID, columna);
        return countID;
    }

    @Override
    public int addRow(Row row) throws SchemaMismatchException {
        SchemaMismatchRow(row.getMetaData().getColumnCount());
        Object [] values=tablaEsquema.values().toArray();
        for(int i=0; values.length>i;++i){
            tablaEsquema.get(i).appenElement(row.getInteger(i));
        }
        return 0;
        
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
        return tablaEsquema.get(columnId);
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
