/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddsimoba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class RevisarDenuncias extends javax.swing.JInternalFrame {

    /**
     * Creates new form RevisarDenuncias
     */
    public RevisarDenuncias() {
        initComponents();
        mostrarTabla();
    }

    void mostrarTabla(){
        // Conexión a la base de datos
        ConexionDB conexion = new ConexionDB();
        
        // Creamos el modelo de la tabla
        DefaultTableModel modelotabla =  new DefaultTableModel();
        
        // Creamos consulta
        String consulta = "SELECT * FROM denuncia WHERE revisada=0";
        
        // Añadimos los nombres a las columnas:
        modelotabla.setColumnIdentifiers(new Object[]{"Cuenta_denunciada",
            "Cuenta_denunciante", "fecha"});
        
        
        //Obtenemos resultados de la consulta
        ResultSet rs = conexion.creaTabla(consulta);
        
        // Rellenamos la tabla:
        try{
            
            while(rs.next()){
                //Añadimos filas al modelo
                modelotabla.addRow(new Object[]{rs.getString("nombrec1"),
                            rs.getString("nombrec2"),rs.getString("fecha")});
            }
            
            this.table.setModel(modelotabla);
            
            conexion.cerrarConexionDB();
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
            throw new RuntimeException(e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        procesar = new javax.swing.JButton();
        ignorar = new javax.swing.JButton();
        refrescar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Revisar Denuncias");

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        procesar.setText("Procesar");
        procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarActionPerformed(evt);
            }
        });

        ignorar.setText("Ignorar");
        ignorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ignorarActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(procesar)
                .addGap(52, 52, 52)
                .addComponent(ignorar)
                .addGap(113, 113, 113))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(131, 131, 131)
                    .addComponent(refrescar)
                    .addContainerGap(373, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(procesar)
                    .addComponent(ignorar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(268, Short.MAX_VALUE)
                    .addComponent(refrescar)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void procesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarActionPerformed
int fila = this.table.getSelectedRow();
        
        if(fila != -1){
            String cuentaSelecc = this.table.getValueAt(fila,0).toString();
            
            ConexionDB conexion = new ConexionDB();
            
            PreparedStatement pstm1 = null, pstm2 = null;
            //String consulta_aux = "UPDATE cuentapertenece SET karma=0 WHERE nombre = ?";
            String consulta_aux = "DELETE FROM cuentapertenece WHERE nombre = ?";
            String consulta_aux2 = "UPDATE denuncia SET revisada=2 WHERE nombrec1 = ?";
            
            try{
                pstm1 = conexion.con.prepareStatement(consulta_aux);
                pstm1.setString(1, cuentaSelecc);
                int resultado = pstm1.executeUpdate();

                if(resultado>0){
                    JOptionPane.showMessageDialog(null, "Se ha modificado la fila correctamente", "Alerta ", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    throw new RuntimeException("No se pudo modificar la fila.");
                }
            
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
                throw new RuntimeException(ex);
             
             }finally{
            
                    try{
                        if(pstm1!=null) pstm1.close();
                     }catch(SQLException ex){
                           ex.printStackTrace(System.out);
                            throw new RuntimeException(ex);
                    }
            }
            
            
            try{
                pstm2 = conexion.con.prepareStatement(consulta_aux2);
                pstm2.setString(1, cuentaSelecc);
                int resultado = pstm2.executeUpdate();

                if(resultado>0){
                    JOptionPane.showMessageDialog(null, "Se han modificado las filas correctamente", "Alerta ", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    throw new RuntimeException("No se pudieron modificar las filas.");
                }
            
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
                throw new RuntimeException(ex);
             
            }finally{
            
                    try{
                        if(pstm1!=null) pstm1.close();
                        if(conexion.con!=null) conexion.cerrarConexionDB();
                     }catch(SQLException ex){
                           ex.printStackTrace(System.out);
                            throw new RuntimeException(ex);
                    }
            }
        }else{
            
            JOptionPane.showMessageDialog(null, "Necesita seleccionar una fila de la lista", "Alerta ", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }//GEN-LAST:event_procesarActionPerformed

    private void refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarActionPerformed
        this.mostrarTabla();
    }//GEN-LAST:event_refrescarActionPerformed

    private void ignorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ignorarActionPerformed
        int fila = this.table.getSelectedRow();
        
        if(fila != -1){
            String cuentaSelecc1 = this.table.getValueAt(fila,0).toString(),
                   cuentaSelecc2 = this.table.getValueAt(fila,1).toString(),
                   fecha = this.table.getValueAt(fila,2).toString();
            
            ConexionDB conexion = new ConexionDB();
            
            PreparedStatement pstm = null;
            String consulta_aux = "UPDATE denuncia SET revisada=1 WHERE nombrec1 = ? and nombrec2 = ? and fecha = ?";
            
            try{
                pstm = conexion.con.prepareStatement(consulta_aux);
                pstm.setString(1, cuentaSelecc1);
                pstm.setString(2, cuentaSelecc2);
                pstm.setString(3, fecha);

                int resultado = pstm.executeUpdate();
                if(resultado==1){
                    JOptionPane.showMessageDialog(null, "Se ha modificado la fila correctamente", "Alerta ", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    throw new RuntimeException("No se pudo modificar la fila.");
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
    }//GEN-LAST:event_ignorarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ignorar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton procesar;
    private javax.swing.JButton refrescar;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
