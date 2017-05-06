package dataAccessLayer;

import entities.PatientEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by radu on 06.05.2017.
 */
public interface PatientDao {
    PatientEntity getByIdPatient(int id) throws SQLException;
    List<PatientEntity> getAllPatients() throws SQLException;
    int addNewPatient(PatientEntity instance) throws SQLException;
    int updatePatient(PatientEntity instance) throws SQLException;
    int deleteByIdPatient(int id) throws SQLException;
}
