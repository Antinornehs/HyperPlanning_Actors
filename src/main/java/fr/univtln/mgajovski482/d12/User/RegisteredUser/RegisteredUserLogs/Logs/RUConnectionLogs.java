package fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.Logs;

/**
 * Created by Maxime on 12/10/2015.
 */
public class RUConnectionLogs {

    private final String email;
    private final String password;

    public RUConnectionLogs(RUConnectionLogsBuilder ruConnectionLogsBuilder){
        this.email = ruConnectionLogsBuilder.email;
        this.password = ruConnectionLogsBuilder.password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static class RUConnectionLogsBuilder{
        private final String email;
        private final String password;

        public RUConnectionLogsBuilder(String email, String password){
            this.password   = password;
            this.email      = email;
        }
        public RUConnectionLogs build(){
            return new RUConnectionLogs(this);
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pseudo : "        + email + "\n");
        stringBuilder.append("Mot de passe : "  + password  + "\n");
        return stringBuilder.toString();
    }
}
