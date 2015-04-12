/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbs_project.gui;
import dbs_project.storage.impl.StorageLayerSMMDS;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author carlosr
 */
public class controla {
    //crear un objeto storage layer
    StorageLayerSMMDS almacenamiento = new StorageLayerSMMDS();
    
    public String recibe_tabla(JTable tabla){
        modifica_tabla t=new modifica_tabla();
        return t.mostrar_celda_elegida(tabla);
       
    }
    
    public void mostrar_toda_tabla(JTable tabla){
         modifica_tabla t=new modifica_tabla();
         t.mostrar_toda_tabla(tabla);
    }
    
    public void mostrar_filas_y_columnas(JTable tabla){
        modifica_tabla t=new modifica_tabla();
        t.mostrar_filas_y_columnas(tabla);
    }
    
    public void ajustar_tablas(JTable tabla){
        String Col= JOptionPane.showInputDialog("Señor usuario por favor ingrese el numero de columnas de la tabla");
        String Ro= JOptionPane.showInputDialog("Señor usuario por favor ingrese el numero de filas de la tabla");
        if(Col.matches("[0-9]*") && Ro.matches("[0-9]*")){
            int nColumnas= Integer.parseInt(Col);
            int nFilas= Integer.parseInt(Ro);
            modifica_tabla t=new modifica_tabla();
            t.ajustar_columnas(tabla, nColumnas, nFilas);
        }
        else{
            JOptionPane.showMessageDialog(tabla, "Error al ingresar la cantidad de Columnas o Filas");
            ajustar_tablas(tabla);
        }
    }
    
    public void eliminar_tabla(JTable tabla){
        //almacenamiento.creartabla(nombre,tipo)
        modifica_tabla t = new modifica_tabla();
        t.ajustar_columnas(tabla, 0, 0);
    }
    
    public void agregar_columna(JTable tabla){
        //almacenamiento.creartabla(nombre,tipo)
        modifica_tabla t = new modifica_tabla();
        t.ajustar_columnas(tabla, tabla.getColumnCount()+1, tabla.getRowCount());
    }
    
    public void eliminar_columna(JTable tabla){
        modifica_tabla t = new modifica_tabla();
        if((tabla.getColumnCount()-1)==0){
            t.ajustar_columnas(tabla, tabla.getColumnCount()-1, 0);
        }
        else{
            t.ajustar_columnas(tabla, tabla.getColumnCount()-1, tabla.getRowCount());
        }
    }
    
    public void agregar_fila(JTable tabla){
        modifica_tabla t = new modifica_tabla();
        if(tabla.getColumnCount()==0){
            JOptionPane.showMessageDialog(tabla, "No hay columnas para agregar Filas");
        }
        else{
            t.ajustar_columnas(tabla, tabla.getColumnCount(), tabla.getRowCount()+1);
        }
    }
    
    public void eliminar_fila(JTable tabla){
        modifica_tabla t = new modifica_tabla();
        t.ajustar_columnas(tabla, tabla.getColumnCount(), tabla.getRowCount()-1);
    }
}
