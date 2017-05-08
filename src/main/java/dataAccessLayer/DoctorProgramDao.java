package dataAccessLayer;

import entities.DoctorProgramEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by radu on 06.05.2017.
 */
public interface DoctorProgramDao {
    DoctorProgramEntity getByIdDoctorProgram(int id) throws SQLException;
    List<DoctorProgramEntity> getAllDoctorPrograms() throws SQLException;
    int addNewDoctorProgram(DoctorProgramEntity instance) throws SQLException;
    int updateDoctorProgram(DoctorProgramEntity instance) throws SQLException;
    int deleteByIdDoctorProgram(int id) throws SQLException;
    List<DoctorProgramEntity> getDoctorProgramByDoctorId(int id) throws SQLException;
}
