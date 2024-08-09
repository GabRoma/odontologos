package DAO;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.lang.*;
public class DB {
    private static final Logger logger= Logger.getLogger(DB.class);
    private static final String SQL_DROP_CREATE_ODONTOLOGOS = " DROP TABLE IF EXISTS ODONTOLOGOS; " + " CREATE TABLE ODONTOLOGOS(ID INT AUTO_INCREMENT PRIMARY KEY, MATRICULA INT NOT NULL, NOMBRE VARCHAR(30) NOT NULL, APELLIDO VARCHAR(30) NOT NULL)";
    public static void crearTablaOdontologo(){
        Connection connection=null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE_ODONTOLOGOS);
            logger.info("La tabla fue creada con exito");
        }catch (Exception e){
            logger.error("Ha ocurrido un error: "+e.getMessage());
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/Odontologos","sa","");
    }
}
