/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddsimoba;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author noelia
 */
public class ListarArticulos extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListarArticulos
     */
    public ListarArticulos() {
        initComponents();
        mostrarTabla();
    }
    
    public void mostrarTabla() {
        
        // Creamos conexión con la BBDD
        ConexionDB conex = new ConexionDB();
        
        // Creamos el modelo de la tabla
        //Creamos el modelo de la tabla
        DefaultTableModel modelotabla =  new DefaultTableModel();
        
        //Creamos la consulta
        String consulta = "SELECT * FROM tienda";
        //Obtenemos resultados de la consulta
        ResultSet rs = conex.creaTabla(consulta);
        
        //Modificamos el modelo para decirle que las columnas llevan dichos identificadores ó nombres que aparecerán
        modelotabla.setColumnIdentifiers(new Object[]{"ID","Nombre","Descripción","Precio"});
    
        //Iniciamos el relleno de la tabla
        
        try{
            
            while(rs.next()){ //Iteramos sobre el ResultSet
                //Añadimos filas al modelo
                modelotabla.addRow(new Object[]{rs.getString("idarticulo"),rs.getString("nombre"),rs.getString("descripcion"), rs.getString("precio")});
            }
            
            this.tabla.setModel(modelotabla);
            
            conex.cerrarConexionDB();
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        borrarArticulo = new javax.swing.JButton();
        modificarArticulo = new javax.swing.JButton();
        refrescar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de artículos");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        borrarArticulo.setText("Borrar artículo");
        borrarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarArticuloActionPerformed(evt);
            }
        });

        modificarArticulo.setText("Modificar artículo");
        modificarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarArticuloActionPerformed(evt);
            }
        });

        refrescar.setText("Refrescar");
        refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(borrarArticulo)
                        .addGap(62, 62, 62)
                        .addComponent(modificarArticulo)
                        .addGap(125, 125, 125)
                        .addComponent(refrescar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrarArticulo)
                    .addComponent(modificarArticulo)
                    .addComponent(refrescar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void borrarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarArticuloActionPerformed
        int numeroFila = this.tabla.getSelectedRow();
        int numeroColumnas = this.tabla.getColumnCount();
        
        if(numeroFila != -1){
            String artSelected = this.tabla.getValueAt(numeroFila,0).toString();
            
            ConexionDB conexion = new ConexionDB();
            
            PreparedStatement pstm = null;   
                String sqlQuery = "DELETE FROM tienda WHERE idarticulo = ?";
                
            try{
            
            
            pstm = conexion.con.prepareStatement(sqlQuery);
            pstm.setString(1, artSelected);
        
            int resultado = pstm.executeUpdate();
        
                    if(resultado ==1){
            
                        JOptionPane.showMessageDialog(null, "Se ha eliminado la fila correctamente", "Alerta ", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        throw new RuntimeException("No se pudo eliminar la fila la fila");
                    }
            
             }catch(SQLException ex){
                ex.printStackTrace(System.out);
                throw new RuntimeException(ex);
             
             }finally{
            
                    try{
                        if(pstm!=null) pstm.close();
                        if(conexion.con!=null) conexion.cerrarConexionDB();
                     }catch(SQLException ex){
                           ex.printStackTrace(System.out);
                            throw new RuntimeException(ex);
                    }
            }
        }else{
            
            JOptionPane.showMessageDialog(null, "Necesita seleccionar una fila de la lista", "Alerta ", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }//GEN-LAST:event_borrarArticuloActionPerformed

    private void modificarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarArticuloActionPerformed
        int numeroFila = this.tabla.getSelectedRow();
        int numeroColumnas = this.tabla.getColumnCount();
        
        if (numeroFila!=-1){
            ArrayList<String> datosFila = new ArrayList<>();
            
            for(int i = 0; i< numeroColumnas; i++){
                datosFila.add(this.tabla.getValueAt(numeroFila, i).toString());   
            }
            
            FormularioModificacionArticulo modi = new FormularioModificacionArticulo(datosFila.get(0),datosFila.get(1),datosFila.get(2));
        
            VentanaPrincipal.escritorio.add(modi);
            
            modi.toFront();
            modi.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Necesita seleccionar una fila de la lista", "Alerta ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_modificarArticuloActionPerformed

    private void refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarActionPerformed
        this.mostrarTabla();
    }//GEN-LAST:event_refrescarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarArticulo;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarArticulo;
    private javax.swing.JButton refrescar;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
