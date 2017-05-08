package dataAccessLayer;

import entities.ConsultationEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by radu on 06.05.2017.
 */
public interface ConsultationDao {
    ConsultationEntity getByIdConsultation(int id) throws SQLException;
    List<ConsultationEntity> getAllConsultations() throws SQLException;
    int addNewConsultation(ConsultationEntity instance) throws SQLException;
    int updateConsultation(ConsultationEntity instance) throws SQLException;
    int deleteByIdConsultation(int id) throws SQLException;
    List<ConsultationEntity> getAllByPatientId(int id, int patientIdIndex) throws SQLException;
    List<ConsultationEntity> getAllByDoctorsName(String name) throws SQLException;
}
