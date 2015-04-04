

package PruebasGUI;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlosr
 */
public class modifica_tabla {
    public void mostrar_celda_elegida(JTable tabla){
        int c= tabla.getSelectedColumn()
        int i= tabla.getSelectedRow();
        
        
        if((i==-1) || (c==-1)){
            JOptionPane.showMessageDialog(tabla, "señor usuario por favor selecione una fila ");
        }
        else{
            String colum1=(String)tabla.getValueAt(i, c);
            System.out.println(""+colum1+"");
        }
    }
    
        public void mostrar_toda_tabla(JTable tabla){
        String dato="";
        int columnas = tabla.getColumnCount();
        int filas = tabla.getRowCount();
        
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j <columnas; j++) {
                    dato+=tabla.getValueAt(i , j)+ "|";
                   
                    //System.out .println(""+tabla.getValueAt(i, j));
                    
                }
                dato+="\n";
                
                
            }
            System.out.println(""+dato);
            
    }
        public void mostrar_filas_y_columnas(JTable tabla){
            JOptionPane.showMessageDialog(tabla, "# columnas"+ tabla.getColumnCount()
            +"#filas"+tabla.getRowCount());
            
        }
        
        public void ajustar_columnas(JTable tabla, int columnas, int filas){
            DefaultTableModel modelo =new DefaultTableModel();
            for (int j = 0; j <columnas; j++) {
                modelo.addColumn(""+j);
            }
            for (int i = 0; i < filas; i++){
                modelo.addRow(new String [] {" "," "});  
            }
            
            int columna = tabla.getColumnCount();
            int fila = tabla.getRowCount();
            if(columnas>columna){
                columnas=columna;
            }
            if(filas>fila){
                filas=fila;
            }
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    String dato=(String) tabla.getValueAt(i , j);
                    modelo.setValueAt(dato, i, j);
                }
            }
            tabla.setModel(modelo);
        }
    
}
