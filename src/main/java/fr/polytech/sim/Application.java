package fr.polytech.sim;

import fr.polytech.sim.cycling.BikeSimulator;
import fr.polytech.sim.log.NamedLogger;

/**
 * Application's main classe.
 */
public class Application {

    /**
     * Entry point.
     * 
     * @param args app's arguments.
     */
    public static void main(String... args) {

        new BikeSimulator().run();

        /*
         * NamedLogger fileLogger = new FileLogger("FileLogger");
         * fileLogger.log("Hello", "world");
         * 
         * System.out.println("--------------------");
         * 
         * NamedLogger consoleLogger = new ConsoleLogger("ConsoleLogger");
         * consoleLogger.log("Hello", "world");
         */

    }
}
