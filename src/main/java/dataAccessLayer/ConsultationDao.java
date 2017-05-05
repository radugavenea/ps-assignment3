package dataAccessLayer;

import dataAccessUtils.GenericDAO;
import entities.ConsultationEntity;

/**
 * Created by radu on 05.05.2017.
 */
public class ConsultationDao extends GenericDAO<ConsultationEntity> {

    public ConsultationDao(String connectionUrl) {
        super(connectionUrl);
    }
}
