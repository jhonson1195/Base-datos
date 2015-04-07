/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.exceptions.NoSuchTableException;
import dbs_project.exceptions.TableAlreadyExistsException;
import dbs_project.storage.StorageLayer;
import dbs_project.storage.Table;
import dbs_project.storage.TableMetaData;
import dbs_project.storage.Type;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author jhonson
 */
public class StorageLayerSMMDS implements StorageLayer{
    private int con;
    private Map <Integer, Tables> MapTablas = new HashMap<>();
    
    public StorageLayerSMMDS(){
        con=-1;
    }
    
    public void TableAlreadyExists(String name) throws TableAlreadyExistsException{
        Object [] values=MapTablas.values().toArray();
        for(int i=0;values.length>i;++i){
            Tables temp =(Tables)values[i];
            if(temp.getTableMetaData().getName()== name){
                throw new TableAlreadyExistsException("La tabla ya existe");
            }
        }  
    }
    
    public void NoSuchTable(int id) throws NoSuchTableException{
            if (!MapTablas.containsKey(id)){
                throw new NoSuchTableException("Id no encontrado");
            }
        }  
    
    
    @Override
    public int createTable(String tableName, Map<String, Type> schema, DataStructure type) throws TableAlreadyExistsException {
        TableAlreadyExists(tableName);
        Object [] ArregloString = schema.keySet().toArray();
        Object [] ArregloType = schema.values().toArray();
        Map <Integer, Columns> tablaEsquema = new HashMap<>();
        Tables tabla = new Tables(tablaEsquema,tableName,con++);
        for(int i=0;ArregloString.length>i;++i){
            Columns<Type> columna = new Columns<>((String)ArregloString[i],tabla,tableName+"."+(String)ArregloString[i],(Type)ArregloType[i],i);
            tablaEsquema.put(i, columna);
        }
        MapTablas.put(con, tabla);
        return con;
    }

    @Override
    public void deleteTable(int tableID) throws NoSuchTableException {
        NoSuchTable(tableID);
        MapTablas.remove(tableID);
    }

    @Override
    public void renameTable(int tableID, String newName) throws TableAlreadyExistsException, NoSuchTableException {
        TableAlreadyExists(newName);
        NoSuchTable(tableID);
        MapTablas.get(tableID).getTableMetaData().setName(newName);
    }

    @Override
    public Table getTable(int tableID) throws NoSuchTableException {
        NoSuchTable(tableID);
        return MapTablas.get(tableID);
    }

    @Override
    public LinearDataStructure<? extends Table> getTables(DataStructure type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, TableMetaData> getDatabaseSchema() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
