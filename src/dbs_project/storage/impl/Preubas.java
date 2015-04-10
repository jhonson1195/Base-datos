/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.exceptions.ColumnAlreadyExistsException;
import dbs_project.exceptions.NoSuchColumnException;
import dbs_project.exceptions.NoSuchRowException;
import dbs_project.exceptions.NoSuchTableException;
import dbs_project.exceptions.SchemaMismatchException;
import dbs_project.exceptions.TableAlreadyExistsException;
import dbs_project.storage.Column;
import dbs_project.storage.Row;
import dbs_project.storage.Table;
import dbs_project.storage.Type;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearList;
import dbs_project.structures.Queue;
import dbs_project.structures.Stack;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *aqui pueden hacer las preubas despues que lo copian solo delen clik derecho y ejecutan solo este archivo.
 * @author jhonson
 */
public class Preubas {
    
    public static void main(String[] args) throws ColumnAlreadyExistsException, NoSuchRowException, NoSuchColumnException, NoSuchTableException, TableAlreadyExistsException, SchemaMismatchException {
     
        Map <String, Type> tabla = new HashMap<>();
        tabla.put("Tabla integer", Type.INTEGER);
        tabla.put("Tabla boolean", Type.INTEGER);
        StorageLayerSMMDS hola = new StorageLayerSMMDS();
        hola.createTable("f", tabla, DataStructure.STACK);
        hola.createTable("h", tabla, DataStructure.STACK);
        hola.getTable(0).createColumn("nueva", Type.INTEGER);
        
        Rows row;
        Table ta = hola.getTable(0);
        Columns co = new Columns("p", (Tables) ta,"t",Type.INTEGER,3);
        hola.getTable(0).addColumn(co);
        row = new Rows<>(0);
        row.appentElement("zz");
        row.appentElement("zz");
        row.appentElement("zz");
        row.appentElement("zz");
        Rows row2 =new Rows<>(0);
        row2.appentElement("c");
        row2.appentElement("d");
        row2.appentElement("ds");
        row2.appentElement("s");
        hola.getTable(0).addRow(row);
        hola.getTable(0).updateRow(0, row2);
        
        System.out.println(hola.getTable(0).getRow(2).getString(2));
        
       
	}
  
}

