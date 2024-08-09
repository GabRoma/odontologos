package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Model.Odontologo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OdontologoDAOTest {
    private OdontologoDAO odontologoDAO;

    @Before
    public void setUp() {
        // Cambiar la implementación según el tipo de persistencia que se quiera probar
        odontologoDAO = new OdontologoDAOLista(); // Para probar con lista
//        odontologoDAO = new OdontologoDAOH2(); // Para probar con base de datos H2
    }

    @Test
    public void testGuardarYListarOdontologos() {
        Odontologo odontologo1 = new Odontologo(1, "Juan", "Pérez");
        Odontologo odontologo2 = new Odontologo(2, "Ana", "García");

        odontologoDAO.guardar(odontologo1);
        odontologoDAO.guardar(odontologo2);

        List<Odontologo> odontologos = odontologoDAO.listarTodos();

        Assert.assertEquals(2, odontologos.size());
        Assert.assertEquals("Juan", odontologos.get(0).getNombre());
        Assert.assertEquals("Ana", odontologos.get(1).getNombre());
    }

    // Método auxiliar para obtener la conexión a H2 (en caso de probar con H2)
    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con H2", e);
        }
    }
}