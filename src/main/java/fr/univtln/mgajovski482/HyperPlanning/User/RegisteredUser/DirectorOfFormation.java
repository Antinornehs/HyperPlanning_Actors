package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;

/**
 * Created by Maxime on 28/09/2015.
 */
public class DirectorOfFormation extends AbstractRegUser {

    public DirectorOfFormation(RUPersonalLogs ruPersonalLogs, RUConnectionLogs ruConnectionLogs){
        super(ruPersonalLogs, ruConnectionLogs);
    }
}