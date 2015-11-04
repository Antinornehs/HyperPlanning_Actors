package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserGenerator;

import com.google.gson.Gson;
import fr.univtln.mgajovski482.HyperPlanning.Other.Consts;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.AbstractRegUser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Maxime on 26/10/2015.
 */
public class JSonMethods {

    private static Logger logger = Logger.getLogger("JSonMethods.class");

    public static void toJSon(Collection<AbstractRegUser> users) throws IOException {
        Gson gson = new Gson();

        String jSonObject = gson.toJson(users);

        try{
            FileWriter writer = new FileWriter(Consts.USER_JSON_PATH);
            writer.write(jSonObject);
            writer.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ecriture impossible !");
            throw new IOException();
        }
    }
    /*
    public static void toFormation() throws IOException {

        Gson gson = new Gson();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(
                    new FileReader(Consts.USER_JSON_PATH));

            User users[] = gson.fromJson(bufferedReader, User[].class);
            String currentEmail;
            for(User currentUser: users){
                currentEmail = currentUser.getRuConnectionLogs().getEmail();
                AbstractRegUser.staticRegUsersMap.put(currentEmail, currentUser);
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Lecture du fichier "+ Consts.USER_JSON_FILE_NAME + " impossible !\n");
            throw new IOException();
        }

    }*/
}
