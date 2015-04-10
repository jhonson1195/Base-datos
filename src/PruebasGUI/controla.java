/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PruebasGUI;
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
    
    public void recibe_tabla(JTable tabla){
        modifica_tabla t=new modifica_tabla();
        t.mostrar_celda_elegida(tabla);
       
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
        int nColumnas= Integer.parseInt(JOptionPane.showInputDialog("señor usuario por favor ingrese el numero de columnas de la tabla"));
        int nFilas= Integer.parseInt(JOptionPane.showInputDialog("señor usuario por favor ingrese el numero de filas de la tabla"));
        modifica_tabla t=new modifica_tabla();
        t.ajustar_columnas(tabla, nColumnas, nFilas);
    }
    
    public void agregar_columna(JTable tabla){
        //almacenamiento.creartabla(nombre,tipo)
        modifica_tabla t = new modifica_tabla();
        t.ajustar_columnas(tabla, tabla.getColumnCount()+1, tabla.getRowCount());
    }
    
    public void eliminar_columna(JTable tabla){
        modifica_tabla t = new modifica_tabla();
        t.ajustar_columnas(tabla, tabla.getColumnCount()-1, tabla.getRowCount());
    }
    
    public void agregar_fila(JTable tabla){
        modifica_tabla t = new modifica_tabla();
        t.ajustar_columnas(tabla, tabla.getColumnCount(), tabla.getRowCount()+1);
    }
    
    public void eliminar_fila(JTable tabla){
        modifica_tabla t = new modifica_tabla();
        t.ajustar_columnas(tabla, tabla.getColumnCount(), tabla.getRowCount()-1);
    }
}
