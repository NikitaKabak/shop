package nikita.nikita.logger;


import org.apache.log4j.Logger;

public class App {
    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        App obj = new App();
        try {
            obj.logMessages();
        } catch (Exception e){
            logger.error("exception", e);
        }
    }
    public void logMessages(){
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");

    }
}
