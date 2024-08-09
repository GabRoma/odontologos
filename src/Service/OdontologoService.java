package Service;

import DAO.OdontologoDAO;
import DAO.OdontologoDAOH2;
import Model.Odontologo;
import java.util.List;

public class OdontologoService {
    private OdontologoDAO odontologoDao;

    public OdontologoService() {
        odontologoDao = new OdontologoDAOH2();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoDao.guardar(odontologo);
    }

    public List<Odontologo> listarTodos(){
        return odontologoDao.listarTodos();
    }
}
