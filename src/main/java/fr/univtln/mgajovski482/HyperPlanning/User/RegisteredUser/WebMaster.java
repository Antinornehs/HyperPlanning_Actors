package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maxime on 28/09/2015.
 */
public class WebMaster extends AbstractRegUser {

    public static Map<String, WebMaster> staticWebMasterMap
            = new HashMap<String, WebMaster>();

    public WebMaster(
            RUPersonalLogs ruPersonalLogs,
            RUConnectionLogs ruConnectionLogs){

        super(ruPersonalLogs, ruConnectionLogs);
        staticWebMasterMap.put(ruConnectionLogs.getEmail(), this);
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
