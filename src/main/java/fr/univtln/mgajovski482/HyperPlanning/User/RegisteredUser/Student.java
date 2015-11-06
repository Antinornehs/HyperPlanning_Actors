package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser;


import fr.univtln.mgajovski482.HyperPlanning.Formation;
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

    private Formation formation;

    public Student(
            RUPersonalLogs ruPersonalLogs,
            RUConnectionLogs ruConnectionLogs) {

        super(ruPersonalLogs, ruConnectionLogs);
        staticStudentMap.put(ruConnectionLogs.getEmail(), this);
    }

    public Student setFormation(Formation formation){
        this.formation = formation;
        return this;
    }

    public Formation getFormation() {
        return formation;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString()+"Student{" +
                "formation=" + formation +
                '}';
    }
}
