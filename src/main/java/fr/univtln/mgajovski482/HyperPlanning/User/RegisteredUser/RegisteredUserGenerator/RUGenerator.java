package fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserGenerator;

import fr.univtln.mgajovski482.HyperPlanning.Other.Consts;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserFactory.RUFactory;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Maxime on 26/10/2015.
 */
public class RUGenerator {

    private final static int FIRST_NAME    = 0;
    private final static int LAST_NAME     = 1;
    private final static int GENDER        = 2;
    private final static int BIRTHDAY      = 3;
    private final static int EMAIL         = 4;
    private final static int PASSWORD      = 5;

    private static Logger logger = Logger.getLogger("RUGenerator.class");

    private static String[][] citiesAndPCs;
    private static String usersInformations[][];

    private static void importCitiesAndPCs() throws IOException {

        File file = new File(Consts.CITIES_FILE_PATH);
        try {
            Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
            citiesAndPCs = new String[sheet.getRowCount()][sheet.getColumnCount()];
            for(int i = 0; i <sheet.getRowCount(); i++){
                citiesAndPCs[i][0] = sheet.getCellAt(0, i).getTextValue();
                citiesAndPCs[i][1] = sheet.getCellAt(1, i).getTextValue();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Impossible to read into :" + Consts.CITIES_FILE_PATH + "\n");
            throw new IOException();
        }
    }

    private static void importUsers() throws Exception {

        File file = new File(Consts.USER_LOGS_FILE_PATH);
        try {
            Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
            usersInformations = new String[sheet.getRowCount()][sheet.getColumnCount()];
            for(int i = 0; i <sheet.getRowCount(); i++){
                usersInformations[i][FIRST_NAME]  = sheet.getCellAt(FIRST_NAME, i).getTextValue();
                usersInformations[i][LAST_NAME]   = sheet.getCellAt(LAST_NAME, i).getTextValue();
                usersInformations[i][GENDER]      = sheet.getCellAt(GENDER, i).getTextValue();
                usersInformations[i][BIRTHDAY]    = sheet.getCellAt(BIRTHDAY, i).getTextValue();
                usersInformations[i][EMAIL]       = sheet.getCellAt(EMAIL, i).getTextValue();
                usersInformations[i][PASSWORD]    = sheet.getCellAt(PASSWORD, i).getTextValue();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Impossible to read into :" + Consts.USER_LOGS_FILE_NAME + "\n");
            throw new IOException();
        }
    }
    public static void createRegisteredUsers() throws Exception{

        RUPersonalLogs.Status currentStatus;
        RUPersonalLogs          ruPersonalLogs;
        RUConnectionLogs        ruConnectionLogs;
        DateFormat              dateFormat          = new SimpleDateFormat("dd/MM/yyyy");
        Calendar                calendar            = Calendar.getInstance();
        int                     random;

        importUsers();
        importCitiesAndPCs();

        for(String[] userInformation :usersInformations){
            currentStatus = RUPersonalLogs.Status.randomStatus();
            random        = new Random().nextInt(citiesAndPCs.length);

            try {
                calendar.setTime(dateFormat.parse(userInformation[BIRTHDAY]));
            } catch (ParseException e) {
                logger.log(Level.SEVERE, "Impossible to parse user birthday !");
                throw new Exception();
            }

            ruConnectionLogs =
                    new RUConnectionLogs(
                            userInformation[EMAIL].toLowerCase(),
                            MD5.encode(userInformation[PASSWORD]));

            ruPersonalLogs =
                    new RUPersonalLogs.RUPersonalLogsBuilder(
                            currentStatus,
                            userInformation[GENDER].equals("Male"),
                            userInformation[LAST_NAME],
                            userInformation[FIRST_NAME],
                            calendar)
                            .city       (citiesAndPCs[random][0])
                            .postalCode (citiesAndPCs[random][1]).build();

            RUFactory.createRegisteredUser(ruPersonalLogs, ruConnectionLogs);
        }
    }
}
