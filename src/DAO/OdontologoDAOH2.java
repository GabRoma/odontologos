package DAO;
import java.sql.*;
import java.util.List;
import org.apache.log4j.Logger;
import Model.Odontologo;
import java.lang.*;
public class OdontologoDAOH2 implements OdontologoDAO{
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES(?,?,?)";
    private static final String SQL_SELECT_ONE = "SELECT * FROM ODONTOLOGOS WHERE ID=?";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Realizando guardado del odontólogo: " + odontologo.getNombre());
        Connection connection = null;
        try {
            connection = DB.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setInt(1, odontologo.getMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.execute();
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()) {
                odontologo.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            logger.error("Problemas con la BD " + e.getMessage());
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Realizando listado de odontólogos");
        Connection connection = null;
        try {
            connection = DB.getConnection();

        } catch (Exception e) {
            logger.error("Problemas con la BD " + e.getMessage());
        }
        return List.of();
    }
}
