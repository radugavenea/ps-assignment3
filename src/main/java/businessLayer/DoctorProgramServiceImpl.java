package businessLayer;

import dataAccessLayer.ConsultationDao;
import dataAccessLayer.DoctorProgramDao;
import dataAccessLayer.UserDao;
import entities.ConsultationEntity;
import entities.DoctorProgramEntity;
import entities.UserEntity;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

/**
 * Created by radu on 08.05.2017.
 */
public class DoctorProgramServiceImpl implements DoctorProgramService {

    private DoctorProgramDao doctorProgramDao;
    private ConsultationDao consultationDao;
    private UserDao userDao;

    public DoctorProgramServiceImpl(DoctorProgramDao doctorProgramDao,ConsultationDao consultationDao, UserDao userDao) {
        this.doctorProgramDao = doctorProgramDao;
        this.consultationDao = consultationDao;
        this.userDao = userDao;
    }

    @Override
    public boolean doctorIsAvailableInInterval(String doctorName, Time startsAt, Time endsAt) throws SQLException {
        UserEntity doctorEntity = userDao.getUserByName(doctorName).get(0);
        DoctorProgramEntity doctorProgram = doctorProgramDao.getDoctorProgramByDoctorId(doctorEntity.getId()).get(0);

        // if appointment is out of doctor's working hours
        if(doctorProgram.getStartsAtProgram().compareTo(startsAt) > 0
                || doctorProgram.getEndsAtProgram().compareTo(endsAt) < 0){
            return false;
        }

        if(doctorHasAnotherAppointment(doctorEntity,startsAt,endsAt)){
            return false;
        }

        return true;
    }


    private boolean doctorHasAnotherAppointment(UserEntity doctor, Time startsAt, Time endsAt) throws SQLException {
        List<ConsultationEntity> consultations = consultationDao.getAllByDoctorsName(doctor.getName());

        for (int i=0; i< consultations.size(); i++){
            if((startsAt.compareTo(consultations.get(i).getStartsAtTime()) >= 0 &&
                    startsAt.compareTo(consultations.get(i).getEndsAtTime()) <= 0) ||
                    (endsAt.compareTo(consultations.get(i).getStartsAtTime()) >= 0 &&
                    endsAt.compareTo(consultations.get(i).getEndsAtTime()) <= 0) ||
                    (startsAt.compareTo(consultations.get(i).getStartsAtTime()) <= 0 &&
                    endsAt.compareTo(consultations.get(i).getEndsAtTime()) >= 0))
                    {
                return true;
            }
        }
        return false;
    }
}
