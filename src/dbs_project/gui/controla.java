/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbs_project.gui;
import dbs_project.storage.impl.StorageLayerSMMDS;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlosr
 */
public class controla {
    //crear un objeto storage layer
    StorageLayerSMMDS almacenamiento = new StorageLayerSMMDS();
    
    //Este metodo recibe una tabla, para extraer un dato de una celda seleccionada
    public String recibe_tabla(JTable tabla){
        int c= tabla.getSelectedColumn();
        int i= tabla.getSelectedRow();
        
        if((i==-1) || (c==-1)){
            JOptionPane.showMessageDialog(tabla, "señor usuario por favor selecione una fila ");
            return "";
        }
        else{
            String colum1=(String)tabla.getValueAt(i, c);
            return colum1;
        }  
    }
    
    //Este metodo recibe una tabla, para extraer todos los datos de la tabla
    public void mostrar_toda_tabla(JTable tabla){
        String dato="";
        int columnas = tabla.getColumnCount();
        int filas = tabla.getRowCount();
        
        //Ciclo para ir extrayerndo Dato por Dato
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j <columnas; j++) {
                dato+=tabla.getValueAt(i , j)+ "|";
            }
            dato+="\n";
        }
        System.out.println(""+dato);    
    }
    
    //Este metodo recibe una tabla, para extraer el tamaño de la tabla
    public void mostrar_filas_y_columnas(JTable tabla){
        JOptionPane.showMessageDialog(tabla, "La tabla contiene "+ tabla.getColumnCount()+" Columnas y "
        +tabla.getRowCount()+" Filas");;
    }
    
    //Este metodo recibe una tabla, para luego ajustar el tamaño de la misma
    public void ajustar_tablas(JTable tabla){
        //Pregunta cual va a ser el nuevo tamaño de la tabla
        String Col= JOptionPane.showInputDialog("Señor usuario por favor ingrese el numero de columnas de la tabla");
        String Ro= JOptionPane.showInputDialog("Señor usuario por favor ingrese el numero de filas de la tabla");
        //Se verifica que los datos ingresados puedan ser convertidos en Integer
        if(Col.matches("[0-9]*") && Ro.matches("[0-9]*")){
            int nColumnas= Integer.parseInt(Col);
            int nFilas= Integer.parseInt(Ro);
            ajustar_columnas(tabla, nColumnas, nFilas);
        }
        else{
            JOptionPane.showMessageDialog(tabla, "Error al ingresar la cantidad de Columnas o Filas");
            ajustar_tablas(tabla);
        }
    }
    
    //Este metodo recibe una tabla, para luego eliminarla
    public void eliminar_tabla(JTable tabla){
        //almacenamiento.creartabla(nombre,tipo)
        ajustar_columnas(tabla, 0, 0);
    }
    
    //Este metodo recibe una tabla, para luego agregar una columna
    public void agregar_columna(JTable tabla){
        //almacenamiento.creartabla(nombre,tipo)
        ajustar_columnas(tabla, tabla.getColumnCount()+1, tabla.getRowCount());
    }
    
    //Este metodo recibe una tabla, para luego eliminar una columna
    public void eliminar_columna(JTable tabla){
        if((tabla.getColumnCount()-1)==0){
            ajustar_columnas(tabla, tabla.getColumnCount()-1, 0);
        }
        else{
            ajustar_columnas(tabla, tabla.getColumnCount()-1, tabla.getRowCount());
        }
    }
    
    //Este metodo recibe una tabla, para luego agregar una fila
    public void agregar_fila(JTable tabla){
        if(tabla.getColumnCount()==0){
            JOptionPane.showMessageDialog(tabla, "No hay columnas para agregar Filas");
        }
        else{
            ajustar_columnas(tabla, tabla.getColumnCount(), tabla.getRowCount()+1);
        }
    }
    
    //Este metodo recibe una tabla, para luego eliminar una fila
    public void eliminar_fila(JTable tabla){
        ajustar_columnas(tabla, tabla.getColumnCount(), tabla.getRowCount()-1);
    }
    
    //Este Metodo es el encargado de hacer todos los cambios a la Tabla
    public void ajustar_columnas(JTable tabla, int columnas, int filas){
        //Se crea una tabla como temporal
        DefaultTableModel modelo =new DefaultTableModel();
        for (int j = 0; j <columnas; j++) {
            //Si se desea aumentar el numero de Columnas, se pide el nombre de la nueva columna
            try{
                modelo.addColumn(tabla.getColumnName(j));
            }
            catch(IndexOutOfBoundsException e){
                String name = JOptionPane.showInputDialog("Señor usuario por favor ingrese el nombre de la columna #"+(j+1));
                modelo.addColumn(name);
            }
        }
        
        //Se crean las filas
        for (int i = 0; i < filas; i++){
            modelo.addRow(new String [] {});  
        }
        
        //Se Crean estas variables, como temporales, para luego ver si el nuevo
        //tamaño es mayor, menor o igual que el que ya tenia la tabla
        int columna = tabla.getColumnCount();
        int fila = tabla.getRowCount();
        
        if(columnas>columna){
            columnas=columna;
        }
        if(filas>fila){
            filas=fila;
        }
        
        //Se copian los datos ya existentes en la tabla, anterior
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String dato=(String) tabla.getValueAt(i , j);
                modelo.setValueAt(dato, i, j);
            }
        }
        tabla.setModel(modelo);
    }
}
