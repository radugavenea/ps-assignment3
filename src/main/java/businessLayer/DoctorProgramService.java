package businessLayer;

import java.sql.SQLException;
import java.sql.Time;

/**
 * Created by radu on 08.05.2017.
 */
public interface DoctorProgramService {
    boolean doctorIsAvailableInInterval(String doctorName,Time startsAt, Time endsAt) throws SQLException;
}
