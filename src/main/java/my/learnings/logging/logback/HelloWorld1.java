package my.learnings.logging.logback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import example.learnings.logback.Example1;

public class HelloWorld1 {

    public static void main(String[] args) {

        // print internal state
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);

        Logger logger = LoggerFactory.getLogger("my.learnings.logging.logback.HelloWorld1");
        logger.debug("Hello world.");
        logger.info("Hello world.");


        Logger rootLogger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        rootLogger.debug("Hello world.");
        rootLogger.info("Hello world.");

        // Understadning the logging level
        // get a logger instance named "com.foo". Let us further assume that the
        // logger is of type ch.qos.logback.classic.Logger so that we can
        // set its level
        ch.qos.logback.classic.Logger clogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.foo");
        // set its Level to INFO. The setLevel() method requires a logback
        // logger
        clogger.setLevel(Level.INFO);

        Logger barlogger = LoggerFactory.getLogger("com.foo.Bar");

        // This request is enabled, because WARN >= INFO
        clogger.warn("Low fuel level.");

        // This request is disabled, because DEBUG < INFO.
        clogger.debug("Starting search for nearest gas station.");

        // The logger instance barlogger, named "com.foo.Bar",
        // will inherit its level from the logger named
        // "com.foo" Thus, the following request is enabled
        // because INFO >= INFO.
        barlogger.info("Located nearest gas station.");

        // This request is disabled, because DEBUG < INFO.
        barlogger.debug("Exiting gas station search");

        new Example1().print();
    }
}