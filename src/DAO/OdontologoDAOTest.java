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
    private OdontologoDAO odontologoDAOH2;
    private OdontologoDAO odontologoDAOLista;

    @Before
    public void setUp() {
        DB.crearTablaOdontologo();
        odontologoDAOH2 = new OdontologoDAOH2();
        odontologoDAOLista = new OdontologoDAOLista();
    }

    @Test
    public void testGuardarOdontologoH2() {
        Odontologo odontologo = new Odontologo(1, "Juan", "Pérez");
        odontologoDAOH2.guardar(odontologo);

        List<Odontologo> odontologos = odontologoDAOH2.listarTodos();
        Assert.assertTrue(odontologos.contains(odontologo));
    }

    @Test
    public void testGuardarOdontologoEnLista() {
        Odontologo odontologo = new Odontologo(2, "Ana", "García");
        odontologoDAOLista.guardar(odontologo);

        List<Odontologo> odontologos = odontologoDAOLista.listarTodos();
        Assert.assertTrue(odontologos.contains(odontologo));
    }

    @Test
    public void testListarOdontologosH2() {
        Odontologo odontologo1 = new Odontologo(3, "Luis", "Martínez");
        Odontologo odontologo2 = new Odontologo(4, "María", "Fernández");
        odontologoDAOH2.guardar(odontologo1);
        odontologoDAOH2.guardar(odontologo2);

        List<Odontologo> odontologos = odontologoDAOH2.listarTodos();
        Assert.assertEquals(2, odontologos.size());
        Assert.assertTrue(odontologos.contains(odontologo1));
        Assert.assertTrue(odontologos.contains(odontologo2));
    }

    @Test
    public void testListarOdontologosDeLista() {
        Odontologo odontologo1 = new Odontologo(5, "Carlos", "González");
        Odontologo odontologo2 = new Odontologo(6, "Laura", "Ramírez");
        odontologoDAOLista.guardar(odontologo1);
        odontologoDAOLista.guardar(odontologo2);

        List<Odontologo> odontologos = odontologoDAOLista.listarTodos();
        Assert.assertEquals(2, odontologos.size());
        Assert.assertTrue(odontologos.contains(odontologo1));
        Assert.assertTrue(odontologos.contains(odontologo2));
    }

    @Test
    public void testGuardarYListarOdontologosH2() {
        Odontologo odontologo = new Odontologo(7, "Pedro", "López");
        odontologoDAOH2.guardar(odontologo);

        List<Odontologo> odontologos = odontologoDAOH2.listarTodos();
        Assert.assertEquals(1, odontologos.size());
        Assert.assertEquals("Pedro", odontologos.get(0).getNombre());
    }

    @Test
    public void testGuardarYListarOdontologosEnLista() {
        Odontologo odontologo = new Odontologo(8, "Lucía", "Sánchez");
        odontologoDAOLista.guardar(odontologo);

        List<Odontologo> odontologos = odontologoDAOLista.listarTodos();
        Assert.assertEquals(1, odontologos.size());
        Assert.assertEquals("Lucía", odontologos.get(0).getNombre());
    }
}