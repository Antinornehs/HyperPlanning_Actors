package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs;

import fr.univtln.mgajovski482.HyperPlanning.Other.Consts;

import java.util.*;

/**
 * Created by Maxime on 28/09/2015.
 */
public class RUPersonalLogs {

    public enum Status{

        STUDENT                 ("Eleve"),
        TEACHER                 ("Professeur"),
        WEBMASTER               ("Webmaster"),
        DIRECTOR_OF_FORMATION   ("Directeur de formation");

        private String name;
        private static final List<Status>   VALUES =
                Collections.unmodifiableList(Arrays.asList(STUDENT, TEACHER, DIRECTOR_OF_FORMATION));
        private static final int            SIZE = values().length - 1;
        private static final Random         RANDOM = new Random();

        Status(String name){
            this.name = name;
        }

        public static String[] getLabels(){
            String[] names = new String[SIZE];
            for(int i = 0; i < SIZE; i++)
                names[i] = VALUES.get(i).getLabel();
            return names;
        }

        public static Status randomStatus()  {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }

        public String getLabel(){
            return name;
        }
    }

    private final Status        status;
    private final boolean       isMale;
    private final String        firstName;
    private final String        lastName;
    private final Calendar      dateOfBirth;
    private int                 age;
    private String              city, address, phoneNumber,
                                webSite, postalCode;


    public RUPersonalLogs(RUPersonalLogsBuilder ruPersonalLogsBuilder){
        this.status         = ruPersonalLogsBuilder.status;
        this.isMale         = ruPersonalLogsBuilder.isMale;
        this.firstName      = ruPersonalLogsBuilder.firstName;
        this.lastName       = ruPersonalLogsBuilder.lastName;
        this.dateOfBirth    = ruPersonalLogsBuilder.dateOfBirth;
        this.phoneNumber    = ruPersonalLogsBuilder.phoneNumber;
        this.webSite        = ruPersonalLogsBuilder.webSite;
        this.city           = ruPersonalLogsBuilder.city;
        this.address        = ruPersonalLogsBuilder.address;
        this.postalCode     = ruPersonalLogsBuilder.postalCode;
        this.age            = getAge();
    }

    public Status getStatus() {
        return status;
    }

    public boolean isMale() {
        return isMale;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getAge(){

        Calendar currentDate  = Calendar.getInstance();
        int currentAge = currentDate.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        if((dateOfBirth.get(Calendar.MONTH) > currentDate.get(Calendar.MONTH))
                || (dateOfBirth.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)
                && dateOfBirth.get(Calendar.DAY_OF_MONTH) > currentDate.get(Calendar.DAY_OF_MONTH)))
            currentAge--;
        return currentAge;
    }

    public static class RUPersonalLogsBuilder {
        private final Status        status;
        private final String        firstName;
        private final String        lastName;
        private final Calendar      dateOfBirth;
        private final boolean       isMale;
        private String              phoneNumber     = Consts.DEFAULT_STRING_VALUE;
        private String              webSite         = Consts.DEFAULT_STRING_VALUE;
        private String              city            = Consts.DEFAULT_STRING_VALUE;
        private String              address         = Consts.DEFAULT_STRING_VALUE;
        private String              postalCode      = Consts.DEFAULT_STRING_VALUE;

        public RUPersonalLogsBuilder(Status status, boolean isMale, String lastName,
                                     String firstName, Calendar dateOfBirth) {
            this.status         = status;
            this.isMale         = isMale;
            this.lastName       = lastName;
            this.firstName      = firstName;
            this.dateOfBirth    = dateOfBirth;

        }

        public RUPersonalLogsBuilder webSite (String webSite){
            this.webSite = webSite;
            return this;
        }

        public RUPersonalLogsBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public RUPersonalLogsBuilder city(String city){
            this.city = city;
            return this;
        }

        public RUPersonalLogsBuilder address(String address){
            this.address = address;
            return this;
        }
        public RUPersonalLogsBuilder postalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public RUPersonalLogs build(){
            return new RUPersonalLogs(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Sexe : "              + ((isMale) ? "Homme" : "Femme" )+ "\n");
        stringBuilder.append("Status : "            + status.getLabel() + "\n");
        stringBuilder.append("Nom : "               + lastName          + "\n");
        stringBuilder.append("Prénom : "            + firstName         + "\n");
        stringBuilder.append("Age : "               + age               + "\n");
        stringBuilder.append("Ville : "             + city              + "\n");
        stringBuilder.append("Code Postal : "       + postalCode        + "\n");
        stringBuilder.append("Adresse : "           + address           + "\n");
        stringBuilder.append("N° de téléphone : "   + phoneNumber       + "\n");
        stringBuilder.append("Site web : "          + webSite           + "\n");
        return stringBuilder.toString();
    }
}
