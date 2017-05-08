package businessLayer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by radu on 08.05.2017.
 */
public class SecretaryNotifierServiceImpl extends Observable implements SecretaryNotifierService {

    @Override
    public void notifyDoctor(String doctorName) {
        setChanged();
        notifyObservers(doctorName);
    }
}
