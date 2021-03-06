/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.gui;

import dbs_project.exceptions.ColumnAlreadyExistsException;
import dbs_project.exceptions.NoSuchColumnException;
import dbs_project.exceptions.NoSuchRowException;
import dbs_project.exceptions.NoSuchTableException;
import dbs_project.exceptions.SchemaMismatchException;
import dbs_project.exceptions.TableAlreadyExistsException;
import dbs_project.storage.ColumnMetaData;
import dbs_project.storage.Table;
import dbs_project.storage.TableMetaData;
import dbs_project.storage.impl.ColumnCursors;
import dbs_project.storage.impl.ColumnMetaDatas;
import dbs_project.storage.impl.Columns;
import dbs_project.storage.impl.DoublyLinkedList;
import dbs_project.storage.impl.RowCursors;
import dbs_project.storage.impl.Rows;
import dbs_project.storage.impl.StorageLayerSMMDS;
import dbs_project.storage.impl.TableMetaDatas;
import dbs_project.storage.impl.Tables;
import dbs_project.structures.DataStructure;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author carlosr
 */
public class vista extends javax.swing.JFrame {
controla c=null;
StorageLayerSMMDS Almacenamiento;
DefaultTableModel vacio =new DefaultTableModel();
DoublyLinkedList almacenar_tablas= new DoublyLinkedList();
int contadorID;
DefaultTableModel Modelo;
DefaultListModel modelojlist = new DefaultListModel();
//almacena el nombre como key y el id como valor
Map <String, Integer> TablaIndex = new HashMap<>();
    private Component frame;

    /**
     * Creates new form vista
     * pantalla principal
     */
    public vista() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Pantalla Principal");
        c = new controla ();
        Almacenamiento = new StorageLayerSMMDS();
        tabla.setModel(vacio);
        contadorID=-1; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btn_addTable = new javax.swing.JButton();
        btn_deleteTable = new javax.swing.JButton();
        btn_changeName = new javax.swing.JButton();
        btn_addColumn = new javax.swing.JButton();
        btn_deleteColumn = new javax.swing.JButton();
        btn_addRow = new javax.swing.JButton();
        btn_deleteRow = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        modelo = new DefaultListModel();
        jList1 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();

        jButton5.setText("Agregar Tabla");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Eliminar Tabla");

        jButton7.setText("Cambiar Nombre");

