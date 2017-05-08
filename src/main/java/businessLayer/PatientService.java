package businessLayer;

import entities.PatientEntity;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Observer;

/**
 * Created by radu on 06.05.2017.
 */
public interface PatientService {
    List<PatientEntity> getAllPatients() throws SQLException;
    int addNewPatient(PatientEntity patient) throws SQLException;
    int editPatient(PatientEntity patient) throws SQLException;
    void addObserver(Observer o);
    List<String> getMappedPatientById(int id) throws SQLException;
}
