/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.gui;

import dbs_project.storage.impl.DoublyLinkedList;
import dbs_project.storage.impl.StorageLayerSMMDS;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;



public class vista extends javax.swing.JFrame {
    //Atributos de la interfaz
    controla c=null;
    StorageLayerSMMDS prueba;
    DefaultTableModel vacio=new DefaultTableModel();
    DoublyLinkedList almacenar_tablas= new DoublyLinkedList();

    /**
     * Se Crea la pantalla principal
     */
    public vista() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Pantalla Principal");
        c = new controla ();
        prueba = new StorageLayerSMMDS();
        tabla.setModel(vacio);
        
        /* 
        *Esto es una prueba para tratar de iniciar la tabla de la intefaz, con
        los datos de la tabla del StorageLayerSMMDS
        //************************
        
        
        Map <String, Type> tabla2;
        tabla2 = new HashMap<>();
        tabla2.put("Tabla integer", Type.INTEGER);
        prueba.createTable("h", tabla2, DataStructure.DOUBLYLINKEDLIST);
        
        Table ta = prueba.getTable(0);
        Columns co = new Columns("p", (Tables) ta,"t",Type.INTEGER,3,DataStructure.DOUBLYLINKEDLIST);
        Columns co2 = new Columns("p1", (Tables) ta,"t",Type.INTEGER,3,DataStructure.DOUBLYLINKEDLIST);
        Columns co3 = new Columns("p2", (Tables) ta,"t",Type.INTEGER,3,DataStructure.DOUBLYLINKEDLIST);
        Columns co4 = new Columns("p3", (Tables) ta,"t",Type.INTEGER,3,DataStructure.DOUBLYLINKEDLIST);
        
        
        Rows row;
        row = new Rows<>(0);
        row.appentElement("zz");
        row.appentElement("z1");
        row.appentElement("z2");
        row.appentElement("z3");
        
        
        
        Rows row2 =new Rows<>(0);
        row2.appentElement("c");
        row2.appentElement("d");
        row2.appentElement("ds");
        row2.appentElement("s");
        
        
        
        
        Rows row3 =new Rows<>(0);
        row3.appentElement("77");
        row3.appentElement("d");
        row3.appentElement("dsff");
        
        
        
        Rows row4 =new Rows<>(0);
        row4.appentElement("435te");
        row4.appentElement("fgeg");
        row4.appentElement("ferege");
        
        
        prueba.getTable(0).addRow(row);
        prueba.getTable(0).addRow(row2);
        prueba.getTable(0).addRow(row3);
        prueba.getTable(0).addRow(row4);
        
        prueba.getTable(0).addColumn(co);
        prueba.getTable(0).addColumn(co2);
        prueba.getTable(0).addColumn(co3);
        prueba.getTable(0).addColumn(co4);
        
        
        prueba.getTable(0).updateRow(0, row);
        prueba.getTable(0).updateColumn(0, co);
        prueba.getTable(0).updateRow(1, row2);
        prueba.getTable(0).updateColumn(1, co2);
        prueba.getTable(0).updateRow(2, row3);
        prueba.getTable(0).updateColumn(2, co3);
        prueba.getTable(0).updateRow(3, row4);
        prueba.getTable(0).updateColumn(3, co4);
        
        Table list=prueba.getTable(0);
        //**************************************
        
        * Una vez que se extraia la tabla del StorageLayer, mi idea era
        * que hiciera un ciclo que mientra hubieran columnas en dicha tabla
        * que los datos en cada columna para agregarlos en la tabla de la interfaz
                
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            Columns col=(Columns) list.getColumn(i);
            for (int j = 0; j < tabla.getRowCount(); j++){
                Object obj = col.getObject(j);
                tabla.setValueAt(obj, j, i);
            }
        }
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btn_cambNombColumn = new javax.swing.JButton();
        btn_verTabla = new javax.swing.JButton();
        btn_addTable = new javax.swing.JButton();
        btn_deleteTable = new javax.swing.JButton();
        btn_changeName = new javax.swing.JButton();
        btn_addColumn = new javax.swing.JButton();
        btn_deleteColumn = new javax.swing.JButton();
        btn_addRow = new javax.swing.JButton();
        btn_deleteRow = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        modelo = new DefaultListModel();
        listColumn = new javax.swing.JList();
        lbl_cantidadTablas = new javax.swing.JLabel();
        lbl_numeroTablas = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        lbl_printValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Esteban", "Morales", "21", "Italiano"},
                {"Carlos", "Ramirez", null, null},
                {"Johnson", null, null, "Costarricense"},
                {"Isacc", null, "25", null}
            },
            new String [] {
                "Nombre", "Apellido", "Edad", "Nacionalidad"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        btn_cambNombColumn.setText("Cambiar Nombre Columna");
        btn_cambNombColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambNombColumnActionPerformed(evt);
            }
        });

        btn_verTabla.setText("Mostrar Tabla");
        btn_verTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verTablaActionPerformed(evt);
            }
        });

        btn_addTable.setText("Agregar Tabla");
        btn_addTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addTableActionPerformed(evt);
            }
        });

        btn_deleteTable.setText("Eliminar Tabla");
        btn_deleteTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteTableActionPerformed(evt);
            }
        });

        btn_changeName.setText("Cambiar Nombre");

        btn_addColumn.setText("Agregar Columna");
        btn_addColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addColumnActionPerformed(evt);
            }
        });

        btn_deleteColumn.setText("Eliminar Columna");
        btn_deleteColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteColumnActionPerformed(evt);
            }
        });

        btn_addRow.setText("Agregar Fila");
        btn_addRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addRowActionPerformed(evt);
            }
        });

        btn_deleteRow.setText("Eliminar Fila");
        btn_deleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteRowActionPerformed(evt);
            }
        });

        listColumn.setModel(modelo);
        jScrollPane2.setViewportView(listColumn);

        lbl_cantidadTablas.setText("Cantidad de Tablas");

        lbl_numeroTablas.setText("Tablas Creadas");

        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_changeName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_cantidadTablas))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(btn_cambNombColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_deleteRow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_addRow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_deleteColumn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_addColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_addTable, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_verTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(btn_deleteTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_printValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbl_numeroTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_addColumn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_deleteColumn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_addRow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_cambNombColumn)
                                .addGap(31, 31, 31)))
                        .addComponent(btn_deleteRow)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_printValue)
                    .addComponent(btn_addTable)
                    .addComponent(btn_deleteTable))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cantidadTablas)
                    .addComponent(lbl_numeroTablas)
                    .addComponent(btn_changeName)
                    .addComponent(btn_verTabla))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Metodo del Boton para Cambiar el Nombre a una Columna
    private void btn_cambNombColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambNombColumnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cambNombColumnActionPerformed

    //Metodo del Boton para ver el tamaño de la tabla
    private void btn_verTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verTablaActionPerformed
        // TODO add your handling code here:
        c.mostrar_filas_y_columnas(tabla);
    }//GEN-LAST:event_btn_verTablaActionPerformed

    //Metodo del Boton para Crear una nueva tabla
    private void btn_addTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addTableActionPerformed
        c.ajustar_tablas(tabla);
        //crear_Tablas obj = new crear_Tablas();
        //obj.setVisible(true);
        //dispose();
    }//GEN-LAST:event_btn_addTableActionPerformed

    //Metodo del Boton para agregar una nueva Columna a la Tabla
    private void btn_addColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addColumnActionPerformed
        c.agregar_columna(tabla);
    }//GEN-LAST:event_btn_addColumnActionPerformed

    //Metodo del Boton para elimanar una Columna a la Tabla
    //ESTO ELIMINA LA ULTIMA COLUMNA DE LA TABLA, NO ELIMINA UNA COLUMNA EN ESPECIFICO
    private void btn_deleteColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteColumnActionPerformed
        c.eliminar_columna(tabla);// TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteColumnActionPerformed

    //Metodo del Boton para agregar una nueva Fila a la Tabla
    private void btn_addRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addRowActionPerformed
        c.agregar_fila(tabla);
    }//GEN-LAST:event_btn_addRowActionPerformed

    //Metodo del Boton para elimanar una Fila a la Tabla
    //ESTO ELIMINA LA ULTIMA FILA DE LA TABLA, NO ELIMINA UNA FILA EN ESPECIFICO
    private void btn_deleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteRowActionPerformed
        c.eliminar_fila(tabla);
    }//GEN-LAST:event_btn_deleteRowActionPerformed

    
    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    //Metodo del Boton para eliminar la Tabla o hacerla Vacia
    private void btn_deleteTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteTableActionPerformed
         c.eliminar_tabla(tabla);
    }//GEN-LAST:event_btn_deleteTableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addColumn;
    private javax.swing.JButton btn_addRow;
    private javax.swing.JButton btn_addTable;
    private javax.swing.JButton btn_cambNombColumn;
    private javax.swing.JButton btn_changeName;
    private javax.swing.JButton btn_deleteColumn;
    private javax.swing.JButton btn_deleteRow;
    private javax.swing.JButton btn_deleteTable;
    private javax.swing.JButton btn_verTabla;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_cantidadTablas;
    private javax.swing.JLabel lbl_numeroTablas;
    private javax.swing.JLabel lbl_printValue;
    private javax.swing.JList listColumn;
    private DefaultListModel modelo;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables
}
