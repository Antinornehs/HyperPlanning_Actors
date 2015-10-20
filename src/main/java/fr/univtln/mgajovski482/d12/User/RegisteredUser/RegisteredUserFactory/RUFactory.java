package fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserFactory;

import fr.univtln.mgajovski482.d12.User.RegisteredUser.*;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;

import java.util.logging.Logger;

/**
 * Created by Maxime on 20/10/2015.
 */
public class RUFactory {

    private static Logger logger = Logger.getLogger("RUFactory.class");

    public static void createRegisteredUser(RUPersonalLogs ruPersonalLogs,
                                            RUConnectionLogs ruConnectionLogs) {

        AbstractRegUser abstractRegUser;
        RUPersonalLogs.Status currentStatus = ruPersonalLogs.getStatus();
        switch (currentStatus){
            case STUDENT:
                abstractRegUser = new Student(ruPersonalLogs, ruConnectionLogs);
            case DIRECTOR_OF_FORMATION:
                abstractRegUser = new DirectorOfFormation(ruPersonalLogs, ruConnectionLogs);
            case WEBMASTER:
                abstractRegUser = new WebMaster(ruPersonalLogs, ruConnectionLogs);
            case TEACHER:
                abstractRegUser = new Teacher(ruPersonalLogs, ruConnectionLogs);
        }
        logger.info("User ( " + currentStatus + " )Created Correctly !");
    }
}
