package DAO;
import Model.Odontologo;

import java.util.List;

public interface OdontologoDAO {
    Odontologo guardar(Odontologo odontologo);
    List<Odontologo> listarTodos();
}