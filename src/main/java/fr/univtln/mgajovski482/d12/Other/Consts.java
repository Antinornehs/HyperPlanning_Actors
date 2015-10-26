package fr.univtln.mgajovski482.d12.Other;

import java.io.File;

/**
 * Created by Maxime on 12/10/2015.
 */
public class Consts {

    public static final String DEFAULT_STRING_VALUE = "ND";

    public final static String  RESOURCES_PATH
            = System.getProperty("user.dir") + File.separator + "resources" + File.separator;

    public final static String USER_JSON_FILE_NAME
            = "Users.json";

    public final static String CITIES_FILE_NAME
            = "CitiesAndPC.ods";

    public final static String USER_LOGS_FILE_NAME
            = "UserLogs.ods";

    public static final String USER_JSON_PATH
            = RESOURCES_PATH + USER_JSON_FILE_NAME;


    public static final String CITIES_FILE_PATH
            = RESOURCES_PATH + CITIES_FILE_NAME;


    public static final String USER_LOGS_FILE_PATH
            = RESOURCES_PATH + USER_LOGS_FILE_NAME;

}
