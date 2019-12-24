/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddsimoba;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class ResultadoConsultasDenuncias extends javax.swing.JInternalFrame {

    /**
     * Creates new form ResultadoConsultasDenuncias
     */
    public ResultadoConsultasDenuncias(String consulta) {
        initComponents();
        generarConsulta(consulta);
    }

    void generarConsulta(String consulta){
        
        // Conexión a la base de datos
        ConexionDB conexion = new ConexionDB();
        
        // Creamos el modelo de la tabla
        DefaultTableModel modelotabla =  new DefaultTableModel();
        
        // Añadimos los nombres a las columnas:
        modelotabla.setColumnIdentifiers(new Object[]{"Cuenta_denunciada",
            "Cuenta_denunciante", "fecha", "revisada"});
        
        //Obtenemos resultados de la consulta
        ResultSet rs = conexion.creaTabla(consulta);
        
        // Rellenamos la tabla:
        try{
            
            while(rs.next()){
                //Añadimos filas al modelo
                modelotabla.addRow(new Object[]{rs.getString("nombrec1"),rs.getString("nombrec2"),
                            rs.getString("fecha"), rs.getString("revisada")});
            }
            
            this.tabla.setModel(modelotabla);
            
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
        tabla = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Resultado");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
