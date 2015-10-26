package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserFactory;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.*;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;

import java.util.logging.Logger;

/**
 * Created by Maxime on 20/10/2015.
 */
public class RUFactory {

    public static void createRegisteredUser(RUPersonalLogs ruPersonalLogs,
                                            RUConnectionLogs ruConnectionLogs) {

        AbstractRegUser abstractRegUser = null;
        RUPersonalLogs.Status currentStatus = ruPersonalLogs.getStatus();
        switch (currentStatus){
            case STUDENT:
                abstractRegUser = new Student(ruPersonalLogs, ruConnectionLogs);
                break;
            case DIRECTOR_OF_FORMATION:
                abstractRegUser = new DirectorOfFormation(ruPersonalLogs, ruConnectionLogs);
                break;
            case WEBMASTER:
                abstractRegUser = new WebMaster(ruPersonalLogs, ruConnectionLogs);
                break;

            case TEACHER:
                abstractRegUser = new Teacher(ruPersonalLogs, ruConnectionLogs);
                break;
        }
    }
}
