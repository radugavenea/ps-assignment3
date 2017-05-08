package businessLayer;

import dataAccessLayer.ConsultationDao;
import entities.ConsultationEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by radu on 06.05.2017.
 */
public class ConsultationServiceImpl extends Observable implements ConsultationService {

    private ConsultationDao consultationDao;

    public ConsultationServiceImpl(ConsultationDao consultationDao) {
        this.consultationDao = consultationDao;
    }


    @Override
    public List<ConsultationEntity> getAllConsultations() throws SQLException {
        return consultationDao.getAllConsultations();
    }

    @Override
    public int addNewConsultation(ConsultationEntity consultation, String username) throws SQLException {
        int returnId = consultationDao.addNewConsultation(consultation);
        setChanged();
        notifyObservers(this);
        return returnId;
    }

    @Override
    public int editConsultation(ConsultationEntity consultation) throws SQLException {
        int returnId = consultationDao.updateConsultation(consultation);
        setChanged();
        notifyObservers(this);
        return returnId;
    }

    @Override
    public int deleteByIdConsultation(int id) throws SQLException {
        int returnId = consultationDao.deleteByIdConsultation(id);
        setChanged();
        notifyObservers(this);
        return returnId;
    }

    @Override
    public List<String> getMappedConsultationById(int id) throws SQLException {
        List<String> fields = null;
        ConsultationEntity consultation = consultationDao.getByIdConsultation(id);
        if(consultation != null){
            fields = new ArrayList<>();
            fields.add(Integer.toString(consultation.getId()));
            fields.add(consultation.getStartsAtTime().toString());
            fields.add(consultation.getEndsAtTime().toString());
            fields.add(consultation.getDoctorsName());
            fields.add(Integer.toString(consultation.getUserId()));
            fields.add(Integer.toString(consultation.getPatientId()));
        }
        return fields;
    }

    @Override
    public List<ConsultationEntity> getAllConsultationByDoctorName(String name) throws SQLException {
        return consultationDao.getAllByDoctorsName(name);
    }

    @Override
    public List<ConsultationEntity> getAllByPatientIdForDoctor(int patientId, String doctorName) throws SQLException {
        List<ConsultationEntity> consultationEntities = consultationDao.getAllByPatientId(patientId);
        List<ConsultationEntity> consultations = new ArrayList<>();
        for(int i=0; i<consultationEntities.size(); i++){
            if(consultationEntities.get(i).getDoctorsName().equals(doctorName)){
                consultations.add(consultationEntities.get(i));
            }
        }
        return consultations.isEmpty() ? null : consultations;
    }


}
