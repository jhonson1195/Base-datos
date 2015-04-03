

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
        int i= tabla.getSelectedRow();
        
        if(i==-1){
            JOptionPane.showMessageDialog(tabla, "señor usuario por favor selecione una fila ");
        }
        else{
            String colum1=(String)tabla.getValueAt(i, 0);
            String colum2=(String)tabla.getValueAt(i, 1);
            System.out.println(""+colum1+""+colum2);
        }
    }
    
        public void mostrar_toda_tabla(JTable tabla,int columnas, int filas){
        String dato="";
        
            for (int i = 0; i < columnas; i++) {
                for (int j = 0; j <filas; j++) {
                    dato+=tabla.getValueAt(i, j)+ "|";
                   
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
        
        public void ajustar_columnas(JTable tabla, int numero){
            DefaultTableModel modelo =new DefaultTableModel();
            for (int i = 0; i < numero; i++) {
                modelo.addColumn(""+i);
                modelo.addRow(new String [] {"1","2"});
                
            }
            tabla.setModel(modelo);
            
            
            
        }
    
}
