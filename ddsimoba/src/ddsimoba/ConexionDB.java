/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddsimoba;

import java.sql.*;


/**
 *
 * @author domin
 */
public class ConexionDB {
    
    // Nos sirve para cargar el driver de Mysql y hacer el JDBC
    public String driver = "com.mysql.cd.jdbc.Driver";
    
    //Nombre de la base de datos
    public String database ="ddsimoba";
    
    //Host
    public String hostname = "localhost";
    
    //Puerto
    public String port ="3306";
    
    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    
    //Nombre de usuario
    public String username ="root";
    
    //Clave de usuario
    public String password ="1234";
    
    public Connection con = null;
    
    public ConexionDB(){
        
        
        //intentamos la conexión
        try{
            
            //Class.forName(driver);Esto no es necesario en la versión actual del driver
            con =  DriverManager.getConnection(url, username, password);
            
           }catch(/*ClassNotFoundException | */SQLException e){
               e.printStackTrace(System.out);
               throw new RuntimeException(e);
           }
        
    }   
        
    
    public void cerrarConexionDB(){
        
      try{
      this.con.close();
      }catch(SQLException e){
          e.printStackTrace(System.out);
          throw new RuntimeException(e);
      }
        
        
    }
    
    //Va a crear una tabla con la consulta que le pongamos
    public ResultSet creaTabla(String consulta){
        
        Statement st = null;
        ResultSet datosTabla = null;
        
        try{
            st = this.con.createStatement();
            datosTabla = st.executeQuery(consulta);
        }catch(SQLException e){
            e.printStackTrace(System.out);
            throw new RuntimeException(e);
        }
        
        return datosTabla;
        
    }
    
    
    
}
