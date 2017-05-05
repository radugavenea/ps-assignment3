import connection.ConnectionUrl;
import connection.DbSqlScript;
import dataAccessLayer.PatientDao;
import entities.PatientEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by radu on 05.05.2017.
 */
public class PatientCRUDTests {


    private PatientDao patientDao;
    @Before
    public void init(){
        DbSqlScript.runTestDbSqlScript();
        patientDao = new PatientDao(ConnectionUrl.testDbUrl);
    }

    @Test
    public void getAllPatientsTest() throws SQLException {
        assert patientDao.getAll().size() == 6;
    }

    @Test
    public void getPatientByIdTest() throws SQLException {
        assert patientDao.getById(1).getName().equals("Miorel");
        assert patientDao.getById(4).getAddress().equals("Mihai Eminescu 20");
    }

    @Test
    public void insertPatientTest() throws SQLException {
        int patientCount = patientDao.getAll().size();
        patientDao.addNew(new PatientEntity("Petunia Virginia","34654645","23452352435", new Date(2012-05-05),"in coltul strazi 35"));
        assert patientDao.getAll().size() == patientCount + 1;
    }

    @Test
    public void updatePatientTest() throws SQLException {
        assert patientDao.getById(1).getName().equals("Miorel");

        PatientEntity patientEntity = patientDao.getById(1);
        patientEntity.setName("Gica");
        patientDao.update(patientEntity);

        assert !patientDao.getById(1).getName().equals("Miorel");
        assert patientDao.getById(1).getName().equals("Gica");
    }

    @Test
    public void deletePatientTest() throws SQLException {
        int patientCount = patientDao.getAll().size();
        patientDao.deleteById(6);
        assert patientDao.getAll().size() == patientCount - 1;
    }


    @After
    public void tearDown(){

    }

}
