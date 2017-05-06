import connection.ConnectionUrl;
import connection.DbSqlScript;
import dataAccessLayer.DoctorProgramDao;
import dataAccessLayer.DoctorProgramDaoImpl;
import entities.DoctorProgramEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Time;

/**
 * Created by radu on 05.05.2017.
 */
public class DoctorProgramCRUDTests {


    private DoctorProgramDao doctorProgramDao;
    @Before
    public void init(){
        DbSqlScript.runTestDbSqlScript();
        doctorProgramDao = new DoctorProgramDaoImpl(ConnectionUrl.testDbUrl);
    }

    @Test
    public void getAllDoctorProgramsTest() throws SQLException {
        assert doctorProgramDao.getAllDoctorPrograms().size() == 2;
    }

    @Test
    public void getDoctorProgramByIdTest() throws SQLException {
        assert doctorProgramDao.getByIdDoctorProgram(1).getStartsAtProgram().toString().equals("08:00:00");
        assert doctorProgramDao.getByIdDoctorProgram(2).getEndsAtProgram().toString().equals("20:00:00");
    }

    @Test
    public void insertDoctorProgramTest() throws SQLException {
        int doctorProgramsCount = doctorProgramDao.getAllDoctorPrograms().size();
        doctorProgramDao.addNewDoctorProgram(new DoctorProgramEntity(new Time(07,00,00), new Time(13,00,00),2));
        assert doctorProgramDao.getAllDoctorPrograms().size() == doctorProgramsCount + 1;
    }

    @Test
    public void updateDoctorProgramTest() throws SQLException {
        assert doctorProgramDao.getByIdDoctorProgram(1).getEndsAtProgram().toString().equals("16:00:00");

        DoctorProgramEntity doctorProgramEntity = doctorProgramDao.getByIdDoctorProgram(1);
        doctorProgramEntity.setEndsAtProgram(new Time(23,30,00));
        doctorProgramDao.updateDoctorProgram(doctorProgramEntity);

        assert !doctorProgramDao.getByIdDoctorProgram(1).getEndsAtProgram().toString().equals("16:00:00");
        assert doctorProgramDao.getByIdDoctorProgram(1).getEndsAtProgram().toString().equals("23:30:00");
    }

    @Test
    public void deleteDoctorProgramTest() throws SQLException {
        int usersCount = doctorProgramDao.getAllDoctorPrograms().size();
        doctorProgramDao.deleteByIdDoctorProgram(2);
        assert doctorProgramDao.getAllDoctorPrograms().size() == usersCount - 1;
    }


    @After
    public void tearDown(){

    }

}
