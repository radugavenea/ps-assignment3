import connection.ConnectionUrl;
import connection.DbSqlScript;
import dataAccessLayer.PatientDao;
import dataAccessLayer.PatientDaoImpl;
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
        patientDao = new PatientDaoImpl(ConnectionUrl.testDbUrl);
    }

    @Test
    public void getAllPatientsTest() throws SQLException {
        assert patientDao.getAllPatients().size() == 6;
    }

    @Test
    public void getPatientByIdTest() throws SQLException {
        assert patientDao.getByIdPatient(1).getName().equals("Miorel");
        assert patientDao.getByIdPatient(4).getAddress().equals("Mihai Eminescu 20");
    }

    @Test
    public void insertPatientTest() throws SQLException {
        int patientCount = patientDao.getAllPatients().size();
        patientDao.addNewPatient(new PatientEntity("Petunia Virginia","34654645","23452352435", new Date(2012-05-05),"in coltul strazi 35"));
        assert patientDao.getAllPatients().size() == patientCount + 1;
    }

    @Test
    public void updatePatientTest() throws SQLException {
        assert patientDao.getByIdPatient(1).getName().equals("Miorel");

        PatientEntity patientEntity = patientDao.getByIdPatient(1);
        patientEntity.setName("Gica");
        patientDao.updatePatient(patientEntity);

        assert !patientDao.getByIdPatient(1).getName().equals("Miorel");
        assert patientDao.getByIdPatient(1).getName().equals("Gica");
    }

    @Test
    public void deletePatientTest() throws SQLException {
        int patientCount = patientDao.getAllPatients().size();
        patientDao.deleteByIdPatient(6);
        assert patientDao.getAllPatients().size() == patientCount - 1;
    }


    @After
    public void tearDown(){

    }

}
