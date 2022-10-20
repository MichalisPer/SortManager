package com.sparta.mp.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectLogger {

    private static Logger logger;

    private ProjectLogger() {
        logger = Logger.getLogger("Project-Logger");
        CustomLoggerConfiguration.configureLogger(logger);
    }

    private static Logger getLogger(){
        if(logger == null){
            new ProjectLogger();
        }
        return logger;
    }
    public static void log(Level level, String msg){
        getLogger().log(level, msg);
    }

}
