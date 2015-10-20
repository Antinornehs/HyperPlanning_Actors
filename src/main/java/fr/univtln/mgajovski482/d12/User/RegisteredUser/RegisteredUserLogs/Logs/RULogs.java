package fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.Logs;

import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.Logs.RUConnectionLogs;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.Logs.RUPersonalLogs;

/**
 * Created by Maxime on 29/09/2015.
 */
public class RULogs {

    private final RUPersonalLogs ruPersonalLogs;
    private final RUConnectionLogs ruConnectionLogs;

    public RULogs(RUPersonalLogs ruPersonalLogs,
                  RUConnectionLogs ruConnectionLogs){
        this.ruPersonalLogs     = ruPersonalLogs;
        this.ruConnectionLogs    = ruConnectionLogs;
    }

    public RUPersonalLogs getRuPersonalLogs() {
        return ruPersonalLogs;
    }

    public RUConnectionLogs getRuConnectionLogs() {
        return ruConnectionLogs;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ruConnectionLogs);
        stringBuilder.append(ruPersonalLogs);
        return stringBuilder.toString();
    }
}
