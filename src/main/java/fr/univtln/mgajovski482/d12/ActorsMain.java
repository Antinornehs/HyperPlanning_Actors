package fr.univtln.mgajovski482.d12;

import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserGenerator.RUGenerator;

import java.util.logging.Logger;

/**
 * Created by Maxime on 26/10/2015.
 */
public class ActorsMain {

    private static Logger logger = Logger.getLogger("ActorsMain.class");

    private static volatile ActorsMain _instance = null;

    public ActorsMain() throws Exception {

        RUGenerator.createRegisteredUsers();
        logger.info("Actors Package Initialized !");
    }

    public static ActorsMain getInstance() throws Exception {
        if(_instance == null) {
            synchronized (ActorsMain.class) {
                if (_instance == null) {
                    _instance = new ActorsMain();
                }
            }
        }
        return _instance;
    }
}
