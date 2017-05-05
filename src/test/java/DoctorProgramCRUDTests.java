import connection.ConnectionUrl;
import connection.DbSqlScript;
import dataAccessLayer.DoctorProgramDao;
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
        doctorProgramDao = new DoctorProgramDao(ConnectionUrl.testDbUrl);
    }

    @Test
    public void getAllDoctorProgramsTest() throws SQLException {
        assert doctorProgramDao.getAll().size() == 2;
    }

    @Test
    public void getDoctorProgramByIdTest() throws SQLException {
        assert doctorProgramDao.getById(1).getStartsAtProgram().toString().equals("08:00:00");
        assert doctorProgramDao.getById(2).getEndsAtProgram().toString().equals("20:00:00");
    }

    @Test
    public void insertDoctorProgramTest() throws SQLException {
        int doctorProgramsCount = doctorProgramDao.getAll().size();
        doctorProgramDao.addNew(new DoctorProgramEntity(new Time(07,00,00), new Time(13,00,00),2));
        assert doctorProgramDao.getAll().size() == doctorProgramsCount + 1;
    }

    @Test
    public void updateDoctorProgramTest() throws SQLException {
        assert doctorProgramDao.getById(1).getEndsAtProgram().toString().equals("16:00:00");

        DoctorProgramEntity doctorProgramEntity = doctorProgramDao.getById(1);
        doctorProgramEntity.setEndsAtProgram(new Time(23,30,00));
        doctorProgramDao.update(doctorProgramEntity);

        assert !doctorProgramDao.getById(1).getEndsAtProgram().toString().equals("16:00:00");
        assert doctorProgramDao.getById(1).getEndsAtProgram().toString().equals("23:30:00");
    }

    @Test
    public void deleteDoctorProgramTest() throws SQLException {
        int usersCount = doctorProgramDao.getAll().size();
        doctorProgramDao.deleteById(2);
        assert doctorProgramDao.getAll().size() == usersCount - 1;
    }


    @After
    public void tearDown(){

    }

}
