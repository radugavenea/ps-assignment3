import connection.ConnectionUrl;
import connection.DbSqlScript;
import dataAccessLayer.ConsultationDao;
import entities.ConsultationEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Time;

/**
 * Created by radu on 05.05.2017.
 */
public class ConsultationCRUDTests {


    private ConsultationDao consultationDao;
    @Before
    public void init(){
        DbSqlScript.runTestDbSqlScript();
        consultationDao = new ConsultationDao(ConnectionUrl.testDbUrl);
    }

    @Test
    public void getAllConsultationsTest() throws SQLException {
        assert consultationDao.getAll().size() == 2;
    }

    @Test
    public void getConsultationByIdTest() throws SQLException {
        assert consultationDao.getById(1).getDoctorsName().equals("AssMan");
        assert consultationDao.getById(2).getPatientId() == 4;
    }

    @Test
    public void insertConsultationTest() throws SQLException {
        int consultationCount = consultationDao.getAll().size();
        consultationDao.addNew(new ConsultationEntity(new Time(13-00-00), new Time(13-25-00), "Gigel",3,4 ));
        assert consultationDao.getAll().size() == consultationCount + 1;
    }

    @Test
    public void updateConsultationTest() throws SQLException {
        assert consultationDao.getById(1).getDoctorsName().equals("AssMan");

        ConsultationEntity consultationEntity = consultationDao.getById(1);
        consultationEntity.setDoctorsName("Gica");
        consultationDao.update(consultationEntity);

        assert !consultationDao.getById(1).getDoctorsName().equals("AssMan");
        assert consultationDao.getById(1).getDoctorsName().equals("Gica");
    }

    @Test
    public void deleteConsultationTest() throws SQLException {
        int consultationCount = consultationDao.getAll().size();
        consultationDao.deleteById(2);
        assert consultationDao.getAll().size() == consultationCount - 1;
    }


    @After
    public void tearDown(){

    }

}
