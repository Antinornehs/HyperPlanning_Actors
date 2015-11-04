package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;

/**
 * Created by Maxime on 28/09/2015.
 */
public class Teacher extends AbstractRegUser {
    Grade grade;
    String domain;


    public Teacher(RUPersonalLogs ruPersonalLogs, RUConnectionLogs ruConnectionLogs, Grade grade, String domain){
        super(ruPersonalLogs,ruConnectionLogs);
        this.grade = grade;
        this.domain = domain;
    }

    public Grade getGrade() {
        return grade;
    }

    public String getDomain() {
        return domain;
    }

    public enum Grade {
        insider,
        outsider
    }

}
