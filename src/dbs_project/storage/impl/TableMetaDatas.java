/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnMetaData;
import dbs_project.storage.TableMetaData;
import java.util.Map;

/**
 *
 * @author jhonson
 */
public class TableMetaDatas implements TableMetaData{
    
    private String Name;
    private int Id;
    private int rowcount;
    
    public TableMetaDatas(String Name, int Id){
        this.Name=Name;
        this.Id=Id;
        
    }

    @Override
    public Map<String, ColumnMetaData> getTableSchema() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return rowcount;
    }
    
    public void increaseCount(){
        rowcount++;
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
