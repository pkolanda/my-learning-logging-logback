package example.learnings.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example1 {

    public static Logger logger = LoggerFactory.getLogger("example.learnings.logback.Example1");
    public void print() {
        logger.debug("Example 1 Hello world.");
        logger.info("Example 1 Hello world."); 
    }

    public static void main(String[] args) {
        logger.debug("Example 1 Hello world.");
        logger.info("Example 1 Hello world.");
    }
}
