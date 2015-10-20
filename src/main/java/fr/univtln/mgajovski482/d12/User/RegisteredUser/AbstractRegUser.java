package fr.univtln.mgajovski482.d12.User.RegisteredUser;

import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;
import fr.univtln.mgajovski482.d12.User.User;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Maxime on 28/09/2015.
 */
public abstract class AbstractRegUser extends User {

    private static Map<String, AbstractRegUser> staticRegUsersMap =  new HashMap<String, AbstractRegUser>();
    private final RUPersonalLogs ruPersonalLogs;
    private final RUConnectionLogs ruConnectionLogs;

    public AbstractRegUser(RUPersonalLogs ruPersonalLogs,
                           RUConnectionLogs ruConnectionLogs){
        this.ruPersonalLogs     = ruPersonalLogs;
        this.ruConnectionLogs   = ruConnectionLogs;
        staticRegUsersMap.put(ruConnectionLogs.getEmail(), this);
    }

    public static Map<String, AbstractRegUser> getStaticRegUsersMap() {
        return staticRegUsersMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractRegUser)) return false;
        AbstractRegUser that = (AbstractRegUser) o;
        return ruConnectionLogs.getEmail().equals(that.ruConnectionLogs.getEmail());

    }

    @Override
    public int hashCode() {
        return ruConnectionLogs.getEmail().hashCode();
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractRegUser)) return false;
        AbstractRegUser that = (AbstractRegUser) o;
        return userName.equals(that.userName);
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }
    */

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ruPersonalLogs);
        stringBuilder.append(ruConnectionLogs);
        return stringBuilder.toString();
    }
}
