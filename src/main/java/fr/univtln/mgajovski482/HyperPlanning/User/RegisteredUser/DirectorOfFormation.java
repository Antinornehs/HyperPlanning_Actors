package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maxime on 28/09/2015.
 */
public class DirectorOfFormation extends Teacher {

    public static Map<String, DirectorOfFormation> staticDirectorOfFormationMap
            = new HashMap<String, DirectorOfFormation>();

    public DirectorOfFormation(
            RUPersonalLogs ruPersonalLogs,
            RUConnectionLogs ruConnectionLogs,
            Grade grade, String domain){

        super(ruPersonalLogs, ruConnectionLogs, grade, domain);
        staticDirectorOfFormationMap.put(ruConnectionLogs.getEmail(), this);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
