/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnMetaData;
import dbs_project.storage.TableMetaData;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jhonson
 */
public class TableMetaDatas implements TableMetaData{
    
    private String Name;
    private int Id;
    private int rowcount;
    private Map<Integer, Columns> tabla;
    
    public TableMetaDatas(String Name, int Id, Map<Integer, Columns> tabla){
        this.Name=Name;
        this.Id=Id;
        rowcount=0;
        this.tabla=tabla;
        
    }

    @Override
    public Map<String, ColumnMetaData> getTableSchema() {
        Map<String, ColumnMetaData> mapa = new HashMap<>();
        Object [] values = tabla.values().toArray();
        for(Object i: values){
            Columns columna = (Columns)i;
            mapa.put(columna.getMetaData().getName(), columna.getMetaData());
        }
        return mapa;
    }

    @Override
    public int getRowCount() {
        return rowcount;
    }
    
    public void increaseCount(){
        rowcount++;
    }
    public void dicreaseCount(){
        rowcount--;
    }
    

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public String getName() {
        return Name;
    }
    
    public void setName(String Name){
        this.Name=Name;
    }
}
