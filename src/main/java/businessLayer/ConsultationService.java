package businessLayer;

import entities.ConsultationEntity;
import entities.PatientEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Observer;

/**
 * Created by radu on 06.05.2017.
 */
public interface ConsultationService {
    List<ConsultationEntity> getAllConsultations() throws SQLException;
    int addNewConsultation(ConsultationEntity consultation) throws SQLException;
    int editConsultation(ConsultationEntity consultation) throws SQLException;
    int deleteByIdConsultation(int id) throws SQLException;
    List<String> getMappedConsultationById(int id) throws SQLException;
    List<ConsultationEntity> getAllByPatientId(int patientId) throws SQLException;
    void addObserver(Observer o);
}
