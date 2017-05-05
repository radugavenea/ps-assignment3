package dataAccessLayer;

import dataAccessUtils.GenericDAO;
import entities.PatientEntity;

/**
 * Created by radu on 05.05.2017.
 */
public class PatientDao extends GenericDAO<PatientEntity> {

    public PatientDao(String connectionUrl) {
        super(connectionUrl);
    }
}
