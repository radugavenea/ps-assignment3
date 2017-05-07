package dataAccessLayer;

import dataAccessUtils.GenericDAO;
import entities.ConsultationEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by radu on 05.05.2017.
 */
public class ConsultationDaoImpl extends GenericDAO<ConsultationEntity> implements ConsultationDao{

    public ConsultationDaoImpl(String connectionUrl) {
        super(connectionUrl);
    }

    @Override
    public ConsultationEntity getByIdConsultation(int id) throws SQLException {
        return super.getById(id);
    }

    @Override
    public List<ConsultationEntity> getAllConsultations() throws SQLException {
        return super.getAll();
    }

    @Override
    public int addNewConsultation(ConsultationEntity instance) throws SQLException {
        return super.addNew(instance);
    }

    @Override
    public int updateConsultation(ConsultationEntity instance) throws SQLException {
        return super.update(instance);
    }

    @Override
    public int deleteByIdConsultation(int id) throws SQLException {
        return super.deleteById(id);
    }

    @Override
    public List<ConsultationEntity> getAllByPatientId(int id, int patientIdIndex) throws SQLException {
        return super.getAllByField(id,patientIdIndex);
    }
}
