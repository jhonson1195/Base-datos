/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PruebasGUI;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author carlosr
 */
public class controla {
    
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
    
    
    
}