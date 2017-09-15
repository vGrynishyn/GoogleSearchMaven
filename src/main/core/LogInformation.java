package core;

import org.apache.log4j.Logger;

public class LogInformation extends Logger {

    protected LogInformation(String name)
    {
        super(name);
    }

    private static String getCallerClassName() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        for (int i = 1; i < stElements.length; i++) {
            StackTraceElement ste = stElements[i];
            if (!ste.getClassName().equals(LogInformation.class.getName())
                    && ste.getClassName().indexOf("java.lang.Thread") != 0) {
                return ste.getClassName();
            }
        }
        return null;
    }

    public static void error(String message) {
        String name = getCallerClassName();
        Logger log = Logger.getLogger(name);
        log.error(message);
    }

    public static void info(String message){
        String name = getCallerClassName();
        Logger log = LogInformation.getLogger(name);
        log.info(message);
    }
}
