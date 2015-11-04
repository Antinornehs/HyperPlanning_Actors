package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;

import java.util.*;

/**
 * Created by Maxime on 28/09/2015.
 */
public class Teacher extends AbstractRegUser {

    public static List<String> domains =
            Collections.unmodifiableList(Arrays.asList(
                    "Mathématiques", "Anglais", "Espagnol",
                    "Informatique", "Allemand"));


    public enum Grade {INSIDER,OUTSIDER;

        private static final Random RANDOM      =
                new Random();

        private static final List<Grade> VALUES =
                Collections.unmodifiableList(Arrays.asList(INSIDER, OUTSIDER));

        private static final int SIZE =
                values().length - 1;

        public static Grade randomGrade()  {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }

    }


    public  final Grade   grade;
    private final String  domain;
    private static Random random = new Random();

    public Teacher(
            RUPersonalLogs ruPersonalLogs,
            RUConnectionLogs ruConnectionLogs,
            Grade grade, String domain){

        super(ruPersonalLogs,ruConnectionLogs);
        this.grade  = grade;
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public static String getRandomDomain(){
        int size = domains.size() - 1;
        return domains.get(random.nextInt(size));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Grade  : "    + grade     + "\n");
        stringBuilder.append("Domaine : "   + domain    + "\n");
        return stringBuilder.toString();
    }
}
