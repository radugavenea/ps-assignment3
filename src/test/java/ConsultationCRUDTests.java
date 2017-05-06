import connection.ConnectionUrl;
import connection.DbSqlScript;
import dataAccessLayer.ConsultationDao;
import dataAccessLayer.ConsultationDaoImpl;
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
        consultationDao = new ConsultationDaoImpl(ConnectionUrl.testDbUrl);
    }

    @Test
    public void getAllConsultationsTest() throws SQLException {
        assert consultationDao.getAllConsultations().size() == 2;
    }

    @Test
    public void getConsultationByIdTest() throws SQLException {
        assert consultationDao.getByIdConsultation(1).getDoctorsName().equals("AssMan");
        assert consultationDao.getByIdConsultation(2).getPatientId() == 4;
    }

    @Test
    public void insertConsultationTest() throws SQLException {
        int consultationCount = consultationDao.getAllConsultations().size();
        consultationDao.addNewConsultation(new ConsultationEntity(new Time(13-00-00), new Time(13-25-00), "Gigel",3,4 ));
        assert consultationDao.getAllConsultations().size() == consultationCount + 1;
    }

    @Test
    public void updateConsultationTest() throws SQLException {
        assert consultationDao.getByIdConsultation(1).getDoctorsName().equals("AssMan");

        ConsultationEntity consultationEntity = consultationDao.getByIdConsultation(1);
        consultationEntity.setDoctorsName("Gica");
        consultationDao.updateConsultation(consultationEntity);

        assert !consultationDao.getByIdConsultation(1).getDoctorsName().equals("AssMan");
        assert consultationDao.getByIdConsultation(1).getDoctorsName().equals("Gica");
    }

    @Test
    public void deleteConsultationTest() throws SQLException {
        int consultationCount = consultationDao.getAllConsultations().size();
        consultationDao.deleteByIdConsultation(2);
        assert consultationDao.getAllConsultations().size() == consultationCount - 1;
    }


    @After
    public void tearDown(){

    }

}
