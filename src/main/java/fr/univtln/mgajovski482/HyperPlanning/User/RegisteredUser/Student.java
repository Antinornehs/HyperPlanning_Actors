package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser;


import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maxime on 28/09/2015.
 */
public class Student extends AbstractRegUser {

    public static Map<String, Student> staticStudentMap
            = new HashMap<String, Student>();

    public Student(
            RUPersonalLogs ruPersonalLogs,
            RUConnectionLogs ruConnectionLogs) {

        super(ruPersonalLogs, ruConnectionLogs);
        staticStudentMap.put(ruConnectionLogs.getEmail(), this);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
