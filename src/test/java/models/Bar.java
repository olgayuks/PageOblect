package models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bar {

    private static final Logger log = LogManager.getLogger(Bar.class);

    public boolean doIt() {
        log.entry();
        log.error("Did it again!");
        return log.exit(false);
    }
}
