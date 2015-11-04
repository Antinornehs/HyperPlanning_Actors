package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser;

import fr.univtln.mgajovski482.HyperPlanning.Formation;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Maxime on 28/09/2015.
 */
public abstract class AbstractRegUser extends User{

    public static Map<String, AbstractRegUser>  staticRegUsersMap   =  new HashMap<String, AbstractRegUser>();
    private List<Formation>                     formations          = new ArrayList<Formation>();
    private final RUPersonalLogs                ruPersonalLogs;
    private final RUConnectionLogs              ruConnectionLogs;

    public AbstractRegUser(RUPersonalLogs ruPersonalLogs,
                           RUConnectionLogs ruConnectionLogs){
        this.ruPersonalLogs     = ruPersonalLogs;
        this.ruConnectionLogs   = ruConnectionLogs;
        staticRegUsersMap.put(ruConnectionLogs.getEmail(), this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractRegUser)) return false;
        AbstractRegUser that = (AbstractRegUser) o;
        return ruConnectionLogs.getEmail().equals(that.ruConnectionLogs.getEmail());
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void addFormations(Formation ...formations) {
        for(Formation currentFormation : formations)
            this.formations.add(currentFormation);
    }

    @Override
    public int hashCode() {
        return ruConnectionLogs.getEmail().hashCode();
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
        stringBuilder.append(ruPersonalLogs);
        stringBuilder.append(ruConnectionLogs);
        return stringBuilder.toString();
    }
}
