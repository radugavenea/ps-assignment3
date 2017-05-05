package dataAccessLayer;

import dataAccessUtils.GenericDAO;
import entities.UserEntity;

/**
 * Created by radu on 05.05.2017.
 */
public class UserDao extends GenericDAO<UserEntity> {

    public UserDao(String connectionUrl) {
        super(connectionUrl);
    }
}
