package businessLayer;

import java.util.Observer;

/**
 * Created by radu on 08.05.2017.
 */
public interface SecretaryNotifierService {
    void addObserver(Observer o);
    void notifyDoctor(String doctorName);
}
