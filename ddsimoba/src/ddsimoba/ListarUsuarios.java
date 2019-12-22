/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddsimoba;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author domin
 */
public class ListarUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListarUsuarios
     */
    
    public ListarUsuarios() {
        initComponents();
        mostrarTabla();
    }
       
    public void mostrarTabla(){
        
        //Creamos conexión BBDD
        ConexionDB conex = new ConexionDB();
        
        //Creamos el modelo de la tabla
        DefaultTableModel modelotabla =  new DefaultTableModel();
        
        //Creamos la consulta
        String consulta = "SELECT * FROM cuentapertenece";
        //Obtenemos resultados de la consulta
        ResultSet rs = conex.creaTabla(consulta);
        
        //Modificamos el modelo para decirle que las columnas llevan dichos identificadores ó nombres que aparecerán
        modelotabla.setColumnIdentifiers(new Object[]{"Usuario","idEquipo","Contraseña","Email","Fec_Nac","Servidor","Saldo","Karma"});
    
        //Iniciamos el relleno de la tabla
        
        try{
            
            while(rs.next()){ //Iteramos sobre el ResultSet
                //Añadimos filas al modelo
                modelotabla.addRow(new Object[]{rs.getString("nombre"),rs.getString("idequipo"),rs.getString("contrasena"), rs.getString("correo"), rs.getString("fec_nac"), rs.getString("servidor"), rs.getString("saldo"), rs.getString("karma")});
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista Usuarios");

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
    

