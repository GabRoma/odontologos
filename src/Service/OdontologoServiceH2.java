package Service;

import DAO.OdontologoDAO;
import DAO.OdontologoDAOH2;
import Model.Odontologo;
import java.util.List;

public class OdontologoServiceH2 {
    private OdontologoDAO odontologoH2;

    public OdontologoServiceH2() {
        odontologoH2 = new OdontologoDAOH2();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoH2.guardar(odontologo);
    }

    public List<Odontologo> listarTodos(){
        return odontologoH2.listarTodos();
    }
}
