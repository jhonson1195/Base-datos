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
import org.apache.commons.collections.primitives.IntIterator;
import java.util.Map;

/**
 *
 * @author jhonson
 */
public class Tables implements Table{
    private Map<Integer, Columns> tablaEsquema;
    private TableMetaDatas MetaData;
    private int countID;
    private DataStructure tipoLista;
    
    
    public Tables(Map <Integer, Columns> tablaEsquema, String Name, int Id,int countID, DataStructure tipoLista){
        this.tablaEsquema= tablaEsquema;
        MetaData= new TableMetaDatas(Name, Id,tablaEsquema);
        this.countID= countID-1;
        this.tipoLista=tipoLista;
    }
    
    private void SchemaMismatchRow(int countRow) throws SchemaMismatchException{
        if(tablaEsquema.size()!=countRow){
            throw new SchemaMismatchException("La fila no concuerda con el numero de columnas");
        }
    }
    
    private void ColumnAlreadyExists(String name)throws ColumnAlreadyExistsException{
        Object [] values=tablaEsquema.values().toArray();
        for(int i=0;values.length>i;++i){
            Columns temp =(Columns)values[i];
            if(temp.getMetaData().getName()== name){
                throw new ColumnAlreadyExistsException("La tabla ya existe");
            }
        }  
    }
    
    private void NoSuchColumn(int indice)throws NoSuchColumnException{
        if(!tablaEsquema.containsKey(indice)){
            throw new NoSuchColumnException("Columna no encontrada");  
        }
    }
    private void NoSuchRow(int id) throws NoSuchRowException{
        Object [] values=tablaEsquema.values().toArray();
        Columns columna=(Columns)values[0];
        if(id>=columna.getList().size()){
            throw new NoSuchRowException("Id invalido");
        }
        
    }

    @Override
    public void renameColumn(int columnId, String newColumnName) throws ColumnAlreadyExistsException, NoSuchColumnException {
        ColumnAlreadyExists(newColumnName);
        NoSuchColumn(columnId);
        tablaEsquema.get(columnId).getMetaData().setName(newColumnName);
    }

    @Override
    public int createColumn(String columnName, Type columnType) throws ColumnAlreadyExistsException {
        ColumnAlreadyExists(columnName);
        Columns<Type> columna = new Columns<>(columnName, this, MetaData.getName()+"."+columnName, columnType, ++countID,tipoLista);
        tablaEsquema.put(countID, columna);
        return countID;
    }

    @Override
    public int addRow(Row row) throws SchemaMismatchException {
        Rows row1 = (Rows) row;
        SchemaMismatchRow(row1.getMetaData().getColumnCount());
        Object [] values=tablaEsquema.values().toArray();
        for(int i=0; values.length>i;++i){
            tablaEsquema.get(i).appenElement(row1.getElement(i));
        }
        Columns columna=(Columns)values[0];
        MetaData.increaseCount();
        return columna.getMetaData().getRowCount();
        
    }

    @Override
    public IntIterator addRows(RowCursor rows) throws SchemaMismatchException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addColumn(Column column) throws SchemaMismatchException, ColumnAlreadyExistsException {
        Object [] values=tablaEsquema.values().toArray();
        Columns columna=(Columns)values[0];
        if(columna.getMetaData().getRowCount()!=column.getMetaData().getRowCount()){
            throw new SchemaMismatchException("La columna no coincide con el numero de filas");
        }
        tablaEsquema.put(++countID, (Columns) column);
        return countID;
    }

    @Override
    public IntIterator addColumns(ColumnCursor columns) throws SchemaMismatchException, ColumnAlreadyExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRow(int rowID) throws NoSuchRowException {
        NoSuchRow(rowID);
        for(int i=0; tablaEsquema.size()>i;++i){
            tablaEsquema.get(i).removeRow(rowID);
        }    
        MetaData.dicreaseCount();
    }

    @Override
    public void deleteRows(IntIterator rowIDs) throws NoSuchRowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dropColumn(int columnId) throws NoSuchColumnException {
        Object[] values=tablaEsquema.values().toArray();
        Columns columna= (Columns)values[0];
        if (tablaEsquema.containsKey(columnId)){
            tablaEsquema.remove(columnId);
        }
        else{
            throw new NoSuchColumnException("Id invalido");
        }
    }

    @Override
    public void dropColumns(IntIterator columnIds) throws NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Columns getColumn(int columnId) throws NoSuchColumnException {
        NoSuchColumn(columnId);
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
        NoSuchRow(rowId);
        Object [] values=tablaEsquema.values().toArray();
        Rows row = new Rows(rowId,this);
        for(Object i:values){
            Columns columna=(Columns)i;
            row.appentElement(columna.getElement(rowId));
        }
        return row;
    }

    @Override
    public void updateRow(int rowID, Row newRow) throws SchemaMismatchException, NoSuchRowException {
        NoSuchRow(rowID);
        Rows row1 = (Rows) newRow;
        SchemaMismatchRow(row1.getMetaData().getColumnCount());
        Object [] values=tablaEsquema.values().toArray();
        int indice=0;
        for(Object i:values){
            Columns columna=(Columns)i;
            try{
                DoublyLinkedList lista=(DoublyLinkedList)columna.getList();
                lista.goToPos(rowID);
                lista.setElement(row1.getElement(indice));
                
            }
            catch(ClassCastException e){
                LinkedList lista=(LinkedList)columna.getList();
                lista.goToPos(rowID);
                lista.setElement(row1.getElement(indice));
            }
            
            
            indice++;
        }
        
        
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
        NoSuchColumn(columnId);
        Object [] values=tablaEsquema.values().toArray();
        Columns columna=(Columns)values[0];
        Columns columna2=(Columns)updateColumn;
        if(columna.getMetaData().getRowCount()!=updateColumn.getMetaData().getRowCount()){
            throw new SchemaMismatchException("La columna no coincide con el numero de filas");
        }
        tablaEsquema.put(columnId, columna2);
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
}
