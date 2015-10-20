package fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs;

/**
 * Created by Maxime on 12/10/2015.
 */
public class RUConnectionLogs {

    private final String email;
    private final String password;

    public RUConnectionLogs(String email, String password){
        this.email      = email;
        this.password   = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pseudo : "        + email + "\n");
        stringBuilder.append("Mot de passe : "  + password  + "\n");
        return stringBuilder.toString();
    }
}
