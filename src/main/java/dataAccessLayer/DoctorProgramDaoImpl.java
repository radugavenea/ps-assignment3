package dataAccessLayer;

import dataAccessUtils.GenericDAO;
import entities.DoctorProgramEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by radu on 05.05.2017.
 */
public class DoctorProgramDaoImpl extends GenericDAO<DoctorProgramEntity> implements DoctorProgramDao {

    public DoctorProgramDaoImpl(String connectionUrl) {
        super(connectionUrl);
    }

    @Override
    public DoctorProgramEntity getByIdDoctorProgram(int id) throws SQLException {
        return super.getById(id);
    }

    @Override
    public List<DoctorProgramEntity> getAllDoctorPrograms() throws SQLException {
        return super.getAll();
    }

    @Override
    public int addNewDoctorProgram(DoctorProgramEntity instance) throws SQLException {
        return super.addNew(instance);
    }

    @Override
    public int updateDoctorProgram(DoctorProgramEntity instance) throws SQLException {
        return super.update(instance);
    }

    @Override
    public int deleteByIdDoctorProgram(int id) throws SQLException {
        return super.deleteById(id);
    }

    @Override
    public List<DoctorProgramEntity> getDoctorProgramByDoctorId(int id) throws SQLException {
        return super.getAllByFieldId(id, 3);
    }
}
