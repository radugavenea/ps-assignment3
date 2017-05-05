package dataAccessLayer;

import dataAccessUtils.GenericDAO;
import entities.DoctorProgramEntity;

/**
 * Created by radu on 05.05.2017.
 */
public class DoctorProgramDao extends GenericDAO<DoctorProgramEntity> {

    public DoctorProgramDao(String connectionUrl) {
        super(connectionUrl);
    }
}
