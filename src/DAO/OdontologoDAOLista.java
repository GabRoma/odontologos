package DAO;

import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Model.Odontologo;
import java.lang.*;

public class OdontologoDAOLista implements OdontologoDAO {
    private static final Logger logger = Logger.getLogger(OdontologoDAOLista.class);
    private List<Odontologo> odontologos;

    public OdontologoDAOLista() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        try {
            odontologos.add(odontologo);
            logger.info("Odontólogo guardado en la lista: " + odontologo.getNombre() + " " + odontologo.getApellido());
        } catch (Exception e) {
            logger.error("Problemas en el guardado " + e.getMessage());
        }
        return odontologo;
    }

        @Override
        public List<Odontologo> listarTodos () {
            logger.info("Odontólogos guardados en la lista");
            return new ArrayList<>(odontologos);
        }
    }