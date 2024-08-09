import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import Service.OdontologoServiceH2;
import Service.OdontologoServiceList;
import Model.Odontologo;

import java.util.List;

public class OdontologoServiceTest {
    private OdontologoServiceH2 odontologoServiceH2;
    private OdontologoServiceList odontologoServiceList;

    @Before
    public void setUp() {
        // Inicialización de los servicios
        odontologoServiceH2 = new OdontologoServiceH2();
        odontologoServiceList = new OdontologoServiceList();

        // Crear la tabla Odontologos en la base de datos H2
        DAO.DB.crearTablaOdontologo();
    }

    @Test
    public void testGuardarOdontologoH2() {
        Odontologo odontologo = new Odontologo(1, "Juan", "Pérez");
        odontologoServiceH2.guardarOdontologo(odontologo);

        List<Odontologo> odontologos = odontologoServiceH2.listarTodos();
        Assert.assertEquals(1, odontologos.size());

        Odontologo odontologoGuardado = odontologos.get(0);
        Assert.assertEquals(odontologo.getMatricula(), odontologoGuardado.getMatricula());
        Assert.assertEquals(odontologo.getNombre(), odontologoGuardado.getNombre());
        Assert.assertEquals(odontologo.getApellido(), odontologoGuardado.getApellido());
    }

    @Test
    public void testGuardarOdontologoEnLista() {
        Odontologo odontologo = new Odontologo(2, "Ana", "García");
        odontologoServiceList.guardarOdontologo(odontologo);

        List<Odontologo> odontologos = odontologoServiceList.listarTodos();
        Assert.assertEquals(1, odontologos.size());

        Odontologo odontologoGuardado = odontologos.get(0);
        Assert.assertEquals(odontologo.getMatricula(), odontologoGuardado.getMatricula());
        Assert.assertEquals(odontologo.getNombre(), odontologoGuardado.getNombre());
        Assert.assertEquals(odontologo.getApellido(), odontologoGuardado.getApellido());
    }

    @Test
    public void testListarOdontologosH2() {
        Odontologo odontologo1 = new Odontologo(3, "Luis", "Martínez");
        Odontologo odontologo2 = new Odontologo(4, "María", "Fernández");
        odontologoServiceH2.guardarOdontologo(odontologo1);
        odontologoServiceH2.guardarOdontologo(odontologo2);

        List<Odontologo> odontologos = odontologoServiceH2.listarTodos();
        Assert.assertEquals(2, odontologos.size());

        Odontologo odontologoRecuperado1 = odontologos.get(0);
        Odontologo odontologoRecuperado2 = odontologos.get(1);

        Assert.assertEquals(odontologo1.getMatricula(), odontologoRecuperado1.getMatricula());
        Assert.assertEquals(odontologo1.getNombre(), odontologoRecuperado1.getNombre());
        Assert.assertEquals(odontologo1.getApellido(), odontologoRecuperado1.getApellido());

        Assert.assertEquals(odontologo2.getMatricula(), odontologoRecuperado2.getMatricula());
        Assert.assertEquals(odontologo2.getNombre(), odontologoRecuperado2.getNombre());
        Assert.assertEquals(odontologo2.getApellido(), odontologoRecuperado2.getApellido());
    }

    @Test
    public void testListarOdontologosEnLista() {
        Odontologo odontologo1 = new Odontologo(5, "Carlos", "González");
        Odontologo odontologo2 = new Odontologo(6, "Laura", "Ramírez");
        odontologoServiceList.guardarOdontologo(odontologo1);
        odontologoServiceList.guardarOdontologo(odontologo2);

        List<Odontologo> odontologos = odontologoServiceList.listarTodos();
        Assert.assertEquals(2, odontologos.size());

        Odontologo odontologoRecuperado1 = odontologos.get(0);
        Odontologo odontologoRecuperado2 = odontologos.get(1);

        Assert.assertEquals(odontologo1.getMatricula(), odontologoRecuperado1.getMatricula());
        Assert.assertEquals(odontologo1.getNombre(), odontologoRecuperado1.getNombre());
        Assert.assertEquals(odontologo1.getApellido(), odontologoRecuperado1.getApellido());

        Assert.assertEquals(odontologo2.getMatricula(), odontologoRecuperado2.getMatricula());
        Assert.assertEquals(odontologo2.getNombre(), odontologoRecuperado2.getNombre());
        Assert.assertEquals(odontologo2.getApellido(), odontologoRecuperado2.getApellido());
    }
}
