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
public class ListarEquipos extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListarEquipos
     */
    public ListarEquipos() {
        initComponents();
        mostrarTabla();
    }

        public void mostrarTabla(){
        
        // Creamos conexión con la BBDD
        ConexionDB conex = new ConexionDB();
        
        //Creamos el modelo de la tabla
        DefaultTableModel modelotabla =  new DefaultTableModel();
        
        //Creamos la consulta
        String consulta = "SELECT idequipo,nombreequipo,nombre FROM cuentapertenece NATURAL JOIN equipo";
        //Obtenemos resultados de la consulta
        ResultSet rs = conex.creaTabla(consulta);
        
        //Modificamos el modelo para decirle que las columnas llevan dichos identificadores ó nombres que aparecerán
        modelotabla.setColumnIdentifiers(new Object[]{"ID","Nombre Equipo","Nombre usuario"});
    
        //Iniciamos el relleno de la tabla
        
        try{
            
            while(rs.next()){ //Iteramos sobre el ResultSet
                //Añadimos filas al modelo
                modelotabla.addRow(new Object[]{rs.getString("idequipo"),rs.getString("nombreequipo"),rs.getString("nombre")});
            }
            
            this.tabla.setModel(modelotabla);
            
            conex.cerrarConexionDB();
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
            throw new RuntimeException(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nuevoNombre = new javax.swing.JTextField();
        cambiarNombre = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Equipos");

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

        jLabel1.setText("Cambiar nombre");

        cambiarNombre.setText("OK");
        cambiarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cambiarNombre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cambiarNombre))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cambiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarNombreActionPerformed
        int fila = this.tabla.getSelectedRow();
        
        if(fila != -1){
            String equipoSelecc = this.tabla.getValueAt(fila,0).toString();
            
            ConexionDB conexion = new ConexionDB();
            
            PreparedStatement pstm = null;
            String consulta_aux = "UPDATE equipo SET nombreequipo=? WHERE idequipo=?";
            
            try{
                pstm = conexion.con.prepareStatement(consulta_aux);
                pstm.setString(1, nuevoNombre.getText());
                pstm.setString(2, equipoSelecc);
                int resultado = pstm.executeUpdate();

                if(resultado>0){
                    JOptionPane.showMessageDialog(null, "Se han modificado las filas correctamente", "Alerta ", JOptionPane.INFORMATION_MESSAGE);
                    mostrarTabla();
                }else{
                    throw new RuntimeException("No se pudieron modificar las filas.");
                }
            
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
                throw new RuntimeException(ex);
             
             }finally{
            
                    try{
                        if(pstm!=null) pstm.close();
                     }catch(SQLException ex){
                           ex.printStackTrace(System.out);
                            throw new RuntimeException(ex);
                    }
            }
        }
    }//GEN-LAST:event_cambiarNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiarNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nuevoNombre;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
