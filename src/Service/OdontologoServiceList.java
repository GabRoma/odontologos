package Service;

import DAO.OdontologoDAO;
import DAO.OdontologoDAOLista;
import Model.Odontologo;
import java.util.List;

public class OdontologoServiceList {
    private OdontologoDAO odontologoLista;

    public OdontologoServiceList() {
        odontologoLista = new OdontologoDAOLista();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoLista.guardar(odontologo);
    }

    public List<Odontologo> listarTodos(){
        return odontologoLista.listarTodos();
    }
}