        jButton8.setText("Modificar Seleccion");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Agregar Columna");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Eliminar Columna");

        jButton11.setText("Agregar Fila");

        jButton12.setText("Eliminar Fila");

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

        jButton2.setText("Cambiar Nombre");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
        btn_changeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changeNameActionPerformed(evt);
            }
        });

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

        jList1.setModel(modelo);
        jScrollPane2.setViewportView(jList1);

        jButton1.setText("Metadatos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Metadatos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Tablas");

        jLabel1.setText("Nombre Tabla");

        jLabel2.setText("Tabla");

        jLabel5.setText("Columna");

        jLabel6.setText("Fila");

        jButton13.setText("Actualizar tabla");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_deleteTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_changeName, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                        .addComponent(btn_addTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_addColumn, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                    .addComponent(btn_deleteColumn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_addRow, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_deleteRow, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton3)
                                .addGap(63, 63, 63)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addGap(119, 119, 119)
                .addComponent(jLabel5)
                .addGap(105, 105, 105)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_addTable)
                            .addComponent(btn_addColumn)
                            .addComponent(btn_addRow))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_changeName)
                            .addComponent(jButton2)
                            .addComponent(btn_deleteRow))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_deleteTable)
                            .addComponent(btn_deleteColumn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void visualizarTabla(){
        try {
        Tables t = (Tables) Almacenamiento.getTable(contadorID);
        TablaIndex.put(t.getTableMetaData().getName(), contadorID);
        jLabel1.setText(t.getTableMetaData().getName());
        modelojlist.addElement(t.getTableMetaData().getName());
        jList1.setModel(modelojlist);
        String [] NombreColumnas= new String[t.getValues().length];
        int indice=0;
        for(Object i:t.getValues()){
            Columns columna=(Columns) i; 
            NombreColumnas [indice]=columna.getMetaData().getName();
            indice++;
        }
        String Datos [][]={};
        Modelo = new DefaultTableModel(Datos, NombreColumnas);
        tabla.setModel(Modelo);
    } catch (NoSuchTableException ex) {
        Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         
    try {
        String Elemento = (String) jList1.getSelectedValue();
        Tables tablaseleccion = (Tables)Almacenamiento.getTable(TablaIndex.get(Elemento));
        ColumnCursors cursor=(ColumnCursors)tablaseleccion.getColumns(DataStructure.DOUBLYLINKEDLIST);
        String Nombre= JOptionPane.showInputDialog("Por favor ingrese el nombre de la columna");
        if(Nombre==null){
            return;
        }
        //tablaseleccion.renameColumn(in, NuevoNombre);
        boolean bandera=true;
        while(bandera){
            if(Nombre.equals(cursor.getMetaData().getName())){
                break;
            }
            bandera=cursor.next();
            
        }
        if(!bandera){
                JOptionPane.showMessageDialog(frame,"Columna no encontrada");
                return;
            }
        String NuevoNombre= JOptionPane.showInputDialog("Por favor ingrese el nuevo nombre");
        if(NuevoNombre==null){
            return;
        }
        ColumnMetaDatas meta=(ColumnMetaDatas)cursor.getMetaData();
        meta.setName(NuevoNombre);
        
    } catch (NoSuchTableException | java.lang.NullPointerException ex) {
        JOptionPane.showMessageDialog(frame,"Por favor seleccione una tabla");}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btn_addTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addTableActionPerformed

        creartabla ceartabla = new creartabla();
        ceartabla.setVisible(true);
        ceartabla.setStorage(Almacenamiento, this);
        contadorID++;
        dispose();
    }//GEN-LAST:event_btn_addTableActionPerformed

    private void btn_addColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addColumnActionPerformed
        
    try {
        String Elemento = (String) jList1.getSelectedValue();
        Tables tablaseleccion = (Tables)Almacenamiento.getTable(TablaIndex.get(Elemento));
        crearColumna agregar = new crearColumna();
        agregar.setTable(tablaseleccion, this);
        agregar.setVisible(true);
        dispose();
          
    } catch (NoSuchTableException | java.lang.NullPointerException ex) {
        JOptionPane.showMessageDialog(frame,"Por favor seleccione una tabla");
    }
    }//GEN-LAST:event_btn_addColumnActionPerformed

    private void btn_deleteColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteColumnActionPerformed
        
        try {
        String Elemento = (String) jList1.getSelectedValue();
        Tables tablaseleccion = (Tables)Almacenamiento.getTable(TablaIndex.get(Elemento));
        ColumnCursors cursor=(ColumnCursors)tablaseleccion.getColumns(DataStructure.DOUBLYLINKEDLIST);
        String Nombre= JOptionPane.showInputDialog("Por favor ingrese el nombre de la columna");
        if(Nombre==null){
            return;
        }
        //tablaseleccion.renameColumn(in, NuevoNombre);
        boolean bandera=true;
        while(bandera){
            if(Nombre.equals(cursor.getMetaData().getName())){
                break;
            }
            bandera=cursor.next();
            
        }
        if(!bandera){
                JOptionPane.showMessageDialog(frame,"Columna no encontrada");
                return;
            }
        tablaseleccion.dropColumn(cursor.getMetaData().getId());
        
        } catch (NoSuchTableException | java.lang.NullPointerException | NoSuchColumnException ex) {
        JOptionPane.showMessageDialog(frame,"Por favor seleccione una tabla");
    }
    }//GEN-LAST:event_btn_deleteColumnActionPerformed

    private void btn_addRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addRowActionPerformed
        String Elemento = (String) jList1.getSelectedValue();
    try {
        Tables tablaseleccion = (Tables)Almacenamiento.getTable(TablaIndex.get(Elemento));
        agregarfila fila=new agregarfila();
        fila.setVisible(true);
        fila.setStorage(tablaseleccion,this);
        dispose();
        
    } catch (NoSuchTableException | java.lang.NullPointerException ex) {
        JOptionPane.showMessageDialog(frame,"Por favor seleccione una tabla");
    }
    
        
        
        
    }//GEN-LAST:event_btn_addRowActionPerformed

    private void btn_deleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteRowActionPerformed
        
    try {
        String Elemento = (String) jList1.getSelectedValue();
        Tables tablaseleccion = (Tables)Almacenamiento.getTable(TablaIndex.get(Elemento));
        String indice= JOptionPane.showInputDialog("Por favor ingrese el id de la fila");
        if(indice==null){
            return;
        }
        int intnum;
        intnum = Integer.parseInt(indice); 
        tablaseleccion.deleteRow(intnum);
        
    } catch (NoSuchTableException | NoSuchRowException | java.lang.NullPointerException ex) {
        JOptionPane.showMessageDialog(frame,"Por favor seleccione una tabla");
    }
        
        
    }//GEN-LAST:event_btn_deleteRowActionPerformed

    private void btn_deleteTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteTableActionPerformed
        String Elemento = (String) jList1.getSelectedValue(); 
    try {
        
        Almacenamiento.deleteTable(TablaIndex.get(Elemento));
        TablaIndex.remove(Elemento);
        modelojlist.removeElement(Elemento);
        
    } catch (NoSuchTableException | java.lang.NullPointerException ex) {
        JOptionPane.showMessageDialog(frame,"Por favor seleccione una tabla");
    } 
    }//GEN-LAST:event_btn_deleteTableActionPerformed

    private void btn_changeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeNameActionPerformed
    String Elemento = (String) jList1.getSelectedValue();
    try {
        TableMetaDatas meta=(TableMetaDatas)Almacenamiento.getTable(TablaIndex.get(Elemento)).getTableMetaData();
        String NuevoNombre= JOptionPane.showInputDialog("Por favor ingrese el nuevo nombre");
        if(NuevoNombre==null){
            return;
        }
        meta.setName(NuevoNombre);
        int indice=TablaIndex.get(Elemento);
        TablaIndex.remove(Elemento);
        TablaIndex.put(NuevoNombre, indice);
        modelojlist.removeElement(Elemento);
        modelojlist.addElement(NuevoNombre);
        jLabel1.setText(NuevoNombre);
        
        
        
    } catch (NoSuchTableException | java.lang.NullPointerException ex) {
        JOptionPane.showMessageDialog(frame,"Por favor seleccione una tabla");
    }
        
    }//GEN-LAST:event_btn_changeNameActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        String Elemento = (String) jList1.getSelectedValue();
        jLabel1.setText(Elemento);
    try {
        ColumnCursors columnas = (ColumnCursors)Almacenamiento.getTable(TablaIndex.get(Elemento)).getColumns(DataStructure.DOUBLYLINKEDLIST);
        RowCursors filas = (RowCursors)Almacenamiento.getTable(TablaIndex.get(Elemento)).getRows(DataStructure.DOUBLYLINKEDLIST);
        String Datos [][]={};
        boolean bandera=true;
        ArrayList arreglo=new ArrayList();
        while(bandera){
            arreglo.add(columnas.getElement().getMetaData().getName());
            bandera=columnas.next();
            
        }
        String [] nombres = new String [arreglo.size()];
        for(int i=0;i<arreglo.size();i++){
            nombres[i]=(String)arreglo.get(i);
        }
        Modelo = new DefaultTableModel(Datos, nombres);
        tabla.setModel(Modelo);
        bandera=true;
        while(bandera){
            String [] arreglo2= new String [filas.getElement().getMetaData().getColumnCount()];
            for(int i=0; i<filas.getElement().getMetaData().getColumnCount();i++){
                arreglo2[i]=(String)filas.getElement().getElement(i);
            }
            bandera=filas.next();
            Modelo.addRow(arreglo2);
        }
       
        }
        catch (NoSuchTableException ex) {
        JOptionPane.showMessageDialog(frame,"Por favor seleccione una tabla");}  
        catch(java.lang.NullPointerException e){}
            
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
    try {
        MetaTabla metadatos = new MetaTabla();
        String Elemento = (String) jList1.getSelectedValue();
        TableMetaDatas meta=(TableMetaDatas)Almacenamiento.getTable(TablaIndex.get(Elemento)).getTableMetaData();
        metadatos.setTalble(meta, this);
        metadatos.setVisible(true);
        dispose();
    
    
    } catch (NoSuchTableException | java.lang.NullPointerException ex) {
        JOptionPane.showMessageDialog(frame,"Por favor seleccione una tabla");
    }
       
        
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        String Elemento = (String) jList1.getSelectedValue();
        Tables tablaseleccion = (Tables)Almacenamiento.getTable(TablaIndex.get(Elemento));
        ColumnCursors cursor=(ColumnCursors)tablaseleccion.getColumns(DataStructure.DOUBLYLINKEDLIST);
        String Nombre= JOptionPane.showInputDialog("Por favor ingrese el nombre de la columna");
        if(Nombre==null){
            return;
        }
        boolean bandera=true;
        while(bandera){
            if(Nombre.equals(cursor.getMetaData().getName())){
                break;
            }
            bandera=cursor.next();
            
        }
        if(!bandera){
                JOptionPane.showMessageDialog(frame,"Columna no encontrada");
                return;
            }
        Metacolu metacolumna = new Metacolu();
        metacolumna.setColum(cursor.getElement().getMetaData(), this);
        metacolumna.setVisible(true);
        } catch (NoSuchTableException | java.lang.NullPointerException ex) {
        JOptionPane.showMessageDialog(frame,"Por favor seleccione una tabla");
    }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton btn_changeName;
    private javax.swing.JButton btn_deleteColumn;
    private javax.swing.JButton btn_deleteRow;
    private javax.swing.JButton btn_deleteTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private DefaultListModel modelo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
