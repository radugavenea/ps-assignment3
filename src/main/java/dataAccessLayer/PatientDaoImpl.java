package dataAccessLayer;

import dataAccessUtils.GenericDAO;
import entities.PatientEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by radu on 05.05.2017.
 */
public class PatientDaoImpl extends GenericDAO<PatientEntity> implements PatientDao {

    public PatientDaoImpl(String connectionUrl) {
        super(connectionUrl);
    }


    @Override
    public PatientEntity getByIdPatient(int id) throws SQLException {
        return super.getById(id);
    }

    @Override
    public List<PatientEntity> getAllPatients() throws SQLException {
        return super.getAll();
    }

    @Override
    public int addNewPatient(PatientEntity instance) throws SQLException {
        return super.addNew(instance);
    }

    @Override
    public int updatePatient(PatientEntity instance) throws SQLException {
        return super.update(instance);
    }

    @Override
    public int deleteByIdPatient(int id) throws SQLException {
        return super.deleteById(id);
    }
}
