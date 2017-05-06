package businessLayer;

import dataAccessLayer.PatientDao;
import entities.PatientEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by radu on 06.05.2017.
 */
public class PatientServiceImpl extends Observable implements PatientService {

    private PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public List<PatientEntity> getAllPatients() throws SQLException {
        return patientDao.getAllPatients();
    }

    @Override
    public int addNewPatient(PatientEntity patient) throws SQLException {
        int returnId = patientDao.addNewPatient(patient);
        setChanged();
        notifyObservers(this);
        return returnId;
    }

    @Override
    public int editPatient(PatientEntity patient) throws SQLException {
        int returnId = patientDao.updatePatient(patient);
        setChanged();
        notifyObservers(this);
        return returnId;
    }

    @Override
    public List<String> getMappedPatientById(int id) throws SQLException {
        List<String> fields = new ArrayList<>();
        PatientEntity patient = patientDao.getByIdPatient(id);
        if(patient != null){
            fields.add(Integer.toString(patient.getId()));
            fields.add(patient.getName());
            fields.add(patient.getCardNumber());
            fields.add(patient.getNumericalCode());
            fields.add(patient.getBirthday().toString());
            fields.add(patient.getAddress());
        }
        return fields.isEmpty() ? null : fields;
    }
}
