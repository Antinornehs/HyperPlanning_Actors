package fr.univtln.mgajovski482.d12.User.RegisteredUser;

import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.Logs.RULogs;
import fr.univtln.mgajovski482.d12.User.User;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Maxime on 28/09/2015.
 */
public abstract class AbstractRegUser extends User {

    private static Map<String, AbstractRegUser> staticRegUsersMap =  new HashMap<String, AbstractRegUser>();
    private final RULogs RULogs;

    private String userName;

    public AbstractRegUser(RULogs RULogs){
        this.RULogs = RULogs;
        userName = RULogs.getRuConnectionLogs().getEmail();
        staticRegUsersMap.put(userName, this);
    }

    public static Map<String, AbstractRegUser> getStaticRegUsersMap() {
        return staticRegUsersMap;
    }

    public RULogs getRULogs() {
        return RULogs;
    }

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


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RULogs);
        return stringBuilder.toString();
    }
}
