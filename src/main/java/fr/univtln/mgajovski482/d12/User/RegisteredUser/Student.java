package fr.univtln.mgajovski482.d12.User.RegisteredUser;


import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;

/**
 * Created by Maxime on 28/09/2015.
 */
public class Student extends AbstractRegUser {

    public Student(RUPersonalLogs ruPersonalLogs, RUConnectionLogs ruConnectionLogs) {
        super(ruPersonalLogs, ruConnectionLogs);
    }
}
